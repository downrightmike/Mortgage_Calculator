/*************************************************************************
  *  Compilation:  javac Mortgage_Calculator.java
  *  Author: downrightmike
  *************************************************************************
  *  TODO: 
    A loan amount such as 100,000 dollars
    • A starting annual interest rate such as 4.000%, which is the decimal value 0.0400
    • An ending annual interest rate such as 6.000%, which is the decimal value 0.0600
    • The first number of years over which the loan will be repaid such as 15
    • The last number of years over which the loan will be repaid such as 30
    The main method will:
    • Call functions to acquire input from the user (while validating the input)
    • Invoke the payment calculation method within a loop.
  *************************************************************************/
  import java.util.Scanner;

public class Mortgage_Calculator{
    public static void main(String[] args){
        //global variables
       // private final 
        String sentinel = "a";
        int loanAmount = 0;
        int firstTermYears = 0;
        int lastTermYears = 0;
        double startingAnnualIR = 0.0;
        double endingAnnualIR = 0.0;
        int startingIRLarge = 0; //long startingIRLarge = 0;
        int endingIRLarge = 0; //long endingIRLarge = 0;
        double annutityFactorVariable = 0.0;
        double paymentVariable = 0.0;
        int arrayLength = 1; //Adding 1 because we normally start at zero


        //Start of the do loop
        do{
        //Call Methods that need input from user
        //A loan amount such as 100,000 dollars
       // loanAmount = IR4.getInteger("Enter the loan amount : ");
        //A starting annual interest rate such as 4.000%, which is the decimal value 0.0400
      //  startingAnnualIR =  IR4.getInteger("Enter the starting annual interest rate as a percent (n.nnn) : ");
        //An ending annual interest rate such as 6.000%, which is the decimal value 0.0600
      //  endingAnnualIR = IR4.getInteger("Enter the ending annual interest rate as a percent (n.nnn) : ");
        //The first number of years over which the loan will be repaid such as 15
      //  firstTermYears = IR4.getInteger("Enter the first term in years for calculating payments : ");
        //The last number of years over which the loan will be repaid such as 30
      //  endingAnnualIR = IR4.getInteger("Enter the last term in years for calculating payments : ");
            // Testing input
            loanAmount = 10000;
            startingAnnualIR = 4.000; 
            endingAnnualIR = 6.751;
            firstTermYears = 15;
            lastTermYears = 30;
            int iterations = 0;
            //Testing what to do about the decimal
            //Problem is I need to be able to iterate over it
            //I want the total number of periods that I need as a int    
            if(endingAnnualIR - startingAnnualIR < 0){
                System.out.println("Invalid interest rates ");
            } else{
            iterations = (int)((endingAnnualIR - startingAnnualIR)*1000) / 250;

//TODO Need to verify it catches the thousand's

            double testInterations1 = endingAnnualIR - startingAnnualIR;
            // System.out.println(testInterations1 + " testInterations1");
            double testInterations2 = testInterations1 * 1000;
            // System.out.println(testInterations2 + " testInterations2");
            double testInterations3 = testInterations2 / 250;
            //If there is a remainder after dividing by 25, I want to capture the extra for the
            if(testInterations3 % 1 != 0){
                // System.out.print("Not equal to 1  ");
                iterations = iterations + 1;
            }else{ // System.out.print("equal to 1  "); 
            }
            // System.out.println(testInterations3 + " testInterations3");
            int testInterations4 = (int)testInterations3 ;
            // System.out.println(testInterations4 + " testInterations4");


            System.out.println(iterations + " iterations");
        }//end of AIR sign check if
        
            //Call the annuityFactor method
        annutityFactorVariable = annuityFactor(firstTermYears, startingAnnualIR); //Good
        //System.out.println("annutityFactor " + annutityFactorVariable); 
        
        //Payment | Payment = Amount Loaned * Annuity Factor
        paymentVariable = payment(loanAmount, annutityFactorVariable); //Good
        //System.out.println("payment " + paymentVariable);
        //Invoke the payment calculation method within a loop.
        //Print Header
            System.out.print("Interest\n");
            System.out.print(" Rate ");
            for(int i = firstTermYears; i <= lastTermYears; i+=5 ){ //Good
                System.out.print("    " + i + " Years");
                arrayLength++;//Get an accurate count of the array length
            }System.out.println();
            //System.out.print("  Test Line   \n");
        //Print Matrix
        //*grabbed from the loops exercise for testing
   /*      int theArray [][] = new int [10][10];
        for (int r = 1; r < theArray.length; r++){//Start @ 1 on a 10x10 for 9x9
            System.out.print(r + " | ");
            for(int c = 1; c < theArray[1].length; c++){
                 theArray[r][c]  = r * c;
                 if(theArray[r][c] < 10){
                   System.out.print(" " + theArray[r][c] + " ");}
                 else{System.out.print(theArray[r][c] + " ");}
                 }System.out.println();
                } */
        //Interest Array print
        
      //  startingIRLarge = startingAnnualIR * 1000;
      //  endingIRLarge = endingAnnualIR * 1000;
                //doo doo doo  percent as a decimal doesn't work.
                //error: incompatible types: possible lossy conversion from double to int
        int iArray [][] = new int [arrayLength][arrayLength];//based on user's terms
        for (int r = 0; r < iterations; r++){
            System.out.print(r + " | ");
            for(int c = 1; c < iArray[1].length; c++){
                 iArray[r][c]  = r * c;
                 System.out.print(" " + iArray[r][c] + " ");
                }System.out.println();
                 
                }

        //Sentinel
        //Do you want to start over?
        //Is this even correct?  *Grab from last lab
          sentinel = "f"; // IR4.getString("Do you want to restart? :");
        }while(false);//sentinel.compareToIgnoreCase("q"));

    }//end of main
    //Mortgage methods start//////////////////////

   
    public static double annuityFactor(int years, double annualIR){
        //return 1.0;
         //Annuity Factor
    //Annuity Factor =(mir*(1+mir))^mtp))/(((1+mir)^mtp)-1)
    double mir = 0.0; //Monthly interest rate | the annual rate divided by 12.
    double mtp = 0.0; //Months to pay | the number of years times* 12.
        mir = annualIR / 12;
        mtp = years * 12;

    //1. Numerator = (mir*(1+mir)^mtp) = (0.003125*(1+0.003125)^360)
    double numerator = mir * Math.pow((1.0 + mir), mtp);
    //2. Denominator =(((1+mir)^mtp)-1)
    double denominator = (Math.pow((1.0 + mir), mtp) - 1);
    //3. Annuity Factor = Numerator / Denominator = 0.0096088 / 2.0748184
    double annuityFactorLocal = numerator / denominator;
        return annuityFactorLocal;
    }//End of annuityFactor method

    public static double payment(int loanAmount, double annuityFactor){
        double payment = 0.0;
        payment = loanAmount * annuityFactor;
        return payment;

    }//end of payment

    //Mortgage methods end//////////////////////
}//end of Class