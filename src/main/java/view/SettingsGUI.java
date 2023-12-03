package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI {
    int players;
    public SettingsGUI(int players)
    {
        this.players = players;

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

                        //pass the values to API

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


    }

    public static void main(String[] args){
        new SettingsGUI(1);
    }

}
