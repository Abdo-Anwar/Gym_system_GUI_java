/**

 *  Abstract Class info

 *  this abstract class contain all the functions which get data being used in different classes

*/
package backend;


abstract class info
{
   /// return All object details in a single string line separated
    public abstract String lineRepresentation();
    /// Return the object unique IdNumber
    public abstract String getSearchKey(); 

     
}
