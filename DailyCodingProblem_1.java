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