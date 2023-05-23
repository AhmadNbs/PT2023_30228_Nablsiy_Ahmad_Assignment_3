package Presentation;

import Model.clients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The View class represents the graphical user interface for the application.
 * It provides a GUI window with various panels, buttons, and tables for managing clients, products, and orders.
 */

public class View {

    JFrame frame1 = new JFrame();

    JPanel mainPanel = new JPanel();
    JPanel panelClient = new JPanel();
    JPanel panelEditC= new JPanel();

    JPanel panelProducts = new JPanel();
    JPanel panelEditP = new JPanel();

    JPanel panelOrders = new JPanel();

    JPanel panelButtonsC= new JPanel();
    JPanel panelButtonsP = new JPanel();
    JPanel panelButtonsO = new JPanel();

    JButton buttonClient = new JButton("Clients");
    JButton buttonProducts = new JButton("Products");
    JButton buttonOrders = new JButton("Orders");

    JButton buttonBack = new JButton("BACK");

    JTable tableInfo = new JTable();
    JTable tableProducts = new JTable();
    JTable tableOrders = new JTable();


    JButton BfindC = new JButton("FIND");
    JButton BnewC = new JButton("NEW");
    JButton BaddC = new JButton("ADD");
    JButton BremoveC = new JButton("REMOVE");
    JButton BeditC = new JButton("EDIT");
    JLabel labelCname = new JLabel("EDIT NAME");
    JLabel labelCaddress = new JLabel("EDIT EMAIL");
    JLabel labelCemail = new JLabel("EDIT ADDRESS");
    JButton BeditCapply = new JButton("APPLY");
    JButton BviewC = new JButton("VIEW ALL");

    JTextField TclientID = new JTextField();
    JTextField TclientName = new JTextField();
    JTextField TclientAddress = new JTextField();
    JTextField TclientEmail = new JTextField();
    JTextField TeditCname = new JTextField();
    JTextField TeditCemail = new JTextField();
    JTextField TeditCaddress = new JTextField();

    JLabel clientName = new JLabel("NAME: ");
    JLabel clientEmail = new JLabel("EMAIL: ");
    JLabel clientAddress = new JLabel("ADDRESS: ");
    JLabel clientID = new JLabel("ID: ");

    JButton BfindP = new JButton("FIND");
    JButton BnewP = new JButton("NEW");
    JButton BaddP = new JButton("ADD");
    JButton BremoveP = new JButton("REMOVE");
    JButton BeditP = new JButton("EDIT");
    JLabel labeleditPname = new JLabel("EDIT PRODUCT:");
    JLabel labeleditPmanufacturer = new JLabel("EDIT MANUFACTURER:");
    JLabel labeleditPquantity = new JLabel("EDIT QUANTITY:");
    JLabel labeleditPprice = new JLabel("EDIT PRICE:");
    JButton BeditPapply = new JButton("APPLY");
    JButton BviewP = new JButton("VIEW ALL");

    JTextField TproductName = new JTextField();
    JTextField Tmanufacturer = new JTextField();
    JTextField TproductQuantity = new JTextField();
    JTextField TproductPrice = new JTextField();
    JTextField TeditProduct = new JTextField();
    JTextField TeditPname = new JTextField();
    JTextField TeditPmanufacturer = new JTextField();
    JTextField TeditPquantity = new JTextField();
    JTextField TeditPprice = new JTextField();
    JTextField TproductID = new JTextField();

    JLabel productName = new JLabel("PRODUCT: ");
    JLabel productManufacturer = new JLabel("MANUFACTURER:");
    JLabel productPrice = new JLabel("PRICE: ");
    JLabel productQuantity = new JLabel("QUANTITY: ");
    JLabel productID = new JLabel("ID: ");

    JButton BfindO = new JButton("FIND");
    JButton BnewO = new JButton("NEW");
    JButton BaddO = new JButton("ADD");
    JButton BviewO = new JButton("VIEW ALL");
    JButton BremoveO = new JButton("REMOVE");

    JTextField TorderID = new JTextField();
    JTextField TorderCID = new JTextField();
    JTextField TorderPID = new JTextField();
    JTextField TorderQ= new JTextField();

