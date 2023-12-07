package interface_adapter.generate_sound;

import use_case.generate_sound.SoundOutputBoundary;
import use_case.generate_sound.SoundOutputData;

public class SoundPresenter implements SoundOutputBoundary {
    @Override
    public void prepareSuccessView(SoundOutputData soundOutputData) {
        soundOutputData.getAe().start();
    }
}
