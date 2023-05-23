package Model;

/**

 The {@code products} class represents a product in the system.

 It contains information such as product ID, name, manufacturer, quantity, and price.
 */

public class products {

    private int id_p;
    private String name_product;
    private String manufacturer;
    private int quantity;
    private double price;

    /**

     Constructs a new product with the specified details.
     @param id_p the product ID
     @param name_product the name of the product
     @param manufacturer the manufacturer of the product
     @param quantity the quantity of the product
     @param price the price of the product
     */

    public products(int id_p, String name_product, String manufacturer, int quantity, double price) {
        this.id_p = id_p;
        this.name_product = name_product;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }

    /**

     Constructs a default product.
     */
    public products() {
    }

    /**

     Returns the product ID.
     @return the product ID
     */
    public int getId_p() {
        return id_p;
    }
    /**

     Sets the product ID.
     @param id_p the product ID to set
     */
    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    /**

     Returns the name of the product.
     @return the name of the product
     */
    public String getName_product() {
        return name_product;
    }
    /**

     Sets the name of the product.
     @param name_product the name of the product to set
     */
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }
    /**

     Returns the manufacturer of the product.
     @return the manufacturer of the product
     */
    public String getManufacturer() {
        return manufacturer;
    }
    /**

     Sets the manufacturer of the product.
     @param manufacturer the manufacturer of the product to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**

     Returns the quantity of the product.
     @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }
    /**

     Sets the quantity of the product.
     @param quantity the quantity of the product to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**

     Returns the price of the product.
     @return the price of the product
     */
    public double getPrice() {
        return price;
    }
    /**

     Sets the price of the product.
     @param price the price of the product to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**

     Returns a string representation of the product.
     @return a string representation of the product
     */

    @Override
    public String toString() {
        return "Products{" +
                "id_p=" + id_p +
                ", name_product='" + name_product + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}
