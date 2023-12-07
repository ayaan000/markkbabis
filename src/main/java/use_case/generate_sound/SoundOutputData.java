package use_case.generate_sound;

import audio.AePlayWave;

public class SoundOutputData {
    AePlayWave ae;

    SoundOutputData(AePlayWave ae){
        this.ae = ae;
    }

    public AePlayWave getAe(){
        return this.ae;
    }
}
