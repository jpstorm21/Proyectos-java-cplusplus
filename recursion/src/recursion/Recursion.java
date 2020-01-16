package recursion;

import java.util.Scanner;

public class Recursion {


    public static void main(String[] args) {
        int [] v1 = {1,2,3,4,5,6,7,8,9,10};
        int [] v2 = {1,2,3};
        int [] vf = new int [10];
        int cant = 0;
        for(int i = 0;i<v1.length;i++){
            boolean repetido = false;
            for(int j = 0;j<v2.length;j++){
                if(v1[i] == v2[j]){
                    repetido = true;
                    break;
                }
            }
            if(!repetido){
                vf[cant]= v1[i];
                cant++;
            }
        }
        
        for(int k = 0;k<cant;k++){
            System.out.print(vf[k] +" ");
        }    
    }
}
