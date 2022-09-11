package de.ivev.spring.genres;

import java.util.List;

public enum Genres {
    CLASSICAL, ROCK;

    public List<String> getSongsList() {

        if (this.equals(CLASSICAL))
            return new ClassicalMusic().getSongsList();

        else return new RockMusic().getSongsList();
    }
}
