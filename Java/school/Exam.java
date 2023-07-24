class Exam
{
    void main()
    {
        int m = 1 ;
        int n = 5;
        int z = 0 ;
        int y = 2 ;
        switch(m)
        {
            case 1 :
            z = n + y ;
            case 2 :
            z = n - 1;
            case 3 :
            z = y+2;
            break;
            default : z = 0;
    }
    System.out.print("z="+z+"n="+n+"y="+y);
   }
}