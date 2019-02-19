package com.mycompany.controller;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.mycompany.model.*;
public class FrontController extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
    FrontController fc=new FrontController();
    fc.takePageParameters(request,response);
    fc.showDetails(request,response);


  }
  public void takePageParameters(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
    String fn=request.getParameter("fullname");
    String gn=request.getParameter("gender");
    String[] pro={request.getParameter("program")};
    String com=request.getParameter("company");
    List lt=Arrays.asList(pro);
    request.setAttribute("cards",lt);
    HttpSession session=request.getSession();
    Client user=null;
    if(session.getAttribute("sessionAttribute")==null){
      user =new Client();
      session.setAttribute("sessionAttribute",user);
    }else{
      session.getAttribute("sessionAttribute");
    }
    user.setFullname(fn);
    user.setGender(gn);
    user.setProgram_lang(pro);
    user.setCompany(com);
    RequestDispatcher rd=request.getRequestDispatcher("details");
    rd.forward(request,response);
  }
  public void showDetails(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
    HttpSession session=request.getSession();
    Client newUser=(Client)session.getAttribute("sessionAttribute");
    request.setAttribute("Name",newUser.getFullname());
    request.setAttribute("Gender",newUser.getGender());
    request.setAttribute("Program",newUser.getProgram_lang());
    request.setAttribute("company",newUser.getCompany());

      RequestDispatcher rd=request.getRequestDispatcher("web/ShowDetailsFrontEnd.jsp");
      rd.forward(request,response);
  }
}
