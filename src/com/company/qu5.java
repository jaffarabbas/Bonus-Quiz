import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
for this propose we made the class of children to save the data and object of this class is stored in the Arraylist f children
*/

// to store the data of Children
class Childern{
    // local Varaible  of the class
    private String firstName;
    private String lastName;
    private String Gender;
    private String Status;
    public String Toyname;

    // Constructor oof the class
    Childern(String gender1, String firstName1, String lastName1, String status){
        this.firstName = firstName1;
        this.lastName = lastName1;
        this.Gender = gender1;
        this.Status = status;
    }
    // for get the type of data
    public String getToyname(){
        if(this.Gender.equals("F") && this.Status.equals("Good")){
            this.Toyname = "Doll";
        }
        else if(this.Gender.equals("M") && this.Status.equals("Good")){
            this.Toyname = "Bicycle";
        }
        else{
            this.Toyname = "Coal";
        }

        return Toyname;
    }
//for return all the data
    public String toString(){
        return lastName +"\t"+ firstName +"\t"+ getToyname();
    }

}

// main class which do all the work
class SantasHelper {
    // ArrayList of children
    private ArrayList<Childern> listOfChild;


    // Constructor of the class
    SantasHelper(){
        listOfChild = new ArrayList<Childern>();
    }

    // get all data from the children
    public void getChild() throws IOException {
        File file = new File("List.txt");
        if (!file.exists()){
            throw new IOException("File not exist in the director ");
        }
        Scanner Output = new Scanner(new FileReader(file));

        Output.nextLine();
        while (Output.hasNext()){
            listOfChild.add(new Childern(Output.next(),Output.next(),Output.next(),Output.next()));
        }
    }

    // create shoppinglist and add the data to at
    public void addlisttfile() throws IOException {
        int coal=0,bicycle=0,Doll=0;
       FileWriter data = new FileWriter("ShoppingList.txt",true);
        PrintWriter print = new PrintWriter(data);
        print.println("Lastname\tFirstname\tToyname");

        for (Childern childern : listOfChild) {
            print.println(childern.toString());
            if(childern.Toyname.equals("Doll"))
                Doll++;
            else if(childern.Toyname.equals("Bicycle"))
                bicycle++;
            else
                coal++;
        }

        print.println("Coal: "+coal+"\nBicycle: "+bicycle+"\nDoll: "+Doll);
        print.close();
    }
    
    public void readtheFile(String FileName) throws FileNotFoundException {
        File file = new File(FileName);
        Scanner Output = new Scanner(new FileReader(file));

        System.out.println(Output.nextLine());
        System.out.println("________________");
        while (Output.hasNextLine())
            System.out.println(Output.nextLine());
    }
}


public class qu5 {
    public static void main(String[] args) {
        SantasHelper h1 = new SantasHelper();
        try {
            h1.getChild();
            h1.addlisttfile();

            //extra code for seeing all the data of the file
            System.out.println("====================================== Data if list.txt =========================================================");
            h1.readtheFile("List.txt");
   
            System.out.println("====================================== Data if ShoppingList.txt =========================================================");
            h1.readtheFile("ShoppingList.txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}