package com.tyranitar.order.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.product.service.ProductService;

@Controller("orderController")
public class OrderControllerImpl implements OrderController {

	@Autowired
	private ProductService productService;

	@Override
	@RequestMapping("order.do")
	public ModelAndView orderForm(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @RequestParam(value="product_no", required=true)int product_no) throws Exception {
		
		Map<String, Object> map =  productService.productDetail(product_no);
		
		mv.addObject("productInfo", map);
		mv.setViewName("orderWriter");
		return mv;
	}

}
