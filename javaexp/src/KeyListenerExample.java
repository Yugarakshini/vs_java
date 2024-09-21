import java.awt.*;
import java.awt.event.*;
public class KeyListenerExample extends Frame implements KeyListener {
    Label l1;
    TextArea area;
    KeyListenerExample(){
        l1 = new Label();
        l1.setBounds(20,50,100,20);
        area = new TextArea();
        area.setBounds(30,80,300,300);
        area.addKeyListener(this);
        add(l1);
    add(area);
    setSize(800,800);
    setLayout(null);
    setVisible(true);
    }
    public void keyPressed(KeyEvent e){
        l1.setText("Key Pressed");
    }
    public void keyReleased(KeyEvent e){
        l1.setText("Key Released");
    }
    public void keyTyped(KeyEvent e){
        l1.setText("Key Typed");
    }
    public static void main(String[] args){
        new KeyListenerExample();
    }
}
