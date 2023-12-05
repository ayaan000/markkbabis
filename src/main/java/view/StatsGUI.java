package view;

import entity.GameStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StatsGUI extends JFrame implements ActionListener {


    public StatsGUI(GameStats gameStats) {

        JLabel background = new JLabel();
        JPanel statsPanel = new JPanel();
        JFrame frame = new JFrame();

        JButton quit = new JButton("Play");
        quit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(quit)) {

                            frame.dispose();
                        }
                    }
                }
        );


        statsPanel.setBorder(BorderFactory.createEmptyBorder(250, 400, 250, 400));
        statsPanel.setLayout(new GridLayout(3, 2, 10, 10));
        int playerScore = gameStats.getPlayerPoints();
        int computerScore = gameStats.getComputerPoints();

        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel playerScoreLbl = new JLabel("Player score:");
        playerScoreLbl.setFont(font);
        JLabel computerScoreLbl = new JLabel("Computer score:");
        computerScoreLbl.setFont(font);
        JLabel playerScoretxt = new JLabel(String.valueOf(playerScore));
        playerScoretxt.setFont(font);
        JLabel computerScoretxt = new JLabel(String.valueOf(computerScore));
        computerScoretxt.setFont(font);
        JLabel endText = new JLabel();
        if (playerScore < computerScore) {
            endText.setText("               You Lose!");
        } else if (playerScore > computerScore) {
            endText.setText("You Win!");
        } else {
            endText.setText("It is a Tie!");
        }
        endText.setFont(font);
        statsPanel.add(playerScoreLbl);
        statsPanel.add(playerScoretxt);
        statsPanel.add(computerScoreLbl);
        statsPanel.add(computerScoretxt);
        statsPanel.add(endText);
        frame.add(statsPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Game Statistics");

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }


}