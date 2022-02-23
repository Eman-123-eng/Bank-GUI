package com.example.gui;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

//Making the PC as a server and Android device as a client
public class Server extends Thread {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message = "";
    private boolean running = false;
    private final int port = 7777;

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            this.start(); //making the thread to start
            System.out.println("Server started. Listening on port: " + port + " with IP " +
                    InetAddress.getLocalHost().getHostAddress().trim());
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port + " " + e);
        }
    }

     /*public void stopServer() {
        running = false;
        this.interrupt(); //to stop the thread
    }*/

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                //the "accept" method waits for a new client connection and returns an individual socket (communication) for that connection
                clientSocket = serverSocket.accept();
                //Handle the connection  //Multithreaded programming

                //pass the socket to the requestHandler thread for processing
                RequestHandler reqHandler = new RequestHandler(clientSocket);
                reqHandler.start();
                if (clientSocket.isClosed())
                    System.out.println("Client is closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*//we will keep listening to the socket's input stream until the message "over" is encountered
        while (!message.equalsIgnoreCase("over")) {
            try {


                //get the inputStream from socket, which will have the message from clients
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                message = bufferedReader.readLine();
                System.out.println("The received message is: " + message);
                if (message == null) //to not throw error when the message sent is empty
                    message = "";

                //finally we close the sockets . it is imp.
                inputStreamReader.close();
                clientSocket.close();

            } catch (IOException e) {
                System.out.println("Problem in message reading: " + e);
            }


        }*/

        Server server = new Server();
        server.startServer();
        new BankAccount();
        new BankCustomer();

        if (serverSocket.isClosed())
            System.out.println("Server is closed");

    }

    class RequestHandler extends Thread {
        private Socket clientSocket;
        String inputLine, outputLine;
        String clientReq, clientData;
        BufferedReader in;
        PrintWriter out;
        String[] arr;
        public BankAccount myAcc;

        RequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("Received a connection");

                    // Get input and output streams
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Firstly, Write out to the client.
                /*outputLine = "Server response";
                out.println(outputLine);
                out.flush();*/

                    //Sending responses to the client until the client closes the connection
                    inputLine = in.readLine();
                    if(inputLine == null){
                        System.out.println("Client does not request");
                        return;
                    }
                    arr = inputLine.split(",");
                    clientReq = arr[0];
                    if (arr.length > 1)
                        clientData = arr[1];

                /*while (inputLine != null && inputLine.length() > 0) {
                    System.out.println("Client: " + inputLine);
                    if(inputLine.equals("1122")){
                        System.out.println("you can sign in");
                        outputLine = "Sign in";
                    }

                    out.println(outputLine);
                    out.flush();
                    if (outputLine.equals("Bye"))
                        break;
                    inputLine = in.readLine();
                }*/

                    System.out.println("Client sends " + clientReq);

                    if (clientReq.equals("Exit")) {
                        System.out.println("Client sends exit");
                        clientSocket.close();
                        System.out.println("Connection closed");
                        return;
                    }

                    handleReq();

                    //out.close();

                    //close the connection
                    //in.close();
                    //clientSocket.close();

                    //System.out.println("Connection closed");
                } catch (IOException e) {
                    System.out.println("Cannot listen on port " + "7777");
                    e.printStackTrace();
                }
            }
        }

        public String checkID(String id) {
            if (BankAccount.isValidAcc(id)) { // Thus, it is an existing account
                if (BankAccount.getAccount(id) != null && BankCustomer.isValidCust(BankAccount.getAccount(id).getCustID())) { //thus, you are a customer
                    System.out.println("You are a customer");
                    return "Customer";
                } else {
                    System.out.println("You are an admin");
                    return "Admin";
                }
            }
            return null;
        }

        public void deposit(double amt){
            myAcc.setBalance(myAcc.getBalance() + amt);
            System.out.println(myAcc.getAcctID()+" Id");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            if (Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
            myAcc.getOperations().add(myAcc.getOperations().size(), "Deposition:" + amt + "-- at:" + dtf.format(now));
        }
        public void withdraw(double amt){
            myAcc.setBalance(myAcc.getBalance() - amt);
            System.out.println(myAcc.getAcctID()+" Id");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            if (Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
            myAcc.getOperations().add(myAcc.getOperations().size(), "Withdrawal:" + amt + "-- at:" + dtf.format(now));
        }

        public void handleReq() {
            switch (clientReq) {
                case "signIn": {
                    System.out.println("Server: go to sign in controller");
                    if (clientData == null)
                        out.println("Enter");
                    String checked = checkID(clientData);
                    if (checked == null)
                        out.println("Incorrect");
                    else if (checked.equals("Admin"))
                        out.println("admin");
                        // out.println("Server: you are an admin");
                    else if (checked.equals("Customer")) {
                        out.println("customer");
                        myAcc = BankAccount.getAccount(clientData);
                        //out.println("Server: you are a customer");
                    } else
                        out.println("Incorrectttt");
                    out.flush();
                    break;
                }
                case "deposit": {
                    if (clientData == null) {
                        out.println("Enter client amount");
                        return;
                    }
                    deposit(Double.parseDouble(clientData));
                    BankAccount.writeToFile();
                    out.println("Server: Deposition,"+ myAcc.getBalance());
                    out.flush();
                    break;
                }
                case "withdraw": {
                    if (clientData == null) {
                        out.println("Enter client amount");
                        return;
                    }
                    withdraw(Double.parseDouble(clientData));
                    BankAccount.writeToFile();
                    out.println("Server: Withdrawal,"+ myAcc.getBalance());
                    out.flush();
                    break;
                }
                default: {
                    out.println("Server: Invalid input");
                    out.flush();
                    break;
                }
            }
        }
    }
}

