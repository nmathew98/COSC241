package week11;

/**
 * An implementation of a merge sort.
 * @author Naveen Mathew
 */
public class MergeSort extends Sorter {
    /**
     * Data field to temporarily hold the array while sorting.
     */
    private Integer[] temporaryArray;

    /**
     * Passes the number array to sorter.
     * @param nums the array of numbers to sort
     */
    public MergeSort(Integer[] nums) {
        super(nums);
        temporaryArray = new Integer[nums.length];
    }

    /**
     * Called upon to sort the array of numbers.
     */
    public void sortNums() {
        mergeSort(0, nums.length - 1);
    }

    /**
     * Merge sorts the array of numbers recursively.
     * @param left the starting position of the sort
     * @param right the ending position of the sort
     */
    private void mergeSort(int left, int right) {
        if (++comparisons > 0 && left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
            update();
        }
    }

    /**
     * Merges the temporary array and the nums array.
     * @param left the starting position
     * @param mid the middle position
     * @param right the ending position
     */
    private void merge(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temporaryArray[i] = nums[i];
        }

        int i = left, j = left, k = mid;
        while (++comparisons > 0 && i < mid && k <= right) {
            if (temporaryArray[i] < temporaryArray[k]) {
                nums[j++] = temporaryArray[i++];
            } else {
                nums[j++] = temporaryArray[k++];
            }
            update();
        }
        while (++comparisons > 0 && i < mid) {
            nums[j++] = temporaryArray[i++];
            update();
        }
        while (++comparisons > 0 && j <= right) {
            nums[j++] = temporaryArray[k++];
            update();
        }
    }
}
