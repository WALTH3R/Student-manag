
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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{
    
    Connection con;
    PreparedStatement pst;
    int row;
    ResultSet rs;
    
    public void doPost(HttpServletRequest req,HttpServletResponse rsp) throws IOException,ServletException
    {
    
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Student3","root","123456789");
        
        String studid =req.getParameter("studid");
        String fname =req.getParameter("fname");
        String lname =req.getParameter("lname");
        String fac =req.getParameter("fac");
        String dep =req.getParameter("dep");
        
        pst = con.prepareStatement("update student set fname=?, lname=?, fac=?, dep=? where studid=?");
        pst.setString(1,fname);
        pst.setString(2,lname);
        pst.setString(3,fac);
        pst.setString(4,dep);
        pst.setString(5,studid);
        row=pst.executeUpdate();
        
        out.println("<font color='green'> Record updated </font> ");
        
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();
        }
        
        
    } 
    
    
    
}
