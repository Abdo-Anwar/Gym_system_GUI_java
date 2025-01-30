package backend;

import backend.Member;
import backend.Trainer;
import backend.dataBase;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberDatabase extends dataBase
{
    private ArrayList<Member> records= new ArrayList<>();
    private String fileName;
    public MemberDatabase(String fileName)
    {

        this.fileName = fileName;

    }


    //yassen all the implemntaion here is fake rewrite it ookkkk
    // Done

    @Override
    /// this function load the members data from the file into A LIST
    public void readFromFile()
    {
        try
        {
            FileReader records =  new FileReader(this.fileName);

            Scanner scan = new Scanner(records);

            ArrayList<String> memberRecords = new ArrayList<String>();

            while (scan.hasNextLine())
            {
                memberRecords.add(scan.nextLine());
            }

            for (String temp : memberRecords)
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
    public Member createRecordFrom(String line)
    {
        //rewrite yasein with your code
        /// done
        String[] subStrings;
        subStrings = line.split(",");
        String id = subStrings[0];
        String name = subStrings[1];
        String email =  subStrings[2];
        String phoneNumber = subStrings[3];
        String membershipType =subStrings[4];
        String status = subStrings[5];

        return new Member(id, name, email, phoneNumber,membershipType,status);
    }


    public ArrayList<Member> returnAllRecords()
    {
        return this.records;
    }

    @Override
    public boolean contains(String key)
    {
        boolean checkTrainer = false;
        for(Member temp: this.records)
        {
            /// the member with the given key (member ID) exists in the records
            if(temp.getSearchKey().matches(key)) return true;
        }
        /// the member with the given key (member ID) does not exist in the records
        return  checkTrainer;
    }



    @Override
    public Member getRecord(String key)
    {

        for(Member temp: this.records)
        {
            if(temp.getSearchKey().matches(key))  return  temp;
        }
        return null;
    }

    public void insertRecord(info record)
    {
        /// Member already exists in the system
        Member member = (Member) record;
        if( contains( member.getSearchKey() ) )
        {
            System.out.println("Member do exist !!");
        }
        else
        {
            this.records.add(member);

            System.out.println("New member is added to the system !!");
        }

    }

    @Override
    public void deleteRecord(String key)
    {
        /// Member is not in the system
        if( ! contains( key ) )
        {
            System.out.println("Member does not exists !!");
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
            for(Member temp :this.records)
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

