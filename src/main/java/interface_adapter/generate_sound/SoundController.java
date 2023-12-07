package interface_adapter.generate_sound;

import entity.Question;
import use_case.generate_sound.SoundInputBoundary;
import use_case.generate_sound.SoundInputData;

public class SoundController {
    SoundInputBoundary soundInteractor;

    public SoundController(SoundInputBoundary soundInteractor){
        this.soundInteractor = soundInteractor;
    }

    public void execute(String name, String text){
        SoundInputData soundInputData = new SoundInputData(name, text);
        soundInteractor.execute(soundInputData);
    }

    public void execute(String name, Question question){
        SoundInputData soundInputData = new SoundInputData(name, question);
        soundInteractor.execute(soundInputData);
    }
}
