
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Walther
 */

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    
    Connection con;
    PreparedStatement pst;
    int row;
    ResultSet rs;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException
    {
    
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        
        String studid =req.getParameter("studid");
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Student3","root","123456789");
        
        
        
        
        pst = con.prepareStatement("delete from student where studid=?");
        pst.setString(1,studid);
        row=pst.executeUpdate();
        
        out.println("<font color='green'> Record Deleted </font> ");
        
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();
        }
        
        
    } 
    
    
    
    
    
}
