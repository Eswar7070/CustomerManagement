package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.ado.DataAccess;
import com.techpalle.util.SuccessPage;
import com.tecpalle.model.Customer;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		
		switch(path)
		{
		case "/loginCustomer":
		validateCustomer(request,response);
		break;
		case"/regCustomer":
			insertCustomer(request,response);
			break;
		case"/reg":
			getRegestrationPage(request,response);
			break;
		case "/Log":
			getLoginPage(request,response);
		default:
			getStartUpPage(request,response);
			break;
		
		}
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String e=request.getParameter("tbEmailLog");
		String p=request.getParameter("tbPassLog");
		
		boolean res=DataAccess.validateCustomer(e, p);
		
		if(res)
		{
			try 
			{
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			
			SuccessPage sp=new SuccessPage();
			request.setAttribute("successDetails", sp);
			
		    rd.forward(request,response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}	
		else 
		{
			getLoginPage(request,response);
		}
		
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		long m=Long.parseLong(request.getParameter("tbMobile"));
		String p=request.getParameter("tbPsd");
		String s=request.getParameter("ddlStates");
		
		Customer c=new Customer(n,e,m,p,s);
		
		DataAccess.insertCustomer(c);
		try 
		{
		RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
	    rd.forward(request,response);
		} 
		catch (ServletException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}


	private void getRegestrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
		RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
	    rd.forward(request,response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
		RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
	    rd.forward(request,response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
		RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
		
			rd.forward(request,response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

	
