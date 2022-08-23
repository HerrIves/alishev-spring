package de.ivev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic music;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic music,  RockMusic rockMusic) {
        this.music = music;
        this.rockMusic = rockMusic;
    }

    public String playMusic(){
        return "Playing " +music.getSong() + ", " + rockMusic.getSong();
    }
}
