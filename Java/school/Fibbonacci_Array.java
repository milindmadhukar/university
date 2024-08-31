import java.util.*;
class Fibbonacci_Array
{
    public static void main(String[] args){
        int n, a = 0, b = 0, s = 1 ,j = 0,terms;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Lines : ");
        n = sc.nextInt();
        sc.close();
        terms = (n*(n+1))/2;
        int Fibbonacci[] = new int[terms];
        for(int i = 1; i <= terms; i++){
            a = b;
            b = s;
            s = a + b;
            Fibbonacci[j] =a;
            j++;
        }
        j = 0;
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c <= r ; c++){
                System.out.print(Fibbonacci[j] + "\t");
                j++;
            }
            System.out.println();
        }
    }
}