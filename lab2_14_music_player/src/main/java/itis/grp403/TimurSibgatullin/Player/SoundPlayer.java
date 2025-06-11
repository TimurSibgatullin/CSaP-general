package itis.grp403.TimurSibgatullin.Player;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    private Clip clip;

    public Clip getClip() {
        return clip;
    }

    public void play(Track track) {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(track.getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            clip.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
