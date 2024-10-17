import java.util.List;

/**
 * Kernel interface for the SensitiveWordFilter component.
 * This interface defines the minimal functionality for managing
 * sensitive words and detecting them in a given text.
 */
public interface swFilterKernel extends Standard {

    /**
     * Adds a word to the sensitive word bank.
     * 
     * @param word the word to be added
     * @ensures sensitiveWordBank.contains(word)
     */
    void addSensitiveWord(String word);

    /**
     * Searches the provided text for any sensitive words from the word bank.
     * 
     * @param text the purpose text
     * @return a list of sensitive words found in it
     * @ensures result is a list of all sensitive words found in the text
     */
    List<String> findSensitiveWords(String text);

    /**
     * Checks if a given word is in the sensitive word bank.
     * 
     * @param word the word to check
     * @return true if the word is sensitive, false otherwise
     * @ensures result == (sensitiveWordBank.contains(word))
     */
    boolean isSensitiveWord(String word);
}