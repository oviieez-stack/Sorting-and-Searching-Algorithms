import java.util.*;

public class AccountIdLookup {

    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("Linear Search:");
        if (found)
            System.out.println("Found");
        else
            System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
    }

    public static void binarySearchFloorCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1, comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary Search:");
        System.out.println("Floor: " + floor + ", Ceiling: " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }

    public static void insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        System.out.println("Insertion Point Index: " + low);
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        linearSearch(risks, 30);

        binarySearchFloorCeil(risks, 30);

        insertionPoint(risks, 30);
    }
}