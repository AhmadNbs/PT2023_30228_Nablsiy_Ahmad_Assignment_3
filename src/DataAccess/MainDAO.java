package DataAccess;

import Model.clients;
import Model.orders;
import Model.products;

import java.sql.SQLException;

public class MainDAO {
    public static void main(String[] args) {
        /*CustomerDAO customerDAO = new CustomerDAO();
        ProductsDAO productsDAO = new ProductsDAO();
        clients client = new clients(205,"Altyn","Zorilo","altynCharyyeva@gmail.com");
        products product = new products();
        try {
            customerDAO.insert(client);
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }*/
        /*AbstractDAO a = new CustomerDAO();
        clients client = new clients(205,"Altyn","Marasti","altynCharyyeva@gmail.com");
        a.delete(client,205);*/

        //AbstractDAO<orders> order = new OrdersDAO();
       /* AbstractDAO<orders> order = new OrdersDAO();

        int nr = 11;
        int id_p = 194;
        int id_c = 70;
        int quantity = 2;
        double price = quantity * order.getPrice(id_p);
        System.out.println("price is "+price);
        //orders o = new orders(nr, id_p, id_c, quantity, price);*/
    }
}
