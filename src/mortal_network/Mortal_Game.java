package mortal_network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;


public class Mortal_Game {
    public Mortal_Game (Socket s, String tipo) {
     
        Window janela = new Window(800,600);
        GameImage backGround = new GameImage("bg_1.png");
        Keyboard teclado = janela.getKeyboard();

        while(true)
        {
                backGround.draw();
                janela.update();
                
                if (teclado.keyDown(Keyboard.ENTER_KEY)){
                
                    Cenario cenario = new Cenario(janela, s, tipo);
                
                }
                
                
                      
        }  
        
    }  
}
