package mortal_network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class SocketCliente {
    
    public SocketCliente(String address, int porta){
        try {
            Socket s = new Socket(address, porta);
            new Mortal_Game(s,"cliente");
        }
        catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Falha de conexão");
            System.exit(0);
        }
        
    }
    
}
