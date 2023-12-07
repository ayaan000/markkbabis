package view;

import data_access.SoundDataAccessObject;
import interface_adapter.generate_sound.SoundController;
import interface_adapter.generate_sound.SoundPresenter;
import interface_adapter.initialize_game.InitializeGameController;
import use_case.generate_sound.SoundInputBoundary;
import use_case.generate_sound.SoundInteractor;
import use_case.generate_sound.SoundOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class HomeGUI extends JFrame implements ActionListener {


    public HomeGUI(InitializeGameController initializeGameController){

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


//        JButton help = new JButton("Help");
//        help.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (e.getSource().equals(help)) {
//
//                        }
//                    }
//                }
//        );


        buttonPanel.setBorder(BorderFactory.createEmptyBorder(500, 400, 250, 400));
        buttonPanel.setLayout(new GridLayout(1,3, 100, 100));
        buttonPanel.add(singlePlayer);
        //buttonPanel.add(help);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Home");

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        generateSound();
    }
    public void actionPerformed(ActionEvent evt) {
    System.out.println("Cancel not implemented yet.");
}

    private void generateSound(){
        SoundDataAccessObject soundDataAccessObject = new SoundDataAccessObject();
        SoundOutputBoundary soundOutputBoundary = new SoundPresenter();
        SoundInputBoundary soundInteractor = new SoundInteractor(soundOutputBoundary, soundDataAccessObject);
        SoundController soundController = new SoundController(soundInteractor);
        soundController.execute("home.wav", "Trivia Game! Click Play to Start");

    }

}

