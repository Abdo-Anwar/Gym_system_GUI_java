
package backend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberClassRegistrationDatabase extends dataBase{
    private ArrayList<MemberClassRegistration> records= new ArrayList<>();
    private String fileName;
    
    public MemberClassRegistrationDatabase(String fileName)
            {

                this.fileName = fileName;

            }
    @Override
   
    public void readFromFile()
            {
                try
                {
                    FileReader records =  new FileReader(this.fileName);

                    Scanner scan = new Scanner(records);

                    ArrayList<String> classRecords = new ArrayList<String>();

                    while (scan.hasNextLine())
                        {
                            classRecords.add(scan.nextLine());
                        }

                    for (String temp : classRecords)
                        {
                             this.records.add(createRecordFrom(temp));
                        }
                    records.close();
                }
                catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }



            }
    @Override
    public MemberClassRegistration createRecordFrom(String line)
            {
                
                String[] subStrings;
                subStrings = line.split(",");
                String memberID = subStrings[0];
                String classID = subStrings[1];
                String status =  subStrings[2];
                LocalDate data = null;

                return new MemberClassRegistration(memberID, classID, status,data);
            }
      public ArrayList<MemberClassRegistration> returnAllRecords()
            {
                return this.records;
            }

       @Override
    public boolean contains(String key)
            {
                boolean checkClassReg = false;
                for(MemberClassRegistration temp: this.records)
                    {
                        
                        if(temp.getSearchKey().matches(key)) return true;
                    }
               
                return  checkClassReg;
            }
    @Override
    public MemberClassRegistration getRecord(String key)
            {

                for(MemberClassRegistration temp: this.records)
                    {
                        if(temp.getSearchKey().matches(key))  return  temp;
                    }
                return null;
            }
    @Override
    public void insertRecord(info record)
            {
                
                MemberClassRegistration classReg = (MemberClassRegistration) record;
                if( contains( classReg.getSearchKey() ) )
                    {
                        System.out.println("Class Registration do exist !!");
                    }
                else
                    {
                        this.records.add(classReg);

                        System.out.println("Class Registration trainer is added to the system !!");
                    }

            }
    @Override
    public void deleteRecord(String key)
            {
               
                if( ! contains( key ) )
                    {
                        System.out.println("Member Class Registration does not exists !!");
                    }
                else
                    {
                        this.records.remove(getRecord(key));
                    }

            }
    @Override
    public void saveToFile()
            {
                try
                    {
                        FileWriter saveRecords =  new FileWriter(this.fileName);
                        for(MemberClassRegistration temp :this.records)
                            {
                                saveRecords.write(temp.lineRepresentation());
                            }
                        saveRecords.close();
                    }
                catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
            }
    
}
