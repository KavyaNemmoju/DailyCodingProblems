//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.


import java.util.ArrayList;
import java.util.Arrays;

class ListAddition {
    public static boolean list_add(int k, int[] list){
        for (int i=0; i<list.length; i++){
            for (int j=i+1; j<list.length; j++){
                if (list[i]+list[j]==k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String [] args){
        int[] l = {10,15,3,7};
        System.out.println(list_add(17, l));
    }
}
