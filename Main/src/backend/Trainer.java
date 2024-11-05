

package backend;


public class Trainer implements info
{

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String specialty;


    public Trainer() {}

    public Trainer(String id, String name, String email,String specialty ,String phoneNumber )
            {
                this.id = id;
                this.name = name;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.specialty = specialty;

            }


    @Override
    /// return All trainer records in a single string line separated
    public String lineRepresentation()
            {
                /// String concatenation in order to get the trainer all details in one line separated by a COMMA
                String trainerRecord;
                trainerRecord = this.id + "," + this.name + "," + this.email + "," + this.phoneNumber+"," + this.specialty;
                return trainerRecord;

            }
    @Override
   /// Return the Trainer unique IdNumber
    public String getSearchKey()
            {

                return this.id;

            }
    public void printTrainer()
    {
        System.out.println("id  : "+this.id);
        System.out.println("name  : "+this.name);
        System.out.println("email  : "+this.email);
        System.out.println("phoneNumber  : "+this.phoneNumber);
        System.out.println("speciality  : "+this.specialty);

    }
}
