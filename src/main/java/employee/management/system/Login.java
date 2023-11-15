package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername, tfPassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("用户名");
        username.setBounds(40, 20, 60, 30);
        add(username);

        tfUsername = new JFormattedTextField();
        tfUsername.setBounds(110, 20, 150, 30);
        add(tfUsername);

        JLabel password = new JLabel("密码");
        password.setBounds(40, 70, 60, 30);
        add(password);

        tfPassword = new JFormattedTextField();
        tfPassword.setBounds(110, 70, 150, 30);
        add(tfPassword);

        JButton login = new JButton("登录");
        login.setBounds(110, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/789010.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 10, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            ConnectDatabase conn = new ConnectDatabase();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            ResultSet resultSet = conn.s.executeQuery(query);

            if (resultSet.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在或密码错误");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
