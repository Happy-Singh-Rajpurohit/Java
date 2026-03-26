import java.util.*;

public class ShortDistance {
    public static int ShortestDistance(String str){
        int i = 0;
        int j = 0;

        for(int k = 0; k < str.length(); k++){
            char ch = str.charAt(k);

            if(ch == 'N'){
                j++;
            }
            else if(ch == 'S'){
                j--;
            }
            else if(ch == 'E'){
                i++;
            }
            else if(ch == 'W'){
                i--;
            }
        }

        return (int)Math.sqrt(i*i + j*j);
    }

    public static void main(String args[]){
        String str = "WNEENESENNN";
        System.out.println(ShortestDistance(str));
    }
}