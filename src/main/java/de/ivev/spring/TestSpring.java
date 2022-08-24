package de.ivev.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
//        RockMusic rockMusic = context.getBean("rockMusic",  RockMusic.class);
//        MusicPlayer musicPlayer = new MusicPlayer(classicalMusic, rockMusic);
//        musicPlayer.playMusic();

        Computer computer = context.getBean("computer",  Computer.class);
        System.out.println(computer.getMusicPlayer().playMusic(Genres.CLASSICAL));

        context.close();
    }

}
