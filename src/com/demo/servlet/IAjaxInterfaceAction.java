package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAjaxInterfaceAction {
	public void performAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
