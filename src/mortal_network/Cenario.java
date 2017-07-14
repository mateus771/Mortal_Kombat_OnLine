package mortal_network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import jplay.Sprite;
import jplay.Window;
import jplay.Collision;
import jplay.Keyboard;

public class Cenario {
    
    public Window janela;
    public Sprite fundo;
    public Jogador jogador;
    public JogadorFora jogador2;
    public Keyboard teclado;
    public boolean colisao;

    
    Cenario(Window window, Socket s, String tipo) {
        janela = window;
        fundo = new Sprite("48357.png");
        jogador = new Jogador(100, 230, "player1.png", s, tipo);
        jogador2 = new JogadorFora(500, 230, "player1.png", s, tipo);
        teclado = new Keyboard();
        
        run();
    }

    public void run() {
        while (true) { 
            fundo.draw();
            jogador.draw();
            jogador.mover(janela, jogador2);
            jogador2.draw();
            jogador2.mover(janela, jogador);
                       
            janela.update();
        }
    }
    
    
}
