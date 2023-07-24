import java.util.Scanner;
class Arrowhead {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r , c,i;
        System.out.print("Enter a Word : ");
        String word = sc.next();
        int length = word.length();
        for(r = 1; r <= length ; r++){
            for(c = 1,i = 0; c <= r ;c++,i++) 
            {
                char ch = word.charAt(i);
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        for(r = 1; r <= length ; r++){
            for(c = length,i = 0 ; c > r   ;c--,i++){
                char ch = word.charAt(i);
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}