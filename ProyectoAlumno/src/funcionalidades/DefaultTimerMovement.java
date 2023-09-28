package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TUIO.TuioListener;

public class DefaultTimerMovement extends JPanel{
    private Timer timer;
    private int total=0;

    public DefaultTimerMovement(ListenerD2 list, int i, int cat) {

        // Crear el timer y establecer el ActionListener
        timer = new Timer(7, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 		        
            	list.moverObj(list.getBala(i));
        //    	list.moverFueraPantalla(list.getBala(i));
            	
 		        // Cuando llega a cero se detiene el timer
 		        if (list.balaFueraPantalla(list.getBala(i))  || (list.colision(list.getBala(i),cat,i)) ) {
 		        
 		        	list.moverFueraPantalla(list.getBala(i));
 		        	timer.stop();
 		                    
 		        }
                //Metodo para avanzar en el tiempo hacia adelante. (Seria todo dibujado)
                //Metodo para comprobar si hay colision o no (PosY +- AltoIMG/2) (�tengo q darle atributos q guarden los valores de la colision?)
                //Metodo para darle una categor�a aleatoria al personaje y q aparezca en pantalla, y comprobar si son == las categorias (-1 o +1)
                //Metodo para saber si se pas� de la pantalla y por ende debe detenerse.
            }
        });
        
   //     timerMov.stop();

        // Iniciar el timer
        timer.start();

        // Configurar la ventana
       
    }
    
	public String getTime() {
    	//devuelve el tiempo transcurrido en formato seg
        int seg = total % 60;
    	return String.format("%02d",seg);
    }
    
    public int getTotalTime() {
    	//devuelve el tiempo total transcurrido
    	return total;
    }
    
    
    public void stop() {
    	timer.stop();
    }
    
    public void start() {
    	timer.start();
    }

}