/**
 * Standard interface for general operations across components.
 * This interface defines methods to manage and check the state of the component.
 */
public interface Standard {

    /**
     * Clears the current component, resetting it to an empty state.
     * For SensitiveWordFilter, this clears the entire sensitive word bank.
     * 
     * @ensures this.isEmpty()
     */
    void clear();

    /**
     * Checks if the current component is empty.
     * For SensitiveWordFilter, this checks if the sensitive word bank is empty.
     * 
     * @return true if the component is empty, false otherwise
     * @ensures result == (this.size() == 0)
     */
    boolean isEmpty();

    /**
     * Returns the size of the current component.
     * For SensitiveWordFilter, this returns the number of sensitive words in the bank.
     * 
     * @return the number of elements in the component
     * @ensures result >= 0
     */
    int size();

    /**
     * Checks if the provided text contains any elements (sensitive words in the case of SensitiveWordFilter).
     * 
     * @param text the text to check
     * @return true if the text contains any elements (sensitive words), false otherwise
     * @ensures result == (this.findSensitiveWords(text).size() > 0)
     */
    boolean contains(String text);
}