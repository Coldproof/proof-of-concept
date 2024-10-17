/**
 * Enhanced interface for the SensitiveWordFilter component.
 * This interface extends the kernel interface by adding additional methods
 * for removing sensitive words, counting occurrences, and marking text.
 */
public interface swFilter extends swFilterKernel {

    /**
     * Removes a word from the sensitive word bank.
     * 
     * @param word the word to be removed
     * @ensures sensitiveWordBank does not contain word
     */
    void removeSensitiveWord(String word);

    /**
     * Counts how many sensitive words appear in the given text.
     * 
     * @param text the text to check for sensitive words
     * @return the number of sensitive words found in the text
     * @ensures result == the number of sensitive words in the text
     */
    int countSensitiveWords(String text);

    /**
     * Clears the entire sensitive word bank.
     * 
     * @ensures sensitiveWordBank is empty
     */
    void clearSensitiveWords();

    /**
     * Checks if the provided text contains any sensitive words.
     * 
     * @param text the goal text
     * @return true if at least one sensitive word is found, false otherwise
     * @ensures result == (findSensitiveWords(text).size() > 0)
     */
    boolean hasSensitiveWords(String text);

    /**
     * Marks the sensitive words in the text by adding markers.
     * 
     * @param text the text in which to mark sensitive words
     * @return the modified text with sensitive words marked
     * @ensures result contains markers for each sensitive word in the text
     */
    String markSensitiveWords(String text);
}