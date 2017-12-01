package com.demo.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONObject;

import com.demo.model.Employee;
import com.demo.servlet.AjaxServlet;
import com.demo.servlet.IAjaxInterfaceAction;

import com.demo.util.JSONUtility;


public class RegistrationAction implements IAjaxInterfaceAction{

	private static enum OPERATION_TYPES {
		CHECK_EMAIL_EXISTS,REGISTER,VIEW_DETAILS;
	}
	
	@Override
	public void performAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("OPERATION");
		switch (OPERATION_TYPES.valueOf(operation)) {
		case CHECK_EMAIL_EXISTS:
			performEmailIdExistsCheckAction(request, response);
			break;
		case REGISTER:
			performRegisterAction(request, response);
			break;
		case VIEW_DETAILS:
			performViewDetailsAction(request, response);
			break;
			
		default:
			System.out.println("Default ");
		}
		
	}

	private void performViewDetailsAction(HttpServletRequest request, HttpServletResponse response) {
		Employee employee = new Employee();
		employee.setFirstName("sdfg");
		employee.setLastName("3465");
		employee.setEmail("qqq@qq.com");
		JSONObject jsonObject = null;
		JSONUtility jsonUtility = new JSONUtility();
		try{
			jsonObject = new JSONObject();
			jsonObject.put("employee", jsonUtility.getJSONFromObject(employee));
		}catch(Exception e){
			e.printStackTrace();
		}
		AjaxServlet.includeJSONResponse(jsonObject.toString(), request, response);
	}

	private void performRegisterAction(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("EMAIL_ID");
		String firstName = request.getParameter("FIRST_NAME");
		String lastName = request.getParameter("LAST_NAME");
		System.out.println("Email : "+email);
		System.out.println("First Name : "+firstName);
		System.out.println("Last Name : "+lastName);
//		===============================================
		JSONObject jsonObject = null;
		try{
			jsonObject = new JSONObject();
			jsonObject.put("STATUS", true);
		}catch(Exception e){
			e.printStackTrace();
		}
		AjaxServlet.includeJSONResponse(jsonObject.toString(), request, response);
	}

	private void performEmailIdExistsCheckAction(HttpServletRequest request,HttpServletResponse response) {
		String email = request.getParameter("EMAIL_ID");
		JSONObject jsonObject = null;
		try{
			jsonObject = new JSONObject();
			String ExistingEmail = "a@a.com";
			if(ExistingEmail.equals(email) && !email.isEmpty() && null != email){
				jsonObject.put("STATUS", true);
			} else {
				jsonObject.put("STATUS", false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		AjaxServlet.includeJSONResponse(jsonObject.toString(), request, response);
	}

}
