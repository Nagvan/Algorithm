package arrays.rotation;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] array = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        int target = 3;
        int index = rotatedArraySearch(array, target);
        System.out.println("Index of " + target + " is: " + index);
        target = 7;
        index = rotatedArraySearch(array, target);
        System.out.println("Index of " + target + " is: " + index);
        target = 1;
        index = rotatedArraySearch(array, target);
        System.out.println("Index of " + target + " is: " + index);
        target = 6;
        index = rotatedArraySearch(array, target);
        System.out.println("Index of " + target + " is: " + index);
        target = 5;
        index = rotatedArraySearch(array, target);
        System.out.println("Index of " + target + " is: " + index);
    }

    private static int rotatedArraySearch(int[] array, int target) {
        /*
           if array is empty or null, we cant find anything so return -1, i.e. not found
         */
        if (array == null || array.length == 0) {
            return -1;
        }
        return rotatedArrayBinarySearch(array, target, 0, array.length - 1);
    }

    /**
     * Binary search of a number in rotated array
     * Will work for both left and right rotated array
     * Time complexity O(log(n))
     * Space complexity O(1)
     *
     * @param array      rotated array
     * @param target     number to be found
     * @param startIndex startIndex of the array
     * @param endIndex   endIndex of the array
     * @return index of the target in the array, if target not found then returns -1
     */
    private static int rotatedArrayBinarySearch(int[] array, int target, int startIndex, int endIndex) {
        //relative position of mid with startIndex and endIndex
        int mid = (startIndex + endIndex) / 2;
        //if startIndex is more than endIndex, it means we have no sub array to search the target
        if (startIndex > endIndex) {
            return -1;
        }
        //target is found in the array at mid index
        if (array[mid] == target) {
            return mid;
        }
        /*
           Either left of mid is sorted or right of mid is sorted.
           In rotated array if we divide the array into two, 1 part will always be sorted
           So find the sorted part, and if the target lie between the sub array we can search in that sub array.
           Else assume we will find it in another sub array and repeat.
         */
        if (array[startIndex] < array[mid - 1]) {
            if (array[startIndex] <= target && array[mid - 1] >= target) {
                return rotatedArrayBinarySearch(array, target, startIndex, mid - 1);
            } else {
                return rotatedArrayBinarySearch(array, target, mid + 1, endIndex);
            }
        } else {
            if (array[mid + 1] <= target && array[endIndex] >= target) {
                return rotatedArrayBinarySearch(array, target, mid + 1, endIndex);
            } else {
                return rotatedArrayBinarySearch(array, target, startIndex, mid - 1);
            }
        }
    }
}
