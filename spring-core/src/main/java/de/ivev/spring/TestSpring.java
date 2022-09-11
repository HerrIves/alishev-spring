package de.ivev.spring;

import de.ivev.spring.config.SpringConfig;
import de.ivev.spring.genres.ClassicalMusic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
                /*new ClassPathXmlApplicationContext("applicationContext.xml");*/

//        Computer computer = context.getBean("computer",  Computer.class);
//        System.out.println(computer.getMusicPlayer().playMusic(Genres.ROCK));

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        System.out.println(musicPlayer.playMusic());

//        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
//        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);


        context.close();
    }

}
