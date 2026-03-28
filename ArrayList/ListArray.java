import java.util.*;


public class ListArray {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        System.out.println(list.get(1));

        list.add(5);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2,10);
        System.out.println(list);

        list.add(1,9);
        System.out.println(list);


        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        Collections.sort(list);
        System.out.println(list);
        
        //Collections.reverse(list) is a Comparator - fns in java which is used to define logic.
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
