
package maternidad;

import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class medico {
    
Connection db = null;
Statement st = null;
ResultSet rs = null;
PreparedStatement pst=null;
String nom,ape,dire,cedu,tele,cor,especiali ;
Integer id_medi;
String sql;
Boolean a;
DefaultTableModel m = new DefaultTableModel();

//Conexion base datos  //

public void conecciondb() {
  try {
      db=DriverManager.getConnection("jdbc:postgresql://localhost:5432/2021MATERNIDADGESTION","postgres","anthonyg"); 
          //Acualize ruta .../basedatos,usuario,contraseña
      } catch (SQLException e) {System.out.println("Ocurrio un error : "+e.getMessage());} }

//Ingreso (unico) tabla cliente
public void inserta_medico() throws SQLException {
if (a==false) { conecciondb();
//ingreso de variables
id_medi=Integer.valueOf(medico_2022.id_me.getText());
cedu=medico_2022.cedula.getText();
nom=medico_2022.nombre.getText();
ape=medico_2022.apellido.getText();      
//tele=Integer.valueOf(cliente.telefono.getText());
dire=medico_2022.direccion.getText(); 
cor=medico_2022.correo.getText();
tele=medico_2022.direccion.getText();
especiali=medico_2022.pro.getText();
//consulta sql en postgres
 sql = "insert into medico(id_medi, cedula_medi, nombre_medi, apellido_medi, direccion_medi, correo_medi, telefono_medi ,especialidad) values (?,?,?,?,?,?,?,?)";
 pst = db.prepareStatement(sql);
 //donde se muetra la insercion 
 pst.setInt(1,id_medi);
 pst.setString(2,cedu);
 pst.setString(3,nom);
 pst.setString(4,ape);
 pst.setString(5,dire);
 pst.setString(6,cor);
  pst.setString(7,tele);
 pst.setString(8,especiali);
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Se Guardo..."); } }

//Actualiza tabla cliente

public void actuali_medico() throws SQLException {
if (a==true) { conecciondb();
id_medi=Integer.valueOf(medico_2022.id_me.getText());
cedu=medico_2022.cedula.getText();
nom=medico_2022.nombre.getText();
ape=medico_2022.apellido.getText();
dire=medico_2022.direccion.getText();
cor=medico_2022.correo.getText();
tele=medico_2022.telefono.getText();
especiali=medico_2022.pro.getText();
 sql = "update medico set cedula_medi=?, nombre_medi=?, apellido_medi=?, direccion_medi=?, correo_medi=?, telefono_medi=?, especialidad=? where id_medi='"+id_medi+"'";
 pst = db.prepareStatement(sql);
 
 //pst.setInt(3,tele);
 pst.setInt(1,id_medi);
 pst.setString(1,cedu);
 pst.setString(2,nom);
 pst.setString(3,ape);
 pst.setString(4,dire);
 pst.setString(5,cor);
 pst.setString(6,tele);
 pst.setString(7,especiali);
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Se Actualizo exitosamente");
}
}

//Consulta tabla cliente si existe cliente
public void consulta_medico() throws SQLException {
 conecciondb();
 st = db.createStatement();
 id_medi=Integer.valueOf(medico_2022.id_me.getText());
 rs = st.executeQuery("select * from medico where id_medi='"+id_medi+"'");
 if (rs.next()) {a=true;
// medico_2022.id_me.setText(rs.getString(1));
 medico_2022.cedula.setText(rs.getString(2));
 medico_2022.nombre.setText(rs.getString(3));
 medico_2022.apellido.setText(rs.getString(4));
 medico_2022.direccion.setText(rs.getString(5));
 medico_2022.correo.setText(rs.getString(6));
 medico_2022.telefono.setText(rs.getString(7));
 medico_2022.pro.setText(rs.getString(8));
 }
 else {JOptionPane.showMessageDialog(null,"No Existe");a=false;} }

//Elimina tabla cliente si existe cliente y no está en otra tabla relacionada

public void elimina_medico() throws SQLException {
 try {
 if (a==true) { conecciondb();
 int resp = JOptionPane.showConfirmDialog(null, "Lo elimina","ALERTA",JOptionPane.YES_NO_OPTION);
 if (resp!=1) {st.execute("delete from medico where id_medi='"+id_medi+"'");
   JOptionPane.showMessageDialog(null,"SE ELIMINO, ya que no tiene relación tabla"); } } 
    }
 catch (SQLException e) {JOptionPane.showMessageDialog(null,"No se puede eliminar, tiene relación tabla");} }

//Limpiar datos entrada de cliente

public void limpia() {
 medico_2022.id_me.setText("");
 medico_2022.cedula.setText("");
 medico_2022.nombre.setText("");
 medico_2022.apellido.setText("");
 medico_2022.direccion.setText("");
 medico_2022.telefono.setText("");
 medico_2022.correo.setText("");
 medico_2022.correo.setText("");
 medico_2022.pro.setText("");
}
}

