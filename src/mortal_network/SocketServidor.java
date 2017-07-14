package mortal_network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
    
    public SocketServidor (int porta){
        try {
            ServerSocket s = new ServerSocket(porta);
            String str;
            while (true) {
                Socket c = s.accept();
                
                new Mortal_Game(c, "servidor");
                
                c.close();
            }
        }
        catch (Exception err){
            System.err.println(err);
        }

    }
    
}
