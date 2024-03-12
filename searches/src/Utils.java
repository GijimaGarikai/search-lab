package src;
import java.util.function.Predicate;

class Utils {
    public static <T> T search(Iterable<T> values, Predicate<? super T> pred) throws Exception {

        for(T value : values) {
            if(pred.test(value)) {
                return value;
            }
        }
        return null;
    }

        /**
     * Search for val in values, return the index of an instance of val.
     *
     * @param values
     *   A sorted array of integers
     * @param val
     *   An integer we're searching for
     * @result
     *   index, an integer
     * @throws Exception
     *   If there is no i s.t. values[i] == val
     * @pre
     *   values is sorted in increasing order.  That is, values[i] <
     *   values[i+1] for all reasonable i.
     * @post
     *   values[index] == val
     */
    public static int binarySearch (int[] values, int val) throws Exception {
        int low, high, mid;
        low = 0;
        high = values.length - 1;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (values[mid]==val) {
                return mid;
            }
            else if (values[mid] > val) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        // System.out.print("values - ");
        // for(int i = 0; i < values.length; i++) {
        //     System.out.print(values[i] + " ");
        // }
        // System.out.println();
        throw new Exception(" Value not found : " + val);   // STUB
    } // binarySearch

    public static int binarySearchRec(int[] values, int val) throws Exception{
        int low = 0, high = values.length - 1;
        int index = -1;
        try {
          index = binaryHelper(values, val, low, high);
          return index;
        }
        catch (Exception e) {
            // if (val%2==0) { 
            //   e.printStackTrace();
            // }
        }
        return -1;
    }

    public static int binaryHelper(int[] values, int val, int low, int high) throws Exception{
        int mid = low + (high - low)/2;
        
        if (low > high) {
            return -1;
        }

        if (values[mid] == val) {
            return mid;
        }
        else if (values[mid] > val) {
            return binaryHelper(values, val, low, mid-1);
        }
        else{
            return binaryHelper(values, val, mid+1, high);
        }

    }
}
