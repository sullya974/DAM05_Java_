import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameCenter extends JFrame {
    public JFrameCenter() {
        setTitle("JFrameCenter Pos");
//        add(new JLabel("Hello the world !", SwingConstants.CENTER), BorderLayout.CENTER);

        add(new JLabel("Hello the world !", SwingConstants.CENTER), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 50));

        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(200, 24));
        txtField.setBounds(50, 50, 200, 30);

        JButton btn = new JButton("Click me!");
        btn.setBounds(50, 100, 200, 30);
        btn.setSize(20, 30);

        add(txtField);
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, txtField.getText());
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Display to the center of screen
        setVisible(true);
    }
}
