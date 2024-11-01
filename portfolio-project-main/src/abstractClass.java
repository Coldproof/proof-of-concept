import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * AbstractSensitiveWordFilter provides a base implementation for a sensitive
 * word filter.
 * It implements methods from the enhanced swFilter interface, relying on kernel
 * and
 * Standard methods to ensure that all secondary methods respect the contracts.
 */
public abstract class abstractClass implements swFilter {

    // Reference to the sensitive word bank, to be managed by concrete subclasses.
    protected Set<String> sensitiveWordBank;

    // Kernel method implementation for adding a sensitive word.
    @Override
    public abstract void addSensitiveWord(String word);

    // Kernel method implementation for finding sensitive words.
    @Override
    public abstract List<String> findSensitiveWords(String text);

    // Kernel method implementation for checking if a word is sensitive.
    @Override
    public abstract boolean isSensitiveWord(String word);

    // Standard method for clearing the sensitive word bank.
    @Override
    public void clear() {
        sensitiveWordBank.clear();
    }

    // Standard method for checking if the sensitive word bank is empty.
    @Override
    public boolean isEmpty() {
        return sensitiveWordBank.isEmpty();
    }

    // Standard method for getting the size of the sensitive word bank.
    @Override
    public int size() {
        return sensitiveWordBank.size();
    }

    // Standard method for checking if text contains any sensitive words.
    @Override
    public boolean contains(String text) {
        return !findSensitiveWords(text).isEmpty();
    }

    // Secondary method: removes a sensitive word, using kernel and Standard
    // methods.
    @Override
    public void removeSensitiveWord(String word) {
        if (isSensitiveWord(word)) { // Check precondition
            sensitiveWordBank.remove(word);
        }
    }

    // Secondary method: counts the occurrences of sensitive words in text.
    @Override
    public int countSensitiveWords(String text) {
        return findSensitiveWords(text).size();
    }

    // Secondary method: clears all sensitive words using the Standard clear method.
    @Override
    public void clearSensitiveWords() {
        clear();
    }

    // Secondary method: checks if text contains any sensitive words.
    @Override
    public boolean hasSensitiveWords(String text) {
        return contains(text);
    }

    // Secondary method: marks sensitive words in the text by appending a marker.
    @Override
    public String markSensitiveWords(String text) {
        List<String> foundWords = findSensitiveWords(text);
        String markedText = text;
        for (String word : foundWords) {
            markedText = markedText.replace(word, word + "*");
        }
        return markedText;
    }

    // Provides a string representation of the sensitive word bank.
    @Override
    public String toString() {
        return "SensitiveWordBank: " + sensitiveWordBank.toString();
    }

    // Checks equality based on the sensitive word bank's content.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        abstractClass that = (abstractClass) obj;
        return Objects.equals(sensitiveWordBank, that.sensitiveWordBank);
    }

    // Optional: provides a hash code based on the sensitive word bank's content.
    @Override
    public int hashCode() {
        return Objects.hash(sensitiveWordBank);
    }
}