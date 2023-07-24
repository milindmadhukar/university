import java.util.Scanner;
class Sum_Of_Squares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number Of Elements: ");
        int n = sc.nextInt();
        int elements[] = new int[n];
        for(int i = 0; i < elements.length; i++) {
            System.out.print("Enter element "+(i+1)+" : ");
            elements[i] = sc.nextInt();
        }
        sc.close();
        int sum =0;
        for(int i: elements) {
            sum += i*i;
        }
        System.out.println("Sum is "+sum);
    }
}