package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;

public class Experiments {
    public static void main(String[] args) throws Exception{
        PrintWriter pen = new PrintWriter(System.out, true);
        String[] tmp = 
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike", 
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));

    String ex1b = Utils.search(Arrays.asList(tmp), (s) -> s.length() == 6);
    String ex2b = Utils.search(strings, (s) -> s.contains("u"));
    // pen.println("found : " + ex1b);
    // pen.println("found : " + ex2b + " with u in it");

    int index = 0;
    for (int i = 1; i <= 32; i++) {
      int[] arr = new int[i];
      for (int j = 0; j < i; j++) {
        arr[j] = j*2;
      }

      for (int k = 0; k < i; k++) {
        index = Utils.binarySearchRec(arr, 2*k);
        if (index != k) {
            pen.println("Position incorrect");
        }
      }

      for (int k = 0; k < i; k++) {
        try {
            if (Utils.binarySearchRec(arr, (2*k) + 1)!=-1){
                pen.println("odd number found");
            }
        }
        catch (Exception e) {

        }
        
      }
    }
    pen.println("Works as expected");
      
    }
}
