import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class form1 {
    public JPanel panel1;
    private JButton button1;
    private JButton BORRARButton;
    private JButton BUSCARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String password = "123456";

                vehiculos vehi = new vehiculos();

                String placa = textField1.getText();
                String marca = textField2.getText();
                Double cilindraje = Double.parseDouble(textField3.getText());
                String tipoconbustible = textField4.getText();
                String color = textField5.getText();
                String propietario = textField6.getText();

                vehi.setPlaca(placa);
                vehi.setMarca(marca);
                vehi.setCilindraje(cilindraje);
                vehi.setTipo_combustible(tipoconbustible);
                vehi.setColor(color);
                vehi.setPropietario(propietario);

                String sql = "INSERT INTO info_vehiculos (placa, marca, cilindraje, tipo_conbustible, color, propietario) VALUES (?,?,?,?,?,?)";

                try (Connection connection = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectada ");
                    PreparedStatement cadena = connection.prepareStatement(sql);
                    cadena.setString(1,placa);
                    cadena.setString(2,marca);
                    cadena.setDouble(3,cilindraje);
                    cadena.setString(4,tipoconbustible);
                    cadena.setString(5,color);
                    cadena.setString(6,propietario);

                    cadena.executeUpdate();


                }catch (SQLException E){
                    System.out.println(E);
                }
            }
        });
        BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new form2().panel2);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.pack();
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(BUSCARButton)).dispose();
            }
        });
    }
}
