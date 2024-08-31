import java.util.*;
class Download_Time_Calculator
{
    static double size_gb;
    static int speed_mbps;
      double new_size = size_gb ;
       double size_mb = new_size * 1024. ;
       double download_time_sec = size_mb / speed_mbps;
       double download_time_min = download_time_sec/60;
       double download_time_left_sec = download_time_sec % 60;
    Scanner sc = new Scanner(System.in);
    static void main()
    {
       System.out.print("Enter the file size in GB : ");
       size_gb = sc.nextDouble();
       System.out.print("Enter your Internet Speed in MBPS : ");
       speed_mbps = sc.nextInt();
       calculate();
    }
    void calculate()
    {
       if(download_time_min < 1 )
       {
           System.out.println("The Time Taken will be : "+Math.round(Math.ceil(download_time_sec))+" secs");
       }
       if(download_time_min < 60 && download_time_min >= 1)
       {
          System.out.println("The Time Taken will be : "+Math.round(Math.floor(download_time_min))+" mins and "+Math.round(download_time_sec)+" secs");
       }
       if(download_time_min >= 60)
       {
          double download_time_hrs = download_time_min / 60;
          double download_time_left_min = download_time_min % 60;
          System.out.println("The Time Taken will be : "+Math.round(Math.floor(download_time_hrs))+" hrs and "+ Math.round(download_time_left_min) + " mins ");
       }
    }
}