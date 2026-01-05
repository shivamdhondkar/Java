import java.sql.*;

public class Connect {
    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/compilersdb", "root", "root"); 
            String sql = "insert into employee values(2222,'James','Engineer',50000)";
            Statement st = con.createStatement();
            int n = st.executeUpdate(sql);
            st.close();
            con.close();

            if(n==1){
                System.out.println("Record insrted");
            }

            else{
                System.out.println("Record not inserted");
            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
