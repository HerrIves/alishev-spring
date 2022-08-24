package de.ivev.spring.genres;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Component
//@Scope("prototype")
public class ClassicalMusic implements Music{
    private List<String> songs = Arrays.asList("Hungarian Rhapsody", "Valkyrie's Dance", "Requiem");

    @Override
    public List<String> getSongsList() {
        return songs;
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println("Post Constract");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Pre Destroy");
    }
}
