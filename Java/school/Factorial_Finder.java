class Factorial_Finder{
    public static void main(String[] args) {
        Factorial_Finder obj = new Factorial_Finder();
        System.out.println(obj.factorialUsingRecursion(6));
        System.out.println(obj.factorialUsingLoop(6));
    }
    public long factorialUsingRecursion(int n){
        long factorial = 1L;
        if(n == 0)
            return 1;
        factorial = n * factorialUsingRecursion(n-1);
        return factorial;
    }

    public long factorialUsingLoop(int n){
        long factorial = 1L;
        for (int i = 1; i <= n; i++)
            factorial *= i;
        return factorial;
    }
}