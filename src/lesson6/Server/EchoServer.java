package lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {



    public EchoServer() {
        ServerSocket server = null;
        Socket socket = null;

        DataOutputStream out;
        DataInputStream in;

        try {
            server = new ServerSocket(8189);
            System.out.println("Server is running");
            socket = server.accept();
            System.out.println("Client is connected");

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
                    }
                }
            }).start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    try {
//                        while (true) {
//                            String str1 = in.readUTF();
//                            System.out.println(str1);
//
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Client is disconnected");
                    break;
                }
//                str = dialog.nextLine();
                out.writeUTF(str);
                System.out.println(str);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
