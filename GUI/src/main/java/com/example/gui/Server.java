package com.example.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("Server started. Listening on port: " + port);
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port + " " + e);
        }
    }

    public void stopServer() {
        running = false;
        this.interrupt(); //to stop the thread
    }

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
    }
}

class RequestHandler extends Thread {
    private Socket clientSocket;

    RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Received a connection");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            // Write out to the client
            out.println("The server response");
            out.flush();

            //Echo lines back to the client until the client closes the connection
            String line = in.readLine();
            while (line != null) {
                out.println("Echo: " + line);
                out.flush();
                line = in.readLine();
            }

            //close the connection
            in.close();
            out.close();
            clientSocket.close();

            System.out.println("Connection closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}