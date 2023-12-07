package use_case.generate_sound;

import entity.Question;

public class SoundInputData {
    String text = "";
    String name;
    Question question;

    public SoundInputData(String name, String text){
        this.text = text;
        this.name = name;
    }

    public SoundInputData(String name, Question question){
        this.name = name;
        this.question = question;
    }
}
