package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cEmpId;
    JButton delete, back;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelEmpId = new JLabel("员工号");
        labelEmpId.setBounds(50, 50, 100, 30);
        add(labelEmpId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try {
            ConnectDatabase conn = new ConnectDatabase();
            String query = "select * from employee";
            ResultSet resultSet = conn.s.executeQuery(query);

            while (resultSet.next()) {
                cEmpId.add(resultSet.getString("employeeId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 姓名
        JLabel labelName = new JLabel("姓名");
        labelName.setBounds(50, 100, 100, 30);
        add(labelName);

        JLabel lblName = new JLabel();
        lblName.setBounds(200, 100, 100, 30);
        add(lblName);

        // 电话
        JLabel labelPhone = new JLabel("电话号码");
        labelPhone.setBounds(50, 150, 100, 30);
        add(labelPhone);

        JLabel lblPhone = new JLabel();
        lblPhone.setBounds(200, 150, 100, 30);
        add(lblPhone);

        // 邮箱
        JLabel labelEmail = new JLabel("邮箱");
        labelEmail.setBounds(50, 200, 100, 30);
        add(labelEmail);

        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(200, 200, 100, 30);
        add(lblEmail);

        try {
            ConnectDatabase conn = new ConnectDatabase();
            String query = "select * from employee where employeeId = '" + cEmpId.getSelectedItem() + "'";
            ResultSet resultSet = conn.s.executeQuery(query);

            while (resultSet.next()) {
                lblName.setText(resultSet.getString("name"));
                lblPhone.setText(resultSet.getString("phone"));
                lblEmail.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    ConnectDatabase conn = new ConnectDatabase();
                    String query = "select * from employee where employeeId = '" + cEmpId.getSelectedItem() + "'";
                    ResultSet resultSet = conn.s.executeQuery(query);

                    while (resultSet.next()) {
                        lblName.setText(resultSet.getString("name"));
                        lblPhone.setText(resultSet.getString("phone"));
                        lblEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });

        delete = new JButton("删除");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("返回");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/109741069_p0.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 500);
        add(image);

        setSize(1000, 400);
        setLocation(350, 200);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == delete) {
            try {
                ConnectDatabase conn = new ConnectDatabase();
                String query = "delete from employee where employeeId = '" + cEmpId.getSelectedItem() + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "删除成功");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
