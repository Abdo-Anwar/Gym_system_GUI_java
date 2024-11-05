/**

 *  interface info

 *  this interface class contain all the functions which get data being used in different classes

 */
package backend;

public interface info
{
    /// return All object details in a single string line separated
    public abstract String lineRepresentation();
    /// Return the object unique IdNumber
    public abstract String getSearchKey();

}

