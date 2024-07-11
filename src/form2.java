import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 {
    public JPanel panel2;
    private JTextField textField1;
    private JButton REGRESARButton;
    private JButton BUSCARButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    public form2() {
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String password = "123456";

                try(Connection connection = DriverManager.getConnection(url,user,password)){
                    System.out.println("CONECTADA A LA BASE DE DATOS");
                    String query = "SELECT * FROM info_vehiculos where placa= '" + textField1.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()){
                        label1.setText(resultSet.getString("marca"));
                        label2.setText(resultSet.getString("cilindraje"));
                        label3.setText(resultSet.getString("tipo_conbustible"));
                        label4.setText(resultSet.getString("color"));
                        label5.setText(resultSet.getString("propietario"));
                    }
                }catch (SQLException E){
                    System.out.println(E.getMessage());
                }
            }
        });
        REGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("REGRESAR");
                frame.setContentPane(new form1().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
