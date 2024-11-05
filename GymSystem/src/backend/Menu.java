
package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
public static void AdminMenu(AdminRole admin, String Name){
              Scanner scan = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("Welcome to FOE Gym System. Admin User");
            System.out.println("----Welcome :"+Name);
            System.out.println("1. Add Trainer");
            System.out.println("2. Get List of Trainer ");
            System.out.println("3. Remove Trainer ");
            System.out.println("4. Logut");
            //System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    UserInputs.addTrainerInput(admin);
                    //System.out.println("Add Trainer succ.");
                    break;
                case 2:
                    
                    ArrayList<Trainer> TrList=   admin.getListOfTrainers();
                    System.out.println(TrList);
                    break;
                case 3:
                    System.out.println("Enter Trainer Id ");
                    String key = scan.nextLine();
                    admin.removeeTrainer(key);
                    System.out.println("Remove Trainer  succ.");
                    break;
                case 4:
                    System.out.println("logout.");
                     return;
                
                
                default:
                    
                    System.out.println("Invalid choice. Please choose again.");
            }
            
            System.out.println(); 
        } while (choice != 4);  

        
    }

    public static void trainerMenu(TrainerRole traniers){
              Scanner scan = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("Welcome to Movie Recommendation System. Trainer User:");
            System.out.println("----Welcome :");
            System.out.println("1- Add Member ");
            System.out.println("2- git List of members ");
            System.out.println("3- Add class ");
            System.out.println("4- git List of classes");
            System.out.println("5.register Member For Class ");
            System.out.println("6. cancel Registration ");
            System.out.println("7. get List Of Registrations ");
            System.out.println("8. logout ");
            System.out.print("Enter your choice: ");
            
            
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                 UserInputs.addMemberDataInput(traniers);
                    break;
                case 2:
                    ArrayList<Member> membersLIst;
                   membersLIst = traniers.getListOfMembers();
                    for(Member member : membersLIst)
                        member.printMember();
                    break;
                case 3:
                    UserInputs.addClassInput(traniers);
                    break;
                case 4:
                   ArrayList<Class> classLIst;
                   classLIst= traniers.getListOfClasses();
                    for(Class classe : classLIst)
                        classe.printClass();
                    break;
                case 5:
                    UserInputs.registerMemberForClass(traniers);
                    break;
                case 6:
                    UserInputs.cancelRegistration(traniers);
                    break;
                case 7:
                  ArrayList<MemberClassRegistration> RegList=  traniers.getListOfRegistrations();
                     for(MemberClassRegistration register : RegList)
                            register.printRegister();
                    break;
                case 8:
                    System.out.println("exit .. ");
                    traniers.logout();
                    return;
                default:
                    
                   
            }
            
            System.out.println(); 
        } while (choice != 8);  


    }

}
