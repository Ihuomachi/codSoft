import java.util.*;

public class numberTask3 {
    public static final int BOUND = 50;
    public static final int MAX_ATTEMPTS = 3; // Maximum number of attempts allowed

    public static void main(String[] args) {
        int finalScore = 0;
        Scanner myObj = new Scanner(System.in);

        while (true) {
            finalScore += playGame();
            System.out.println("GAME OVER! \nWould you like to play again? yes/no");
            String guessAnswer = myObj.nextLine();
            if (!guessAnswer.equalsIgnoreCase("yes")) {
                break;
            }
            System.out.println("How many more times do you want to play?");
            int guessAns1Int = Integer.parseInt(myObj.nextLine());
            if (guessAns1Int <= 0) {
                break;
            }
        }

        System.out.println("GAME OVER! Your final score is " + finalScore);
    }

    public static int playGame() {
        Random rand = new Random();
        int randomInt = rand.nextInt(BOUND + 1); // Random number between 0 and BOUND
        Scanner myObj = new Scanner(System.in);
        int guessInt = -1;
        int userScore = 0;
        int attempts = 0; // Number of attempts made

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Guess the random number between 0 and " + BOUND);

            String guessInput = myObj.nextLine();
            try {
                guessInt = Integer.parseInt(guessInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue; // Skip to the next iteration
            }

            if (guessInt == randomInt) {
                System.out.println("That's CORRECT! You guessed right.");
                userScore++;
                break; // Exit the loop as the user guessed correctly
            } else if (guessInt > randomInt) {
                System.out.println("You guessed a number HIGHER than the random number.");
            } else if (guessInt < randomInt) {
                System.out.println("You guessed a number LESS than the random number.");
            }

            attempts++;
        }

        if (guessInt != randomInt) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomInt);
        }

        return userScore;
    }
}
