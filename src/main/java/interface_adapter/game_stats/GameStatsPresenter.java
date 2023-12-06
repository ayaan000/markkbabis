package interface_adapter.game_stats;

import use_case.game_stats.GameStatsOutputBoundary;
import use_case.game_stats.GameStatsOutputData;
import view.StatsGUI;

public class GameStatsPresenter implements GameStatsOutputBoundary {
    public GameStatsPresenter() {}

    public void prepareSuccessView(GameStatsOutputData gameStatsOutputData) {
        new StatsGUI(gameStatsOutputData);
        //Pass question list from outputdata to GameGUI
    }
}
