package week11;

/**
 * An implementation of a quick sort.
 * @author Naveen Mathew
 */
public class QuickSort extends Sorter {
    /**
     * Passes the array of numbers to sort to Sorter.
     * @param nums the array of numbers to sort
     */
    public QuickSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Called upon to sort the array of numbers.
     */
    public void sortNums() {
        quickSort(0, nums.length - 1 );
    }

    /**
     * Sorts the array of numbers using a quick sort.
     * @param left the starting position
     * @param right the ending position
     */
    private void quickSort(int left, int right) {
        if (left < right) {
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
    }

    /**
     * Partitions the array of numbers.
     * @param left the starting position
     * @param right the ending position
     * @return the hole in the array
     */
    private int partition(int left, int right) {
        int pivot = nums[left];
        int hole = left, i = left+1, j = right;
        while (true) {
            while (++comparisons > 0 && j > hole && nums[j] >= pivot) {
                j--;
                update();
            }
            if (++comparisons > 0 && j== hole) {
                update();
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while (++comparisons > 0 && i < hole && nums[i] < pivot) {
                i++;
                update();
            }
            if (++comparisons > 0 && i == hole) {
                update();
                break;
            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;
        return hole;
    }
}
