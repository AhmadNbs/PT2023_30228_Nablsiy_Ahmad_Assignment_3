package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

import javax.swing.table.DefaultTableModel;

/**

 This class is an abstract data access object (DAO) that provides common functionality for interacting with a database.

 It is parameterized with the type of object it handles.

 @param <T> the type of object

 @Author: Technical University of Cluj-Napoca, Romania Distributed Systems Research Laboratory, http://dsrl.coned.utcluj.ro/

 @Since: Apr 03, 2017

 @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**

     Constructs an AbstractDAO object.
     */
    @SuppressWarnings("unchecked")

    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**

     Creates a select query based on the provided field.
     @param field the field to be used in the WHERE clause
     @return the select query
     */

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }


    /**

     Retrieves all objects of type T from the database.

     @return A list containing all objects of type T found in the database. If no objects are found, an empty list is returned.
 */
    public List<T> findAll() {
        // TODO:
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        System.out.println(sb.toString());

        try {
            statement = dbConnection.prepareStatement(sb.toString());

            resultSet = statement.executeQuery();
            List<T> output = createObjects(resultSet);
            if(output.size() == 0) {
                System.out.println("Empty list");
            }
            return output;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    /**

     Retrieves an object of type T based on the provided ID.

     @param id The ID used to retrieve the object.

     @return An object of type T with the specified ID, or null if not found.
     */

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        ArrayList<T> obj = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**

     Retrieves a DefaultTableModel object representing the table data based on the provided list of objects.

     @param list The list of objects to populate the table data.

     @return A DefaultTableModel object representing the table data.
     */

    public DefaultTableModel getTable(List<T> list) {
        Vector<String> columnNames = new Vector<String>(); // TableHeader
        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // TableData

        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                columnNames.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        ListIterator<T> iter = list.listIterator();
        while (iter.hasNext()) {
            Vector<Object> vector = new Vector<Object>();
            Object object1 = iter.next();
            for (Field field1 : object1.getClass().getDeclaredFields()) {
                field1.setAccessible(true);
                Object value;
                try {
                    value = field1.get(object1);
                    vector.add(value);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
}


    /**

     Creates objects of type T from the ResultSet.
     @param resultSet The ResultSet containing the data to create objects from.
     @return A List of objects of type T created from the ResultSet.
     @throws InstantiationException If there is an error instantiating the object.
     @throws IllegalAccessException If there is an error accessing the fields of the object.
     @throws SQLException If there is an error accessing the data in the ResultSet.
     @throws IntrospectionException If there is an error introspecting the object.
     */

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**

     Inserts an object of type T into the database.

     @param t The object to be inserted into the database.

     @return The auto-generated ID of the inserted object.

     @throws IllegalAccessException If there is an illegal access to a field during the insertion process.

     @throws SQLException If a database access error occurs.
     */

    public int insert(T t) throws IllegalAccessException, SQLException {
        // TODO
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = 0;
        
        Class<?> myObjectClass = t.getClass();
        String className = myObjectClass.getSimpleName();
        Field[] fields = myObjectClass.getDeclaredFields();

        StringBuilder insertStatementString = new StringBuilder("INSERT INTO " + className + " VALUES(");

        int count = 0;
        System.out.println(fields.length);
        for(Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(t);
            if(field.getType().equals(String.class)) {
                insertStatementString.append("'");
            }
            insertStatementString.append(value);
            if(field.getType().equals(String.class)) {
                insertStatementString.append("'");
            }
            if(count == fields.length - 1) {
                insertStatementString.append(")");
            } else {
                insertStatementString.append(",");
            }
            ++count;
        }
        System.out.println(insertStatementString);
        insertStatement = dbConnection.prepareStatement(insertStatementString.toString(), Statement.RETURN_GENERATED_KEYS);
        insertStatement.executeUpdate();

        ResultSet rs = insertStatement.getGeneratedKeys();
        if(rs.next()){
            insertedId = rs.getInt(1);
        }

        ConnectionFactory.close(insertStatement);
        ConnectionFactory.close(dbConnection);

        System.out.println(className);
        return insertedId;
    }

    /**

     Updates an object of type T in the database based on the given ID value.

     @param t The object to be updated in the database.

     @param id_value The ID value used to identify the object to be updated.

     @return The updated object.
     */

    public T update(T t, int id_value){
        // TODO:
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        Class<?> myObjectClass = t.getClass();
        String className = myObjectClass.getSimpleName();

        Field[] fields = myObjectClass.getDeclaredFields();

        ArrayList<String> Names = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Names.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Names);

      StringBuilder updateStatementString = new StringBuilder("UPDATE " + className + " SET ");

        int count = 0;

        System.out.println(fields.length);
        Object value = null;
        for(Field field : fields) {
            field.setAccessible(true);
            try{
                value = field.get(t);
            }catch (IllegalAccessException e){
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("e.getMessage() = " + e.getMessage());
            }

            updateStatementString.append(Names.get(count) + " = ");
            if(field.getType().equals(String.class)) {
                updateStatementString.append("'");
            }
            updateStatementString.append(value);
            if(field.getType().equals(String.class)) {
                updateStatementString.append("'");
            }
          if (count == fields.length-1 ) {
              updateStatementString.append(" ");
          }
          else{
              updateStatementString.append(", ");
          }
            ++count;
        }
        updateStatementString.append(" WHERE "+ Names.get(0) +" = "+ id_value);
        System.out.println(updateStatementString);

        try{
            updateStatement = dbConnection.prepareStatement(updateStatementString.toString(), Statement.RETURN_GENERATED_KEYS);
            int rowsAffected = updateStatement.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }


        ConnectionFactory.close(updateStatement);
        ConnectionFactory.close(dbConnection);

        System.out.println(className);
        return t;
    }

    /**

     Retrieves the price of a product based on the given product ID.

     @param id_p The ID of the product.

     @return The price of the product.
     */

    public double getPrice (int id_p)
    {
        ResultSet rs = null;
        double price = 0;
        Connection dbConnection = null;
        Statement getValueStatement = null;

        String queryPrice = "SELECT * FROM products WHERE id_p = "+id_p;

        try{
            dbConnection = ConnectionFactory.getConnection();
            getValueStatement = dbConnection.createStatement();

            rs = getValueStatement.executeQuery(queryPrice);
            if (rs.next()) {
                 price = rs.getDouble("price"); //

                System.out.println("Field Value: " + price);
            } else {
                System.out.println("No matching records found.");
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        ConnectionFactory.close(getValueStatement);
        ConnectionFactory.close(dbConnection);

        return price;
    }

    /**

     Deletes a record from the database based on the given object and ID value.

     @param t The object to delete.

     @param id_value The ID value of the record to delete.

     @return The number of rows affected by the deletion.
     */

    public int delete(T t, int id_value){
        // TODO:
        Connection dbConnection = ConnectionFactory.getConnection();
        Statement deleteStatement = null;
        int rowsAffected = 0;

        Class<?> myObjectClass = t.getClass();
        String className = myObjectClass.getSimpleName();

        ArrayList<String> Names = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Names.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Names);
        String deleteQuery = "DELETE FROM " + className + " WHERE "+Names.get(0)+" = "+id_value;
        System.out.println(deleteQuery);

        try{
            deleteStatement = dbConnection.createStatement();
            rowsAffected = deleteStatement.executeUpdate(deleteQuery);
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        ConnectionFactory.close(deleteStatement);
        ConnectionFactory.close(dbConnection);

        System.out.println(className);
        return rowsAffected;
    }

    /**

     Retrieves the quantity of a product based on the given product ID.

     @param id_p The ID of the product.

     @return The quantity of the product.
     */

    public int getQuantity (int id_p)
    {
        ResultSet rs = null;
        int quantity = 0;
        Connection dbConnection = null;
        Statement getValueStatement = null;

        String queryQuantity = "SELECT * FROM products WHERE id_p = "+id_p;

        try{
            dbConnection = ConnectionFactory.getConnection();
            getValueStatement = dbConnection.createStatement();

            rs = getValueStatement.executeQuery(queryQuantity);
            if (rs.next()) {
                quantity = rs.getInt("quantity"); //

                System.out.println("Field Value: " + quantity);
            } else {
                System.out.println("No matching records found.");
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        ConnectionFactory.close(getValueStatement);
        ConnectionFactory.close(dbConnection);

        return quantity;
    }
}
