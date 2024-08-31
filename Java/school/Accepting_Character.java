import java.util.*;
class Accepting_Character
{
    public static void main(String[] args){
        int i,n ;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Word: ");
        String s = sc.next();
        sc.close();
        n = s.length();
        for(i = 0 ; i < n ; i++){
           char ch = s.charAt(i);
           System.out.print(ch +", ");
        }
    }
}