// import java.util.*;

// class Cafe {
//       Scanner sc = new Scanner(System.in);
//       int choice = 0, Servings = 0, total = 0, new_total = 0, cost = 0;
//       double GST_Total = 0;
//       String Product, Final_Printer = "";

//       void main() {
//             System.out.println("Welcome To StarCups™");
//             Outer: while (true) {
//                   System.out.println("What do you want?");
//                   System.out.println(" 1 - Coffee");
//                   System.out.println(" 2 - Tea");
//                   System.out.println(" 3 - Exit");
//                   System.out.print("\nEnter your Choice : ");
//                   choice = sc.nextInt();
//                   if (choice >= 1 && choice <= 3) {
//                         switch (choice) {
//                               case 1:
//                                     cost = Coffee(); // calls method Coffee
//                                     break;
//                               case 2:
//                                     cost = Tea(); // calls method Tea
//                                     break;
//                               case 3:
//                                     Total_Calc();
//                                     break Outer;
//                         }
//                         Bill(cost);
//                   } else {
//                         System.out.println("Don't Try to Fool My Program ! :D ");
//                   }
//             }
//       }

//       int Coffee() {
//             System.out.println("You Chose Coffee ! ");
//             System.out.println("The Menu for Coffee is as follows : ");
//             System.out.println("Item No: Item Name:\t\t\tPrice:");
//             System.out.println("1.\t Cappucino(Hot) -\t\tRs.100");
//             System.out.println("2.\t Frappicino(Cold) -\t\tRs.110");
//             System.out.println("3.\t Americano(Hot) -\t\tRs.120");
//             System.out.println("4.\t Pumpkin Spice Latte (Hot) -\tRs.120");
//             System.out.println("5.\t Salted Caramel Mocha(Hot) -\tRs.130");
//             System.out.println("6.\t White Choclate Mocha(Hot) -\tRs.135");
//             System.out.println("7.\t Cafe Mocha(Hot) -\t\tRs.135");
//             System.out.println("8.\t Flat White(Hot) -\t\tRs.140");
//             System.out.println("9.\t Ice Coffee(Cold) -\t\tRs.150");
//             System.out.print("Enter Your Choice of Coffee : ");
//             int choice_coffee = sc.nextInt();
//             System.out.print("Enter the number of Servings Needed : ");
//             Servings = sc.nextInt();
//             switch (choice_coffee) {
//                   case 1:
//                         Product = "Cappucino";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 100;
//                         break;
//                   case 2:
//                         Product = "Frappicino";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 110;
//                         break;
//                   case 3:
//                         Product = "Americano";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 120;
//                         break;
//                   case 4:
//                         Product = "Pumpkin Spice Latte";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 120;
//                         break;
//                   case 5:
//                         Product = "Salted Caramel Mocha";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 130;
//                         break;
//                   case 6:
//                         Product = "White Choclate Mocha";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 135;
//                         break;
//                   case 7:
//                         Product = "Cafe Mocha";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 135;
//                         break;
//                   case 8:
//                         Product = "Flat White";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 140;
//                         break;
//                   case 9:
//                         Product = "Ice Coffee";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 150;
//                         break;
//                   default:
//                         System.out.println("Wrong Choice\nTry Again....");
//                         break;
//             }
//             return cost;
//       }

//       int Tea() {
//             System.out.println("You Chose Tea ! ");
//             System.out.println("The Menu for Tea is as follows : ");
//             System.out.println("Item No: Item Name:\t\tPrice:");
//             System.out.println("1.\t Normal Tea -\t\tRs.30");
//             System.out.println("2.\t Masala Tea -\t\tRs.35");
//             System.out.println("3.\t Ginger Tea -\t\tRs.40");
//             System.out.println("4.\t Green Tea -\t\tRs.45");
//             System.out.println("5.\t Black Tea -\t\tRs.50");
//             System.out.print("Enter Your Choice of Tea : ");
//             int choice_Tea = sc.nextInt();
//             System.out.print("Enter the number of Servings Needed : ");
//             Servings = sc.nextInt();
//             switch (choice_Tea) {
//                   case 1:
//                         Product = "Classic Tea";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 30;
//                         break;
//                   case 2:
//                         Product = "Masala Tea";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 35;
//                         break;
//                   case 3:
//                         Product = "Ginger Tea";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 40;
//                         break;
//                   case 4:
//                         Product = "Green Tea";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 45;
//                         break;
//                   case 5:
//                         Product = "Black Tea";
//                         System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
//                         cost = 50;
//                         break;
//                   default:
//                         System.out.println("Wrong Choice\nTry Again....");
//             }
//             return cost;
//       }

//       void Bill(int cost) {
//             total = cost * Servings;
//             new_total = new_total + total;
//             System.out.println("========================================================");
//             System.out.println("                         BILL              ");
//             System.out.println("                       StarCups™           ");
//             System.out.println("========================================================");
//             System.out.println("Product Name\t\tQuantinty\tPrice\t\tFinal");
//             String Printer = Product + "\t\t" + Servings + "   \t\t" + cost + " Rs\t\t" + total + "\n";
//             Final_Printer = Final_Printer + Printer;
//             System.out.println(Final_Printer);
//             System.out.println("\t\t\t\t\t\t       =========");
//             System.out.println("Total Amount =\t\t\t\t\t        " + new_total + " Rs\n\n");
//       }

//       void Total_Calc() {
//             if (new_total != 0) {
//                   double GST_Total = new_total * 1.18;
//                   System.out.println("Amount Payable(INCLUSIVE OF TAXES) =\t\t" + Math.round(GST_Total) + " Rs\n\n");
//                   System.out.println("THANK YOU >> COME BACK AGAIN\nSUB TO PEWDS AND GET 10% DISCOUNT!!!");
//             } else
//                   System.out.println("Go Buy Something.....\nMy Program is FoolProof:D ");
//       }
// }



















