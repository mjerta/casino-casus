package novi;

import java.util.Scanner;

import novi.BlackJack.BlackjackGame;
import novi.higherlower.HigherLowerGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        BlackjackGame game = new BlackjackGame(inputScanner);

        game.playGame();
    }
}
