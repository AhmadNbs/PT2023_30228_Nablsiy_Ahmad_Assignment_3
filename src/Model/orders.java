package Model;

/**

 The {@code orders} class represents an order in the system.

 It contains information such as order number, product ID, client ID, quantity, and price.
 */

public class orders {

    private int nr;
    private int id_p;
    private int id_c;
    private int quantity;
    private double price;

    /**

     Constructs a new order with the specified details.
     @param nr the order number
     @param id_p the product ID
     @param id_c the client ID
     @param quantity the quantity of the order
     @param price the price of the order
     */

    public orders(int nr, int id_p, int id_c, int quantity, double price) {
        this.nr = nr;
        this.id_p = id_p;
        this.id_c = id_c;
        this.quantity = quantity;
        this.price = price;
    }

    /**

     Constructs a default order.
     */
    public orders() {
    }
    /**

     Returns the order number.
     @return the order number
     */
    public int getNr() {
        return nr;
    }
    /**

     Sets the order number.
     @param nr the order number to set
     */
    public void setNr(int nr) {
        this.nr = nr;
    }
    /**

     Returns the product ID of the order.
     @return the product ID
     */
    public int getId_p() {
        return id_p;
    }
    /**

     Sets the product ID of the order.
     @param id_p the product ID to set
     */
    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    /**

     Returns the client ID of the order.
     @return the client ID
     */
    public int getId_c() {
        return id_c;
    }
    /**

     Sets the client ID of the order.
     @param id_c the client ID to set
     */
    public void setId_c(int id_c) {
        this.id_c = id_c;
    }
    /**

     Returns the quantity of the order.
     @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**

     Sets the quantity of the order.
     @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**

     Returns the price of the order.
     @return the price
     */
    public double getPrice() {
        return price;
    }
    /**

     Sets the price of the order.
     @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**

     Returns a string representation of the order.
     @return a string representation of the order
     */

    @Override
    public String toString() {
        return "Orders{" +
                "nr=" + nr +
                ", id_p=" + id_p +
                ", id_c=" + id_c +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
