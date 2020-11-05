package arrays.rotation;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] leftArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        leftRotate(leftArray, k);
        System.out.println("After Left Rotation");
        for (int number : leftArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        int[] rightArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rightRotate(rightArray, k);
        System.out.println("After Right Rotation");
        for (int number : rightArray) {
            System.out.print(number + " ");
        }
    }

    /**
     * Function to rotate an array left by k
     * Total Time complexity O(n)
     * Total Space complexity O(1)
     * @param array array to be rotate
     * @param k amount by which array will be rotated
     */
    private static void leftRotate(int[] array, int k) {
        /*reverse 1st k numbers only
         * Time complexity O(k/2)
         * Space Complexity O(1)
         */
        reverse(array, 0, k - 1);
        /*reverse numbers after 1st k numbers only
         * Time complexity O((n-k)/2)
         * Space Complexity O(1)
         */
        reverse(array, k, array.length - 1);
        /*reverse entire array
         * Time complexity O(n/2)
         * Space Complexity O(1)
         */
        reverse(array, 0, array.length - 1);
    }

    /**
     * Function to rotate an array right by k
     * Total Time complexity O(n)
     * Total Space complexity O(1)
     * @param array array for rotation
     * @param k amount by which array will be rotated
     */
    private static void rightRotate(int[] array, int k) {
        /*reverse last k numbers only
         * Time complexity O(k/2)
         * Space Complexity O(1)
         */
        reverse(array, array.length - k, array.length - 1);
        /*reverse numbers before last k numbers only
         * Time complexity O((n-k)/2)
         * Space Complexity O(1)
         */
        reverse(array, 0, array.length - k - 1);
        /*reverse entire array
         * Time complexity O(n/2)
         * Space Complexity O(1)
         */
        reverse(array, 0, array.length - 1);
    }

    /**
     * Function to reverse an array, will work for any kind of array
     * Time complexity O(n/2)
     * Space complexity O(1)
     * @param array array to rotate
     * @param left left index
     * @param right right index
     */
    private static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
