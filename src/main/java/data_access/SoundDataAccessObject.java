package data_access;

import audio.AePlayWave;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import entity.Question;
import use_case.generate_sound.SoundDataAccessInterface;

import java.io.*;

public class SoundDataAccessObject implements SoundDataAccessInterface {
    String apikey = "S4mwBQqs-D5XTBqUCZpUR0EA56Ns2QmKGjW0ARPumXN3";
    IamAuthenticator authenticator = new IamAuthenticator(apikey);
    TextToSpeech tts = new TextToSpeech(authenticator);

    public AePlayWave generateSound(String name, Question question) {


        tts.setServiceUrl("https://api.au-syd.text-to-speech.watson.cloud.ibm.com/instances/ed398db9-abab-406a-a985-9aa246224ca8");
        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text(question.getQuestion() + ", ," + question.getPossibleAnswers().toArray()[0] + ", , "
                                    + question.getPossibleAnswers().toArray()[1] + ", ," +
                                    question.getPossibleAnswers().toArray()[2] + ", ," +
                                    question.getPossibleAnswers().toArray()[3])
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();
            InputStream inputStream =
                    tts.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream(name);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AePlayWave(name);
    }

    public AePlayWave generateSound(String name, String text) {

        tts.setServiceUrl("https://api.au-syd.text-to-speech.watson.cloud.ibm.com/instances/ed398db9-abab-406a-a985-9aa246224ca8");
        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text(text)
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();
            InputStream inputStream =
                    tts.synthesize(synthesizeOptions).execute().getResult();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream(name);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AePlayWave(name);

    }

}

