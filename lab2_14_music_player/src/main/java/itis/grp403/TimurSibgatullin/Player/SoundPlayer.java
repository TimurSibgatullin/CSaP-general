package itis.grp403.TimurSibgatullin.Player;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    private Clip clip;
    public Thread currentThread;

    public Clip getClip() {
        return clip;
    }

    public void play(Track track) {
        currentThread = new Thread(()-> { try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(track.getPath()));
            this.clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
        }});
        currentThread.start();
    }

    public void stop() {
        try {
            currentThread.interrupt();
            clip.stop();
        } catch (Exception e) {
        }
    }
}
