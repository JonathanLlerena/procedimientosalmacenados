
package proalmacenado;
import java.sql.*;

public class database {

  private String bd = "jugadore";
  private String login = "root";
  private String password = "";
  private String url = "jdbc:mysql://localhost/"+bd;
  private Connection conn = null;
  
  public database(){
      try{         
         Class.forName("com.mysql.jdbc.Driver");         
         conn = DriverManager.getConnection(url,login,password);         
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }
   
  public String procedure(String nombre, int anio_nacimiento)
   {
       String resultado=null;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = conn.prepareCall(" CALL registrar_jugador(?,?,?) ");
            //se cargan los parametros de entrada
            proc.setString("nombre", nombre);//Tipo String
            proc.setInt("anio_nac", anio_nacimiento);//Tipo entero
            // parametros de salida
            proc.registerOutParameter("resultado", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getString("resultado");
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
       return resultado;
   }
}
