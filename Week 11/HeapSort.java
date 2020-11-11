package week11;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Naveen Mathew
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using heap sort.
     */
    public void sortNums() {
        heapify();
        int n = nums.length;
        for (int s = n - 1; n > 0; s--) {
            swap(0, s);
            siftDown(0, s);
        }
    }

    private void swap(int x, int y) {
        // int i, j, and nums[] are all protected datafields in the
        // superclass Sort so we can use them without declaring them
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }

    /**
     *  Turn this into a heap by sifting down each value that isn't
     *  already a leaf.
     */
    private void heapify() {
        int n = nums.length;
        for (int x = (n/2) - 1; x>=0; x--) {
            siftDown(x, n);
        }
    }

    /**
     *  Move the value at index i down in the heap to its correct
     *  place by continually swapping it with its largest child that
     *  is bigger than it.
     *
     * @param i the index of the value to be sifted down in the heap.
     * @param size the size of the current heap (will be smaller than
     *        array length as heap sort is performed).
     */
    private void siftDown(int i, int size) {
        int child = getLargerChildIndex(i, size);
        if (child != -1) {
            swap(i, child);
            siftDown(child, size);
        }
    }

    /**
     *  Returns the index of the largest child of i, or -1 if i
     *  doesn't have a child larger than itself.
     *
     * @return the index of i's largest child that is bigger than i or
     *         -1 if no such child exists.
     */
    private int getLargerChildIndex(int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (++comparisons > 0 && right < size && nums[right] > nums[left] &&
            nums[right] > nums[index]) {
            return right;
        }
        if (++comparisons > 0 && left < size && nums[left] > nums[index]) {
            return left;
        }
        return -1;
    }
}
