package Presentation;

import DataAccess.AbstractDAO;
import DataAccess.CustomerDAO;
import DataAccess.OrdersDAO;
import DataAccess.ProductsDAO;
import Model.clients;
import Model.orders;
import Model.products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * The Control class represents the controller in the MVC architecture.
 * It handles the actions and events triggered by the View class and interacts with the DataAccess layer and Model classes.
 */

public class Control {
    private  View view;

    /**
     * Constructs a Control object with the specified View.
     *
     * @param v The View object to associate with the controller.
     */

    public Control(View v){
        this.view=v;

        this.view.addActionListenerForX(new AddNewClientBtnListener());
        this.view.addActionListenerForView(new ShowClientsBtnListener());
        this.view.addActionListenerForEdit(new EditClientBtnListener());
        this.view.addActionListenerForDeleteC(new DeleteClientBtnListener());

        this.view.addActionListenerForAddP(new AddNewProductBtnListener());
        this.view.addActionListenerForEditP(new EditProductBtnListener());
        this.view.addActionListenerForViewP(new ShowProductBtnListener());
        this.view.addActionListenerForDeleteP(new DeleteProductBtnListener());

        this.view.addActionListenerForAddO(new AddNewOrderBtnListener());
        this.view.addActionListenerForViewO(new ShowOrdersBtnListener());
        this.view.addActionListenerForDeleteO(new DeleteOrderBtnListener());

    }

    /**
     * ActionListener for the "Add New Client" button.
     */

    class AddNewClientBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int id = Integer.parseInt(view.TclientID.getText());
            String name = view.TclientName.getText();
            String address = view.TclientAddress.getText();
            String mail = view.TclientEmail.getText();
            clients c = new clients(id, name, address, mail);
            CustomerDAO client = new CustomerDAO();

            try {
                client.insert(c);
            } catch (IllegalAccessException | SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("a new client has been inserted");

        }

    }

    /**
     * ActionListener for the "Show Clients" button.
     */

    class ShowClientsBtnListener implements  ActionListener{
        public  void actionPerformed(ActionEvent e)
        {
            AbstractDAO<clients> dao = new CustomerDAO();
            view.tableInfo.setModel(dao.getTable(dao.findAll()));
            view.tableInfo.setFillsViewportHeight(true);
        }
    }


    /**
     * ActionListener for the "Edit Client" button.
     */

    class EditClientBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            int id = Integer.parseInt(view.TclientID.getText());
            String name = view.TeditCname.getText();
            String mail = view.TeditCaddress.getText();
            String address = view.TeditCemail.getText();
            clients c = new clients(id, name, address, mail);
            CustomerDAO client = new CustomerDAO();

            client.update(c,id);
            System.out.println("one client has been modified");
        }

    }


    /**
     * ActionListener for the "Delete Client" button.
     */

    class DeleteClientBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            AbstractDAO<clients> daoC = new CustomerDAO();
            int id = Integer.parseInt(view.TclientID.getText());
            clients c = new clients();
            daoC.delete(c,id);
            System.out.println("one client has been deleted");
        }
    }

    /**
     * ActionListener for the "Add New Product" button.
     */

    class AddNewProductBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int id = Integer.parseInt(view.TproductID.getText());
            String product = view.TproductName.getText();
            String manufacturer = view.Tmanufacturer.getText();
            int quantity = Integer.parseInt(view.TproductQuantity.getText());
            double price = (double)Integer.parseInt(view.TproductPrice.getText());
            products p = new products(id, product, manufacturer, quantity, price);
            ProductsDAO prod = new ProductsDAO();

            try {
                prod.insert(p);
            } catch (IllegalAccessException | SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("a new product has been inserted");

        }

    }

    /**
     * ActionListener for the "Show Products" button.
     */

    class ShowProductBtnListener implements ActionListener{
        public  void actionPerformed(ActionEvent e)
        {
            AbstractDAO<products> daoP = new ProductsDAO();
            view.tableInfo.setModel(daoP.getTable(daoP.findAll()));
            view.tableInfo.setFillsViewportHeight(true);
        }
    }

    /**
     * ActionListener for the "Edit Product" button.
     */

    class EditProductBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            int id = Integer.parseInt(view.TproductID.getText());
            String product = view.TeditPname.getText();
            String manufacturer = view.TeditPmanufacturer.getText();
            int quantity = Integer.parseInt(view.TeditPquantity.getText());
            double price = (double)Integer.parseInt(view.TeditPprice.getText());
            products p = new products(id, product, manufacturer, quantity, price);
            ProductsDAO prod = new ProductsDAO();

            prod.update(p,id);
            System.out.println("one product has been modified");

        }
    }

    /**
     * ActionListener for the "Delete Product" button.
     */

    class DeleteProductBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            AbstractDAO<products> daoP = new ProductsDAO();
            int id = Integer.parseInt(view.TproductID.getText());
            products p = new products();
            daoP.delete(p,id);
            System.out.println("one product has been deleted");
        }
    }

    /**
     * ActionListener for the "Add New Order" button.
     */

    class AddNewOrderBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            AbstractDAO<orders> order = new OrdersDAO();
            int nr = Integer.parseInt(view.TorderID.getText());
            int id_p = Integer.parseInt(view.TorderPID.getText());
            int id_c = Integer.parseInt(view.TorderCID.getText());
            int quantity = Integer.parseInt(view.TorderQ.getText());

            int quantityP = order.getQuantity(id_p);
            double price = quantity * order.getPrice(id_p);

            if (quantity > quantityP)
            {
                System.out.println("the available quantity is not enough");
                return;
            }
            else {
                orders o = new orders(nr, id_p, id_c, quantity, price);

                try {
                    order.insert(o);
                } catch (IllegalAccessException | SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("a new order has been inserted");
            }
        }
    }

    /**
     * ActionListener for the "Show Orders" button.
     */

    class ShowOrdersBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            AbstractDAO<orders> daoO = new OrdersDAO();
            view.tableInfo.setModel(daoO.getTable(daoO.findAll()));
            view.tableInfo.setFillsViewportHeight(true);
        }
    }

    /**
     * ActionListener for the "Delete Order" button.
     */

    class DeleteOrderBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            AbstractDAO<orders> daoO = new OrdersDAO();
            int id = Integer.parseInt(view.TorderID.getText());
            orders o = new orders();
            daoO.delete(o,id);

            System.out.println("one order has been deleted");
        }
    }


}