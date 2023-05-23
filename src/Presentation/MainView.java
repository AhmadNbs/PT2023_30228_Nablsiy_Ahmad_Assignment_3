package Presentation;

/**
 * The MainView class is the entry point for the application.
 * It initializes the View and Control objects to start the program.
 */

public class MainView {
    /**
     * The main method of the application.
     * It creates an instance of the View and Control classes.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        View ob = new View();
        Control ctrl = new Control(ob);
    }
}
