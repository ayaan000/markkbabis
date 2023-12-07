package use_case.generate_sound;

import audio.AePlayWave;
import entity.Question;


public interface SoundDataAccessInterface {
    AePlayWave generateSound(String name, Question question);

    AePlayWave generateSound(String name, String text);
}
