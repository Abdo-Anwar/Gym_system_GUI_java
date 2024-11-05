/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author abdah
 */
public class UserInputs {
    
    public static void addTrainerInput(AdminRole admin) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Create new Trainer. Please Enter the Following Data:");

        String trainerId;
        do {
            System.out.print("Id: ");
            trainerId = scan.nextLine();
            if (!DataValidator.isValidID(trainerId)) {
                System.out.println("Invalid ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(trainerId));

        String name;
        do {
            System.out.print("Name: ");
            name = scan.nextLine();
            if (!DataValidator.isValidName(name)) {
                System.out.println("Invalid Name. Please enter a name containing only letters and spaces.");
            }
        } while (!DataValidator.isValidName(name));

        String email;
        do {
            System.out.print("Email: ");
            email = scan.nextLine();
            if (!DataValidator.isValidEmail(email)) {
                System.out.println("Invalid Email. Please enter a valid email address.");
            }
        } while (!DataValidator.isValidEmail(email));

        String specialty;
        do {
            System.out.print("Specialty: ");
            specialty = scan.nextLine();
            if (!DataValidator.isValidName(specialty)) {
                System.out.println("Invalid Specialty. Allowed types are: basic, premium, gold, silver.");
            }
        } while (!DataValidator.isValidMembershipType(specialty));

        String phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = scan.nextLine();
            if (!DataValidator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid Phone Number. Please enter an 11-digit phone number.");
            }
        } while (!DataValidator.isValidPhoneNumber(phoneNumber));

        admin.addTrainer(trainerId, name, email, specialty, phoneNumber);
        System.out.println("Trainer created successfully with validated data.");
    }
    
    

    public static void addMemberDataInput(TrainerRole tran) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Create new Member. Please Enter the Following Data:");

        String memberId;
        do {
            System.out.print("Member ID: ");
            memberId = scan.nextLine();
            if (!DataValidator.isValidID(memberId)) {
                System.out.println("Invalid Member ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(memberId));

        String name;
        do {
            System.out.print("Name: ");
            name = scan.nextLine();
            if (!DataValidator.isValidName(name)) {
                System.out.println("Invalid Name. Please enter a name containing only letters and spaces.");
            }
        } while (!DataValidator.isValidName(name));

        String membershipType;
        do {
            System.out.print("Membership Type: ");
            membershipType = scan.nextLine();
            if (!DataValidator.isValidMembershipType(membershipType)) {
                System.out.println("Invalid Membership Type. Allowed types are: basic, premium, gold, silver.");
            }
        } while (!DataValidator.isValidMembershipType(membershipType));

        String email;
        do {
            System.out.print("Email: ");
            email = scan.nextLine();
            if (!DataValidator.isValidEmail(email)) {
                System.out.println("Invalid Email. Please enter a valid email address.");
            }
        } while (!DataValidator.isValidEmail(email));

        String phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = scan.nextLine();
            if (!DataValidator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid Phone Number. Please enter an 11-digit phone number.");
            }
        } while (!DataValidator.isValidPhoneNumber(phoneNumber));

        String status;
        do {
            System.out.print("Status: ");
            status = scan.nextLine();
            if (!DataValidator.isValidStatus(status)) {
                System.out.println("Invalid Status. Allowed statuses are: active, expired, pending.");
            }
        } while (!DataValidator.isValidStatus(status));

        tran.addMember(memberId, name, membershipType, email, phoneNumber, status);
        System.out.println("Member created successfully with validated data.");
    }
    
    
    
    
    
    
    
    
     public static void addClassInput(TrainerRole tran) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Create new Class. Please Enter the Following Data:");

        String classID;
        do {
            System.out.print("Class ID: ");
            classID = scan.nextLine();
            if (!DataValidator.isValidID(classID)) {
                System.out.println("Invalid Class ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(classID));

        String className;
        do {
            System.out.print("Class Name: ");
            className = scan.nextLine();
            if (!DataValidator.isValidName(className)) {
                System.out.println("Invalid Class Name. Please enter a name containing only letters and spaces.");
            }
        } while (!DataValidator.isValidName(className));

        String trainerID;
        do {
            System.out.print("Trainer ID: ");
            trainerID = scan.nextLine();
            if (!DataValidator.isValidID(trainerID)) {
                System.out.println("Invalid Trainer ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(trainerID));

        int duration;
        do {
            System.out.print("Duration (in minutes): ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer for duration.");
                scan.next(); // Consume invalid input
            }
            duration = scan.nextInt();
            if (duration <= 0) {
                System.out.println("Duration must be a positive integer.");
            }
        } while (duration <= 0);

        int maxParticipants;
        do {
            System.out.print("Maximum Participants: ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer for maximum participants.");
                scan.next(); // Consume invalid input
            }
            maxParticipants = scan.nextInt();
            if (maxParticipants <= 0) {
                System.out.println("Maximum participants must be a positive integer.");
            }
        } while (maxParticipants <= 0);

        // Validated data can now be used to create the class.
        System.out.println("Class created successfully with validated data.");
        tran.addClass(classID, className, trainerID, duration, maxParticipants);
    }
     
     
     
     
     
      public static void registerMemberForClass(TrainerRole tran) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Register Member for Class. Please Enter the Following Data:");

        String memberID;
        do {
            System.out.print("Member ID: ");
            memberID = scan.nextLine();
            if (!DataValidator.isValidID(memberID)) {
                System.out.println("Invalid Member ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(memberID));

        String classID;
        do {
            System.out.print("Class ID: ");
            classID = scan.nextLine();
            if (!DataValidator.isValidID(classID)) {
                System.out.println("Invalid Class ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(classID));

        LocalDate registrationDate;
        while (true) {
            System.out.print("Registration Date (yyyy-MM-dd): ");
            String dateStr = scan.nextLine();
            if (DataValidator.isValidDate(dateStr)) {
                registrationDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            } else {
                System.out.println("Invalid Date. Please enter a valid date in the format yyyy-MM-dd and ensure it’s today or a future date.");
            }
        }

        tran.registerMemberForClass(memberID, classID, registrationDate);
        System.out.println("Member successfully registered for the class with validated data.");
    }
      
       public static void cancelRegistration(TrainerRole tran) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cancel Member Registration for Class. Please Enter the Following Data:");

        String memberID;
        do {
            System.out.print("Member ID: ");
            memberID = scan.nextLine();
            if (!DataValidator.isValidID(memberID)) {
                System.out.println("Invalid Member ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(memberID));

        String classID;
        do {
            System.out.print("Class ID: ");
            classID = scan.nextLine();
            if (!DataValidator.isValidID(classID)) {
                System.out.println("Invalid Class ID. Please enter an alphanumeric ID of length 4-10.");
            }
        } while (!DataValidator.isValidID(classID));

        tran.cancelRegistration(memberID, classID);
        System.out.println("Registration for Member ID " + memberID + " in Class ID " + classID + " has been canceled successfully.");
    }

      
}



