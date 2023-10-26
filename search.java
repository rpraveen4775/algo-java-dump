class Search {
    void linearsearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                System.out.println("Element found at index " + i);
                break;
            }
        }
    }
    // This Function takes a sorted array and a key and returns the index of the key
    int binarySearch(int arr[], int key) {
        int low  = 0;
        int high = arr.length -1;

        while ( low <= high) {
            int mid = (low + high) / 2;

            if (key == arr[mid]){
                return mid;
            } else if (key < arr[mid]){
                high = mid -1;
            } else if (key > arr[mid]){
                low = mid;
            } else {
                return -1;
            }
        }
        return -1 ;
    }

    int jumpSearch(){ return 0; }
    int interpolationSearch(){ return 0; }
    int exponentialSearch(){ return 0; }
    int fibonacciSearch(){ return 0; }
    int ternarySearch(){ return 0; }
    int subListSearch(){ return 0; }
    int binarySearchOnLinkedList(){ return 0; }
    int binarySearchOnInfiniteArray(){ return 0; }
    int binarySearchOnNearlySortedArray(){ return 0; }
    int binarySearchOnSortedRotatedArray(){ return 0; }
    int binarySearchOnSortedRotatedArrayWithDuplicates(){ return 0; }


    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5,6 };
        int key = 4;
        Search obj = new Search();
        obj.linearsearch(arr, key);
    
        int arr2[] = { 1, 2, 3, 4, 5,6 };
        int response = obj.binarySearch(arr2, key);
        if ( response == -1 ) {
            System.out.println("key not found");
        } else {
            System.out.println("key found at index " + response);
        }
    }
}
