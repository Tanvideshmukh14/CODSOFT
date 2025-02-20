import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int maxNum;
        int minNum;
        int randomNumber;
        int userGuess;
        int roundsWon = 0;
        boolean roundWon;

        Scanner input = new Scanner(System.in);

        System.out.println("Let's decide the range first");

        System.out.println("Enter the maximum number");
        maxNum = input.nextInt();

        System.out.println("Enter the minimum number");
        minNum = input.nextInt();

        for (int i = 1; i <=3; i++) {

            randomNumber = (int)(Math.random()*(maxNum - minNum + 1) + minNum);
            roundWon = false;

            for (int j = 1; j <= 3; j++) {
                {
                    System.out.println("Round : " + i + " : Attempt no : " + j);
                    System.out.println("Enter your guessed number : ");
                    userGuess = input.nextInt();

                    if (userGuess > randomNumber) {
                        System.out.println("The guess is too high.");
                    } else if (userGuess < randomNumber) {
                        System.out.println("The guess is too low.");
                    } else {
                        System.out.println("Your guess is correct.");
                        System.out.println("You completed the game in " + j + " attempts.");
                        roundsWon++;
                        roundWon = true;
                        break;

                    }
                }

            }
            if (!roundWon) {
                System.out.println("Sorry, you've used all 3 attempts. The correct number was " + randomNumber);
            }
        }
        System.out.println("Total rounds won : " + roundsWon + " out of 3.");
    }
}
