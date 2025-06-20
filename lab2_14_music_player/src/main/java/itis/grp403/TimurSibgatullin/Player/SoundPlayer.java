package itis.grp403.TimurSibgatullin.Player;


import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    private Clip clip;
    public Thread currentThread;

    public Clip getClip() {
        return clip;
    }

    public void play(Track track, Runnable onTrackEnd) {
        currentThread = new Thread(() -> {
            try {
                AudioInputStream audioStream =
                        AudioSystem.getAudioInputStream(new File(track.getPath()));
                this.clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength()/1000);
                clip.close();
                onTrackEnd.run();
            } catch (Exception e) {
            }
        });
        currentThread.start();
    }

    public void stop() {
        try {
            currentThread.interrupt();
            clip.close();
        } catch (Exception e) {
        }
    }
}
