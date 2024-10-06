
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
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Walther
 */

@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet{
    
    
    Connection con;
    PreparedStatement pst;
    int row;
    ResultSet rs;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException
    {
    
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        String sid =req.getParameter("studid");
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Student3","root","123456789");
        
        pst = con.prepareStatement("Select * from student where studid = ?");
        pst.setString(1,sid);
        rs=pst.executeQuery();
       
        while(rs.next())
        {
            out.print("<form action ='EditServlet' method='POST'");
            out.print("<table");
            out.print("<tr><td>Studid</td> <td><input type='text' name ='studid' value= '"+rs.getString("studid")+ "'/> <td> </tr>");
            out.print("<tr><td>Firstname</td> <td><input type='text' name ='fname' value= '"+rs.getString("fname")+ "'/> <td> </tr>");
            out.print("<tr><td>Lastname</td> <td><input type='text' name ='lname' value= '"+rs.getString("lname")+ "'/> <td> </tr>");
            out.print("<tr><td>Faculty</td> <td><input type='text' name ='fac' value= '"+rs.getString("fac")+ "'/> <td> </tr>");
            out.print("<tr><td>Department</td> <td><input type='text' name ='dep' value= '"+rs.getString("dep")+ "'/> <td> </tr>");
            out.print("<tr> <td colspan = '2'><input type='submit'  value= 'Edit'/> </td> </tr>");
            
            out.print("</table");
            out.print("</form");
            
            
        }
        
        
        
        out.println("</table>");
        
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();
        }
        
        
    } 
    
}
