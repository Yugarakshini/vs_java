import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class text1 extends Applet implements ActionListener {
    public static void main(String[] args){
    final TextField text1, text2, text3, text4;  // Corrected variable name
    final Label label1, label2;
    final int a, b, d;
    String c1;}

    public void init() {
        label1 = new Label("enter first number");
        add(label1);

        label2 = new Label("enter second number");
        add(label2);

        text2 = new TextField(10);
        text2.addActionListener(this);
        add(text2);

        text3 = new TextField(10);
        text3.setEchoChar('#');
        add(text3);

        text4 = new TextField("uneditable");
        text4.setEditable(false);
        add(text4);
    }

    public void paint(Graphics g) {
        g.drawString("sum is " + d, 50, 100);
        text4.setText(c1);
    }

    public void actionPerformed(ActionEvent e) {
        a = Integer.parseInt(text2.getText());
        b = Integer.parseInt(text3.getText());
        d = a + b;
        c1 = String.valueOf(d);
        repaint();
    }
}