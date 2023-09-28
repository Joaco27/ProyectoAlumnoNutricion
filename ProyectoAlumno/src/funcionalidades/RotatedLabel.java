package funcionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RotatedLabel extends JLabel {
	
    private float angle;

    public RotatedLabel(String cadena, int x, int y, int width, int height, float a) {
        super(cadena, SwingConstants.CENTER);
        angle = a;
        setFont(new Font("Arial", Font.BOLD, 40));
        setForeground(Color.black);
        setVerticalAlignment(SwingConstants.CENTER);
        setBounds(x, y, width, height);
    }
    
    public RotatedLabel(int x, int y, int width, int height, float a) {
        angle = a;
        setVerticalAlignment(SwingConstants.CENTER);
        setBounds(x, y, width, height);
    }

    public void setRotation(float angle) {
        this.angle = angle;
        repaint(); // Vuelve a pintar el componente para reflejar la rotación
    }
    
    public void setStrike(int n) {
    	this.setText(String.format("%d", n));
    }

    @Override
    public void paintComponent(Graphics g) {      
        Graphics2D gx = (Graphics2D) g.create(); // Crea una copia del contexto gráfico
        AffineTransform originalTransform = gx.getTransform(); // Guarda la transformación original
        gx.rotate(Math.toRadians(angle), getWidth() / 2, getHeight() / 2); // Aplica la rotación
        super.paintComponent(gx);
        gx.setTransform(originalTransform); // Restaura la transformación original
        gx.dispose(); // Libera los recursos del contexto gráfico
    }
}
