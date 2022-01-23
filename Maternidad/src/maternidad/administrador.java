
package maternidad;

import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class administrador {
Connection db = null;
Statement st = null;
ResultSet rs = null;
PreparedStatement pst=null;
String ced, nomb,apell,corr,direc,telef,profe ;
Integer id_a ;
String sql;
Boolean a;
DefaultTableModel m = new DefaultTableModel();



//Conexion base datos  

public void conecciondb() {
  try {
      db=DriverManager.getConnection("jdbc:postgresql://localhost:5432/2021MATERNIDADGESTION","postgres","anthonyg"); 
          //Acualize ruta .../basedatos,usuario,contraseña
      } catch (SQLException e) {System.out.println("Ocurrio un error : "+e.getMessage());} }

//Ingreso (unico) tabla cliente
public void inserta_administrador() throws SQLException {
if (a==false) { conecciondb();
//ingreso de variables
id_a=Integer.valueOf(administrador_2022.id_adminis.getText());
ced=administrador_2022.cedula_c.getText();
nomb=administrador_2022.nombre_n.getText();
apell=administrador_2022.apellido_a.getText();  
direc=administrador_2022.direccion_d.getText();
corr=administrador_2022.correo_c.getText();
telef=administrador_2022.telefono_t.getText();  
profe=administrador_2022.profesion_p.getText();
//consulta sql en postgres
 sql = "insert into administrativo (cedula_admin, nombre_admin, apellido_admin, direccion_admin,correo_admin, telefono_c, profesion_admin) values (?,?,?,?,?,?,?,?)";
 pst = db.prepareStatement(sql);
 //donde se muetra la insercion 
 pst.setInt(1,id_a);
 pst.setString(2,ced);
 pst.setString(3,nomb);
 pst.setString(5,direc);
 pst.setString(6,corr);
 pst.setString(7,telef);
 pst.setString(8,profe);
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Se Guardo..."); } }


//Actualiza tabla cliente

public void actuali_administrador() throws SQLException {
if (a==true) { conecciondb();
id_a=Integer.valueOf(administrador_2022.id_adminis.getText());
ced=administrador_2022.cedula_c.getText();
nomb=administrador_2022.nombre_n.getText();
apell=administrador_2022.apellido_a.getText();
direc=administrador_2022.direccion_d.getText();
corr=administrador_2022.correo_c.getText();
telef=administrador_2022.telefono_t.getText();
profe=administrador_2022.profesion_p.getText();
 sql = "update administrativo set cedula_admin=?, nombre_admin=?, apellido_admin=? ,direccion_admin=?, correo_admin=?, telefono_admin=?, profesion_admin=? where id_admin='"+id_a+"'";
 pst = db.prepareStatement(sql);
 
 //pst.setInt(1,id_a);
 pst.setString(1,ced);
 pst.setString(2,nomb);
 pst.setString(3,apell);
 pst.setString(4,direc);
 pst.setString(5,corr);
 pst.setString(6,telef);
 pst.setString(7,profe);
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Se Actualizo con éxito");
}
}


//Consulta tabla cliente si existe cliente

public void consulta_administrador() throws SQLException {
 conecciondb();
 st = db.createStatement();
 id_a=Integer.valueOf(administrador_2022.id_adminis.getText());
 rs = st.executeQuery("select * from administrativo where id_admin='"+id_a+"'");
 if (rs.next()) {a=true;
 
  administrador_2022.cedula_c.setText(rs.getString(2));
  administrador_2022.nombre_n.setText(rs.getString(3));
  administrador_2022.apellido_a.setText(rs.getString(4));
  administrador_2022.direccion_d.setText(rs.getString(5));
   administrador_2022.correo_c.setText(rs.getString(6));
  administrador_2022.telefono_t.setText(rs.getString(7));
  administrador_2022.profesion_p.setText(rs.getString(8));
 
  
 }
 else {JOptionPane.showMessageDialog(null,"No Existe...");a=false;} }


//Elimina tabla cliente si existe cliente y no está en otra tabla relacionada

public void elimina_administrador() throws SQLException {
 try {
 if (a==true) { conecciondb();
 int resp = JOptionPane.showConfirmDialog(null, "Lo elimina","ALERTA",JOptionPane.YES_NO_OPTION);
 if (resp!=1) {st.execute("delete from administrativo where id_admin='"+id_a+"'");
   JOptionPane.showMessageDialog(null,"SE ELIMINO, ya que no tiene relación tabla"); } } 
    }
 catch (SQLException e) {JOptionPane.showMessageDialog(null,"No se puede eliminar, tiene relación tabla");} }

//Limpiar datos entrada de cliente

public void limpia() {
administrador_2022.id_adminis.setText("");
administrador_2022.cedula_c.setText("");
administrador_2022.nombre_n.setText("");
administrador_2022.apellido_a.setText("");
administrador_2022.direccion_d.setText("");
administrador_2022.correo_c.setText("");
administrador_2022.telefono_t.setText("");
administrador_2022.profesion_p.setText("");


}
}

