package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Naveen Mathew
 */
public class Tower{

    /** The top block. */
    private char top;

    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }

    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }

    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**
     * Count the number of blocks in a tower.
     * @return an int equal to the height of the tower
     * @author Naveen Mathew.
     */
    public int height() {
        if (!this.isEmpty()) {
            if (this.rest != null) {
                return 1 + this.rest.height();
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    /**
     * Counts the number of blocks equal to a character in the tower.
     * @param c character to look for
     * @return returns the number of blocks equal to c
     * @author Naveen Mathew
     */
    public int count(char c) {
        if (!this.isEmpty()) {
            if (this.rest != null) {
                if (this.top == c) {
                    return 1 + this.rest.count(c);
                } else {
                    return 0 + this.rest.count(c);
                }
            } else {
                return this.top == c ? 1 : 0;
            }
        } else {
            return 0;
        }
    }
}
