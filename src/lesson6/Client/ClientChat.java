package lesson6.Client;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {


    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public ClientChat() {
        Socket socket;
        DataOutputStream out;
        DataInputStream in;


        try {
            socket = new Socket(IP_ADRESS, PORT);

            Scanner dialog = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            String str = dialog.nextLine();
                            out.writeUTF(str);
//                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            String str1 = in.readUTF();
//                            out.writeUTF(str1);
                            System.out.println(str1);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
