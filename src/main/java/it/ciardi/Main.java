package it.ciardi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Boolean a = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Il Client è partito");
        
        Socket s = new Socket("localhost",5672);
        System.out.println("Il client si è collegato");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String message;
        do {
            message = sc.nextLine();
            if (message.equals("!") ) {
                break;
            }

            out.writeBytes( message + "\n");
            String stringaRicevuta = in.readLine();
            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            System.out.println("La stringa restituita è: " + stringaMaiuscola);

            
        } while (!message.equals("!") );
        s.close();
        
    }
}