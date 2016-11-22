/**
 * Created by manojpolisetti on 28/10/15.
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException,
            ClassNotFoundException {

        // create socket on agreed upon port (and local host for this example)...
        Socket socket = new Socket("data.cs.purdue.edu", 4242);

        // open input stream first, gets header from server...
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        // open output stream second, sends header to server...
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        // read object(s) from server...
        String s1 = (String) ois.readObject();
        System.out.printf("received from server: %s\n", s1);

        // write object(s) to server...
        String s2 = s1.toUpperCase();
        oos.writeObject(s2);
        oos.flush(); // ensure data is sent to the server
        System.out.printf("sent to server: %s\n", s2);

        // close streams...
        oos.close();
        ois.close();
    }
}
