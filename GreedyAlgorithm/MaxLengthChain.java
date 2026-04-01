import java.util.*;

public class MaxLengthChain {
    public static void main(String[] args){//O(nlogn) because of sorting
        int pairs[][] = {{5,24}, {15,25}, {27,40}, {50,60}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > chainEnd){
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println(chainLength);
    }
}
