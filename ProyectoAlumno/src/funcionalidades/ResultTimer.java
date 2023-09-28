package funcionalidades;
import funcionalidades.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ResultTimer extends JPanel{
    private Timer timer;
    private int seconds = 2;
    
    public ResultTimer(ListenerRD1 list) {
        // Crear el JLabel para mostrar el tiempo

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    list.tiempoCeroIsTrue();                    
                }
            }
        });
        // Iniciar el timer
        timer.start();
    }
    
    public ResultTimer(ListenerRD2 list) {
        // Crear el JLabel para mostrar el tiempo

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    list.tiempoCeroIsTrue();                  
                }
            }
        });
        // Iniciar el timer
        timer.start();
    }
    
    public void stop() {
    	timer.stop();
    }
}
