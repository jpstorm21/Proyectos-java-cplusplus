
package lobos;

public class Lobos {

    public static boolean isPalindrome(String palabra){
        char [] vector = palabra.toCharArray();
        int tam = vector.length-1;
        boolean sol = false;
        for(int i = 0; i< vector.length-1;i++){
            if(vector[i] == vector[tam]){
                sol = true;
                tam--;
            }else{
                sol =false;
            }
        }
        return sol;
    }
    public static void main(String[] args) {
        boolean x = isPalindrome("ana");
        if(x){
            System.out.println("es palindrome");
        }else{
            System.out.println("no es palindrome");
        }
        
        
    }
    
}
