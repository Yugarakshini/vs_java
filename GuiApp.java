import java.awt.Color;
import javax.swing.*;

public class GuiApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Java GUI Application");

        JPanel panel = new JPanel(); // Create a panel
        panel.setBackground(Color.PINK); // Set panel background to pink

        JButton button = new JButton("Click Me");

        panel.add(button); // Add button to panel
        frame.add(panel); // Add panel to frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setSize(300, 200); 
        frame.setVisible(true);
    }
}
