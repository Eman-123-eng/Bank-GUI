package com.example.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//Making the PC as a server and Android device as a client
public class Server {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message = "";


    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 7777 " + e);
        }
        System.out.println("Server started. Listening on port: 7777");

        //we will keep listening to the socket's input stream until the message "over" is encountered

        while (!message.equalsIgnoreCase("over")) {
            try {
                //the "accept" method waits for a new client connection and returns an individual socket (communication) for that connection
                clientSocket = serverSocket.accept();

                //get the inputStream from socket, which will have the message from clients
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                message = bufferedReader.readLine();
                System.out.println("The received message is: " + message);
                if(message == null) //to not throw error when the message sent is empty
                    message = "";

                //finally we close the sockets . it is imp.
                inputStreamReader.close();
                clientSocket.close();

            } catch (IOException e) {
                System.out.println("Problem in message reading: " + e);
            }


        }
    }
}
