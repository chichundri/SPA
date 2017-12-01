package com.demo.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AjaxServlet() {
        super();
    }

    private static enum AllowedActions {
		RegistrationAction;
		private static AllowedActions[] actionOperationArray;
		static {
			actionOperationArray = AllowedActions.values();
		}
		public static boolean contains(String ao) {
			for (int i = 0, size = actionOperationArray.length; i < size; i++) {
				if (actionOperationArray[i].name().equals(ao)) {
					return true;
				}
			}
			return false;
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("ACTION");
		String operation = request.getParameter("OPERATION");
		
		if(AllowedActions.contains(action)){
			Class<?> object = null;
			try {
				object = Class.forName("com.demo.action." + action);
				IAjaxInterfaceAction actionObject = (IAjaxInterfaceAction) object.newInstance();
				actionObject.performAction(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(action == null && operation == null){
			response.sendRedirect("/Demo/temp.jsp");
		}
	}

	public static void includeJSONResponse(String jsonString, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(jsonString);
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
