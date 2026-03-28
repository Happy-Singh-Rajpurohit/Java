import java.util.*;

public class MostWaterBF {
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int width = j-i;
                int heightOfWater = Math.min(height.get(i), height.get(j));
                int water = width * heightOfWater;
                list.add(water);
                maxWater = Math.max(maxWater, water);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxArea(height));
    }
}
