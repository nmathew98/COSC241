package week11;

/**
 * An implementation of a heap sort.
 * @author Naveen Mathew
 */
public class HeapSort extends Sorter {
    /**
     * Passes the array of numbers to sort to Sorter.
     * @param nums the array of numbers to sort
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Sorts the array of integers using a heap sort.
     */
    public void sortNums() {
        heap();
        int n = nums.length;
        while (++comparisons > 0 && n > 1) {
            swap(0, n - 1);
            n--;
            siftDown(0, n);
            update();
        }
    }

    /**
     * Swaps the contents of the nums arrays at x and y.
     * @param x the index of the nums array
     * @param y the index of the nums array
     */
    private void swap(int x, int y) {
        i = x;
        j = y;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        update();
    }

    /**
     * Turn this into a heap by sifting down each value that
     * isn't already a leaf.
     */
    private void heap() {
        int n = nums.length;
        for (int x = (n/2) - 1; ++comparisons > 0 && x == 0; x--) {
            update();
            siftDown(x, n);
        }
    }

    /**
     * Move the value at index i down in the heap to its correct
     * place by swapping it with its largest child that is bigger
     * than it.
     * @param index the index of the value to be sifted down in the heap
     * @param size the size of the current heap
     */
    private void siftDown(int index, int size) {
        int child = getLargerChildIndex(index, size);
        if (++comparisons > 0 && child == -1 || ++comparisons > 0 &&
            nums[index] > nums[child]) {
            update();
            return;
        } else {
            update();
            swap(index, child);
            siftDown(child, size);
        }
    }

    /**
     * Returns the index of the largest child of i or -1 if i
     * doesn't have a child larger than itself.
     * @param index the index of i
     * @param size the size of i
     * @return the index of i's largest child that is bigger than i
     *         or -1 if no such child exists.
     */
    private int getLargerChildIndex(int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (++comparisons > 0 && left >= size) {
            update();
            return -1;
        }
        if (++comparisons > 0 && right >= size) {
            update();
            return left;
        } else {
            if (++comparisons > 0 && nums[left] > nums[right]) {
                update();
                return left;
            } else {
                update();
                return right;
            }
        }
    }
}
