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


public class HomeGUI extends JFrame implements ActionListener {


    public HomeGUI(InitializeGameController initializeGameController){

        generateSound();
        JLabel background = new JLabel();
        JPanel buttonPanel = new JPanel();
        JFrame frame = new JFrame();

        JButton singlePlayer = new JButton("Play");
        singlePlayer.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(singlePlayer)) {

                            SettingsGUI settingsGUI = new SettingsGUI(initializeGameController);
                            frame.dispose();
                        }
                    }
                }
        );


        JButton help = new JButton("Help");
        help.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(help)) {

                        }
                    }
                }
        );


        buttonPanel.setBorder(BorderFactory.createEmptyBorder(500, 400, 250, 400));
        buttonPanel.setLayout(new GridLayout(1,3, 100, 100));
        buttonPanel.add(singlePlayer);
        buttonPanel.add(help);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Home");

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        AePlayWave aw = new AePlayWave("home.wav");
        aw.start();
    }
    public void actionPerformed(ActionEvent evt) {
    System.out.println("Cancel not implemented yet.");
}

    private void generateSound(){
        String apikey = "S4mwBQqs-D5XTBqUCZpUR0EA56Ns2QmKGjW0ARPumXN3";
        IamAuthenticator authenticator = new IamAuthenticator(apikey);
        TextToSpeech tts = new TextToSpeech(authenticator);
        tts.setServiceUrl("https://api.au-syd.text-to-speech.watson.cloud.ibm.com/instances/ed398db9-abab-406a-a985-9aa246224ca8");
        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text("Trivia Game! Play or Help")
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();
            InputStream inputStream =
                    tts.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream("home.wav");
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
}

