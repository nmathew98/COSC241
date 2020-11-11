package week06;

public class WordList {

    // The first word in this WordList.
    private String first;

    // The remaining words in this WordList.
    private WordList rest;

    // Creates a new empty WordList.
    public WordList() {
        this.first = "";
        this.rest = null;
    }

    // Creates a new WordList consisting of `word' joined to the
    // front of `rest'.
    private WordList(String word, WordList rest) {
        this.first = word;
        this.rest = rest;
    }

    // Returns a new WordList by adding `word' to this WordList.
    public WordList add(String word) {
        return new WordList(word, this);
    }

    // Returns true if this WordList contains `word' otherwise false.
    public boolean contains(String word) {
        if (this.first.equals(word)) {
            return true;
        } else if (this.rest != null) {
            return this.rest.contains(word);
        } else {
            return false;
        }
    }

    // Returns true if this WordList is empty, otherwise false.
    public boolean isEmpty() {
        return this.first == "" ? true : false;
    }

    // Returns how many words are in this WordList.
    public int size() {
        int count = 0;
        if (this.first != "") {
            count++;
            if (this.rest != null) {
                count += this.rest.size();
            } else {
                return count;
            }
        }
        return count;
    }

    // Returns a String representation of this WordList consisting of
    // each word in the order they were added separated by spaces.
    public String toString() {
        String wordList = "";
        if (this.first != "") {
            wordList = this.first;
            if (this.rest != null) {
                wordList = this.rest.toString() + " " + wordList;
            }
        }
        return wordList.trim();
    }
}
