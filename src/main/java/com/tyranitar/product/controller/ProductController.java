package com.tyranitar.product.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tyranitar.member.dto.MemberDTO;
import com.tyranitar.product.dto.ProductDTO;
import com.tyranitar.product.service.ProductService;


@Controller("productController")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//이미지 저장소 - 파일 저장 위치
	private static final String CURR_IMAGE_REPO_PATH = "C:\\tyanitar\\imgFile";
	
	//상품 상세보기
	@RequestMapping("productDetail.do")
	public ModelAndView productDetail(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, @RequestParam(value="product_no", required=true)int product_no)throws Exception {
		
		Map<String, Object> map = productService.productDetail(product_no);
		mv.addObject("map",map);
		mv.setViewName("productDetail");
		
		return mv;
	}
	
	//상품 작성 
	@RequestMapping("productWriteSuccess.do")
	public ModelAndView productWrite(HttpServletRequest request, HttpServletResponse response, 
			ModelAndView mv, 
			@RequestParam("MainFile") MultipartFile MainFile,
			@RequestParam("SubFile") MultipartFile[] SubFile,
			@ModelAttribute("productInfo") ProductDTO productDTO
			) throws Exception {
		
		System.out.println(productDTO);
		productService.productWrite(productDTO);
		
		int product_no = productService.selectProduct_no(productDTO.getProduct_name());
		
		String path = CURR_IMAGE_REPO_PATH+"\\"+product_no;
		File Folder = new File(path);
		
		if (!Folder.exists()) {
			Folder.mkdir(); //폴더 생성합니다.
		    System.out.println("폴더가 생성되었습니다.");
        } 
		else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		Map<String,Object> mainMap = new HashMap<String,Object>();
		
		String mExt = MainFile.getOriginalFilename().substring(MainFile.getOriginalFilename().lastIndexOf("."));
		String mName = productDTO.getProduct_name()+"_"+"main"+mExt;
		System.out.println("mName = "+mName);
		if(!MainFile.getOriginalFilename().isEmpty()) {
			MainFile.transferTo(new File(path, mName));
		}

		mainMap.put("mName", mName);
		mainMap.put("product_no", product_no);
		
		int i=1;
		List<Object> subName = new ArrayList<Object>();
		System.out.println("subName = "+ subName);
		for(MultipartFile img : SubFile) {
			String sExt = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));
			String sName = productDTO.getProduct_name()+"_"+"sub"+i+sExt;
			
			subName.add(sName);
			
			if(!img.getOriginalFilename().isEmpty()) {
				img.transferTo(new File(path, sName));
			}
			i++;
		}
		
		System.out.println("subName = "+subName);
		System.out.println("product_no = "+product_no);
		System.out.println("mainMap = "+mainMap);
		productService.productImageWrite(subName,product_no,mainMap);
		
		mv.setViewName("redirect:/product.do");
		
		return mv;
		
	}
	
	//상품 작성 폼
	@RequestMapping("productWrite.do")
	public String productWrite(HttpServletRequest request, HttpServletResponse response
			) throws Exception{

	return "productWrite";
	}
	
	//상품 리스트
	@RequestMapping("product.do")
	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception{
		List<ProductDTO> productList = productService.productList();
		mv.addObject("productList", productList);
		mv.setViewName("productList");
		
		HttpSession session = request.getSession();
		MemberDTO memberDto =(MemberDTO)session.getAttribute("MDTO");
		Boolean isLogin = (Boolean)session.getAttribute("isLogin");
		mv.addObject("memberDTO", memberDto);
		mv.addObject("isLogin", isLogin);
		System.out.println(mv);
		return mv;
	}
	
}
