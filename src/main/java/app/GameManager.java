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


        HomeGUI homeViewModel = new HomeGUI();

        TriviaDataAccessObject userDataAccessObject = new TriviaDataAccessObject();


    }
}
