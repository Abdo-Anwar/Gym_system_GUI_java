
package backend;
import java.util.ArrayList;
import java.util.Scanner;


public class Backend {

   
    public static void main(String[] args) {
        int ch;
        System.out.println("Enter Admin Name :");
        Scanner scan = new Scanner(System.in);
        String adminName = scan.nextLine();
        AdminRole admin= new AdminRole();
       // Menu.AdminMenu(admin,adminName);
        TrainerRole traniersRole  = new TrainerRole();
        do{
        System.out.println("User as ..");
        System.out.println("1. admin ");
        System.out.println("2. Trainer");
        System.out.print("Enter your choisse ");
        ch = scan.nextInt();
        scan.nextLine();
           switch (ch) {
                case 1:
                    Menu.AdminMenu(admin,adminName);
                    break;
                case 2:
                    
                    Menu.trainerMenu(traniersRole);
                    
                    break;
                case 3:
                    System.out.println("exit .. ");
                    break;
                
                default:
                    
                    System.out.println("Invalid choice. Please choose again.");
               }
            
            System.out.println(); 
        } while (ch != 3);  

        scan.close(); 
    }

    
}
