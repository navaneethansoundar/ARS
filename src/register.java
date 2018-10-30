

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=req.getParameter("name");        
		String last_name=req.getParameter("last_name");   
		String email=req.getParameter("email"); 
		String phone_number=req.getParameter("phone_number"); 
		String gender=req.getParameter("gender"); 
		String DOB=req.getParameter("DOB"); 
		String address=req.getParameter("address"); 
		String city=req.getParameter("city"); 
		String state=req.getParameter("state");
		String pin_code=req.getParameter("Pin_code");      
		String country=req.getParameter("country");      
		String age=req.getParameter("age");  
		String Message=req.getParameter("Message");  
		      
		Connection con=null;        
		Statement stmt=null;        
		PrintWriter out=res.getWriter();        
		try       
		{             
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println("1");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","1234" ); 
		System.out.println("2");
		stmt=con.createStatement();  
		System.out.println("3");
		int i = stmt.executeUpdate("insert into reg values('"+name+"', '"+last_name+"', '"+email+"','"+phone_number+"','"+gender+"','"+DOB+"','"+address+"','"+city+"','"+state+"','"+pin_code+"','"+country+"','"+age+"','"+Message+"')");              
		System.out.println("4");
		if(i>0) {               
		System.out.println("Inserted Successfully");              

		}else                
			System.out.println("Insert Unsuccessful");  
		}
		catch(Exception e){

		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
