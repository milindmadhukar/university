import java.util.* ;
class Area_Perimetre{
    public static void main(String[] args){
        double r,per,area ;
        Scanner sc = new Scanner (System.in) ;
        System.out.print("Enter the Radius of the circle: ") ;
        r = sc.nextDouble() ;
        sc.close();
        per = 2 * Math.PI * r ;
        area = Math.PI * Math.pow(r,2) ;
        System.out.println("Enter the Perimetre of the circle = " + per) ;
        System.out.println("Enter the Area of the circle = " + area) ;
    }
}