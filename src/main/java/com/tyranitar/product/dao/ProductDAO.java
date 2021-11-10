package com.tyranitar.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyranitar.product.dto.ProductDTO;
@Repository("productDAO")
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductDTO> productList()throws Exception {
		List<ProductDTO> productList = sqlSession.selectList("product.productList");
		return productList;
	}
	
	public void productWrite(ProductDTO productDTO)throws Exception {
		System.out.println("productDTO = "+productDTO);
		sqlSession.insert("product.productWrite",productDTO);
		
	}
	public int selectProduct_no(String product_name)throws Exception {
		System.out.println("product_name = "+product_name);
		int product_no = sqlSession.selectOne("product.selectProductNO",product_name);
		return product_no;
	}
	public void productImageWrite(List<Object> subName, int product_no, Map<String, Object> mainMap)throws Exception {
		System.out.println("들어옴?");
		System.out.println("mainMap = "+mainMap);
		sqlSession.insert("product.productMainImageWrite", mainMap);
		
		Map<String,Object> subMap = new HashMap<String,Object>();
		
		subMap.put("product_no", product_no);
		for(int i=0; i<subName.size(); i++) {
			subMap.put("subName", subName.get(i));
			System.out.println("subMap"+subMap);
			sqlSession.insert("product.productSubImageWrite",subMap);
		}
	}

	public Map<String, Object> productDetail(int product_no)throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ProductDTO productDTO = sqlSession.selectOne("product.productDetail", product_no);
		map.put("productDTO", productDTO);
		
		List<ProductDTO> productDTOImage = sqlSession.selectList("product.productDetailImage", product_no);
		map.put("productDTOImage", productDTOImage);
		return map;
	}
	

}
