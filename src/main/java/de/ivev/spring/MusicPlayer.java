package de.ivev.spring;

import de.ivev.spring.genres.Genres;
import de.ivev.spring.genres.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {        return name;    }
    public int getVolume() {        return volume;    }

    private Genres genre = Genres.values()[0];

    @Autowired
    @Qualifier("classicalMusic")
    private Music classiclMusic;
    @Autowired
    @Qualifier("rockMusic")
    private Music rockMusic;


    public String playMusic(){
        return playRandomSong();
    }
    public String playMusic(Genres genre){
        this.genre = genre;
        return playRandomSong();
    }

    public String playRandomSong(){
        List<String> songsList = genre.getSongsList();
        return songsList.get(new Random().nextInt(songsList.size()));
    }
}
