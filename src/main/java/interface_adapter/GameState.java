package interface_adapter;

public class GameState {

    private String currentQuestion = "";
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public GameState(GameState copy){
        currentQuestion = copy.currentQuestion;
        option1 = copy.option1;
        option2 = copy.option2;
        option3 = copy.option3;
        option4 = copy.option4;

    }

    public GameState(){}

    public void setCurrentQuestion(String currentQuestion){this.currentQuestion = currentQuestion;}

    public void setOption1(String option1){this.option1 = option1;}

    public void setOption2(String option2){this.option2 = option2;}

    public void setOption3(String option3){this.option3 = option3;}

    public void setOption4(String option4){this.option4 = option4;}

}
