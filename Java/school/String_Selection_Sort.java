class String_Selection_Sort
{
    String a[] = {"Milind ","Anurag","Jash","Tirth","Sarthak","Rupesh","Rinkesh","RinkiyaKePapa"};
    int pos , i , j ;
    String tmp , small;
    void main()
    {
        for(i = 0; i <  a.length ; i++)
        {
            small = a[i];
            pos = i;
            for(j = i +1 ; j < a.length ;  j++)
            {
                if(a[j].compareTo(small) < 0)
                {
                    small = a[j];
                    pos = j;
                }
            }
                tmp = a[i];
                a[i] = a[pos];
                a[pos] = tmp;
        }
        for(int k = 0 ; k < a.length ; k++)
        System.out.print(a[k]+ ", " );
    }
}