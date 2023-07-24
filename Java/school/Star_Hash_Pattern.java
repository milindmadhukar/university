class Star_Hash_Pattern
{
    void main()
    {
        for(int r = 1 ; r <= 5 ; r++)
        {
            for(int c = 1 ; c <= r ; c++)
            {
               if(c % 2 != 0)
               System.out.print("$ ");
               else
               System.out.print("# ");
            }
            System.out.println();
        }
    }
}