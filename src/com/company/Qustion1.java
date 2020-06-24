package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//first class (Main class)
//all values are hardcoded
abstract class Account_holder{

    Random Random_Value_for_Account_number = new Random();//random value for account number
    Scanner Scanner_For_Account_Holder_Information = new Scanner(System.in);//scanner for account holder information

    String Account_Holder_Name;//variables
    String Account_Type;//variables
    Long Account_Number = (Long)(Random_Value_for_Account_number.nextLong()%100000000)+1000000000000000000L;//variables==random creation
    double Balance_of_Account;//variables
    double Minimum_balance;//variables
    double Service_charges;//variables

    //contructer 1
    //1. Define parameterized constructor in a class hierarchy.
    public Account_holder(String Account_Holder_Name_of_constructer_parameter,String Account_Type_of_constructer_parameter){//parameters
        this.Account_Holder_Name = Account_Holder_Name_of_constructer_parameter;
        this.Account_Type = Account_Type_of_constructer_parameter;
    }

    //abstract method
    abstract public String toString();
}
//Second Class (Derived class 1 and derived from first class account holder)
class Saving_Account extends Account_holder{
    //contructer 2
    //contructer containing superclass constructer
    //1. Define parameterized constructor in a class hierarchy.
    public Saving_Account(double Balance_Of_Account,double Minimum_balance,double Service_charges){
        super("Hasan","cur");
        this.Balance_of_Account = Balance_Of_Account;
        this.Minimum_balance = Minimum_balance;
        this.Service_charges = Service_charges;
        Selection_Of_Methods_Of_Banking();
    }

    //abrtract method implementation
    public String toString(){
        return "Account Holder Name : "+Account_Holder_Name+"\n"+"Account Type : "+Account_Type+"\nAccount Number : "+Account_Number;
    }
    //Method 1
    //for interst
    //Compute interest and add to balance.
    void Simple_interest(double interest,int time_per_year){
        //A = P(1 + rt)
        double Simple_Interest = this.Balance_of_Account*(1+interest*time_per_year);//interst formula
        System.out.println("Interset Rate : "+interest+"\n\nInterst per "+time_per_year+" year is = "+Simple_Interest);
    }
    //Method 2
    //for deposit
    // Allow deposit and update the balance.
    void Deposit_Payment(double Payment_for_Deposit){
        double Payment_after_Desposit=Balance_of_Account+Payment_for_Deposit;//deposit formula
        System.out.println("Your Balance For Deposit is = "+Payment_for_Deposit+"\n\nYou Current Balance is = "+Balance_of_Account+"\n\nYou New Balance is = "+Payment_after_Desposit);
    }
    //Method 3
    //for with draw
    void Payment_for_WithDraw(double Payment_to_With_Draw){
        double Payment_after_With_Draw = Balance_of_Account - Payment_to_With_Draw;//with draw formula
        if(Payment_to_With_Draw > Balance_of_Account){
            System.out.println("You donot have enought Balance !!!!\n\nYour Wanted Balance for With draw is = "+Payment_to_With_Draw+"\n\nYour Current Balance is = "+Balance_of_Account);
            System.out.println("You Have Alert !!!!!!!\n\n");
            Check_for_Minimum_Balance(this.Minimum_balance,this.Service_charges);//method for checking minimum balance
        }
        else{
            System.out.println("Your Old Balance is = "+Balance_of_Account+"\n\nYou With Draw = "+Payment_to_With_Draw+"Your new Balance is = "+Payment_after_With_Draw+"\n\n\t\t\tHappy Banking!!!!!!!!");
        }
    }
    //Method 4 (SubMethod)
    //checking minimum balance
    void Check_for_Minimum_Balance(double Minimum_balance_check_for_method,double Service_charges_check_for_method){
        if(Balance_of_Account < Minimum_balance_check_for_method){
            System.out.println("Your Balance is ower Then The Appropiate Balance\n\n (Minimum balance = "+Minimum_balance_check_for_method+")\n\n konw You Have to Pay The Service Charge = "+Service_charges_check_for_method);
        }
        else{
            System.out.println("Your Balance is Following the Rule is under Minimum Balance");
        }
    }
    //Method 5
    // this for selecter of method through switch cases
    void Selection_Of_Methods_Of_Banking(){
        Scanner Scanner_For_Method_Selection = new Scanner(System.in);//Scanner for For_Method_Selection

        System.out.println("Its a Current Account of "+this.Account_Holder_Name+"\n\nFor Interest Rate type I\nFor With Draw type W\nFor Deposit type D");
        System.out.print("Enter");
        char Selecter_Character = Scanner_For_Method_Selection.next().charAt(0);
        switch (Selecter_Character){
            case 'I':
                Simple_interest(0.324,1);
                break;
            case 'W':
                Payment_for_WithDraw(500);
                break;
            case 'D':
                Deposit_Payment(1000);
                break;
            default:
                Selection_Of_Methods_Of_Banking();
                break;
        }
    }
}
//Third Class (Derived class 2 and derived from first class account holder)
class Current_Account extends Account_holder{
    double Balance_of_Account;//variable
    double Minimum_balance=100;//variable
    double Service_charges=500;//varibale

