package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import entity.Computer;
import entity.Player;
import entity.Question;

public class GameGUI extends JFrame {

    Question[] questions;
    Player player;
    Computer computer;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int cardCount = 5; // Change this to the number of cards you want

    public GameGUI(Question[] questions, Player player, Computer computer) {
        this.questions = questions;
        this.player = player;
        this.computer = computer;
        setTitle("CardLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create and add cards to the cardPanel
        for (int i = 0; i < questions.length; i++) {
            String cardName = "Card " + (i + 1);
            JPanel card = createCard(questions[i]);
            cardPanel.add(card, cardName);
        }

        add(cardPanel, BorderLayout.CENTER);

        // Create buttons to navigate through cards

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createCard(Question question) {
        JPanel mainPanel = new JPanel();

        String q = question.getQuestion();
        JLabel questionText = new JLabel(q);
        mainPanel.add(questionText, BorderLayout.NORTH);

        TitledBorder title;
//            String question = "Which is the best animal?";
//        title = BorderFactory.createTitledBorder(question);
//        title.setTitleJustification(TitledBorder.CENTER);
//
//        answersPanel.setBorder(title);

        // POINTS TEXT
        Integer playerPtInput = player.getTotalPoints();
        String playerPoint = playerPtInput.toString();
        String playerTitle = "Player: " + playerPoint;
        JLabel playerText = new JLabel(playerTitle);
        mainPanel.add(playerText, BorderLayout.WEST);

        Integer compPtInput = computer.getTotalPoints2();
        String compPoint = compPtInput.toString();
        String compTitle = "Computer: " + compPoint;
        JLabel compText = new JLabel(compTitle);
        mainPanel.add(compText, BorderLayout.EAST);

//        // POSSIBLE ANSWERS
        JPanel answersPanel = new JPanel();
        //answersPanel.setBorder(BorderFactory.createEmptyBorder(500, 400, 250, 400));
//        answersPanel.setLayout(new GridLayout(1,3, 100, 100));

        // create the buttons for the possible answers
        // TASK: need to somehow get the answers from somewhere and randomly assign them to different buttons
        // can I get the possible answers from initialize_game use case output data?
        Object[] possibleAnswers = question.getPossibleAnswers().toArray();

        JRadioButton answer0 = new JRadioButton(possibleAnswers[0].toString());
        JRadioButton answer1 = new JRadioButton(possibleAnswers[1].toString());
        JRadioButton answer2 = new JRadioButton(possibleAnswers[2].toString());
        JRadioButton answer3 = new JRadioButton(possibleAnswers[3].toString());

        // group all the buttons in one area (functionality)
        ButtonGroup group = new ButtonGroup();
        group.add(answer0);
        group.add(answer1);
        group.add(answer2);
        group.add(answer3);

        // add all buttons to panel (visual purposes)
        answersPanel.add(answer0);
        answersPanel.add(answer1);
        answersPanel.add(answer2);
        answersPanel.add(answer3);

        mainPanel.add(answersPanel, BorderLayout.CENTER);


        // ACTION RESPONSE TO THE BUTTONS
        // ItemListener invokes changes based on changed states of buttons
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("You selected: " + e.getItem());
                    //cardLayout.next(cardPanel);
                    // add action here (color change, correct answer)
                }
            }
        };


        answer0.addItemListener(listener);
        answer1.addItemListener(listener);
        answer2.addItemListener(listener);
        answer3.addItemListener(listener);

        return mainPanel;
    }

    public static void main(String[] args) {
//        List<String> possibleAnswer = new ArrayList<>();
//        possibleAnswer.add("ans1");
//        possibleAnswer.add("ans2");
//        possibleAnswer.add("ans3");
//        possibleAnswer.add("ans4");
//        Question question1 = new Question("Example question", possibleAnswer, "ans2");
//        Question question2 = new Question("Example question #2", possibleAnswer, "ans3");
//        Question[] questionlist = new Question[2];
//        questionlist[0] = question1;
//        questionlist[1] = question2;
//        new CardLayoutExample(questionlist);
        //SwingUtilities.invokeLater(() -> new CardLayoutExample([question1]);
    }
}