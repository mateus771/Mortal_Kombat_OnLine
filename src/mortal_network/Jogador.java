package mortal_network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Jogador extends Sprite{
    
    public double velocidade = 0.1;
    public int direcao = 3;
    public Keyboard teclado;
    public boolean moveing = false;
    public int life;
    public Socket s;
    public String tipo;
    public InputStream i;
    public OutputStream o;
    public String str;
    
    public Jogador(int x, int y, String nome, Socket s, String tipo) {
        super(nome, 18);
        this.x = x;
        this.y = y;  
        life = 10;
        this.setTotalDuration(2000);
        this.s = s;
        this.tipo = tipo; 
        
    }
    public void mover(Window janela, JogadorFora pl2){
        //moveX(0.3);
        

        if (teclado == null) {
            teclado = janela.getKeyboard();
        }
        if(tipo == "servidor"){
            try {
                o = s.getOutputStream();
            }catch (Exception err){
                System.err.println(err);
            }
            if (life > 0){
                if (teclado.keyDown(Keyboard.SPACE_KEY)) {
                    if (this.collided(pl2) || pl2.collided(this)){
                        pl2.life--;
                        try {
                            o.write(1);
                        }catch (Exception err){
                            System.err.println(err);
                         }
                        

                    }
                    if (direcao != 3){
                        setSequence(8, 9);
                        direcao = 3;
                    }moveing = true;
                }
                if (teclado.keyDown(Keyboard.LEFT_KEY)){
                    try {
                            o.write(2);
                        }catch (Exception err){
                            System.err.println(err);
                         }
                    if (this.x > 0){
                        this.x -= velocidade;
                    }
                 //   if (this.collided(pl2) || pl2.collided(this)){
                 //       this.x += velocidade - 0.001;
                 //   }
                    if (direcao != 1){
                        setSequence(11, 18);
                        direcao = 1;
                    }moveing = true;
                }
                if (teclado.keyDown(Keyboard.RIGHT_KEY)){
                    try {
                            o.write(3);
                        }catch (Exception err){
                            System.err.println(err);
                         }
                    if (this.x < janela.getWidth() - 161 || this.collided(pl2)){
                        this.x += velocidade;
                    }
                 //   if (this.collided(pl2) || pl2.collided(this)){
                 //       this.x -= velocidade - 0.001;
                 //   }
                    if (direcao != 2){
                        setSequence(0, 7);
                        direcao = 2;
                    }moveing = true;
                }
            } else {
                try {
                            o.write(4);
                        }catch (Exception err){
                            System.err.println(err);
                         }
                setSequence(7, 8);
            }
        }
        if(tipo == "cliente"){
            try {
                i = s.getInputStream();
                }catch (Exception err){
                System.err.println(err);
            }
            
            if (life > 0){
                try {
                if (i.read() == 1) {
                    pl2.life--;
                    if (direcao != 3){
                        setSequence(8, 9);
                        direcao = 3;
                    }moveing = true;
                }
                }catch (Exception err){
                System.err.println(err);
                }
                try {
                if (i.read() == 2){
                    
                    if (this.x > 0){
                        this.x -= velocidade;
                    }
                 //   if (this.collided(pl2) || pl2.collided(this)){
                 //       this.x += velocidade - 0.001;
                 //   }
                    if (direcao != 1){
                        setSequence(11, 18);
                        direcao = 1;
                    }moveing = true;
                }
                }catch (Exception err){
                System.err.println(err);
                }
                try {
                if (i.read() == 3){
                    
                    if (this.x < janela.getWidth() - 161 || this.collided(pl2)){
                        this.x += velocidade;
                    }
                 //   if (this.collided(pl2) || pl2.collided(this)){
                 //       this.x -= velocidade - 0.001;
                 //   }
                    if (direcao != 2){
                        setSequence(0, 7);
                        direcao = 2;
                    }moveing = true;
                }
                }catch (Exception err){
                System.err.println(err);
                }
            } else {
                try {
                if (i.read() == 4){
                setSequence(7, 8);
                }}catch (Exception err){
                System.err.println(err);
                }
            }
        }
        if (moveing){
            update();
            moveing = false;
        }
        
    }
  
    
    
    
    
}
