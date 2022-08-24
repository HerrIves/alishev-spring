package de.ivev.spring.genres;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music{
    private List<String> songs = Arrays.asList("Wind cries Mary", "Bogeymen Rhapsody", "Nothing is Matter");
    @Override
    public List<String> getSongsList() {
        return songs;
    }
}
