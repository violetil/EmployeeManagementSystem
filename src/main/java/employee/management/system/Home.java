package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton add, view, update, remove;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/109741069_p0.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("员工管理系统");
        heading.setBounds(770, 30, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        image.add(heading);

        add = new JButton("添加员工");
        add.setBounds(700, 85, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("查看员工");
        view.setBounds(870, 85, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("更新员工");
        update.setBounds(700, 145, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("移除员工");
        remove.setBounds(870, 145, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (event.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (event.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
