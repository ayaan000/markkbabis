package use_case;

public class SelectAnswerInputData {
    final private int answer;

    public SelectAnswerInputData(int answer){
        this.answer = answer;
    }

    int getAnswer(){return answer;}
}
