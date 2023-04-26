package NoUsados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TimerP extends JPanel{
	private JLabel label;
    private Timer timer;
    private int seconds = 120;

    public TimerP() {
        // Crear el JLabel para mostrar el tiempo
        label = new JLabel("2:00");
        add(label);

        // Crear el timer y establecer el ActionListener
        timer = new Timer(1000, (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizar el JLabel con el tiempo restante
                seconds--;
                int minutes = seconds / 60;
                int secs = seconds % 60;
                label.setText(String.format("%d:%02d", minutes, secs));

                // Cuando llega a cero se detiene el timer
                if (seconds == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(label, "Se acabo el tiempo!");
                    // Agregar cualquier código que quieras que se ejecute cuando el timer llega a cero
                }
            }
        });

        // Iniciar el timer
        timer.start();

        // Configurar la ventana
        setSize(200, 100);
        setVisible(true);
    }
}

