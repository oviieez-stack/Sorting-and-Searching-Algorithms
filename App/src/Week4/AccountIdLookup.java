import java.util.*;

public class AccountIdLookup {

    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First: " + first + ", Last: " + last + ", Comparisons: " + comparisons);
    }

    public static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comparisons = 0;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                index = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int count = 0;

        if (index != -1) {
            int left = index, right = index;

            while (left >= 0 && arr[left].equals(target)) {
                count++;
                left--;
            }

            while (right < arr.length && arr[right].equals(target)) {
                count++;
                right++;
            }

            count--;
        }

        System.out.println("Binary Search:");
        System.out.println("Index: " + index + ", Count: " + count + ", Comparisons: " + comparisons);
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        linearSearch(logs, "accB");

        Arrays.sort(logs);
        System.out.println("Sorted: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
    }
}