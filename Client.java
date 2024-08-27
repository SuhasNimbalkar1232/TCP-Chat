import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
        public static void main(String[] args)throws IOException{
                 InetAddress ip = InetAddress.getLocalHost();
                int port = 4444;
                Scanner sc = new Scanner(System.in);
 
                Socket s = new Socket(ip, port);
 
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
                while(true){
                    String inp = sc.nextLine();  
        
                    if (inp.equals("bye"))
                        break;
        
                    dos.writeUTF(inp);
        
                    String out = dis.readUTF();
                    System.out.println("Server Says:" + out);
                }
        
        }
}
