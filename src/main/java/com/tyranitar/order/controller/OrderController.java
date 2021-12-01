package com.tyranitar.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface OrderController {
	
	public ModelAndView orderForm(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @RequestParam(value="product_no", required=true)int product_no)throws Exception;
	
}