    JLabel orderProductID = new JLabel("ID PRODUCT");
    JLabel orderClientID = new JLabel("ID CLIENT");
    JLabel orderQuantity = new JLabel("QUANTITY");
    JLabel orderID = new JLabel("ID ORDER");
    JScrollPane paneC = new JScrollPane();

    public View()
    {
        frame1.setTitle("Orders Management");
        frame1.setVisible(true);
        frame1.setResizable(false);
        frame1.setSize(900, 700);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setBackground(new Color(218,165,32));
        frame1.setLayout(null);

        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(160,132,227));
        mainPanel.setBounds(40,40,700,500);
        frame1.add(mainPanel);
        mainPanel.setVisible(true);

        panelButtonsC.setLayout(null);
        panelButtonsC.setBounds(20,40,120,600);
        panelButtonsC.setBackground(new Color(218,165,32));
        frame1.add(panelButtonsC);
        panelButtonsC.setVisible(false);

        panelButtonsP.setLayout(null);
        panelButtonsP.setBounds(20,40,120,600);
        panelButtonsP.setBackground(new Color(218,165,32));
        frame1.add(panelButtonsP);
        panelButtonsP.setVisible(false);

        panelButtonsO.setLayout(null);
        panelButtonsO.setBounds(20,40,120,600);
        panelButtonsO.setBackground(new Color(218,165,32));
        frame1.add(panelButtonsO);
        panelButtonsO.setVisible(false);

        panelClient.setLayout(null);
        panelClient.setBounds(140,140,580,50);
        panelClient.setBackground(new Color(218,165,32));
        frame1.add(panelClient);
        panelClient.setVisible(false);

        panelEditC.setLayout(null);
        panelEditC.setBounds(140,190,580,50);
        panelEditC.setBackground(new Color(218,165,32));
        frame1.add(panelEditC);
        panelEditC.setVisible(false);

        panelProducts.setLayout(null);
        panelProducts.setBounds(140,140,800,50);
        panelProducts.setBackground(new Color(218,165,32));
        frame1.add(panelProducts);
        panelProducts.setVisible(false);

        panelOrders.setLayout(null);
        panelOrders.setBounds(140,140,580,50);
        panelOrders.setBackground(new Color(218,165,32));
        frame1.add(panelOrders);
        panelOrders.setVisible(false);

        panelEditP.setLayout(null);
        panelEditP.setBounds(140,190,800,50);
        panelEditP.setBackground(new Color(218,165,32));
        frame1.add(panelEditP);
        panelEditP.setVisible(false);

        buttonBack.setBackground(new Color(180,180,180));
        buttonBack.setToolTipText("");
        buttonBack.setForeground(new Color(0, 0, 90));
        buttonBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonBack.setBounds(650, 600, 100, 50);
        frame1.add(buttonBack);

