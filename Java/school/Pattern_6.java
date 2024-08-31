class Pattern_6
{
    void main()
    {
        int r,c ;
        char ch ;
        for (r = 1 ; r <= 5 ; r++)
        {
            for(c = 1,ch = 'A'; c <= r ; c++,ch++)
            System.out.print(ch + " ");
            System.out.println();
        }
    }
}