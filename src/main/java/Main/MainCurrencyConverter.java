package Main;

import java.io.*;
import java.util.Scanner;
import Currency.Coin;
import Currency.CoinFactory;
import Currency.Coins;


public class MainCurrencyConverter
{
    static Results resultsList;

    public static void main(String[] args)
    {

        String YesOrNo = "y";
        resultsList = new Results();

        System.out.println("Welcome to currency converter."  );

        do
        {
            int choice = screen1();
            double amount = screen2();

            Coins coinType = Coins.ILS;
            if (choice == 1) {
                coinType = Coins.ILS;
            } else if (choice == 2) {
                coinType = Coins.USD;
            } else if (choice == 3) {
                coinType = Coins.EUR;
            }


            Coin selectedCoin = CoinFactory.getCoinInstance(coinType);

            double result = selectedCoin.calculate(amount);

            YesOrNo = screen3(result, coinType);


        }
        while (YesOrNo.equalsIgnoreCase("y"));




        System.out.println("Thanks for using our currency converter.");
        System.out.println("Your results are");


        try
        {

            // Prints results and saves them to file
            for (String result :resultsList.list)
            {
                System.out.println(result);

                FileWriter fw = new FileWriter("D:\\\\results.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("\n" + result);
                bw.close();
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Bonus question 6 - open results file in notepad

        Runtime rs = Runtime. getRuntime();
        try {
            rs. exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

        // Method screen1
        // Displays screen1 and asks user for the conversion option
        // Gets no parameter
        // Returns user's choice of coin
        public static int screen1 ()
        {


            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option: (1/2/3) "   );
            System.out.println("1. Dollars to shekels "  );
            System.out.println("2. Shekels to dollars"  );
            System.out.println("3. Shekels to Euro"  );

            int choice = 0;

            try
            {
                choice = scanner.nextInt();
            }
            catch (Exception e)
            {
                choice = 0;
            }


            while (choice <1 || choice>3)
            {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Invalid choice, please try again "   );
                System.out.println("Please choose an option: (1/2/3) "   );
                System.out.println("1. Dollars to shekels "  );
                System.out.println("2. Shekels to dollars"  );
                System.out.println("3. Shekels to Euro"  );


                try
                {
                    choice = scanner2.nextInt();
                }
                catch (Exception e)
                {
                    choice = 0;
                }

            }


            return choice;



        }

        // Method screen2
        // Displays screen2 and asks user for the amount to convert
        // Gets no parameter
        // Returns user's input
        public static double screen2 ()
        {
            System.out.println("Please enter an amount to convert");

            Scanner scanner = new Scanner(System.in);

            double amount= -1;

            try
            {
                amount = scanner.nextDouble();
            }
            catch (Exception e)
            {
                amount = -1;
            }



            while (amount<0)
            {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Invalid choice, please try again "   );
                System.out.println("Please enter a positive number");

                try
                {
                    amount = scanner2.nextDouble();
                }
                catch (Exception e)
                {
                    amount = -1;
                }

           }
            return amount;

        }

        // Method screen3
        // Displays screen3 (the result) and asks user whether he wants to use the converter again
        // Gets calculation result and coin type
        // Returns user's choice
        public static String screen3 (double result, Coins coinType)
        {

            String resultText = "The result is: "+ result + " " + coinType;
            System.out.println(resultText);
            resultsList.list.add(resultText);


            System.out.println("Would you like to use the converter again? Y/N");
            Scanner scanner = new Scanner(System.in);
            String YesOrNo = scanner.next();

            while (!YesOrNo.equalsIgnoreCase("y") && !YesOrNo.equalsIgnoreCase("n"))
            {
                System.out.println("Invalid choice, please try again "   );
                System.out.println("Would you like to use the converter again? Y/N");
                YesOrNo = scanner.next();
            }
            return YesOrNo;




        }










}
