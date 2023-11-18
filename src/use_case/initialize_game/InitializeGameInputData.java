package use_case.initialize_game;

public class InitializeGameInputData {
    private String category;
    private String difficulty;      // could also implement as an int with 1 being easiest and 3 being hardest
    private int numQuestions;

    public InitializeGameInputData(String category, String difficulty, int numQuestions) {
        this.category = category;
        this.difficulty = difficulty;
        this.numQuestions = numQuestions;
    }

    public String getCategory() {return category;}
    public String getDifficulty() {return difficulty;}
    public int getNumQuestions() {return numQuestions;}
}
