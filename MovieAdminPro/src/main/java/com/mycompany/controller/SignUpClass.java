import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;//importing servlet api
import javax.servlet.http.*;
public class SignUpClass extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
    response.setContentType("text/html");
    PrintWriter show=response.getWriter();//PrintWriterObject
    show.println("<html>");
    show.println("<head>");
    show.println("<title>UserPage</title>");
    show.println("</head>");
    show.println("<body>");
    show.println("<h1>This content shown here will be stored to movie DataBase</h1>");
    String str= "Welcome"+" "+"to"+" "+request.getParameter("fName")+" "+request.getParameter("lName");
    show.println("<p>Your Movie Admin account has been created</p>");
    show.println("<p>"+str+"</p>");
    RequestDispatcher rd= request.getRequestDispatcher("/LogIn");
    rd.forward(request,response);
      try{
  show.println(doSqlConnection(request,response));
}catch(SQLException e1){
  e1.printStackTrace();
}catch(ClassNotFoundException e2){
  e2.printStackTrace();
}
    show.println("</body>");
    show.println("</html>");
  }
    public String doSqlConnection(HttpServletRequest request,HttpServletResponse response)throws SQLException, ClassNotFoundException,IOException,ServletException{
      String res=" ";
      try{
      String url="jdbc:mysql://localhost:3306/movieDB";
      String uName="root";
      String pWord="I@monly5";
      String fName=request.getParameter("fName");
      String lName=request.getParameter("lName");
      String email=request.getParameter("email");
      String pword=request.getParameter("pword");
      String dOB=request.getParameter("DOB");
      String query1="select * from user_signup";
      Class.forName("com.mysql.jdbc.Driver");
      Connection sqlCon=DriverManager.getConnection(url,uName,pWord);
      sqlCon.setAutoCommit(false);
      Statement st=sqlCon.createStatement();
      ResultSet result=st.executeQuery(query1);
      String strUid=result.getString(1);
      int uid=Integer.parseInt(strUid);
      uid=uid+1;
      String query2="insert into user_signup values( 1,'"+fName+" ',' "+lName+" ',' "+email+" ','"+pword+"','"+dOB+"')";
      int exec=st.executeUpdate(query2);
      sqlCon.commit();
      while(result.next()){
        res=result.getString(1)+","+result.getString(2)+","+result.getString(3);
      }
    }catch(SQLException e){
      System.out.println(e);
    }catch(ClassNotFoundException cnf){
      System.out.println(cnf);
    }
    return res;
    }
  }
