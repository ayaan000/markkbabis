package app;
import data_access.TriviaDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import view.GameGUI;
import view.HomeGUI;
import view.SettingsGUI;

import javax.swing.*;
import java.awt.*;

public class GameManager {

    public Question[] initialize_game(){

    }

    public static void main(String[] args) {
        JFrame application = new JFrame("Trivia");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        //new ViewManager(views, cardLayout, viewManagerModel);

        HomeGUI homeViewModel = new HomeGUI();
        GameGUI gameViewModel = new GameGUI();
        SettingsGUI settingViewModel = new SettingsGUI(1);
        //What is the players in SettingsGUI doing??

        TriviaDataAccessObject userDataAccessObject = new TriviaDataAccessObject();

        `

    }
}
