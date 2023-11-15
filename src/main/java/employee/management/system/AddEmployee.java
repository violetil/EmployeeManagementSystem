package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JButton add, back;
    JTextField tfName, tfIdNumber, tfSalary, tfAddress, tfPhone, tfEmail, tfDesignation;
    JDateChooser dcDob;
    JComboBox cbEducation;
    JLabel tfEmpId;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("添加员工信息");
        heading.setBounds(360, 30, 160, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // 姓名
        JLabel labelName = new JLabel("姓名");
        labelName.setBounds(50, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);

        tfName = new JFormattedTextField();
        tfName.setBounds(200, 150, 150, 30);
        add(tfName);

        // 身份证号
        JLabel labelIdNumber = new JLabel("身份证号");
        labelIdNumber.setBounds(450, 150, 200, 30);
        labelIdNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelIdNumber);

        tfIdNumber = new JFormattedTextField();
        tfIdNumber.setBounds(580, 150, 200, 30);
        add(tfIdNumber);

        // 生日
        JLabel labelDob = new JLabel("出生日期");
        labelDob.setBounds(50, 200, 150, 30);
        labelDob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDob);

        dcDob = new JDateChooser();
        dcDob.setBounds(200, 200, 150, 30);
        add(dcDob);

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

        String[] course = { "无", "博士", "硕士", "本科", "大专", "高中", "初中", "小学" };
        cbEducation = new JComboBox(course);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(580, 300, 200, 30);
        add(cbEducation);

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

        tfEmpId = new JLabel("" + number);
        tfEmpId.setBounds(200, 400, 150, 30);
        add(tfEmpId);

        add = new JButton("添加");
        add.setBounds(220, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

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
        if (event.getSource() == add) {
            String name = tfName.getText();
            String dob = ((JTextField) dcDob.getDateEditor().getUiComponent()).getText();
            String salary = tfSalary.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String education = (String) cbEducation.getSelectedItem();
            String designation = tfDesignation.getText();
            String idNumber = tfIdNumber.getText();
            String employeeId = tfEmpId.getText();

            try {
                ConnectDatabase conn = new ConnectDatabase();
                String query = "insert into employee values('" + name + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + idNumber + "', '" + employeeId + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "已成功添加");
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
        new AddEmployee();
    }
}
