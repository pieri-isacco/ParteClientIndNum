package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 5600);
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            BufferedReader inServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String num;
            int tent = 0;
            do {
                tent++;
                System.out.println("Inserisci un numero da indovinare");
                String st = in.readLine();
                out.writeBytes(st + "\n");
                num = inServer.readLine();
                if(num.equals("1"))
                {
                    System.out.println("Numero da indovinare più alto.");
                }
                if(num.equals("2"))
                {
                    System.out.println("Numero da indovinare più basso.");
                }
            } while (Integer.parseInt(num) != 3);
            System.out.println("Numero indovinato");
            System.out.println("HAI INDOVINATO IN: " + tent);
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE");
            System.exit(1);
        }
    }
}
