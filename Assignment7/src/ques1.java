import java.sql.*;
import java.util.*;
public class ques1 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String url = "jdbc:postgresql://192.168.1.17:5432/cse_db24";
        String user = "24bcsi23";
        String pass = "24bcsi23";

        String sql = "CREATE TABLE studentiwt2 (" +
                     "roll_no INT PRIMARY KEY, " +
                     "name VARCHAR(50), " +
                     "age INT, " +
                     "department VARCHAR(30), " +
                     "cgpa NUMERIC(4,2))";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement()) {
            
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
            
          
            stmt.executeUpdate("INSERT INTO studentiwt2 VALUES  (1, 'Amrut', 25, 'MCA', 8.5)");
            stmt.executeUpdate("INSERT INTO studentiwt2 VALUES (2, 'Ayush', 21, 'cse', 9.7)");
            System.out.println("Hardcoded data inserted!");
            
    
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter CGPA: ");
            float cgpa = sc.nextFloat();

            String insertQuery = "INSERT INTO studentiwt2 VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, dept);
            ps.setFloat(5, cgpa);

            ps.executeUpdate();
            System.out.println("User record inserted!");
            
  
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentiwt2");
            System.out.println("\n   Student Records ");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("roll_no") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("department") + " | " +
                        rs.getFloat("cgpa")
                );
            }
            
           
            System.out.print("\nEnter Roll No to update: ");
            int uRoll = sc.nextInt();
            System.out.print("Enter new CGPA: ");
            float newCgpa = sc.nextFloat();
            String updateQuery = "UPDATE studentiwt2 SET cgpa=? WHERE roll_no=?";
            PreparedStatement ps2 = con.prepareStatement(updateQuery);
            ps2.setFloat(1, newCgpa);
            ps2.setInt(2, uRoll);

            ps2.executeUpdate();
            System.out.println("CGPA updated!");
            
           
            System.out.print("\nEnter Roll No to delete: ");
            int dRoll = sc.nextInt();
            String deleteQuery = "DELETE FROM studentiwt2 WHERE roll_no=?";
            PreparedStatement ps3 = con.prepareStatement(deleteQuery);
            ps3.setInt(1, dRoll);
            ps3.executeUpdate();

            System.out.println("Record deleted!");
            

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}
            