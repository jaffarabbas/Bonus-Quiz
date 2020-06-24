package com.company;
//Quiz 2

//in this i use filing read and write
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class Program_Checker{
//instance
   public String gender;
   public String firstname;
   public String lastname;
   public String status;
   public String Toyname;
   int coal=0,bicycle=0,Doll=0;
//method 1
    //main method
   public void Runner(){
        try{//file created List.txt
            String filename = "J:\\Github\\Bonus-Quiz\\src\\com\\company\\List.txt";

            File file = new File(filename);

            if(file.createNewFile()){
                System.out.println("File created");
            }
            else{
                Shopping_List_Created();
                Write_In_List();
                addlisttfile();
            }
        }
        catch(IOException e){
            System.out.println("Error : "+e);
        }
    }
//method 2
    //it will write in list
    public void Write_In_List() throws IOException {
	    Scanner obj = new Scanner(System.in);
    	System.out.println("Previous created");
    	        String filename  ="J:\\Github\\Bonus-Quiz\\src\\com\\company\\List.txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));
                PrintWriter pw = new PrintWriter(writer);
                System.out.println("Enter your Gender : ");
                 gender = obj.nextLine();
                System.out.println("Enter your First name : ");
                 firstname = obj.nextLine();
                System.out.println("Enter your Last name : ");
                 lastname = obj.nextLine();
                System.out.println("Enter your Status : ");
                 status = obj.nextLine();


                writer.write("\n"+gender+"      "+firstname+"\t      "+lastname+"\t  "+status+"\n");
                writer.close();
                System.out.println("FileWriter succesfully");

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String read;
       // System.out.println("Gender   First Name  Last Name  Status \n");
        while ((read = reader.readLine()) != null){
            System.out.println(read);
        }
    }
//method 3
    //it will create list
    public void Shopping_List_Created(){
        try{
            String filename2  ="J:\\Github\\Bonus-Quiz\\src\\com\\company\\ShoppingList.txt";
            File file2 = new File(filename2);
            if(file2.createNewFile()){
                System.out.println("Shopping File created");
            }

        }
        catch(IOException e){
            System.out.println("Error : "+e);
        }
    }
//it will set toy name by statement
    public String getToyname(){
        if(this.gender.equals("F") && this.status.equals("Good")){
            this.Toyname = "Doll";
        }
        else if(this.gender.equals("M") && this.status.equals("Good")){
            this.Toyname = "Bicycle";
        }
        else{
            this.Toyname = "Coal";
        }

        return Toyname;
    }
 //method 3
    //it will add lis in Shopping list
    public void addlisttfile() throws IOException {

        String filename = "J:\\Github\\Bonus-Quiz\\src\\com\\company\\ShoppingList.txt";
        FileWriter writer = new FileWriter(filename,true);

        PrintWriter print = new PrintWriter(writer);
        Show_Increasment();
        writer.write("\n"+firstname+"      "+lastname+"\t"+getToyname()+"\n\n\n\n"+"Coal : "+coal+"\nBicyle : "+bicycle+"\nDoll : "+Doll);
        writer.close();
        System.out.println("FileWriter succesfully");
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String read;
      //  System.out.println("First Name  Last Name  ToyName \n");
        while ((read = reader.readLine()) != null){
            System.out.println(read);
        }
    }

    //it will check increasement
    public void Show_Increasment(){
            if(getToyname().equals("Doll"))
                Doll++;
            else if(getToyname().equals("Bicycle"))
                bicycle++;
            else if(getToyname().equals("Coal"))
                coal++;
    }

//constructer to run main method
    public Program_Checker(){
	    Runner();
    }
}

//Main class
public class Quiz_5 {
    public static void main(String[] args) {
    	Program_Checker obj = new Program_Checker();
    }
}
