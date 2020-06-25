package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//candidate class
//all instant variable are private
//get method so we use encapsulation in it so we get it
class Candidate{
    private String name;//private instants
    private int number_of_vote;//private instants
//some get setter methods for private instants
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_vote() {
        return number_of_vote;
    }

    //it will set the increasement in the vote value
    public void setNumber_of_vote() {
        ++number_of_vote;
    }

    //constructer 1
    //it will give value to setName() method in instance
    public Candidate(String name){
        setName(name);
    }

    //to string method
    public String toString(){
        return ("Name of the Candidate is: "+getName()+"\t\tNumber of Vote: "+getNumber_of_vote());
    }
}

//Voting classs
 //class 2
class VotingMachine{
    ArrayList<Candidate> Candidate_Holder_array =new ArrayList<Candidate>();//Array list collection

//method 1
    //add name
    void addCandidateName(String canName) throws Exception {
        for(Candidate candidate : Candidate_Holder_array){
            if(candidate.getName().equals(canName)){
                throw new Exception("This Name is Already Exist");
            }
        }
        Candidate_Holder_array.add(new Candidate(canName));
    }
    //method 2
    //add vote
    void castVote(String name)throws Exception{
        for(Candidate candidate : Candidate_Holder_array){
            if(candidate.getName().equals(name)){
                candidate.setNumber_of_vote();
                return;
            }
        }  

        throw new Exception("Name is not in the list");
    }
    //method 3
    //to string
     public String toString(){
        String Candidate_null = "";
        for (Candidate candidate : Candidate_Holder_array) {
            Candidate_null += candidate.toString()+"\n\n";
        }
            return Candidate_null;
    }
    //method 4
    //claculate result
    public void Election_Result(){
        int HiggestVote = 0;
        int indexOfWinner = 0;
        for (int i = 0; i < Candidate_Holder_array.size(); i++) {
            if(Candidate_Holder_array.get(i).getNumber_of_vote() > HiggestVote){
                HiggestVote = Candidate_Holder_array.get(i).getNumber_of_vote();
                indexOfWinner = i;
            }
        }
        System.out.println("THe Winner Is:");
        System.out.println(Candidate_Holder_array.get(indexOfWinner).toString());
    }

}

//test class
class Election_Bouth{
    VotingMachine object_of_Machine = new VotingMachine();

    void Polling_bouth(){
        try {
            object_of_Machine.addCandidateName("a_candidate");
            object_of_Machine.addCandidateName("b_candidate");
            object_of_Machine.addCandidateName("c_candidate");
            object_of_Machine.addCandidateName("d_candidate");
            object_of_Machine.addCandidateName("e_candidate");


            Random rand = new Random();

            for(int i = 1; i<=rand.nextInt(1000);i++){
               object_of_Machine.castVote("a_candidate");
            }
            for(int i = 1; i<=rand.nextInt(1000);i++){
                object_of_Machine.castVote("b_candidate");
            }
            for(int i = 1; i<=rand.nextInt(1000);i++){
                object_of_Machine.castVote("c_candidate");
            }
            for(int i = 1; i<=rand.nextInt(1000);i++){
                object_of_Machine.castVote("d_candidate");
            }
            for(int i = 1; i<=rand.nextInt(1000);i++){
                object_of_Machine.castVote("e_candidate");
            }

            System.out.println("Candidate List is given Below:");
            System.out.println(object_of_Machine.toString());
            object_of_Machine.Election_Result();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        Election_Bouth obj = new Election_Bouth();
        obj.Polling_bouth();
    }
}
