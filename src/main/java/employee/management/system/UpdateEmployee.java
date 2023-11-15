package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    JButton update, back;
    JTextField tfEducation, tfIdNumber, tfSalary, tfAddress, tfPhone, tfEmail, tfDesignation;
    JLabel tfEmpId;
    String employeeId;

    UpdateEmployee(String employeeId) {
        this.employeeId = employeeId;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("更新员工信息");
        heading.setBounds(360, 30, 160, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // 姓名
        JLabel labelName = new JLabel("姓名");
        labelName.setBounds(50, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);

        JLabel lblName = new JLabel();
        lblName.setBounds(200, 150, 150, 30);
        add(lblName);

        // 身份证号
        JLabel labelIdNumber = new JLabel("身份证号");
        labelIdNumber.setBounds(450, 150, 200, 30);
        labelIdNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelIdNumber);

        JLabel lblIdNumber = new JLabel();
        lblIdNumber.setBounds(580, 150, 200, 30);
        add(lblIdNumber);

        // 生日
        JLabel labelDob = new JLabel("出生日期");
        labelDob.setBounds(50, 200, 150, 30);
        labelDob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDob);

        JLabel lblDob = new JLabel();
        lblDob.setBounds(200, 200, 150, 30);
        add(lblDob);

        // 薪资
        JLabel labelSalary = new JLabel("薪资");
        labelSalary.setBounds(450, 200, 200, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);

        tfSalary = new JFormattedTextField();
        tfSalary.setBounds(580, 200, 200, 30);
        add(tfSalary);

        // 住址
        JLabel labelAddress = new JLabel("住址");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);

        tfAddress = new JFormattedTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        // 手机号
        JLabel labelPhone = new JLabel("手机号");
        labelPhone.setBounds(450, 250, 200, 30);
        labelPhone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhone);

        tfPhone = new JFormattedTextField();
        tfPhone.setBounds(580, 250, 200, 30);
        add(tfPhone);

        // 邮箱
        JLabel labelEmail = new JLabel("邮箱");
        labelEmail.setBounds(50, 300, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);

        tfEmail = new JFormattedTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        // 受教程度
        JLabel labelEducation = new JLabel("受教程度");
        labelEducation.setBounds(450, 300, 200, 30);
        labelEducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEducation);

        tfEducation = new JFormattedTextField();
        tfEducation.setBounds(580, 300, 200, 30);
        add(tfEducation);

        // 职位
        JLabel labelDesignation = new JLabel("职位");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDesignation);

        tfDesignation = new JFormattedTextField();
        tfDesignation.setBounds(200, 350, 150, 30);
        add(tfDesignation);

        // 员工号
        JLabel labelEmpId = new JLabel("员工号");
        labelEmpId.setBounds(50, 400, 150, 30);
        labelEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpId);

        tfEmpId = new JLabel();
        tfEmpId.setBounds(200, 400, 150, 30);
        add(tfEmpId);

        try {
            ConnectDatabase conn = new ConnectDatabase();
            String query = "select * from employee where employeeId = '" + employeeId + "'";
            ResultSet resultSet = conn.s.executeQuery(query);

            while (resultSet.next()) {
                lblName.setText(resultSet.getString("name"));
                lblDob.setText(resultSet.getString("dob"));
                tfAddress.setText(resultSet.getString("address"));
                tfSalary.setText(resultSet.getString("salary"));
                tfPhone.setText(resultSet.getString("phone"));
                tfEmail.setText(resultSet.getString("email"));
                tfEducation.setText(resultSet.getString("education"));
                lblIdNumber.setText(resultSet.getString("idNumber"));
                tfEmpId.setText(resultSet.getString("employeeId"));
                tfDesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("更新");
        update.setBounds(220, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("返回");
        back.setBounds(470, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(350, 100);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == update) {
            String salary = tfSalary.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String education = tfEducation.getText();
            String designation = tfDesignation.getText();

            try {
                ConnectDatabase conn = new ConnectDatabase();
                String query = "update employee set salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation + "' where employeeId = " + employeeId;

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "更新成功");
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
        new UpdateEmployee("");
    }
}
