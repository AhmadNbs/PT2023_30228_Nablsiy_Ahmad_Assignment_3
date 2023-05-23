package Model;

/**

 The {@code clients} class represents a client in the system.

 It contains information such as client ID, name, email, and address.
 */

public class clients {

    private int id_C;
    private String name_client;
    private String email;
    private String address;

    /**

     Constructs a new client with the specified details.
     @param id_C the ID of the client
     @param name_client the name of the client
     @param address the address of the client
     @param email the email of the client
     */
    public clients(int id_C, String name_client, String address, String email) {
        this.id_C = id_C;
        this.name_client = name_client;
        this.address = address;
        this.email = email;
    }

    /**
     Constructs a default client.
     */
    public clients() {}

    /**

     Returns the ID of the client.
     @return the client ID
     */
    public int getId_C() {
        return id_C;
    }
    /**

     Sets the ID of the client.
     @param id_C the client ID to set
     */
    public void setId_C(int id_C) {
        this.id_C = id_C;
    }
    /**

     Returns the name of the client.
     @return the client name
     */
    public String getName_client() {
        return name_client;
    }
    /**

     Sets the name of the client.
     @param name_client the client name to set
     */
    public void setName_client(String name_client) {
        this.name_client = name_client;
    }
    /**

     Returns the email of the client.
     @return the client email
     */
    public String getEmail() {
        return email;
    }
    /**

     Sets the email of the client.
     @param email the client email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**

     Returns the address of the client.
     @return the client address
     */
    public String getAddress() {
        return address;
    }
    /**

     Sets the address of the client.
     @param address the client address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**

     Returns a string representation of the client.
     @return a string representation of the client
     */
    @Override
    public String toString() {
        return "Clients{" +
                "id_C=" + id_C +
                ", name_client='" + name_client + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
