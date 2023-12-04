package view;


import audio.AePlayWave;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import interface_adapter.initialize_game.InitializeGameController;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SettingsGUI {

    private final InitializeGameController initializeGameController;

    public SettingsGUI(InitializeGameController initializeGameController)
    {
        this.initializeGameController = initializeGameController;

        //Creating audio file
        String apikey = "S4mwBQqs-D5XTBqUCZpUR0EA56Ns2QmKGjW0ARPumXN3";
        IamAuthenticator authenticator = new IamAuthenticator(apikey);
        TextToSpeech tts = new TextToSpeech(authenticator);
        tts.setServiceUrl("https://api.au-syd.text-to-speech.watson.cloud.ibm.com/instances/ed398db9-abab-406a-a985-9aa246224ca8");
        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text("Enter the difficulty, number of questions and category")
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();
            InputStream inputStream =
                    tts.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream("settings.wav");
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


        //creating UI
        JLabel background = new JLabel();
        JPanel buttonPanel = new JPanel();
        JFrame frame = new JFrame();

        JPanel textFields = new JPanel();


        textFields.setBorder(BorderFactory.createEmptyBorder(300, 400, 300, 400));
        textFields.setLayout(new GridLayout(4,2, 20, 20));

        //Getting difficulty
        JLabel difficultylbl = new JLabel("Difficulty:");
        textFields.add(difficultylbl);
        difficultylbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] difficulty = {"easy", "medium", "hard"};
        final JComboBox<String> difficultyBox = new JComboBox<String>(difficulty);

        difficultyBox.setMaximumSize(difficultyBox.getPreferredSize());
        difficultyBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFields.add(difficultyBox);


        //getting number of questions
        JLabel questionlbl = new JLabel("Number of Questions:");
        textFields.add(questionlbl);
        difficultylbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] questionNumbers = {"5", "10", "15"};
        final JComboBox<String> questionNumbersBox = new JComboBox<String>(questionNumbers);

        questionNumbersBox.setMaximumSize(questionNumbersBox.getPreferredSize());
        questionNumbersBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFields.add(questionNumbersBox);

        //getting category
        JLabel categorylbl = new JLabel("Category:");
        textFields.add(categorylbl);
        difficultylbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] categories = {"Film", "Geography", "Cartoon & Animations", "Music", "Books", "Computers",
                "Science & Nature", "History", "Comics", "Vehicles", "General Knowledge", "Board Games", "Animals",
                "Television", "Politics", "Video Games", "Sports"};
        final JComboBox<String> categoriesBox = new JComboBox<String>(categories);

        categoriesBox.setMaximumSize(categoriesBox.getPreferredSize());
        categoriesBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFields.add(categoriesBox);


        //adding enter button
        JButton nextPage = new JButton("Enter");
        nextPage.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String category = String.valueOf(categoriesBox.getSelectedItem());
                        String questionNumber = String.valueOf(questionNumbersBox);
                        String difficulty = String.valueOf(difficultyBox);



                        GameGUI Game = new GameGUI();
                        frame.dispose();
                    }
                }
        );
        textFields.add(nextPage);



        frame.add(textFields, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Settings");
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        AePlayWave aw = new AePlayWave("settings.wav");
        aw.start();


    }


}
