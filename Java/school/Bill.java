import java.util.* ;
class Bill{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Cost of the Product: ");
        int product_value = sc.nextInt();
        System.out.print("Enter the Quantity of the Product: ");
        int quantity = sc.nextInt();
        sc.close();
        int amt,final_value;
        amt = product_value * quantity;
        final_value = (amt + amt*18/100);
        System.out.println("Cost of the product = " +final_value);
        
        
    }
}
        