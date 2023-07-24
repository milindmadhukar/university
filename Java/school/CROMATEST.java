import java.util.*;
class CROMATEST
{
    int bill = 0;
    public void main()
    {
        int ch;
        System.out.println("CROMA");
        do
        {
        Scanner ob = new Scanner(System.in);
        System.out.println("1.MOBILES \n2.LAPTOPS \n3.CAMERAS \n4.HEADPHONES \n5.GAMING \n6.EXIT");
        System.out.print("ENTER CHOICE : ");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            MOBILE();
            break;
            case 2 :
            LAPTOPS();
            break;
            case 3 : 
            CAMERAS();
            break;
            case 4 :
            HEADPHONES();
            break;
            case 5 :
            GAMING();
            break;
            case 6:
            System.out.println("BILL = INR " + bill);
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
      }while(ch!=6);
    }
    public void MOBILE()
    {
        String n;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.APPLE DEVICES \n2.ANDROID DEVICES ");
        System.out.print("ENTER CHOICE : ");
        n = ob.next();
        char n1=ob.next().charAt(0);
        char n2 = ob.next().charAt(1);
        char n3 = ob.next().charAt(2);
        char n4 = ob.next().charAt(3);
        char n5 = ob.next().charAt(4);
        if(n1 == 'a' && n2 == 'p' && n3 == 'p' && n4 == 'l' && n5 == 'e' )
        {
            Apple();
        }
    }
    public void Apple()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.iPhone 8 - 60000INR \n2.iPhone 8+ - 70000INR  \n3.iPhone X - 80000INR \n4.iPhone XS - 90000INR \n5.iPhone XS MAX - 100000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 60000;
           break;
           case 2 :
           bill = bill + 70000;
           break;
           case 3 :
           bill = bill + 80000;
           break;
           case 4 :
           bill = bill + 90000;
           break;
           case 5 :
           bill = bill + 100000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void Android()
    {
        int ch;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.VIVO \n2.OPPO \n3.SAMSUNG \n4.ONEPLUS");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            VIVO();
            break;
            case 2 :
            OPPO();
            break;
            case 3 :
            SAMSUNG();
            break;
            case 4 :
            ONEPLUS();
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
    }
    public  void VIVO()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.VIVO V11 PRO - 30000INR \n2.VIVO V11 - 24000INR  \n3.VIVO V9 PRO - 18000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 30000;
           break;
           case 2 :
           bill = bill + 24000;
           break;
           case 3 :
           bill = bill + 18000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void OPPO()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.OPPO F9 - 22000INR \n2.OPPO F9 PRO - 27000INR  \n3.OPPO A5 - 16000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 22000;
           break;
           case 2 :
           bill = bill + 27000;
           break;
           case 3 :
           bill = bill + 16000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void ONEPLUS()
    {
        int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.ONEPLUS 5t - 26000INR \n2.ONEPLUS 6 - 35000INR  \n3.ONEPLUS 6t - 42000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 26000;
           break;
           case 2 :
           bill = bill + 35000;
           break;
           case 3 :
           bill = bill + 42000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void SAMSUNG()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.SAMSUNG GALAXY A9 - 39000INR \n2.SAMSUNG GALAXY NOTE 8 - 75000INR  \n3.SAMSUNG GALAXY NOTE 9 - 93000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 39000;
           break;
           case 2 :
           bill = bill + 75000;
           break;
           case 3 :
           bill = bill + 93000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void LAPTOPS()
    {
        int ch,n;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.MAC \n2.DELL \n3.HP ");
        System.out.print("ENTER CHOICE : ");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            MAC();
            break;
            case 2 :
            DELL();
            break;
            case 3 :
            HP();
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
    }
    public  void MAC()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.MACBOOK AIR - 65000INR \n2.MACBOOK PRO - 114000INR  \n3.iMac - 124000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 65000;
           break;
           case 2 :
           bill = bill + 114000;
           break;
           case 3 :
           bill = bill + 124000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void DELL()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.DELL LATITUDE - 55000INR \n2.DELL VOSTRO - 35000INR  \n3.DELL XPS - 65000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 55000;
           break;
           case 2 :
           bill = bill + 35000;
           break;
           case 3 :
           bill = bill + 65000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void HP()
    {
        int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.HP PRO BOOK - 46000INR \n2.HP ELITE BOOK - 65000INR  \n3.HP PAVILLION - 42000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 46000;
           break;
           case 2 :
           bill = bill + 65000;
           break;
           case 3 :
           bill = bill + 42000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void CAMERAS()
    {
        int ch,n;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.NIKON \n2.CANON \n3.GOPRO ");
        System.out.print("ENTER CHOICE : ");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            NIKON();
            break;
            case 2 :
            CANON();
            break;
            case 3 :
            GOPRO();
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
    }
    public  void NIKON()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.NIKON PRO  - 30000INR \n2.NIKON SMART - 20000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 30000;
           break;
           case 2 :
           bill = bill + 20000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void CANON()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.CANON PRO - 40000INR \n2.CANON SMART - 30000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 40000;
           break;
           case 2 :
           bill = bill + 30000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void GOPRO()
    {
        int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.GOPRO 2 - 35000INR \n2.GOPRO 3 - 50000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 35000;
           break;
           case 2 :
           bill = bill + 50000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void HEADPHONES()
    {
        int ch,n;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.BOSE \n2.BEATS \n3.SKULLCANDY ");
        System.out.print("ENTER CHOICE : ");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            BOSE();
            break;
            case 2 :
            BEATS();
            break;
            case 3 :
            SKULLCANDY();
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
    }
    public  void BOSE()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.BOSE QUIET COMFORT35  - 30000INR \n2.BOSE SOUNDLINK - 20000INR \n3.BOSE SOUND SPORT EARPHONES - 19000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 30000;
           break;
           case 2 :
           bill = bill + 20000;
           break;
           case 3 :
           bill = bill + 19000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void BEATS()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.BEATS SOLO 3 - 25000INR \n2.BEATS POWERBEATS 3 EARPHONES - 12000INR \n3.BEATS STUDIO3 - 50000INR ");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 25000;
           break;
           case 2 :
           bill = bill + 12000;
           break;
           case 3 :
           bill = bill + 50000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void SKULLCANDY()
    {
        int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.SKULLCANDY CRUSHER - 13000INR \n2.SKULLCANDY UPROAR  - 10000INR \n3.SKULLCANDY JIB - 20000INR");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 13000;
           break;
           case 2 :
           bill = bill + 10000;
           break;
           case 3 :
           bill = bill + 20000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void GAMING()
    {
        int ch,n;
        Scanner ob = new Scanner(System.in);
        System.out.println("1.XBOX DEVICES \n2.PLAYSTATION DEVICES ");
        System.out.print("ENTER CHOICE : ");
        ch = ob.nextInt();
        switch(ch)
        {
            case 1 :
            XBOX();
            break;
            case 2 :
            PS();
            break;
            default  :
            System.out.println("Error 401x DFJ");
        }
    }
    public  void XBOX()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.XBOX 1X  - 50000INR \n2.XBOX 1 - 25000INR \n3.XBOX 1S - 35000INR \n4.XBOX LIVE GOLD(1 YEAR) - 4000INR \n5.XBOX GAMES");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 50000;
           break;
           case 2 :
           bill = bill + 25000;
           break;
           case 3 :
           bill = bill + 35000;
           break;
           case 4 :
           bill = bill + 4000;
           break;
           case 5 :
           XBOXGAMES();
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void XBOXGAMES()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.CALL OF DUTY - 4000INR \n2.FIFA 19 - 4500INR \n3.PUBG - 2500INR \n4.GTA 5 - 3000INR ");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 4000;
           break;
           case 2 :
           bill = bill + 4500;
           break;
           case 3 :
           bill = bill + 2500;
           break;
           case 4 :
           bill = bill + 3000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public  void PS()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.PS4 SLIM  - 36000INR \n2.PS4 PRO - 42000INR \n3.PS4 - 30000INR \n4.PS PLUS(1 YEAR) - 6000INR \n5.PLAYSTATION GAMES");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 36000;
           break;
           case 2 :
           bill = bill + 42000;
           break;
           case 3 :
           bill = bill + 30000;
           break;
           case 4 :
           bill = bill + 6000;
           break;
           case 5 :
           PSGAMES();
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
    public void PSGAMES()
    {
       int ch;
       Scanner ob = new Scanner(System.in);
       System.out.println("1.CALL OF DUTY - 4000INR \n2.FIFA 19 - 4500INR \n3.PUBG - 2000INR \n4.GTA 5 - 3000INR ");
       ch = ob.nextInt();
       switch(ch)
       {
           case 1 :
           bill = bill + 4000;
           break;
           case 2 :
           bill = bill + 4500;
           break;
           case 3 :
           bill = bill + 2000;
           break;
           case 4 :
           bill = bill + 3000;
           break;
           default  :
           System.out.println("Error 401x DFJ");
        }
    }
}