import java.util.Scanner;

class Cafe {
      public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int choice = 0, Servings = 0, total = 0, new_total = 0, cost = 0;
            double GST_Total = 0;
            String Product, Final_Printer = "";
            System.out.println("Welcome To StarCups™");
            Cafe obj = new Cafe();
            Outer: while (true) {
                  System.out.println("What do you want?");
                  System.out.println(" 1 - Coffee");
                  System.out.println(" 2 - Tea");
                  System.out.println(" 3 - Exit");
                  System.out.print("\nEnter your Choice : ");
                  choice = sc.nextInt();
                  if (choice >= 1 && choice <= 3) {
                        switch (choice) {
                              case 1:
                                    cost = obj.Coffee(); // calls method Coffee
                                    break;
                              case 2:
                                    cost = obj.Tea(); // calls method Tea
                                    break;
                              case 3:
                                    obj.Total_Calc();
                                    break Outer;
                        }
                        obj.Bill(cost);
                  } else {
                        System.out.println("Don't Try to Fool My Program ! :D ");
                  }
            }
      }

      int Coffee() {
            System.out.println("You Chose Coffee ! ");
            System.out.println("The Menu for Coffee is as follows : ");
            System.out.println("Item No: Item Name:\t\t\tPrice:");
            System.out.println("1.\t Cappucino(Hot) -\t\tRs.100");
            System.out.println("2.\t Frappicino(Cold) -\t\tRs.110");
            System.out.println("3.\t Americano(Hot) -\t\tRs.120");
            System.out.println("4.\t Pumpkin Spice Latte (Hot) -\tRs.120");
            System.out.println("5.\t Salted Caramel Mocha(Hot) -\tRs.130");
            System.out.println("6.\t White Choclate Mocha(Hot) -\tRs.135");
            System.out.println("7.\t Cafe Mocha(Hot) -\t\tRs.135");
            System.out.println("8.\t Flat White(Hot) -\t\tRs.140");
            System.out.println("9.\t Ice Coffee(Cold) -\t\tRs.150");
            System.out.print("Enter Your Choice of Coffee : ");
            int choice_coffee = sc.nextInt();
            System.out.print("Enter the number of Servings Needed : ");
            Servings = sc.nextInt();
            switch (choice_coffee) {
                  case 1:
                        Product = "Cappucino";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 100;
                        break;
                  case 2:
                        Product = "Frappicino";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 110;
                        break;
                  case 3:
                        Product = "Americano";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 120;
                        break;
                  case 4:
                        Product = "Pumpkin Spice Latte";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 120;
                        break;
                  case 5:
                        Product = "Salted Caramel Mocha";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 130;
                        break;
                  case 6:
                        Product = "White Choclate Mocha";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 135;
                        break;
                  case 7:
                        Product = "Cafe Mocha";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 135;
                        break;
                  case 8:
                        Product = "Flat White";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 140;
                        break;
                  case 9:
                        Product = "Ice Coffee";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 150;
                        break;
                  default:
                        System.out.println("Wrong Choice\nTry Again....");
                        break;
            }
            return cost;
      }

      int Tea() {
            System.out.println("You Chose Tea ! ");
            System.out.println("The Menu for Tea is as follows : ");
            System.out.println("Item No: Item Name:\t\tPrice:");
            System.out.println("1.\t Normal Tea -\t\tRs.30");
            System.out.println("2.\t Masala Tea -\t\tRs.35");
            System.out.println("3.\t Ginger Tea -\t\tRs.40");
            System.out.println("4.\t Green Tea -\t\tRs.45");
            System.out.println("5.\t Black Tea -\t\tRs.50");
            System.out.print("Enter Your Choice of Tea : ");
            int choice_Tea = sc.nextInt();
            System.out.print("Enter the number of Servings Needed : ");
            Servings = sc.nextInt();
            switch (choice_Tea) {
                  case 1:
                        Product = "Classic Tea";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 30;
                        break;
                  case 2:
                        Product = "Masala Tea";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 35;
                        break;
                  case 3:
                        Product = "Ginger Tea";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 40;
                        break;
                  case 4:
                        Product = "Green Tea";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 45;
                        break;
                  case 5:
                        Product = "Black Tea";
                        System.out.println("You chose " + Servings + " cup(s) of " + Product + " !");
                        cost = 50;
                        break;
                  default:
                        System.out.println("Wrong Choice\nTry Again....");
            }
            return cost;
      }

      void Bill(int cost) {
            total = cost * Servings;
            new_total = new_total + total;
            System.out.println("========================================================");
            System.out.println("                         BILL              ");
            System.out.println("                       StarCups™           ");
            System.out.println("========================================================");
            System.out.println("Product Name\t\tQuantinty\tPrice\t\tFinal");
            String Printer = Product + "\t\t" + Servings + "   \t\t" + cost + " Rs\t\t" + total + "\n";
            Final_Printer = Final_Printer + Printer;
            System.out.println(Final_Printer);
            System.out.println("\t\t\t\t\t\t       =========");
            System.out.println("Total Amount =\t\t\t\t\t        " + new_total + " Rs\n\n");
      }

      void Total_Calc() {
            if (new_total != 0) {
                  double GST_Total = new_total * 1.18;
                  System.out.println("Amount Payable(INCLUSIVE OF TAXES) =\t\t" + Math.round(GST_Total) + " Rs\n\n");
                  System.out.println("THANK YOU >> COME BACK AGAIN\nSUB TO PEWDS AND GET 10% DISCOUNT!!!");
            } else
                  System.out.println("Go Buy Something.....\nMy Program is FoolProof:D ");
      }
}