    //contructer 3
    ////contructer containing superclass constructer
    //1. Define parameterized constructor in a class hierarchy.
    public Current_Account(double Balance_Of_Accounts){
        super("hasan","cur");
        this.Balance_of_Account = Balance_Of_Accounts;
        Selection_Of_Methods_Of_Banking();
    }

    //String method is called 2 times
    public String toString(){
        return "Account Holder Name : "+Account_Holder_Name+"\n"+"Account Type : "+Account_Type+"\nAccount Number : "+Account_Number;
    }
    //Method 1
    void Deposit_Payment(double Payment_for_Deposit){
        double Payment_after_Desposit=Balance_of_Account+Payment_for_Deposit;
        System.out.println("Your Balance For Deposit is = "+Payment_for_Deposit+"\n\nYou Current Balance is = "+Balance_of_Account+"\n\nYou New Balance is = "+Payment_after_Desposit);
    }
    //Method 2
    void Payment_for_WithDraw(double Payment_to_With_Draw){
        double Payment_after_With_Draw = Balance_of_Account - Payment_to_With_Draw;
        if(Payment_to_With_Draw > Balance_of_Account){
            System.out.println("You donot have enought Balance !!!!\n\nYour Wanted Balance for With draw is = "+Payment_to_With_Draw+"\n\nYour Current Balance is = "+Balance_of_Account);
            System.out.println("You Have Alert !!!!!!!\n\n");
            Check_for_Minimum_Balance(this.Minimum_balance,this.Service_charges);
        }
        else{
            //Display the balance.
            System.out.println("Your Old Balance is = "+Balance_of_Account+"\n\nYou With Draw = "+Payment_to_With_Draw+"Your new Balance is = "+Payment_after_With_Draw+"\n\n\t\t\tHappy Banking!!!!!!!!");
        }
    }
    //Method 3 (SubMethod)
    void Check_for_Minimum_Balance(double Minimum_balance_check_for_method,double Service_charges_check_for_method){
        if(Balance_of_Account < Minimum_balance_check_for_method){
            System.out.println("Your Balance is ower Then The Appropiate Balance\n\n (Minimum balance = "+Minimum_balance_check_for_method+")\n\n konw You Have to Pay The Service Charge = "+Service_charges_check_for_method);
        }
        else{
            System.out.println("Your Balance is Following the Rule is under Minimum Balance");
        }
    }

    //Method 4 this for selecter of method through switch cases
    void Selection_Of_Methods_Of_Banking(){
        Scanner Scanner_For_Method_Selection = new Scanner(System.in);//Scanner for Meyhod o banking

        System.out.println("Its a Current Account of "+this.Account_Holder_Name+"\n\nFor With Draw type W\nFor Deposit type D");
        System.out.print("Enter");
        char Selecter_Character = Scanner_For_Method_Selection.next().charAt(0);
        switch (Selecter_Character){
            case 'W':
                Payment_for_WithDraw(500);
                break;
            case 'D':
                Deposit_Payment(1000);
                break;
            default:
                Selection_Of_Methods_Of_Banking();
                break;
        }
    }
}

class Data_base_log_class{
    Scanner Scanner_for_Account_type_selection = new Scanner(System.in);
    void First_Account_Method_Current_Account(){
        ArrayList<Account_holder> Holder_array =new ArrayList<Account_holder>(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(Holder_array.toString());
            Holder_array.add(new Current_Account(100000));
        }
    }

    void Second_Account_Method_Saving_Account() {

        ArrayList<Account_holder> Holder_array =new ArrayList<Account_holder>(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(Holder_array.toString());
            Holder_array.add(new Saving_Account(100000,200,500));
        }
    }

    void Display_Of_Accounts() {
        System.out.println("Select Your Account Types \n\nS for Saving\nC for Current");

        System.out.print("Enter : ");
        char Selecter_Of_Accounts = Scanner_for_Account_type_selection.next().charAt(0);

        switch (Selecter_Of_Accounts) {
            case 'S':
                First_Account_Method_Current_Account();
                break;
            case 'C':
                Second_Account_Method_Saving_Account();
                break;
            default:
                Display_Of_Accounts();
                break;
        }
    }
}

public class Qustion1 {

    public static void main(String[] args) {
        Data_base_log_class Object_Of_Data_Class = new Data_base_log_class();
        Object_Of_Data_Class.Display_Of_Accounts();
    }
}