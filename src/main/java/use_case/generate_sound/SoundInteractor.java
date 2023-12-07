package use_case.generate_sound;

import audio.AePlayWave;

public class SoundInteractor implements SoundInputBoundary{

    private final SoundDataAccessInterface soundDataAccessObject;
    private final SoundOutputBoundary soundPresenter;
    public SoundInteractor(SoundOutputBoundary soundPresenter, SoundDataAccessInterface soundDataAccessInterface){
        this.soundPresenter = soundPresenter;
        this.soundDataAccessObject = soundDataAccessInterface;

    }

    @Override
    public void execute(SoundInputData soundInputData) {
        if(soundInputData.text.isEmpty()){
            AePlayWave ae = soundDataAccessObject.generateSound(soundInputData.name, soundInputData.question);
            SoundOutputData soundOutputData = new SoundOutputData(ae);
            soundPresenter.prepareSuccessView(soundOutputData);
        }
        else{
            AePlayWave ae = soundDataAccessObject.generateSound(soundInputData.name, soundInputData.text);
            SoundOutputData soundOutputData = new SoundOutputData(ae);
            soundPresenter.prepareSuccessView(soundOutputData);
        }

    }
}
