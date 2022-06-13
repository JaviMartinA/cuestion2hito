import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JPanel Main;
    private JLabel txtTitrulo;
    private JLabel labelUsuario;
    private JLabel labelCorreo;
    private JLabel labelPassword;
    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JLabel labelHabilidades;
    private JLabel labelPuntualidad;
    private JComboBox cbPuntualidad;
    private JComboBox cbTrabajo;
    private JComboBox cbMediaE;
    private JComboBox cbAdaptacion;
    private JComboBox cbIniciativa;
    private JButton btnSave;
    private JLabel lblmdusuario;
    private JTable tabla;
    private JButton btnShow;
    private JLabel labelmdusuario;
    Connection con;
    PreparedStatement pst;

    public Login() {
        Connection();
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario,correo,password;
                usuario=txtUsuario.getText();
                correo=txtCorreo.getText();
                password= String.valueOf(txtPassword.getPassword());
                char primera=password.charAt(0);
                if(!correo.contains("@")){
                    JOptionPane.showMessageDialog(null,"Correo no válido");
                }
                else if(!(password.length() >= 8 || Character.isUpperCase(primera))){
                    JOptionPane.showMessageDialog(null,"Contraseña no válida");
                    JOptionPane.showMessageDialog(null,"Revise haber introducido bien la contraseña o que la primera letra esté en mayúsculas");
                }else{
                    try{
                        float media=calcularMedia();
                        pst=con.prepareStatement("update hito_grupal_pg set mediaalumno=? where usuario=?");
                        pst.setFloat(1,media);
                        pst.setString(2,usuario);
                        pst.executeUpdate();
                        cargarTabla();
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null,"No se puede hallar la media");
                    }
                }

            }
        });
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario,correo,password;
                usuario=txtUsuario.getText();
                correo=txtCorreo.getText();
                password= String.valueOf(txtPassword.getPassword());
                char primera=password.charAt(0);
                if(!correo.contains("@")){
                    JOptionPane.showMessageDialog(null,"Correo no válido");
                }
                else if(!(password.length() >= 8 || Character.isUpperCase(primera))){
                    JOptionPane.showMessageDialog(null,"Contraseña no válida");
                    JOptionPane.showMessageDialog(null,"Revise haber introducido bien la contraseña o que la primera letra esté en mayúsculas");
                }
                else{
                    try{
                        cargarTabla();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"Revise que haya iniciado sesión");
                    }
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de sesión y cálculo de media");
        frame.setContentPane(new Login().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();

        }
    }
    public void cargarTabla() {
        try {
            pst = con.prepareStatement("select * from hito_grupal_pg");
            ResultSet rs = pst.executeQuery();
            tabla.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public float calcularMedia(){
        int puntualidad,trabajoequipo,mediaexamenes,adaptacion,iniciativa;
        puntualidad=cbPuntualidad.getSelectedIndex();
        trabajoequipo=cbTrabajo.getSelectedIndex();
        mediaexamenes=cbMediaE.getSelectedIndex();
        adaptacion=cbAdaptacion.getSelectedIndex();
        iniciativa=cbIniciativa.getSelectedIndex();
        int total=puntualidad+trabajoequipo+mediaexamenes+adaptacion+iniciativa;
        return total/5.0f;
    }
}
