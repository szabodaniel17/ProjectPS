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
        Exercise ex = new Exercise("flotari","10-12 reps",4,"2 mins");
        observable.addObserver(observer);
        observable.setExercise(new Exercise("flotari","10-12 reps",4,"2 mins"));
        assertEquals(observer.getExercise(),ex);
    }

}
