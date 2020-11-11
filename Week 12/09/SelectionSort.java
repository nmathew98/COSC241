package week09;

/**
  * A selection sort implementation.
  * @author Naveen Mathew
  */
public class SelectionSort extends Sorter {
    /**
     * Create a new SelectionSort sorter.
     * @param nums the array of Integers to sort
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Sort our array of integers.
     */
    public void sortNums() {
        comparisons = 0;
        for (i = 0; i < nums.length - 1; i++) {
            int minimumIndex = i;
            for (j = i + 1; j < nums.length; j++) {
                comparisons++;
                minimumIndex = nums[minimumIndex] > nums[j] ? j : minimumIndex;
                update();
            }
            int temp = nums[i];
            nums[i] = nums[minimumIndex];
            nums[minimumIndex] = temp;
        }
    }
}
