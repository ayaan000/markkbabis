package view;

import audio.AePlayWave;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import entity.Question;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import entity.Computer;
import entity.Player;
import entity.Question;
import interface_adapter.game_stats.GameStatsController;
import use_case.game_stats.GameStatsInputBoundary;
import use_case.game_stats.GameStatsInteractor;
import use_case.game_stats.GameStatsOutputBoundary;
import use_case.game_stats.GameStatsOutputData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GameGUI extends JFrame {

    private int questionCounter = 0;
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

        generateSound(questions[0]);
        AePlayWave aw = new AePlayWave("game.wav");
        aw.start();

        // Create buttons to navigate through cards

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (questionCounter < questions.length) {
                    cardLayout.next(cardPanel);
                    generateSound(questions[++questionCounter]);
                    AePlayWave aw = new AePlayWave("game.wav");
                    aw.start();
                }
                else{
                    GameStatsOutputBoundary gameStatsOutputBoundary = new GameStatsPresenter();
                    GameStatsInputBoundary gameStatsInputInteractor = new GameStatsInteractor(gameStatsOutputBoundary);
                    GameStatsController gameStatsController = new GameStatsController(gameStatsInputInteractor);
                    gameStatsController.execute(player, computer);

                }

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createCard(Question question) {
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

        int corrIndex = question.getIndexAnswer();
        boolean correctness = false;


        JRadioButton answer0 = new AnswerRadioButton(possibleAnswers[0].toString(), true);
        JRadioButton answer1 = new AnswerRadioButton(possibleAnswers[1].toString(), false);
        JRadioButton answer2 = new AnswerRadioButton(possibleAnswers[2].toString(), false);
        JRadioButton answer3 = new AnswerRadioButton(possibleAnswers[3].toString(),false );

        JRadioButton[] buttons = {answer0, answer1, answer2, answer3};

        Collections.shuffle(Arrays.asList(buttons));

        System.out.println(question.getCorrectAnswer());
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


        // ACTION RESPONSE TO THE BUTTONS
        // ItemListener invokes changes based on changed states of buttons
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    AnswerRadioButton selectedButton = (AnswerRadioButton) e.getSource();
                    System.out.println("You selected: " + e.getItem());

                    if (selectedButton.isCorrect()){
                        selectedButton.setBackground(Color.GREEN);

                    } else {
                        selectedButton.setBackground(Color.RED);
                        answer0.setBackground(Color.GREEN);
                    }

                    answer0.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
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


    private void generateSound(Question question){
        String apikey = "S4mwBQqs-D5XTBqUCZpUR0EA56Ns2QmKGjW0ARPumXN3";
        IamAuthenticator authenticator = new IamAuthenticator(apikey);
        TextToSpeech tts = new TextToSpeech(authenticator);
        tts.setServiceUrl("https://api.au-syd.text-to-speech.watson.cloud.ibm.com/instances/ed398db9-abab-406a-a985-9aa246224ca8");
        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text(question.getQuestion() + ", ," + question.getPossibleAnswers().toArray()[0]+ ", , "
                                    + question.getPossibleAnswers().toArray()[1]+ ", ," +
                                    question.getPossibleAnswers().toArray()[2]+ ", ," +
                                    question.getPossibleAnswers().toArray()[3])
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();
            InputStream inputStream =
                    tts.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream("game.wav");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
