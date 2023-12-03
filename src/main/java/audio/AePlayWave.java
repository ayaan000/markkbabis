package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AePlayWave extends Thread {

    private List<String> filenameQueue;

    private String filename;

    private final Position curPosition;

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

    enum Position {
        LEFT, RIGHT, NORMAL
    }

    public AePlayWave(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }

    public AePlayWave(String[] filenameQueue ) {
        this.filenameQueue = new ArrayList<>();
        this.filenameQueue.addAll( Arrays.asList(filenameQueue) );
        curPosition = Position.NORMAL;
    }



    public void run() {

        if ( filenameQueue == null ) {
            filenameQueue = new ArrayList<String>();
            filenameQueue.add(this.filename);
        }


        for ( String filename : filenameQueue ) {
            File soundFile = new File(filename);
            if (!soundFile.exists()) {
                System.err.println("Wave file not found: " + filename);
                return;
            }

            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
                //return;
                continue;
            } catch (IOException e1) {
                e1.printStackTrace();
                //return;
                continue;
            }

            AudioFormat format = audioInputStream.getFormat();
            SourceDataLine auline = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            try {
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                //return;
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                //return;
                continue;
            }

            if (auline.isControlSupported(FloatControl.Type.PAN)) {
                FloatControl pan = (FloatControl) auline
                        .getControl(FloatControl.Type.PAN);
                if (curPosition == Position.RIGHT) {
                    pan.setValue(1.0f);
                }
                else if (curPosition == Position.LEFT) {
                    pan.setValue(-1.0f);
                }
            }

            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

            try {
                while (nBytesRead != -1) {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                    if (nBytesRead >= 0) {
                        auline.write(abData, 0, nBytesRead);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                //return;
                continue;
            } finally {
                auline.drain();
                auline.close();
            }
        }
    }

    public static void main ( String[] args ) {
        new AePlayWave(new String[] { args[0], args[0] }).start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new AePlayWave(args[0]).start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new AePlayWave(args[0]).start();
    }
}