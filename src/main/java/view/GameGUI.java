package view;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GameGUI extends JFrame {

    public GameGUI () {
        JFrame frame = new JFrame();        // frame is essentially the window we see

        JLabel background = new JLabel();   // what is this meant to be used for? Why is it called background?
        // maybe we need a label for the question?

        JPanel answersPanel = new JPanel(); // panel holds components (label, buttons, etc.)
        //answersPanel.setBorder(BorderFactory.createEmptyBorder(500, 400, 250, 400));
        answersPanel.setLayout(new GridLayout(1,3, 100, 100));

        TitledBorder title;
        String question = "Which is the best animal?";
        title = BorderFactory.createTitledBorder(question);
        title.setTitleJustification(TitledBorder.CENTER);

        answersPanel.setBorder(title);

        // create the buttons for the possible answers
        // TASK: need to somehow get the answers from somewhere and randomly assign them to different buttons
        // can I get the possible answers from initialize_game use case output data?
        JRadioButton answer0 = new JRadioButton("cat");
        JRadioButton answer1 = new JRadioButton("rat");
        JRadioButton answer2 = new JRadioButton("capybara");
        JRadioButton answer3 = new JRadioButton("raccoon");

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

        // ItemListener invokes changes based on changed states of buttons
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("You selected: " + e.getItem());
                    // add action here (color change, correct answer)
                }
            }
        };

        answer0.addItemListener(listener);
        answer1.addItemListener(listener);
        answer2.addItemListener(listener);
        answer3.addItemListener(listener);

        //frame.add(questionText);
        frame.add(answersPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gameplay");

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

    }

    public static void main(String[] args) {
        new GameGUI();
    }
}