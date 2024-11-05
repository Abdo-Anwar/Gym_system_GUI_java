package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole
{
      private ClassDatabase classDatabase;
      private MemberDatabase memberDatabase;
      private MemberClassRegistrationDatabase memberClassRegistrationDatabase;


    public TrainerRole()
    {
        classDatabase = new ClassDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\backend\\src\\backend\\Classes.txt");
        memberDatabase = new MemberDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\backend\\src\\backend\\Members.txt");
        memberClassRegistrationDatabase = new MemberClassRegistrationDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\backend\\src\\backend\\Registrations.txt");
        classDatabase.readFromFile();
        memberDatabase.readFromFile();
        memberClassRegistrationDatabase.readFromFile();
    }
    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status)
    {   
        if (!DataValidator.isValidID(memberID)) {
        System.out.println("Invalid Member ID. Please enter an alphanumeric ID of length 4-10.");
        return;
    }

    if (!DataValidator.isValidName(name)) {
        System.out.println("Invalid Name. Name should contain only letters and spaces and be at least 2 characters long.");
        return;
    }

    if (!DataValidator.isValidMembershipType(membershipType)) {
        System.out.println("Invalid Membership Type. Please enter one of the allowed types: basic, premium, gold, or silver.");
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

    if (!DataValidator.isValidStatus(status)) {
        System.out.println("Invalid Status. Please enter one of the allowed statuses: active, expired, or pending.");
        return;
    }
        Member newMember  = new Member(memberID,name,email,phoneNumber,membershipType,status);
        memberDatabase.insertRecord(newMember);

    }
    public ArrayList<Member> getListOfMembers ()
    {
        return memberDatabase.returnAllRecords();
    }
    
    
    public void addClass (String classID, String className, String trainerID, int duration, int maxParticipants)
    {  TrainerDatabase trainerDatabase = new TrainerDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\backend\\src\\backend\\Trainers.txt");
        trainerDatabase.readFromFile();

        if (!DataValidator.isValidID(classID)) {
        System.out.println("Invalid Class ID. Please enter an alphanumeric ID of length 4-10.");
        return;
    }

    if (!DataValidator.isValidName(className)) {
        System.out.println("Invalid Class Name. Name should contain only letters and spaces and be at least 2 characters long.");
        return;
    }

    if ((!(DataValidator.isValidID(trainerID)))|| !trainerDatabase.contains(trainerID)) {

         System.out.println(trainerDatabase.contains(trainerID));
        System.out.println("Invalid Trainer ID. Please enter an alphanumeric ID of length 4-10.");
        return;
    }

    if (duration <= 0) {
        System.out.println("Invalid Duration. Duration should be a positive number.");
        return;
    }

    if (maxParticipants <= 0) {
        System.out.println("Invalid Max Participants. The number of participants should be a positive integer.");
        return;
    }
        
        Class newClass =  new Class(classID,className,trainerID,duration,maxParticipants);
        classDatabase.insertRecord(newClass);

    }
    public ArrayList<Class>getListOfClasses ()
    {
        return classDatabase.returnAllRecords();
    }
    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        
        if (!DataValidator.isValidID(memberID)) {
            System.out.println("Invalid Member ID. Please enter a valid ID.");
            return false;
        }

        if (!DataValidator.isValidID(classID)) {
            System.out.println("Invalid Class ID. Please enter a valid ID.");
            return false;
        }

        
        boolean memberCheck = memberDatabase.contains(memberID);
        boolean classCheck = classDatabase.contains(classID);
        boolean checkRegister = memberClassRegistrationDatabase.contains(memberID+classID);

        if (memberCheck && classCheck && checkRegister) {
            
            if (!DataValidator.isValidDate(registrationDate.toString())) {
                System.out.println("Invalid Registration Date. Please enter a date that is today or later.");
                return false;
            }

            Class classe = classDatabase.getRecord(classID);
            if (classe.getAvailableSeats() > 0) {
                MemberClassRegistration newRegister = new MemberClassRegistration(memberID, classID, "active", registrationDate);
                memberClassRegistrationDatabase.insertRecord(newRegister);
                classe.setAvailableSeats(classe.getAvailableSeats() - 1);
                System.out.println("Member registered for class successfully.");
                return true;
            } else {
                System.out.println("No available seats in this class.");
            }
        } else {
            if (!memberCheck) {
                System.out.println("Member ID does not exist.");
            }
            if (!classCheck) {
                System.out.println("Class ID does not exist.");
            }
        }

        return false;
    }
    public boolean cancelRegistration (String memberID, String classID)
    {
        if (!DataValidator.isValidID(memberID)) {
        System.out.println("Invalid Member ID. Please enter a valid ID.");
        return false;
    }

    if (!DataValidator.isValidID(classID)) {
        System.out.println("Invalid Class ID. Please enter a valid ID.");
        return false;
    }
        
        boolean checkRegister = memberClassRegistrationDatabase.contains(memberID+classID);

        if (checkRegister)
        {
            MemberClassRegistration registration  =  memberClassRegistrationDatabase.getRecord(memberID+classID);
            Class classe  =  classDatabase.getRecord(classID);
            LocalDate currentData =  LocalDate.now();
            int registrationDays = currentData.compareTo(registration.getRegistrationDate());
            if(registrationDays>=0 && registrationDays<=3)
                {
                    registration.settRegistrationStatus("canceled");
                    classe.setAvailableSeats(classe.getAvailableSeats()+1);
                    return true;
                }
            return false;

        }
        return false;
    }
    public ArrayList<MemberClassRegistration>getListOfRegistrations ()
    {return memberClassRegistrationDatabase.returnAllRecords();}
    public void logout()
    {

        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        memberClassRegistrationDatabase.saveToFile();


    }
}
