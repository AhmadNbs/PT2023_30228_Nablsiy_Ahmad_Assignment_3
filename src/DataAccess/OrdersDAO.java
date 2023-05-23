/**

 A Data Access Object (DAO) class for handling operations related to the "orders" table in the database.
 Extends the AbstractDAO class with the type parameter set to "orders".
 */

package DataAccess;

import Model.orders;

public class OrdersDAO extends AbstractDAO<orders>{
    /**
     * Constructs a new OrdersDAO object.
     * Calls the constructor of the superclass, AbstractDAO, with no arguments.
     */
    public OrdersDAO (){
        super();
    }
}
