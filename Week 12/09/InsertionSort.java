package week09;

/**
 *  An insertion sort implementation.
 *  @author Naveen Mathew
 */

public class InsertionSort extends Sorter {
   /**
    *  Creates a new InsertionSort sorter.
    *  @param nums the number integer to sort
    */
    public InsertionSort(Integer[] nums) {
       super(nums);
    }

   /**
    *  Sorts the numbers.
    */
    public void sortNums() {
        for (i = 1; i < nums.length; i++) {
            int key = nums[i];
            int temp = 0;
            j = i - 1;
            while (j >= 0 && nums[j] > key) {
                comparisons++;
                nums[j+1] = nums[j];
                j = j-1;
                update();
            }
            nums[j+1] = key;
        }
    }
}
