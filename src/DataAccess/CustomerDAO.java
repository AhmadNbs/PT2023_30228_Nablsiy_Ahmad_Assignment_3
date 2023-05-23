/**

 A Data Access Object (DAO) class for handling operations related to the "clients" table in the database.
 Extends the AbstractDAO class with the type parameter set to "clients".
 */

package DataAccess;

import Model.clients;


public class CustomerDAO extends AbstractDAO<clients>{
    /**
     * Constructs a new CustomerDAO object.
     * Calls the constructor of the superclass, AbstractDAO, with no arguments.
     */
    public CustomerDAO (){
        super();
    }
}
