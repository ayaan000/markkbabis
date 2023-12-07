package view;

import data_access.SoundDataAccessObject;
import entity.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Arrays;
import java.util.Collections;

import entity.Computer;
import entity.Player;
import entity.Question;
import interface_adapter.game_stats.GameStatsController;
import interface_adapter.generate_sound.SoundController;
import interface_adapter.generate_sound.SoundPresenter;
import use_case.game_stats.GameStatsInputBoundary;
import use_case.game_stats.GameStatsInteractor;
import use_case.game_stats.GameStatsOutputBoundary;

import interface_adapter.game_stats.GameStatsPresenter;
import use_case.calculate_point.CalculatePointInputData;
import use_case.calculate_point.CalculatePointInteractor;
import use_case.generate_sound.SoundInputBoundary;
import use_case.generate_sound.SoundInteractor;
import use_case.generate_sound.SoundOutputBoundary;


public class GameGUI extends JFrame {

    private int questionCounter = 0;
    Question[] questions;
    Player player;
    Computer computer;

    boolean isCorrect = false;

    private long startTime = System.currentTimeMillis();
    private long endTime = 0;

    private long elapsedTime;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GameGUI(Game game, Player player, Computer computer) {


        this.questions = game.getQuestionList();
        this.player = player;
        this.computer = computer;
        setTitle("Trivia Game - Markk Babis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setSize(400, 300);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create and add cards to the cardPanel
        for (int i = 0; i < game.getNumQuestions(); i++) {
            String cardName = "Card " + (i + 1);
            JPanel card = createCard(questions[i], i + 1);
            cardPanel.add(card, cardName);
        }

        add(cardPanel, BorderLayout.CENTER);

        //Code for Sound

        generateSound(questions[0]);

        // Create buttons to navigate through cards

        JButton nextButton = new JButton("Next");
        CalculatePointInteractor calculatePointInteractor = new CalculatePointInteractor(player, computer);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (questionCounter < game.getNumQuestions() - 1) {
                    CalculatePointInputData calculatePointInputData = new CalculatePointInputData(isCorrect, computer.getComResult(), elapsedTime, computer.getTimeDelay().getSeconds());
                    calculatePointInteractor.execute(calculatePointInputData);
                    System.out.println("Player points: " + player.getTotalPoints());
                    System.out.println("Computer points: " + computer.getTotalPoints2());
                    isCorrect = false;
                    cardLayout.next(cardPanel);
                    System.out.println(elapsedTime);
                    startTime = System.currentTimeMillis();
                    generateSound(questions[++questionCounter]);

                } else {
                    //GameStats Connection
                    CalculatePointInputData calculatePointInputData = new CalculatePointInputData(isCorrect, computer.getComResult(), elapsedTime, computer.getTimeDelay().getSeconds());
                    calculatePointInteractor.execute(calculatePointInputData);
                    GameStatsOutputBoundary gameStatsOutputBoundary = new GameStatsPresenter();
                    GameStatsInputBoundary gameStatsInputInteractor = new GameStatsInteractor(gameStatsOutputBoundary);
                    GameStatsController gameStatsController = new GameStatsController(gameStatsInputInteractor);
                    gameStatsController.execute(player, computer);
                    GameGUI.super.dispose();
                }

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createCard(Question question, int questionNumber) {
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(350, 350, 400, 400));

        Font largeFont = new Font("Calibri", Font.PLAIN, 28);

        String q = "Question #" + questionNumber + ": " + question.getQuestion() + "    ";
        JLabel questionText = new JLabel(q);
        questionText.setFont(largeFont);
        mainPanel.add(questionText, BorderLayout.NORTH);



        // POSSIBLE ANSWERS
        JPanel answersPanel = new JPanel();


        // create the buttons for the possible answers
        Object[] possibleAnswers = question.getPossibleAnswers().toArray();

        int answerTextSize = 20;

        Font answerFont = new Font("Arial", Font.BOLD, answerTextSize);


        JRadioButton answer0 = new AnswerRadioButton(possibleAnswers[0].toString(), true);
        answer0.setFont(answerFont);
        JRadioButton answer1 = new AnswerRadioButton(possibleAnswers[1].toString(), false);
        answer1.setFont(answerFont);
        JRadioButton answer2 = new AnswerRadioButton(possibleAnswers[2].toString(), false);
        answer2.setFont(answerFont);
        JRadioButton answer3 = new AnswerRadioButton(possibleAnswers[3].toString(), false);
        answer3.setFont(answerFont);

        JRadioButton[] buttons = {answer0, answer1, answer2, answer3};

        //Show the buttons in random order everytime
        Collections.shuffle(Arrays.asList(buttons));

        // group all the buttons in one area (functionality)
        ButtonGroup group = new ButtonGroup();
        group.add(buttons[0]);
        group.add(buttons[1]);
        group.add(buttons[2]);
        group.add(buttons[3]);

        // add all buttons to panel (visual purposes)
        answersPanel.add(buttons[0]);
        answersPanel.add(buttons[1]);
        answersPanel.add(buttons[2]);
        answersPanel.add(buttons[3]);

        mainPanel.add(answersPanel, BorderLayout.CENTER);


        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    endTime = System.currentTimeMillis();
                    elapsedTime = (endTime - startTime) / 1000;

                    AnswerRadioButton selectedButton = (AnswerRadioButton) e.getSource();
                    System.out.println("You selected: " + selectedButton.getText());

                    if (selectedButton.isCorrect()) {
                        selectedButton.setBackground(Color.GREEN);
                        isCorrect = true;

                    } else {
                        selectedButton.setBackground(Color.RED);
                        answer0.setBackground(Color.GREEN);
                    }

                    answer0.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);

                }
            }
        };

        answer0.addItemListener(listener);
        answer1.addItemListener(listener);
        answer2.addItemListener(listener);
        answer3.addItemListener(listener);

        return mainPanel;
    }


    private void generateSound(Question question) {
        SoundDataAccessObject soundDataAccessObject = new SoundDataAccessObject();
        SoundOutputBoundary soundOutputBoundary = new SoundPresenter();
        SoundInputBoundary soundInteractor = new SoundInteractor(soundOutputBoundary, soundDataAccessObject);
        SoundController soundController = new SoundController(soundInteractor);
        soundController.execute("game.wav", question);

    }
}


class AnswerRadioButton extends JRadioButton {
    private boolean isCorrect;

    public AnswerRadioButton(String text, boolean isCorrect) {
        super(text);
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
