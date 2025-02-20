package QuizApplicationWithTimer;

import java.util.Scanner;

public class QuizApplicationWithTimer {

    public static void main(String[] args) {

        int answer;
        int score = 0;

        Scanner Input = new Scanner(System.in);

        Multithreading multithreading1 = new Multithreading();
        Multithreading multithreading2 = new Multithreading();
        Multithreading multithreading3 = new Multithreading();

        System.out.println("Welcome to this Quiz ,you got 5 seconds to answer each question");

        System.out.println("Que1: What does HTML stand for?");
        System.out.println("1.HyperText Markup Language");
        System.out.println("2.HighText Machine Language");
        System.out.println("3.Hyperlink Text Markup Language");
        System.out.println("4.None of the above");

        multithreading1.start();

        answer = Input.nextInt();
        multithreading1.timer.cancel();
        if (answer == 1){
            System.out.println("Correct answer");
            score++;
        }else {
            System.out.println("Incorrect answer");
        }



        System.out.println("Que2: Which company developed the Windows operating system?");
        System.out.println("1.Apple");
        System.out.println("2.Microsoft");
        System.out.println("3.Google");
        System.out.println("4.IBM");


        multithreading2.start();

        answer = Input.nextInt();
        multithreading2.timer.cancel();

        if (answer == 2){
            System.out.println("Correct answer");
            score++;
        }else {
            System.out.println("Incorrect answer");
        }


        System.out.println("Que3: What does RAM stand for in computers?");
        System.out.println("1.Read Access Memory");
        System.out.println("2.Random Access Memory");
        System.out.println("3.Real Access Memory");
        System.out.println("4.Random Array Memory");

        multithreading3.start();

        answer = Input.nextInt();
        multithreading3.timer.cancel();

        if (answer == 2) {
            System.out.println("Correct answer");
            score++;
        } else {
            System.out.println("Incorrect answer");
        }

        System.out.println("Your score is " + score + " out of 3");
    }
}