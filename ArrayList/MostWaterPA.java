import java.util.*;

public class MostWaterPA {
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        int lp=0;
        int rp=height.size()-1;
        ArrayList<Integer> list = new ArrayList<>();

        while(lp<rp){
            int width = rp-lp;
            int heightOfWater = Math.min(height.get(lp), height.get(rp));
            int water = width * heightOfWater;
            list.add(water);
            maxWater = Math.max(maxWater, water);

            if(height.get(lp) < height.get(rp)){
                lp++;
            } else {
                rp--;
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
