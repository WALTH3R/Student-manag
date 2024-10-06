
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


@WebServlet("/viewstudent")
public class viewstudent extends HttpServlet {
    Connection con;
    PreparedStatement pst;
    int row;
    ResultSet rs;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException
    {
    
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Student3","root","123456789");
        
        String sql;
        sql="select * from student";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        
        out.println("<table cellspacing = '0' width ='350px' border='1'> ");
        out.println("<tr>");
        out.println("<td>Studid</td>");
        out.println("<td>Firstname</td>");
        out.println("<td>Lastnane</td>");
        out.println("<td>Faculty</td>");
        out.println("<td>Department</td>");
        out.println("<td>Edit</td>");
        out.println("<td>Delete</td>");
        out.println("</tr>");
        
        
       while(rs.next())
       {
       out.println("<tr>");
           out.println("<td>"+  rs.getString("studid")  +"</td>");
           out.println("<td>"+  rs.getString("fname")  +"</td>");
           out.println("<td>"+  rs.getString("lname")  +"</td>");
           out.println("<td>"+  rs.getString("fac")  +"</td>");
           out.println("<td>"+  rs.getString("dep")  +"</td>");
           
           out.println("<td>"+ "<a href='Editreturn?studid="+ rs.getString("studid")+"'>Edit </a>" +"</td>");
           out.println("<td>"+ "<a href='Delete?studid="+ rs.getString("studid")+"'>Delete </a>" +"</td>");
       out.println("</tr>");
       }
        
        
        
        
        out.println("</table>");
        
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();
        }
        
        
    } 
}
