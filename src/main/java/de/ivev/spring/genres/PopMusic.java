package de.ivev.spring.genres;

import java.util.Arrays;
import java.util.List;

public class PopMusic implements Music{
    List<String>songs = Arrays.asList("Adele - Fireworks", "Sting - Shape of my Heart", "Sia - Blow it All");

    @Override
    public List<String> getSongsList() {
        return songs;
    }
}
