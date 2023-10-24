package funcionalidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerD1 {
	private Timer timer;
    private int seconds = 2;
    
    public TimerD1(ListenerD1 list, boolean soyV) {

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    if (soyV) {
                        list.cambiarV();
                    }
                    else {
                    	list.cambiarO();
                    }
                }
            }
        });
        // Iniciar el timer
        timer.start();
    }
    
    public TimerD1(ListenerD1 list) {

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    list.finDelJuego();
                }
            }
        });
        // Iniciar el timer
        timer.start();
    }
}
