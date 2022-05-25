class sort {
    /**
     * bubble sort
     * 每次比较相邻的两个数，将小的数放在后面，每一轮就可以确认一个正确位置的球。
     * 时间： n + ... + 2 + 1
     * O(n^2)
     */
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        
        // ith loop to confirm all the elements are in the right place
        for (int i = 0; i < n; i++) {
            // optimize: use swapped 确认是否在一轮中进行过交换操作，如果没有进行过一次，那么说明已经全部排好序，可以优化best case to O(n)
            boolean swapped = false;
            for (int j = 1; j < n - 1; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    swapped = true;
                }

                if (!swapped) return;
            }    
            
        }
    }

    /**
     * insertion sort: 
     * 将排序好的和未排序分开，每次从未排序里的挑出一个元素排入排序好的部分里面。(ascending)
     * 时间：1 + 2 + ... n = O(n^2)
     */
    public void insertSort(int[] nums) {
        int n = nums.length;

        // unsorted part loop, the first element see as in the sorted part:
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int j = i;
            // sorted part, move forward sorted part to get the slot for current element
            for (; j > 0; j--) {
                if (curr < nums[j]) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }

            // insert the current element:
             nums[j] = curr;
        }
    }


    /**
     * 
     */
    public void selectionSort(int[] nums) {

    }

    public void mergeSort(int[] nums) {

    }

    public void quickSort(int[] nums) {

    }

    public void bucketSort(int[] nums) {

    }

}