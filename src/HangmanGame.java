import java.util.Scanner;

public class HangmanGame 
{
    public static void main(String[] args) 
    {
		Scanner scan = new Scanner(System.in);
		
		// Variables
		Hangman hangman = new Hangman();
        char guessedLetter;
        int tryThisValue;
        
        // 1. Start the game.
        System.out.println( "====================================" );
		System.out.println( "      Welcome to Hangman Game!      " );
        System.out.println( "====================================" );
        
		// 2. Ask the user to guess letters until the game is over.
        while( !hangman.isGameOver() ) 
        {
			System.out.println( "Valid letters: " + hangman.getAllLetters() );
			System.out.println( "Used letters: " + hangman.getUsedLetters() );
			System.out.print( "Please enter a letter (upper case): " );
            guessedLetter = scan.next().charAt(0);
            System.out.println( "====================================" );
            
            // 2.1 If the character is not valid or it is a previously used, warn the user.
            tryThisValue = hangman.tryThis(guessedLetter);
            
            if ( tryThisValue == -1 ) 
            {				
				System.out.println( "Please enter a valid character!" );
            } 
            else if ( tryThisValue == -2 )
            {
                System.out.println( "Please enter an unused letter!" );
            }
            else 
            {
                System.out.println( "Number of incorrect tries: " + hangman.getNumOfIncorrectTries() + "/" + hangman.getMaxAllowedIncorrectTries() );
				System.out.println( "Word so far: " + hangman.getKnownSoFar() );
            }
            
            System.out.println( "====================================" );
        }
        
        // 3. Print out a game is over message followed by if the user has won.
		System.out.println( "Game is over!" );
        if ( hangman.hasLost() ) 
        {
			System.out.println( "You have lost!" );
        } 
        else
        {
			System.out.println( "You have won!" );
        }
        
        System.out.println( "====================================" );
        
		scan.close();
	}
}
