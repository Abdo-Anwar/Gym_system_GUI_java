
package backend;


abstract class dataBase
{

    public dataBase() {}


public abstract void readFromFile ();
public abstract info createRecordFrom (String line);
//public abstract ArrayList<info> returnAllRecords ();
public abstract boolean contains (String key);
public abstract info getRecord (String key); 
abstract public  void insertRecord(info record);   /// each class will define a fn with a different parameter datatype and this is not apply to abstraction
public abstract void deleteRecord (String key);
public abstract void saveToFile();
  
}
