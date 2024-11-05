/**

 *   Class TrainerDataBase

 *  this  class contain all the functions being used in creating,editing,creating databases for trainers

 */
package backend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TrainerDatabase extends dataBase
{
    private ArrayList<Trainer> records= new ArrayList<>();
    private String fileName;
    public TrainerDatabase(String fileName)
            {

                this.fileName = fileName;

            }

    
    //yassen all the implemntaion here is fake rewrite it ookkkk
    // Done
    
    @Override
    /// this function load the trainers data from the file into A LIST
    public void readFromFile()
            {
                try
                {
                    FileReader records =  new FileReader(this.fileName);

                    Scanner scan = new Scanner(records);

                    ArrayList<String> trainerRecords = new ArrayList<String>();

                    while (scan.hasNextLine())
                        {
                            trainerRecords.add(scan.nextLine());
                        }

                    for (String temp : trainerRecords)
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
    public Trainer createRecordFrom(String line)
            {
                //rewrite yasein with your code
                /// done
                String[] subStrings;
                subStrings = line.split(",");
                String id = subStrings[0];
                String name = subStrings[1];
                String email =  subStrings[2];
                String phoneNumber = subStrings[3];
                String specialty = subStrings[4];



                return new Trainer(id, name, email,specialty,phoneNumber);
            }

    
    public ArrayList<Trainer> returnAllRecords()
            {
                return this.records;
            }

    @Override
    public boolean contains(String key)
            {
                boolean checkTrainer = false;
                for(Trainer temp: this.records)
                    {
                        /// the trainer with the given key (trainer ID) exists in the records
                        if(temp.getSearchKey().matches(key)) return true;
                    }
                /// the trainer with the given key (trainer ID) does not exist in the records
                return  checkTrainer;
            }



    @Override
    public Trainer getRecord(String key)
            {

                for(Trainer temp: this.records)
                    {
                        if(temp.getSearchKey().matches(key))  return  temp;
                    }
                return null;
            }


    public void insertRecord(info record)
            {
                /// Trainer already exists in the system
                Trainer trainer = (Trainer) record;
                if( contains( trainer.getSearchKey() ) )
                    {
                        System.out.println("Trainer do exist !!");
                    }
                else
                    {
                        this.records.add(trainer);

                        System.out.println("New trainer is added to the system !!");
                    }

            }

    @Override
    public void deleteRecord(String key)
            {
                /// Trainer is not in the system
                if( ! contains( key ) )
                    {
                        System.out.println("Trainer does not exists !!");
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
                        for(Trainer temp :this.records)
                            {
                                saveRecords.write(temp.lineRepresentation()+"\n");
                            }
                        saveRecords.close();
                    }
                catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
            }

}

