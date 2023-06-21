package funcionalidades;
import funcionalidades.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TUIO.TuioListener;

public class DefaultTimer extends JPanel{
	private JLabel label;
    private Timer timer;
    private int seconds = 300;
    private int minutes, secs, total=0;

    public DefaultTimer(ListenerD1 list) {
        // Crear el JLabel para mostrar el tiempo
        label = new JLabel("5:00");
        label.setForeground(Color.yellow);
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                minutes = seconds / 60;
                secs = seconds % 60;
                label.setText(String.format("%d:%02d", minutes, secs));
                total++;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    list.fin(false);
                    
                    // Agregar cualquier código que quieras que se ejecute cuando el timer llega a cero
                }
            }
        });

        // Iniciar el timer
        timer.start();

        // Configurar la ventana
       
    }
    public DefaultTimer() {
        // Crear el JLabel para mostrar el tiempo
        label = new JLabel("5:00");
        label.setForeground(Color.white);
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                minutes = seconds / 60;
                secs = seconds % 60;
                label.setText(String.format("%d:%02d", minutes, secs));
                total++;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    
                    // Agregar cualquier código que quieras que se ejecute cuando el timer llega a cero
                }
            }
        });

        // Iniciar el timer
        timer.start();

        // Configurar la ventana
       
    }
    
    
	public String getTime() {
    	//devuelve el tiempo transcurrido en formato min:seg
    	int min = total / 60;
        int seg = total % 60;
    	return String.format("%d:%02d", min, seg);
    }
    
    public int getTotalTime() {
    	//devuelve el tiempo total transcurrido
    	return total;
    }
    
    
    public void stop() {
    	timer.stop();
    }
}
