
package backend;

import java.time.LocalDate;


public class MemberClassRegistration implements info {
    private String  memberID;
    private String  classID;
    private String   status ;
    private LocalDate registrationDate;

    public String getMemberID() {
        return memberID;
    }

    public MemberClassRegistration(String memberID, String classID, String status,LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = LocalDate.now();
    }

    public void setRegistrationDate() {
        this.registrationDate = LocalDate.now(); 
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getClassID() {
        return classID;
    }

    public void settRegistrationStatus(String status) {
        this.status = status;
    }
    @Override
    public String getSearchKey () {
        return memberID+classID;
    }
    @Override
    public String lineRepresentation(){
        String classRegInfo;
        classRegInfo = this.memberID+','+this.classID+','+this.registrationDate+','+this.status ;
        return classRegInfo;
    }
    public void printRegister()
    {
        System.out.println("memberId  : "+this.memberID);
        System.out.println("classId  : "+this.classID);
        System.out.println("status  : "+this.status);
        System.out.println("Date  : "+this.registrationDate);


    }
    
}
