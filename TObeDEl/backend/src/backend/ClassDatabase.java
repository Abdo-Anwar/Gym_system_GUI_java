/**

 *   Class  ClassDataBase

 *  this  class contain all the functions being used in creating,editing,creating databases for classes

 */
package backend;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ClassDatabase extends dataBase
{
    private ArrayList<Class> records= new ArrayList<>();
    private String fileName;
    public ClassDatabase(String fileName)
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

            ArrayList<String> classesRecords = new ArrayList<String>();

            while (scan.hasNextLine())
            {
                classesRecords.add(scan.nextLine());
            }

            for (String temp : classesRecords)
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
    public Class createRecordFrom(String line)
    {
        //rewrite yasein with your code
        /// done
        String[] subStrings;
        subStrings = line.split(",");
        String classid = subStrings[0];
        String className = subStrings[1];
        String trainerId = subStrings[2];
        int duration =  Integer.parseInt(subStrings[3]);
        int availableSeats = Integer.parseInt(subStrings[4]);

        return new Class(classid,className,trainerId,duration,availableSeats);
    }


    public ArrayList<Class> returnAllRecords()
    {
        return this.records;
    }

    @Override
    public boolean contains(String key)
    {
        boolean checkTrainer = false;
        for(Class temp: this.records)
        {
            /// the class with the given key (Class ID) exists in the records
            if(temp.getSearchKey().matches(key)) return true;
        }
        /// the class with the given key (Class ID) does not exist in the records
        return  checkTrainer;
    }



    @Override
    public Class getRecord(String key)
    {

        for(Class temp: this.records)
        {
            if(temp.getSearchKey().matches(key))  return  temp;
        }
        return null;
    }

    public void insertRecord(info record)
    {
        /// Class already exists in the system
        Class classa = (Class) record;
        if( contains( classa.getSearchKey() ) )
        {
            System.out.println("Class do exist !!");
        }
        else
        {
            this.records.add(classa);

            System.out.println("New Class is added to the system !!");
        }

    }

    @Override
    public void deleteRecord(String key)
    {
        /// Class is not in the system
        if( ! contains( key ) )
        {
            System.out.println("Class does not exists !!");
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
            for(Class temp :this.records)
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

