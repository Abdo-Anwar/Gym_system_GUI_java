
package backend;


public class Class extends info
{
    
    private String classid;
    private String className;
    private String trainerID;
    private int duration ;
    private int availableSeats;

    public Class(String classid, String className, String trainerID, int duration, int availableSeats)
            {
                this.classid = classid;
                this.className = className;
                this.trainerID = trainerID;
                this.duration = duration;
                this.availableSeats = availableSeats;
            }

    

    public int getAvailableSeats()
            {
                return this.availableSeats;
            }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    
    
    @Override
    public String lineRepresentation()
            {
                return this.classid + "," + this.className + "," + this.trainerID + "," + Integer.toString(this.duration)+","+this.availableSeats;

            }
    @Override
    public String getSearchKey()
            {
                return this.classid;

            }

}
