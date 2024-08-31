class Rectangle 
{
    double lenght , breadth ;
    double area,perimetre ;
    void GetValues(double len , double bre)
    {
        lenght = len;
        breadth = bre;
    }
    double calcArea()
    {
        double ar = lenght * breadth ;
        area = ar ;
        return ar ; 
    }
    double calcPerimetre()
    {
        double perm = 2 * (lenght + breadth) ;
        perimetre = perm ;
        return perm ;
    }
}