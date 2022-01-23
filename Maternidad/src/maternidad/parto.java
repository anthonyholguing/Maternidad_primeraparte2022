/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maternidad;


import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class parto {
    
Connection db = null;
Statement st = null;
ResultSet rs = null;
PreparedStatement pst=null;

//String id_m,id_t,dan,nom;
String obstre, neona, pedia,canti, sexoneon,pesoneon,noved ;
Integer id_part, id_lim,id_medi, id_mante, id_madre, id_mater ;
java.sql.Date fech;

Boolean a;
String sql;

DefaultTableModel m = new DefaultTableModel();
conexion DB = new conexion();
Connection conexion =DB.conectarDB();

public void conecciondb() {
  try {
      db=DriverManager.getConnection("jdbc:postgresql://localhost:5432/2021MATERNIDADGESTION","postgres","anthonyg"); 
          //Acualize ruta .../basedatos,usuario,contraseña
      } catch (SQLException e) {System.out.println("Ocurrio un error : "+e.getMessage());} }


public void inserta_parto1_2022() throws SQLException {
    //conexion a la base de dato 
 conecciondb();
 // funcion de llamar a la transaccion
 try{
     // ingreso de datos 
     //id_li, id_mant, id_mad, id_mat
      id_part=Integer.valueOf(parto1_2022.parto.getText());
      id_lim=Integer.valueOf(parto1_2022.limpieza.getText());
      id_medi=Integer.valueOf(parto1_2022.medico.getText());
      id_mante=Integer.valueOf(parto1_2022.mantenimiento.getText());
      id_madre=Integer.valueOf(parto1_2022.madre.getText());
//obstre, neona, pedia,canti, sexoneon,pesoneon,noved
     obstre=parto1_2022.obstreta.getText();
     pedia=parto1_2022.pediatra.getText();
     neona=parto1_2022.neonatolo.getText();
     canti=parto1_2022.cantidad.getText();
     fech = new java.sql.Date(parto1_2022.fechaparto.getDate().getTime());
     sexoneon=parto1_2022.sexo.getText();
     pesoneon=parto1_2022.peso.getText();
     noved=parto1_2022.novedad.getText();
     id_mater=Integer.valueOf(parto1_2022.maternidad.getText());
     
     //consulta sql en postgres
   //  sql ="select transaccion('"+id_m+"','"+id_t+"','"+dan+"','"+fecha+"','"+garan+"',"+adq+");" ;
     //select transaccionuno('25','003','circuito','2000/12/05','2001/12/05', 150);
      sql ="select transaccion("+id_part+","+id_lim+","+id_medi+","+id_mante+","+id_madre+",'"+obstre+"','"+pedia+"','"+neona+"','"+canti+"','"+ fech+"','"+sexoneon+"','"+pesoneon+"','"+noved+"',"+id_mater+");" ;
     System.out.println(sql);

//select transaccion
//('6666','444445639','333335620','555556985','222225555','Thiago Francisco','Alfredo Carreño','Alberto Paez','1','19/11/2021','M','2 Kg','Proceso con éxito','888886990');     
   PreparedStatement pstmt = conexion.prepareStatement(sql);
      rs = pstmt.executeQuery();
      //mensaje de confirmacion
      JOptionPane.showMessageDialog(null,"Se Guardo...");
     System.out.println(rs);
    }catch(SQLException e){
        // mensaje de error que se mostrara como alert
         JOptionPane alerta = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);
         JDialog dialog = alerta.createDialog("Warning!");
         dialog.setAlwaysOnTop(true); // to show top of all other application
         dialog.setVisible(true);        
    }
}
}
/*
id_part, 
id_lim,
id_medi,
id_mante
id_madre
obstreta_part              pediatra_part
neonatologo_part           cantidad_part
fecha_de_part               sexoneonato_part
pesoneonato_part            novedad_part
id_mater
*/
