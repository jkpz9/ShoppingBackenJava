package org.awakening.javashopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	// 1. The page not found
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException ()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "404 Error Page");
		mv.addObject("errorTitle", "The page is not constructed :(");
		mv.addObject("errorDescription", "The page you are looking for is not available now !");
		return mv;
	}
	
	// 2. The Product not found 
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException ()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "product Unvailable");
		mv.addObject("errorTitle", "The product is not available :(");
		mv.addObject("errorDescription", "The product you are looking for is not available right now !");
		return mv;
	}
	
	// 3. Passed Wrong Paramaters
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException (Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "error");
		
		// Only for debugging Aplication
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		
		mv.addObject("errorTitle", "Contact your Administrator!!");
		mv.addObject("errorDescription", sw.toString());
		return mv;
	}
	
	
	
	
}
