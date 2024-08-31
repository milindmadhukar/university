class String_Bubble_Sort
{
    String arr[] = {"Tirth","Anurag","Das","Sarthak","Jash","Sahil Bhavesh","Virat","Mohit"};
    void main()
    {
        String tmp = "";
        System.out.println("Original Array : ");
        for(int k = 0 ; k < arr.length ; k++)
        System.out.print(arr[k] + ",");
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0 ; j< arr.length - i - 1 ;  j++)
            {
                if(arr[j].compareTo(arr[j+1]) > 0)
                {
                    tmp = arr[j] ; 
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
                }
        System.out.println("\n\nSorted Array : ");        
        for(int k = 0 ; k < arr.length ; k++)
        System.out.print(arr[k] + ",");
    }
}
