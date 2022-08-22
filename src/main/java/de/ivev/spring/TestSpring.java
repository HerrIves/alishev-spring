package de.ivev.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Music rockMusic = context.getBean("rockMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(rockMusic);
        musicPlayer.playMusic();

        Music classicalMusic = context.getBean("classicalMusic", Music.class);
        musicPlayer = new MusicPlayer(classicalMusic);
        musicPlayer.playMusic();

        context.close();
    }

}
