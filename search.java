class Search {
    int linearsearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;                
            }
        }
        return -1;
    }
    // This Function takes a sorted array and a key and returns the index of the key
    int binarySearch(int arr[], int key) {
        int low  = 0;
        int high = arr.length -1;

        while ( low <= high) {
            int mid = (low + high) / 2;
            // System.out.println("mid = " + mid);
            // System.out.print("low = " + low);
            // System.out.println(" high = " + high);

            if (key == arr[mid]){
                return mid;
            } else if (key < arr[mid]){
                high = mid;
            } else if (key > arr[mid]){
                low = mid+1;
            } else {
                return -1;
            }
        }
        return -1 ;
    }
    /* Jump Search:
     * jumps on a step of sqrt(n) and then does a linear search on a decided low and high
     */
    int jumpSearch(int arr[], int key) {
        int step = (int) Math.sqrt(arr.length);
        int prev = 0;
        int next = step;
        while (arr[next] < key && next < arr.length) {
            prev = next;
            next = next+step;
        }
        for (int i = prev; i <= next ; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    /* Interpolation Search : 
     * O(log2(log2 n)) for the average case, and O(n) 
     * Interpolation Search works on Array which are sorted and uniformly distributed
     * y=mx+c is the equation of a straight line
     * arr[hi]=m*hi+c
     * arr[lo]=m*lo+c
     * element = m*position +c
     * position can be calculated by subtracting eq 1 - eq 2 and eq2 - eq3.
     * position will be pivot element to search either left or right. 
     * This is an improvment over binary search for sorted and uniformly distributed array.
     */
    int interpolationSearch(){ return 0; }
    
    /* exponentialSearch :
     * This works better for unbounded/ Infinite array.
     * This works better if element is closer to the first element or last element.
     */
    int exponentialSearch(){ return 0; }

    /* fibonacciSearch :
     * Binary Search uses a division operator to divide range. Fibonacci Search doesn’t use /, 
     * but uses + and -. The division operator may be costly on some CPUs.
     * Complexity would be same as Binary Search : log(n)
     */
    int fibonacciSearch(){ return 0; }

    /* ternarySearch :
     * log3n complexity
     * binary search is better than ternary search
     * unnecessary complex code
     */
    int ternarySearch(){ return 0; }
    int subListSearch(){ return 0; }
    int binarySearchOnLinkedList(){ return 0; }
    int binarySearchOnInfiniteArray(){ return 0; }
    int binarySearchOnNearlySortedArray(){ return 0; }

    int binarySearchWithLowHigh(int arr[], int key,int low, int high ) {
        while ( low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]){
                return mid;
            } else if (key < arr[mid]){
                high = mid;
            } else if (key > arr[mid]){
                low = mid+1;
            } else {
                return -1;
            }
        }
        return -1 ;
    }
    /* Binary Search on Rotated Array
     * Rotation index is the index where the array is rotated
     * it is given
     * Find the element 
     */ 
    int binarySearchOnSortedRotatedArray(int arr[], int key, int rotationIndex){
        int low = 0;
        int high = arr.length -1;
        int leftSubPartIndex = binarySearchWithLowHigh(arr, key, low, rotationIndex - 1);
        int rightSubPartIndex = binarySearchWithLowHigh(arr, key, rotationIndex, high);

        if (leftSubPartIndex != -1){
            return leftSubPartIndex;
        } else if (rightSubPartIndex != -1){
            return rightSubPartIndex;
        }
        return -1 ;
    }
    int binarySearchOnSortedRotatedArrayWithDuplicates(){ return 0; }
    static void printResponse(String searchName, int response){
        if ( response == -1 ) {
            System.out.println(searchName+ ": key not found");
        } else {
            System.out.println(searchName +": key found at index " + response);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5,6 };
        int key = 5;
        Search obj = new Search();
        Search.printResponse("linearSearch",obj.linearsearch(arr, key));
    
        int arr2[] = { 1, 2, 3, 4, 5};
        
        Search.printResponse("binarySearch", obj.binarySearch(arr2, key));

        Search.printResponse("jumpSearch",obj.jumpSearch(arr2, key));
        int key2 = 7;
        int arr3[] = {4, 5, 6, 7, 8, 9,1, 2, 3};
        Search.printResponse("binarySearchOnSortedRotatedArray",obj.binarySearchOnSortedRotatedArray(arr3, key2, 6));
    }
}
