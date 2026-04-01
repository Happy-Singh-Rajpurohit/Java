import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {//O(n)
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //Sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i; // activity number
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function - short form / anonymous function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));   //Sort based on column 2 (end time)


        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println(maxAct);
        System.out.println(ans);
    }
}
