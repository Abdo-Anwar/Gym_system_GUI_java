package backend;

import java.util.ArrayList;


public class AdminRole {

    private TrainerDatabase trainerDatabase;
    public AdminRole()
    {
         this.trainerDatabase = new TrainerDatabase("src/backend/Trainers.txt");
         this.trainerDatabase.readFromFile();

    }
    
    public void addTrainer(String traineId,String name ,String email,String specialty,String phoneNumber){
    if (!DataValidator.isValidID(traineId)) {
        System.out.println("Invalid Trainer ID. Please enter an alphanumeric ID of length 4-10.");
        return;
    }

    if (!DataValidator.isValidName(name)) {
        System.out.println("Invalid Name. Name should contain only letters and spaces and be at least 2 characters long.");
        return;
    }
    if (!DataValidator.isValidName(specialty)) {
        System.out.println("Invalid Name. Name should contain only letters and spaces and be at least 2 characters long.");
        return;
    }
    if (!DataValidator.isValidEmail(email)) {
        System.out.println("Invalid Email. Please enter a valid email address.");
        return;
    }

    if (!DataValidator.isValidPhoneNumber(phoneNumber)) {
        System.out.println("Invalid Phone Number. Phone number should contain exactly 11 digits.");
        return;
    }

        
        
        
        Trainer t= new Trainer(traineId, name, email, phoneNumber, specialty);
        if(trainerDatabase.contains(traineId)){
            System.out.println("this tranier already exist.");
        }else{
            trainerDatabase.insertRecord(t);
        }
     }
    public ArrayList<Trainer> getListOfTrainers(){
        
        ArrayList<Trainer> TrainerList= new ArrayList<>();
        TrainerList = trainerDatabase.returnAllRecords();
        return TrainerList;
    }
    public void removeeTrainer(String key){
        if (!DataValidator.isValidID(key)) {
        System.out.println("Invalid Trainer ID. Please enter an alphanumeric ID of length 4-10.");
        return;
    }
        
        if(!(trainerDatabase.contains(key))){
            System.out.println("this key doesn't exist "+key );
        }else{
            trainerDatabase.deleteRecord(key);
                    }
    }
    public void logout(){
    trainerDatabase.saveToFile();
    }
}
