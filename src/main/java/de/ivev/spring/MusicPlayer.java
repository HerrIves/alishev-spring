package de.ivev.spring;

import de.ivev.spring.genres.Genres;
import de.ivev.spring.genres.Music;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer(List<Music>musicList) {
        this.musicList = musicList;
    }

    public String getName() {        return name;    }
    public int getVolume() {        return volume;    }

    private List<Music> musicList;

    public String playMusic(){
        Music someMusic = musicList.get(new Random().nextInt(musicList.size()));
        return playRandomSong(someMusic.getSongsList());
    }


    private Genres genre = Genres.values()[0];
    public String playMusic(Genres genre){
        this.genre = genre;
        return playRandomSong(genre.getSongsList());
    }


    public String playRandomSong(List<String> songList){
        return songList.get(new Random().nextInt(songList.size()));
    }
}
