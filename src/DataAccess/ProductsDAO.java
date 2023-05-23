/**

 A Data Access Object (DAO) class for handling operations related to the "products" table in the database.
 Extends the AbstractDAO class with the type parameter set to "products".
 */
package DataAccess;

import Model.products;

public class ProductsDAO extends AbstractDAO<products>{
    /**
     * Constructs a new ProductsDAO object.
     * Calls the constructor of the superclass, AbstractDAO, with no arguments.
     */
    public ProductsDAO (){
        super();
    }

}
