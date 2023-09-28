package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TUIO.TuioListener;

public class DefaultTimerD2 extends JPanel{
    private Timer timer;
    private DefaultTimerMovement [][] dtM = new DefaultTimerMovement[2][10]; //CAMBIAR
    private int seconds = 38; //CAMBIAR
    private int secs, carga = 2, total=0;
    private boolean active = false;

    public DefaultTimerD2(ListenerD2 list, Color colorTeam, Integer y, int cat) {
        
      //Categorias: 1. Frutas || 2. Lacteos || 3.Legumbres || 4. Carnes || 5. Semillas || 6.Procesados 
        

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
            	//suelto el ataque en 30 segundos, de los 33 totales 
            	
            	if ((seconds > 33) && (active == false)){
            		
            		list.mostrarCartel(cat);
            		active=true;
            	}
            	
            	if ((seconds > 3) && (seconds <= 33)) {
            		
            		//ARMAR LA CARGA COMO UNA IMAGEN APARTE DEL CAÑON, PARA Q LOS DISPAROS NO SE MUEVAN RARO
            		
            		if (list.getContadoresFin() == 0) {
            			list.cambioO(carga-2);
            		} else if (list.getContadoresFin() == 1) list.cambioV(carga-1);
            		
            		if (active == true) {
            			active = false;
            			list.transparentarCartel(cat);
            		}
            		if ((seconds-1)%3 == 0) {
            			int i = (33-seconds) / 3;
            			int j = list.getContadoresFin();
            			list.lanzarObj(list.getBala((33-seconds) / 3));
            			
            			dtM[j][i] = new DefaultTimerMovement(list,i,cat+1);
            		}
            		
            	}
            	list.transparentar();
            	
            	if (carga < 6) carga += 2;
            	else carga -= 4;
                seconds--;
                secs = seconds % 60 - 3;
            
                total++;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                	list.finContador();
                    timer.stop();
                    if (list.getContadoresFin() == 2) {
                    	list.fin(false);
                    }
                    // Agregar cualquier c�digo que quieras que se ejecute cuando el timer llega a cero
         
                }
            }
        });

        // Iniciar el timer
        timer.start();

        // Configurar la ventana
       
    }
    
  
    
    public int getSeconds() {
    	return seconds;
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