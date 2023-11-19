package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI implements ActionListener {
        //Create SettingsGUI

        public HomeGUI(){
            JLabel background = new JLabel();
            JPanel buttonPanel = new JPanel();
            JFrame frame = new JFrame();

            JButton singlePlayer = new JButton("Single Player");
            singlePlayer.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(singlePlayer)) {
                                SettingsGUI settingsGUI = new SettingsGUI(1);
                                settingsGUI.display();
                            }
                        }
                    }
            );

            JButton multiPlayer = new JButton("Multi Player");
            multiPlayer.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(multiPlayer)) {

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


            buttonPanel.setBorder(BorderFactory.createEmptyBorder(550, 400, 200, 400));
            buttonPanel.setLayout(new GridLayout(1,3, 100, 100));
            buttonPanel.add(singlePlayer);
            buttonPanel.add(multiPlayer);
            buttonPanel.add(help);

            frame.add(buttonPanel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Task Manager");
            frame.setSize(500, 500);
            frame.pack();
            frame.setVisible(true);
        }
        public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

        public static void main(String[] args){
            new HomeGUI();
        }

}

