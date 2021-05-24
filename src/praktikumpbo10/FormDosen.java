package praktikumpbo10;

import javax.swing.*;

public class FormDosen {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;


    public static void main(String[] args) {
        JFrame frame = new JFrame("FormDosen");
        frame.setContentPane(new FormDosen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}