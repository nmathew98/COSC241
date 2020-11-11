package week10;

/**
 * EmptyPileException used by EP and ExamPile.
 * Thrown when a function gets an empty pile of papers to grade.
 * @author Naveen Mathew
 */

public class EmptyPileException extends Exception {
    /**
     * Gets rid of the serializable warning.
     * Not really needed but good for learning.
     */
    public static final long serialVersionUID = 1L;

    /**
     * Constructer method.
     * Passes the exception message to ther superclass
     * @param exception the exception message
     */
    public EmptyPileException(String exception) {
        super(exception);
    }

    /**
     * Gets the message that was thrown with the exception.
     * @return Returns the message that was passed to the superclass
     */
    public String getMessage() {
        return super.getMessage();
    }
}
