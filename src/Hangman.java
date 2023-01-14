/**
 * A class that allows to create a hangman game. 
 */
public class Hangman 
{
    private final String[] WORDLIST = {"ABSURD", "ABYSS", "AWKWARD", "BUFFALO", "CYCLE", "EXODUS", "INJURY", "OXYGEN", "TRANSCRIPT"};
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;

    // Constructors
    
    /**
     * A constructor that initializes the values of hangman class.
    */
    public Hangman()
    {
        this.secretWord = new StringBuffer();
        this.secretWord = chooseSecretWord();
        this.maxAllowedIncorrectTries = 6;
        this.numberOfIncorrectTries = 0;
        this.allLetters = new StringBuffer( "ABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        this.usedLetters = new StringBuffer();
        this.knownSoFar = new StringBuffer();  
        
        for (int i = 0; i < secretWord.length(); i++) 
        {
            knownSoFar.append("*"); // Put * instead of letters in the word.
        }
    }

    // Methods
    
    /**
     * A getter method that returns all letters in English alphabet.
     * @return All letters in English alphabet
     */
    public String getAllLetters()
    {
        return allLetters.toString();
    }


    /**
     * A getter method that returns all the letters that have been tried.
     * @return Letters that have been tried
     */
    public String getUsedLetters()
    {
        return usedLetters.toString();
    }

    /**
     * A getter method that returns the number of incorrect tries so far.
     * @return Number of incorrect tries so far
     */
    public int getNumOfIncorrectTries()
    {
        return numberOfIncorrectTries;
    }

    /**
     * A getter method that returns the maximum number of allowed tries.
     * @return The maximum allowed tries
     */
    public int getMaxAllowedIncorrectTries()
    {
        return maxAllowedIncorrectTries;
    }

    /**
     * A getter method that returns the partial word formed with known letters only.
     * @return The partial word formed with known letters only
     */
    public String getKnownSoFar()
    {
        return knownSoFar.toString();
    }

    /**
     * Indicates whether the game is over or not.
     * @return Whether the game is over or not
     */
    public boolean isGameOver()
    {
        return numberOfIncorrectTries == maxAllowedIncorrectTries || knownSoFar.toString().equals(secretWord.toString());
    }

    /**
     *  Indicates whether the user has lost or won the game.
     * @return Whether the game is lost or won
     */
    public boolean hasLost()
    {
        return numberOfIncorrectTries == maxAllowedIncorrectTries;
    }

    /**
     * Checks if a letter is in the secretWord and add it to usedLetters.
     * If it is in secretWord, updates knownSoFar with the discovered letter.
     * @param letter The guessed letter
     * @return Number of occurrences of letter in secretWord
     */
    public int tryThis( char letter )
    {
        int count;
        count = 0;
        
        // A character that is not in allLetters is invalid.
        if (allLetters.indexOf(String.valueOf(letter)) == -1) 
        {
            return -1;
        }
        else if ( usedLetters.indexOf(String.valueOf(letter)) != -1 ) 
        {
            return -2;
        }
        else if ( isGameOver() ) 
        {
            return -3;
        }
        else 
        {
            usedLetters.append(letter);
            
            for (int i = 0; i < secretWord.length(); i++) 
            {
                if (secretWord.charAt(i) == letter) 
                {
                    // Replace the blank letters with the correct letter.
                    knownSoFar.replace(i, i+1, String.valueOf(letter));
                    count++;
                }
            }
            
        if ( count == 0 ) 
        {
            numberOfIncorrectTries++;
        }
         
            return count;
        }
         
    }

	/**
     * Chooses a random word from the list.
     * @return The chosen word
     */
    public StringBuffer chooseSecretWord()
    {    
        StringBuffer word;
        word = new StringBuffer( WORDLIST[(int) ( Math.random() * WORDLIST.length )] );
        return word;
    }
    
}
