package main.java.java8.exercise;

import main.java.java8.entity.Track;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MapExerciseTest {
    public static IntSummaryStatistics  intSummary(){
        return Arrays.asList(new Track("一生所爱",50),new Track("roll",100),new Track("后来",90)).stream().mapToInt(track -> track.getLength()).summaryStatistics();
    }

    public static void main(String[] args) {
        System.out.println(intSummary().getMax());
        System.out.println(intSummary().getCount());
        System.out.println(intSummary().getAverage());
        System.out.println(intSummary().getMin());
        System.out.println(intSummary().getSum());
        Arrays.asList(new Track("一生所爱",50),new Track("roll",100),new Track("后来",90)).stream().
                forEach(track -> {
                    System.out.println(track.getName());
                    System.out.println(track.getLength());
                });
    }
}
