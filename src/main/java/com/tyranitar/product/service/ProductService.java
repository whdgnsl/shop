package com.tyranitar.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyranitar.board.dto.BoardDTO;
import com.tyranitar.product.dao.ProductDAO;
import com.tyranitar.product.dto.ProductDTO;
@Service("productService")
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	//상품 리스트 불러오기
	public  List<ProductDTO> productList()throws Exception {
		List<ProductDTO> productList = productDAO.productList();
		return productList;
	}
	
	public void productWrite(ProductDTO productDTO)throws Exception {
		productDAO.productWrite(productDTO);
	}

	public int selectProduct_no(String product_name)throws Exception {
		int product_no = productDAO.selectProduct_no(product_name);
		return product_no;
	}

	public void productImageWrite(List<Object> subName, int product_no, Map<String, Object> mainMap)throws Exception {
		productDAO.productImageWrite(subName, product_no, mainMap);
	}

	
	public Map<String, Object> productDetail(int product_no)throws Exception {
		
		Map<String, Object> map = productDAO.productDetail(product_no);
		
		return map;
	}

	

}
