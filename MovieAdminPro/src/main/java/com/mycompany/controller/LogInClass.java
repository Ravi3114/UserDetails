import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;//importing servlet api
import javax.servlet.http.*;
public class LogInClass extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
    response.setContentType("text/html");
    PrintWriter show=response.getWriter();//PrintWriterObject
    show.println("<html>");
    show.println("<head>");
    show.println("<title>UserPage</title>");
    show.println("</head>");
    show.println("<body>");
    show.println("<h1>This content if from Database Movie choose a movie </h1>");
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
      String url="jdbc:mysql://localhost:3306/movieDB";
      String uName="root";
      String pWord="I@monly5";
      String fName=request.getParameter("fName");
      String lName=request.getParameter("lName");
      String email=request.getParameter("email");
      String pword=request.getParameter("pword");
      String dOB=request.getParameter("DOB");
      String e_mail=request.getParameter("e_mail");
      String p_word=request.getParameter("p_word");
      String query2="select * from movie";
      Connection sqlConnect=null;
      PreparedStatement st=null;
      ResultSet result=null;
      try{
      Class.forName("com.mysql.jdbc.Driver");

      sqlConnect=DriverManager.getConnection(url,uName,pWord);
     }catch(ClassNotFoundException c){
       c.printStackTrace();
      }catch(SQLException e){
        e.printStackTrace();
      }
      try{
      sqlConnect.setAutoCommit(false);
      st=sqlConnect.createStatement();
      result=st.executeQuery(query2);
      sqlConnect.commit();
     }catch(SQLException e1){
       e1.printStackTrace();
      }
      try{
        sqlConnect.rollback();
      }catch(SQLException e2){
        e2.printStackTrace();
      }
      String res=" ";
      while(result.next()){
        res=result.getString(1)+","+result.getString(2)+","+result.getString(3);
      }
      return res;
    }
  }
