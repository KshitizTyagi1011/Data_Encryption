import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;  // Add this import for Arrays

public class MaxPossibleMex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 3, 2, 5));
        int result = maxPossibleMex(list);
        System.out.println("Maximum Possible MEX: " + result);
    }
    
    public static int maxPossibleMex(List<Integer> list) {
        Collections.sort(list);  // Sort the list in ascending order
        
        int mex = 0;
        for (int num : list) {
            if (num <= mex) {
                mex++;  // Increment MEX if the current number is equal to or smaller than the current MEX
            } else {
                break;  // Stop iterating once we find a number greater than MEX
            }
        }
        
        return mex;  // Fix the space character here
    }
}
