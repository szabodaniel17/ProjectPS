package com.example.sd2020.demo;

import entity.Exercise;
import org.junit.Test;
import service.AdminService;
import service.TrainerService;

import static org.junit.Assert.assertEquals;

public class ObserverTest {

    @Test
    public void testObserver(){
        AdminService observable = new AdminService();
        TrainerService observer = new TrainerService();
        Exercise ex = new Exercise("flotari");
        observable.addObserver(observer);
        observable.setExercise(new Exercise("flotari"));
        assertEquals(observer.getExercise(),ex);
    }

}
