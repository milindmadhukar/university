class Report_Card
{
    void display()
    {
        String name = "MILIND";
        int roll,math,total ,science,english;
        roll = 9131;
        math = 100;
        science = 100;
        english = 100;
        total = math + science + english;
        double per = (total/3);
        System.out.println("Your name is "+ name);
        System.out.println("Your Roll No is "+ roll);
        System.out.println("Your percentage is : "+ per);
    }
}
        