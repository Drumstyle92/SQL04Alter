import java.sql.*;

/**
 * @author Drumstyle92
 * Class with the entire code.
 */
public class Tester {
    /**
     * @param args main parameter
     * Main method containing creating a connection with the database,
     * modifications on the student table.
     */
    public static void main(String[] args) {

        Connection conn = null;

        try{
            // database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb",
                                              "root","Confusione1992");
            // table update
            Statement alterTable = conn.createStatement();
            alterTable.execute("ALTER TABLE students ADD country varchar(30);");
            String newQueryUpdate1 = "UPDATE students SET country = 'Italy' WHERE student_id = 1;";
            alterTable.execute(newQueryUpdate1);
            String newQueryUpdate2 = "UPDATE students SET country = 'Italy' WHERE student_id = 2;";
            alterTable.execute(newQueryUpdate2);
            String newQueryUpdate3 = "UPDATE students SET country = 'Germany' WHERE student_id = 3;";
            alterTable.execute(newQueryUpdate3);
            String newQueryUpdate4 = "UPDATE students SET country = 'Germany' WHERE student_id = 4;";
            alterTable.execute(newQueryUpdate4);
            System.out.println("-changed table-");

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }finally {

            try{
                if(conn != null){

                    conn.close();

                }

            }catch (SQLException ex){

                System.out.println(ex.getMessage());
            }
        }
    }
}
