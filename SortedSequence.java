/**
 * @author andrewzheng
 * Question:R-12.7:This is the code for combining sequences through as an array. It will increase in capacity based
 * on the combined element through the if statement. This run in O(n) as this code goes through each element of the
 * sequence in n time while adding them together.
 */
import java.util.Arrays;
import java.util.Comparator;
public class SortedSequence {

  
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, k = 0;

        while (i + k != S.length) { 
            if (k == S2.length || (i < S1.length && comp.compare(S1[i], S2[k]) < 0))//this is to compare the two sequences by length
                if (k != 0) {
                    if (S[(i + k) - 1] != S1[i]) {
                        S[i + k] = S1[i];//does a scan through the sequence to add them into merge array
                    }
                    i++;
                } else {
                    S[i + k] = S1[i++];
                }
            else if (k != 0) { //same goes for the second sequence, it goes through every element and add them
                if (S[(i + k) - 1] != S2[k]) {
                    S[i + k] = S2[k];
                }
                k++;
            } else {
                S[i + k] = S2[k++];
            }
        }
    }

    public static String arrayToString(Object[] array) {
        StringBuilder result = new StringBuilder();
        for(Object object : array) {
            if(object != null) {
                result.append(object);//this removes the null values for the output as when the combining the sequence
                result.append(" "); //This is because when combining the arrays, the capacity increases, while it removes 
                //all the duplicate values, leaving it as null value
            }
        }
        return result.toString().trim();
    }
    //driver code to test
    public static void main(String[] args) {
        Comparator comp = new DefaultComparator();
        Integer[] array1 = {0, 1, 2, 3, 4, 9};
        Integer[] array2 = {0, 1, 2, 3, 4, 20, 50};
        Integer[] arrayResult = new Integer[array1.length + array2.length];//combining the two array/sequence for the output
        
        
        SortedSequence.merge(array1, array2, arrayResult, comp);
        
        System.out.println("The merge seqeuence ["+ arrayToString(arrayResult)+ "]");
    }
}


