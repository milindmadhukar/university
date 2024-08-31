class Pattern
{
    void main()
    {
        int NOL = 5; 
        for(int line = 1 ; line <= 5 ; line++)
        {
            for(int j = 1 ; j <= (NOL - line) ; j++)
            System.out.print("*");
            System.out.println(line);
        }
    }
}