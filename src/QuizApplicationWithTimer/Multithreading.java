package QuizApplicationWithTimer;

import java.util.Timer;
import java.util.TimerTask;

public class Multithreading extends Thread{


    boolean timeUp;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Time up");
            timeUp = false;
        }
    };
    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            if (!timeUp) {
                System.out.println("Please choose any option to continue");
                timeUp = true;
            }
        }
    };

    @Override
    public void run() {
            timer.schedule(task, 5000);
            timer.schedule(task2, 5000);

    }
}