        /**
         * ActionListener for the buttonBack button.
         * Switches the visibility of panels and components to navigate back to the main panel.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(true);

                panelClient.setVisible(false);
                panelEditC.setVisible(false);
                panelButtonsC.setVisible(false);
                clientID.setVisible(false);
                TclientID.setVisible(false);
                paneC.setVisible(false);

                panelProducts.setVisible(false);
                panelEditP.setVisible(false);
                panelButtonsP.setVisible(false);
                productID.setVisible(false);
                TproductID.setVisible(false);

                panelOrders.setVisible(false);
                panelButtonsO.setVisible(false);
                orderID.setVisible(false);
                TorderID.setVisible(false);
            }
        });

        buttonClient.setBackground(new Color(180,180,180));
        buttonClient.setToolTipText("");
        buttonClient.setForeground(new Color(0, 0, 90));
        buttonClient.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonClient.setBounds(250, 50, 200, 30);
        mainPanel.add(buttonClient);


        buttonProducts.setBackground(new Color(180,180,180));
        buttonProducts.setToolTipText("");
        buttonProducts.setForeground(new Color(0, 0, 90));
        buttonProducts.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonProducts.setBounds(250, 160, 200, 30);
        mainPanel.add(buttonProducts);


        buttonOrders.setBackground(new Color(180,180,180));
        buttonOrders.setToolTipText("");
        buttonOrders.setForeground(new Color(0, 0, 90));
        buttonOrders.setFont(new Font("Tahoma", Font.BOLD, 14));
        buttonOrders.setBounds(250, 260, 200, 30);
        mainPanel.add(buttonOrders);


        BfindC.setBackground(new Color(180,180,180));
        BfindC.setToolTipText("");
        BfindC.setForeground(new Color(0, 0, 90));
        BfindC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BfindC.setBounds(10, 50, 100, 50);
        panelButtonsC.add(BfindC);

        BnewC.setBackground(new Color(180,180,180));
        BnewC.setToolTipText("");
        BnewC.setForeground(new Color(0, 0, 90));
        BnewC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BnewC.setBounds(10, 100, 100, 50);
        panelButtonsC.add(BnewC);

        BeditC.setBackground(new Color(180,180,180));
        BeditC.setToolTipText("");
        BeditC.setForeground(new Color(0, 0, 90));
        BeditC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BeditC.setBounds(10, 150, 100, 50);
        panelButtonsC.add(BeditC);

        BremoveC.setBackground(new Color(180,180,180));
        BremoveC.setToolTipText("");
        BremoveC.setForeground(new Color(0, 0, 90));
        BremoveC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BremoveC.setBounds(10, 200, 100, 50);
        panelButtonsC.add(BremoveC);

        BviewC.setBackground(new Color(180,180,180));
        BviewC.setToolTipText("");
        BviewC.setForeground(new Color(0, 0, 90));
        BviewC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BviewC.setBounds(10, 250, 100, 50);
        panelButtonsC.add(BviewC);


        clientID.setBounds(150, 90, 70, 20);
        clientID.setFont(new Font("TimesRoman",Font.BOLD,12));
        frame1.add(clientID);
        clientID.setVisible(false);
        TclientID.setFont(new Font("TimesRoman",Font.BOLD,12));
        TclientID.setBounds(150,110,150,20);
        TclientID.setVisible(false);
        frame1.add(TclientID);

        clientName.setBounds(10,10,70,20);
        clientName.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelClient.add(clientName);
        TclientName.setFont(new Font("TimesRoman",Font.BOLD,12));
        TclientName.setBounds(0,30,150,20);
        panelClient.add(TclientName);

        clientAddress.setBounds(160,10,70,20);
        clientAddress.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelClient.add(clientAddress);
        TclientAddress.setFont(new Font("TimesRoman",Font.BOLD,12));
        TclientAddress.setBounds(150,30,150,20);
        panelClient.add(TclientAddress);

        clientEmail.setBounds(310,10,70,20);
        clientEmail.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelClient.add(clientEmail);
        TclientEmail.setFont(new Font("TimesRoman",Font.BOLD,12));
        TclientEmail.setBounds(300,30,150,20);
        panelClient.add(TclientEmail);

        BaddC.setBackground(new Color(180,180,180));
        BaddC.setToolTipText("");
        BaddC.setForeground(new Color(0, 0, 90));
        BaddC.setFont(new Font("Tahoma", Font.BOLD, 12));
        BaddC.setBounds(460, 0, 100, 50);
        panelClient.add(BaddC);

        labelCname.setBounds(0,10,120,20);
        labelCname.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditC.add(labelCname);
        TeditCname.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditCname.setBounds(0,30,150,20);
        panelEditC.add(TeditCname);

        labelCaddress.setBounds(165,10,120,20);
        labelCaddress.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditC.add(labelCaddress);
        TeditCaddress.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditCaddress.setBounds(165,30,150,20);
        panelEditC.add(TeditCaddress);

        BeditCapply.setBounds(500,10,80,20);
        BeditCapply.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditC.add(BeditCapply);

        labelCemail.setBounds(330,10,120,20);
        labelCemail.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditC.add(labelCemail);
        TeditCemail.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditCemail.setBounds(330,30,150,20);
        panelEditC.add(TeditCemail);

        /**
         * ActionListener for the buttonClient button.
         * Switches the visibility of panels and components to display the client-related functionality.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        buttonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelClient.setVisible(false);
                panelEditC.setVisible(false);
                panelButtonsC.setVisible(true);
                clientID.setVisible(true);
                TclientID.setVisible(true);
            }
        });

        BaddC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        /**
         * ActionListener for the BeditC button.
         * Switches the visibility of panels and components to enable editing of client information.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */
        BeditC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelClient.setVisible(false);
                panelEditC.setVisible(true);
                panelButtonsC.setVisible(true);
                //paneC.setVisible(false);
            }
        });

        /**
         * ActionListener for the BnewC button.
         * Switches the visibility of panels and components to enable creating a new client.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BnewC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelClient.setVisible(true);
                panelEditC.setVisible(false);
                panelButtonsC.setVisible(true);
                //paneC.setVisible(false);
            }
        });

        /**
         * ActionListener for the BviewC button.
         * Switches the visibility of panels and components to enable viewing clients.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BviewC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelClient.setVisible(false);
                panelEditC.setVisible(false);
                panelButtonsC.setVisible(true);
                paneC.setVisible(true);
            }
        });

        BfindP.setBackground(new Color(180,180,180));
        BfindP.setToolTipText("");
        BfindP.setForeground(new Color(0, 0, 90));
        BfindP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BfindP.setBounds(10, 50, 100, 50);
        panelButtonsP.add(BfindP);

        BnewP.setBackground(new Color(180,180,180));
        BnewP.setToolTipText("");
        BnewP.setForeground(new Color(0, 0, 90));
        BnewP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BnewP.setBounds(10, 100, 100, 50);
        panelButtonsP.add(BnewP);

        BeditP.setBackground(new Color(180,180,180));
        BeditP.setToolTipText("");
        BeditP.setForeground(new Color(0, 0, 90));
        BeditP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BeditP.setBounds(10, 150, 100, 50);
        panelButtonsP.add(BeditP);

        BremoveP.setBackground(new Color(180,180,180));
        BremoveP.setToolTipText("");
        BremoveP.setForeground(new Color(0, 0, 90));
        BremoveP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BremoveP.setBounds(10, 200, 100, 50);
        panelButtonsP.add(BremoveP);

        BviewP.setBackground(new Color(180,180,180));
        BviewP.setToolTipText("");
        BviewP.setForeground(new Color(0, 0, 90));
        BviewP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BviewP.setBounds(10, 250, 100, 50);
        panelButtonsP.add(BviewP);


        productID.setBounds(150, 90, 70, 20);
        productID.setFont(new Font("TimesRoman",Font.BOLD,12));
        frame1.add(productID);
        productID.setVisible(false);
        TproductID.setFont(new Font("TimesRoman",Font.BOLD,12));
        TproductID.setBounds(150,110,150,20);
        TproductID.setVisible(false);
        frame1.add(TproductID);

        productName.setBounds(10,10,70,20);
        productName.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelProducts.add(productName);
        TproductName.setFont(new Font("TimesRoman",Font.BOLD,12));
        TproductName.setBounds(0,30,150,20);
        panelProducts.add(TproductName);

        productQuantity.setBounds(160,10,70,20);
        productQuantity.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelProducts.add(productQuantity);
        TproductQuantity.setFont(new Font("TimesRoman",Font.BOLD,12));
        TproductQuantity.setBounds(150,30,150,20);
        panelProducts.add(TproductQuantity);

        productPrice.setBounds(310,10,70,20);
        productPrice.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelProducts.add(productPrice);
        TproductPrice.setFont(new Font("TimesRoman",Font.BOLD,12));
        TproductPrice.setBounds(300,30,150,20);
        panelProducts.add(TproductPrice);

        productManufacturer.setBounds(460, 10, 120, 20);
        productManufacturer.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelProducts.add(productManufacturer);
        Tmanufacturer.setFont(new Font("TimesRoman",Font.BOLD,12));
        Tmanufacturer.setBounds(450,30,150,20);
        panelProducts.add(Tmanufacturer);

        BaddP.setBackground(new Color(180,180,180));
        BaddP.setToolTipText("");
        BaddP.setForeground(new Color(0, 0, 90));
        BaddP.setFont(new Font("Tahoma", Font.BOLD, 12));
        BaddP.setBounds(610, 0, 100, 50);
        panelProducts.add(BaddP);

        labeleditPname.setBounds(0,10,120,20);
        labeleditPname.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditP.add(labeleditPname);
        TeditPname.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditPname.setBounds(0,30,150,20);
        panelEditP.add(TeditPname);

        labeleditPquantity.setBounds(165,10,120,20);
        labeleditPquantity.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditP.add(labeleditPquantity);
        TeditPquantity.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditPquantity.setBounds(165,30,150,20);
        panelEditP.add(TeditPquantity);

        BeditPapply.setBounds(650,10,80,20);
        BeditPapply.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditP.add(BeditPapply);

        labeleditPprice.setBounds(330,10,120,20);
        labeleditPprice.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditP.add(labeleditPprice);
        TeditPprice.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditPprice.setBounds(330,30,150,20);
        panelEditP.add(TeditPprice);

        labeleditPmanufacturer.setBounds(495,10,150,20);
        labeleditPmanufacturer.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelEditP.add(labeleditPmanufacturer);
        TeditPmanufacturer.setFont(new Font("TimesRoman",Font.BOLD,12));
        TeditPmanufacturer.setBounds(495,30,150,20);
        panelEditP.add(TeditPmanufacturer);

        /**
         * ActionListener for the buttonProducts button.
         * Switches the visibility of panels and components to enable product management.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        buttonProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //frame1.setContentPane(panelClient);
                mainPanel.setVisible(false);
                panelProducts.setVisible(false);
                panelEditP.setVisible(false);
                panelButtonsP.setVisible(true);
                productID.setVisible(true);
                TproductID.setVisible(true);
            }
        });

        /**
         * ActionListener for the BeditP button.
         * Switches the visibility of panels and components to enable product editing.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BeditP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelProducts.setVisible(false);
                panelEditP.setVisible(true);
                panelButtonsP.setVisible(true);
                productID.setVisible(true);
                TproductID.setVisible(true);
            }
        });

        /**
         * ActionListener for the BnewP button.
         * Switches the visibility of panels and components to enable adding new products.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BnewP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelProducts.setVisible(true);
                panelEditP.setVisible(false);
                panelButtonsP.setVisible(true);
                //paneC.setVisible(false);
                productID.setVisible(true);
                TproductID.setVisible(true);
            }
        });

        /**
         * ActionListener for the BviewP button.
         * Switches the visibility of panels and components to display product information.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BviewP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelProducts.setVisible(false);
                panelEditP.setVisible(false);
                panelButtonsP.setVisible(true);
                tableInfo.setVisible(true);
                paneC.setVisible(true);
            }
        });

        BfindO.setBackground(new Color(180,180,180));
        BfindO.setToolTipText("");
        BfindO.setForeground(new Color(0, 0, 90));
        BfindO.setFont(new Font("Tahoma", Font.BOLD, 12));
        BfindO.setBounds(10, 50, 100, 50);
        panelButtonsO.add(BfindO);

        BnewO.setBackground(new Color(180,180,180));
        BnewO.setToolTipText("");
        BnewO.setForeground(new Color(0, 0, 90));
        BnewO.setFont(new Font("Tahoma", Font.BOLD, 12));
        BnewO.setBounds(10, 100, 100, 50);
        panelButtonsO.add(BnewO);


        BremoveO.setBackground(new Color(180,180,180));
        BremoveO.setToolTipText("");
        BremoveO.setForeground(new Color(0, 0, 90));
        BremoveO.setFont(new Font("Tahoma", Font.BOLD, 12));
        BremoveO.setBounds(10, 200, 100, 50);
        panelButtonsO.add(BremoveO);

        BviewO.setBackground(new Color(180,180,180));
        BviewO.setToolTipText("");
        BviewO.setForeground(new Color(0, 0, 90));
        BviewO.setFont(new Font("Tahoma", Font.BOLD, 12));
        BviewO.setBounds(10, 250, 100, 50);
        panelButtonsO.add(BviewO);


        orderID.setBounds(150, 90, 150, 20);
        orderID.setFont(new Font("TimesRoman",Font.BOLD,12));
        frame1.add(orderID);
        orderID.setVisible(false);
        TorderID.setFont(new Font("TimesRoman",Font.BOLD,12));
        TorderID.setBounds(150,110,150,20);
        TorderID.setVisible(false);
        frame1.add(TorderID);

        orderClientID.setBounds(10,10,70,20);
        orderClientID.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelOrders.add(orderClientID);
        TorderCID.setFont(new Font("TimesRoman",Font.BOLD,12));
        TorderCID.setBounds(0,30,150,20);
        panelOrders.add(TorderCID);

        orderProductID.setBounds(160,10,70,20);
        orderProductID.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelOrders.add(orderProductID);
        TorderPID.setFont(new Font("TimesRoman",Font.BOLD,12));
        TorderPID.setBounds(150,30,150,20);
        panelOrders.add(TorderPID);

        orderQuantity.setBounds(310,10,70,20);
        orderQuantity.setFont(new Font("TimesRoman",Font.BOLD,12));
        panelOrders.add(orderQuantity);
        TorderQ.setFont(new Font("TimesRoman",Font.BOLD,12));
        TorderQ.setBounds(300,30,150,20);
        panelOrders.add(TorderQ);

        BaddO.setBackground(new Color(180,180,180));
        BaddO.setToolTipText("");
        BaddO.setForeground(new Color(0, 0, 90));
        BaddO.setFont(new Font("Tahoma", Font.BOLD, 12));
        BaddO.setBounds(460, 0, 100, 50);
        panelOrders.add(BaddO);

        /**
         * ActionListener for the buttonOrders button.
         * Switches the visibility of panels and components to display order information.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        buttonOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //frame1.setContentPane(panelClient);
                mainPanel.setVisible(false);
                panelOrders.setVisible(false);
                panelButtonsO.setVisible(true);
                orderID.setVisible(true);
                TorderID.setVisible(true);
            }
        });

        /**
         * ActionListener for the BnewO button.
         * Switches the visibility of panels and components to add a new order.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BnewO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelOrders.setVisible(true);
                panelButtonsO.setVisible(true);
            }
        });

        /**
         * ActionListener for the BviewO button.
         * Switches the visibility of panels and components to display order information.
         *
         * @param e The ActionEvent triggered by clicking the button.
         */

        BviewO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                panelOrders.setVisible(false);
                panelButtonsO.setVisible(true);
                paneC.setVisible(true);
            }
        });

        tableInfo.setBackground(Color.white);
        tableInfo.setForeground(Color.black);
        tableInfo.setSelectionBackground(Color.red);
        tableInfo.setGridColor(Color.red);
        tableInfo.setSelectionForeground(Color.white);
        tableInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tableInfo.setRowHeight(20);
        tableInfo.setAutoCreateRowSorter(true);
        tableInfo.setVisible(false);

        paneC = new JScrollPane(tableInfo);
        paneC.setBackground(Color.red);
        paneC.setForeground(Color.white);
        paneC.setBounds(150,300,600,200);
        frame1.add(paneC);
        paneC.setVisible(false);

    }

    /**
     * Adds an ActionListener to the button associated with action X.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForX(ActionListener actionListener)
    {
        this.BaddC.addActionListener(actionListener);

    }

    /**
     * Adds an ActionListener to the BviewC button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForView(ActionListener actionListener)
    {
        this.BviewC.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BeditCapply button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForEdit(ActionListener actionListener)
    {
        this.BeditCapply.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BaddP button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForAddP(ActionListener actionListener)
    {
        this.BaddP.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BviewP button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForViewP(ActionListener actionListener)
    {
        this.BviewP.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BeditPapply button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForEditP(ActionListener actionListener)
    {
        this.BeditPapply.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BaddO button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForAddO(ActionListener actionListener)
    {
        this.BaddO.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BviewO button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForViewO(ActionListener actionListener)
    {
        this.BviewO.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BremoveC button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForDeleteC(ActionListener actionListener)
    {
        this.BremoveC.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BremoveP button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForDeleteP(ActionListener actionListener)
    {
        this.BremoveP.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the BremoveO button.
     *
     * @param actionListener The ActionListener to be added.
     */

    public void addActionListenerForDeleteO(ActionListener actionListener)
    {
        this.BremoveO.addActionListener(actionListener);
    }

}
