import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static String usuario="hall";
    private static String senha="123";
    private static String banco="fazendaws";
    private static String ip="localhost";
    private static String driver="com.mysql.jdbc.Driver";
    private static Connection conexao = null;

    //padrao singleton
    public static Connection getConnection() {
        System.out.println(">>Conectando ao banco");
        try {
            Class.forName(driver);
            if(conexao==null || conexao.isClosed()){
                conexao=DriverManager.getConnection("jdbc:mysql://"+ip+"/"+banco+"",usuario, senha);
            }
            return conexao; 
        }catch (ClassNotFoundException e) {    
            throw new RuntimeException(e);    
        }catch (SQLException e) {

            closeConnection();
            throw new RuntimeException(e);
        }

    }

    public static void closeConnection(){
        try{
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
                System.out.println(">>Conexao encerrada com sucesso");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        System.out.println("conexao: "+getConnection());
        System.out.println("conexao: "+getConnection());
        System.out.println("conexao: "+getConnection());
    }

}