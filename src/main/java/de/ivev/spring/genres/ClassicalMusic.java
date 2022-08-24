package de.ivev.spring.genres;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music{
    private List<String> songs = Arrays.asList("Hungarian Rhapsody", "Valkyrie's Dance", "Requiem");

    @Override
    public List<String> getSongsList() {
        return songs;
    }
}
