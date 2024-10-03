import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Additional Notes: Due to time constraints, I have only completed a basic framework, 
//but the function implementation process will be comprehensively modified.

//General description for this PART: First, we define what sensitive words are. 
//Secondly, after we set a piece of text, we can find the sensitive words in the text.

//

public class SensitiveWordFilter {
    // Example field representing the sensitive word bank
    private Set<String> sensitiveWordBank;

    // Constructor to initialize the sensitive word bank
    public SensitiveWordFilter() {
        sensitiveWordBank = new HashSet<>();
    }

    // Kernel method: Add a sensitive word
    public void addSensitiveWord(String word) {
        sensitiveWordBank.add(word);
    }

    // Kernel method: Find sensitive words in the provided text
    public List<String> findSensitiveWords(String text) {
        List<String> foundWords = new ArrayList<>();
        for (String word : sensitiveWordBank) {
            if (text.contains(word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }

    // Kernel method: Check if a given word is a sensitive word
    public boolean isSensitiveWord(String word) {
        return sensitiveWordBank.contains(word);
    }

    // Secondary method: Remove a sensitive word
    public void removeSensitiveWord(String word) {
        sensitiveWordBank.remove(word);
    }

    // Secondary method: Count how many sensitive words appear in the given text
    public int countSensitiveWords(String text) {
        return findSensitiveWords(text).size();
    }

    // Secondary method: Clear the entire sensitive word bank
    public void clearSensitiveWords() {
        sensitiveWordBank.clear();
    }

    // Secondary method: Check if the provided text contains any sensitive words
    public boolean hasSensitiveWords(String text) {
        return !findSensitiveWords(text).isEmpty();
    }

    // Secondary method: Mark the sensitive words in the text
    public String markSensitiveWords(String text) {
        for (String word : sensitiveWordBank) {
            text = text.replace(word, word + "*");
        }
        return text;
    }

    // Main method: Show the component in action
    public static void main(String[] args) {
        SensitiveWordFilter filter = new SensitiveWordFilter();

        // Add some sensitive words
        filter.addSensitiveWord("Java");
        filter.addSensitiveWord("programming");
        filter.addSensitiveWord("applications");
        filter.addSensitiveWord("object-oriented");
        filter.addSensitiveWord("morning");

        // Example text. I will add text input and output and sth else in the future.
        String text = "Java is a versatile programming language widely used for building applications across various platforms. It is known for its object-oriented features, portability, and strong community support. Java's \"write once, run anywhere\" capability makes it a popular choice among developers.";

        // Find and mark sensitive words
        List<String> foundWords = filter.findSensitiveWords(text);
        String markedText = filter.markSensitiveWords(text);

        // Output the results
        System.out.println("Found sensitive words: " + foundWords);
        System.out.println("Marked text: " + markedText);
    }
}