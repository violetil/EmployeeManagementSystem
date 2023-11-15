package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    int windowsWidth = 1170;
    int windowsHeight = 650;
    int headingSize = 60;
    int headingWidth = 360;
    int headingHeight = 60;

    int headingXLocation = (windowsWidth - headingWidth) / 2;
    int headingYLocation = 30;

    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("员工管理系统");
        heading.setBounds(headingXLocation, headingYLocation, headingWidth, headingHeight);
        heading.setFont(new Font("serif", Font.PLAIN, headingSize));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/789010.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton clickHere = new JButton("点击此处继续");
        clickHere.setBounds(400, 400, 280, 60);
        clickHere.setBackground(Color.GRAY);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);
        image.add(clickHere);

        setSize(windowsWidth, windowsHeight);
        setLocation(250, 150);
        setResizable(false);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(800);
            } catch (Exception e) {

            }

            heading.setVisible(true);
            try {
                Thread.sleep(800);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}


