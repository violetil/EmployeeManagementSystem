package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cEmployeeId;
    JButton search, print, update, back;

    ViewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchLbl = new JLabel("搜索员工");
        searchLbl.setBounds(20, 20, 150, 20);
        add(searchLbl);

        cEmployeeId = new Choice();
        cEmployeeId.setBounds(180, 20, 150, 20);
        add(cEmployeeId);

        try {
            ConnectDatabase conn = new ConnectDatabase();
            ResultSet resultSet = conn.s.executeQuery("select * from employee");
            while (resultSet.next()) {
                cEmployeeId.add(resultSet.getString("employeeId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            ConnectDatabase conn = new ConnectDatabase();
            ResultSet resultSet = conn.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("搜索");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("打印");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("更新");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("返回");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(350, 200);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == search) {
            String query = "select * from employee where employeeId = '" + cEmployeeId.getSelectedItem() + "'";

            try {
                ConnectDatabase conn = new ConnectDatabase();
                ResultSet resultSet = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cEmployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
