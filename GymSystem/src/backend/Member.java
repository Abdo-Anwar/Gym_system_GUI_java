
package backend;

public class Member implements info
{
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String membershipType;
    private String status;

    public Member() {}

    public Member(String id, String name, String email, String phoneNumber,String membershipType,String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.status = status;
    }

    @Override
    /// return All trainer records in a single string line separated
    public String lineRepresentation()
    {
        /// String concatenation in order to get the trainer all details in one line separated by a COMMA
        String memberRecord;
        memberRecord = this.id + "," + this.name + "," + this.email +  ","  + this.phoneNumber + "," + this.membershipType + "," + this.status;
        return memberRecord;

    }
    @Override
    /// Return the Trainer unique IdNumber
    public String getSearchKey()
    {

        return this.id;

    }
    public void printMember()
    {
        System.out.println("id  : "+this.id);
        System.out.println("name  : "+this.name);
        System.out.println("email  : "+this.email);
        System.out.println("phoneNumber  : "+this.phoneNumber);
        System.out.println("membership  : "+this.membershipType);
        System.out.println("status  : "+this.status);

    }
}
