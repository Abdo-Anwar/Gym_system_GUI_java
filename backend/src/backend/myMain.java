package backend;

public class myMain


{

    public static void main(String[] args)
    {
        MemberDatabase memberDatabase = new MemberDatabase("C:\\Users\\User\\Desktop\\Gym_system_GUI_java\\backend\\src\\backend\\Members.txt");
        memberDatabase.readFromFile();
        Member member  =new Member("9032","Yassen","yi34039@gmail.com","01143931949","Gold","active");
        memberDatabase.insertRecord(member);
        memberDatabase.saveToFile();

    }



}
