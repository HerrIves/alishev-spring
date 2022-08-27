package de.ivev.spring.config;

import de.ivev.spring.Computer;
import de.ivev.spring.MusicPlayer;
import de.ivev.spring.genres.ClassicalMusic;
import de.ivev.spring.genres.Music;
import de.ivev.spring.genres.PopMusic;
import de.ivev.spring.genres.RockMusic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public PopMusic popMusic(){
        return new PopMusic();
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(rockMusic(), classicalMusic());
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }

}