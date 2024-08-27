import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class Server
{
    public static void main(String args[]) throws IOException
    {

        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();
 
        Scanner sc = new Scanner(System.in);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
 
        while (true)
        {
            String recv = dis.readUTF();
            
            System.out.println("User Says:"+recv);
            
            if(recv.equals("bye"))
                break;
            
            String send = sc.nextLine();
            dos.writeUTF(send);
        }
    }
}
