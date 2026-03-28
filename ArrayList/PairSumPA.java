import java.util.*;
public class PairSumPA {
    public static boolean pairSum(ArrayList<Integer> list, int target){
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            //Case 1
            if(list.get(left) + list.get(right) == target){
                return true;
            }
            //Case 2
            else if(list.get(left) + list.get(right) < target){
                left++;
            }
            //Case 3
            else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int target = 9;
        System.out.println(pairSum(list, target));
    }
}
