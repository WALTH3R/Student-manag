
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;
import java.sql.Connection;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;



@WebServlet("/Student")

public class Student extends HttpServlet {
    
    Connection con;
    PreparedStatement pst;
    int row;
    
    public void doPost(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException
    {
    
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Student3","root","123456789");
        String studid = req.getParameter("studid");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String fac = req.getParameter("fac");
        String dep = req.getParameter("dep");
        
        pst = con.prepareStatement("insert into student(studid,fname,lname,fac,dep)values(?,?,?,?,?)");
        pst.setString(1, studid);
        pst.setString(2, fname);
        pst.setString(3, lname);
        pst.setString(4, fac);
        pst.setString(5, dep);
        row = pst.executeUpdate();
        
        out.println("<font color='green'> Record Added </font> ");
        
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();
        }
        
        
    } 
    
    
    
}
