package backend;

import java.util.ArrayList;

public class myMain


{

    public static void main(String[] args)
    {
//        MemberDatabase memberDatabase = new MemberDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\GymSystem\\src\\backend\\Members.txt");
//        memberDatabase.readFromFile();
//        Member member  =new Member("9032","Yassen","yi34039@gmail.com","01143931949","Gold","active");
//        memberDatabase.insertRecord(member);
//        memberDatabase.saveToFile();
//        Class classe  = new Class("9025","sasas","2564",6,5);
//        ClassDatabase classDatabase = new ClassDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\GymSystem\\src\\backend\\Classes.txt");
//        classDatabase.insertRecord(classe);
//        memberDatabase.saveToFile();
        TrainerRole trainerRole  = new TrainerRole();
        trainerRole.addClass("9025","sasas","2564",6,5);
        System.out.println(trainerRole.checkTrainerExistance("2564"));
        TrainerDatabase trainerDatabase = new TrainerDatabase("src/backend/Trainers.txt");
        trainerDatabase.readFromFile();
        ArrayList<Trainer> trainers = trainerDatabase.returnAllRecords();
        for (Trainer trainer : trainers)
            trainer.printTrainer();
    }



}
