package com.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Footwear;
import com.service.SportyShoesService;

@Controller
@RequestMapping("/mainapp")
public class MainApp {
	
	
	@Autowired(required=true)
	private SportyShoesService service;
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}
	
	@GetMapping("/sportyHome")
	public String sportyShoesHome(ModelMap model) {
		model.put("footwears", service.fetchFootwearProduct());
		return "sportyHome";
	}
	
	@GetMapping("/adminLogin")
	public String sportyShoesAdminLogin() {
		return "adminLogin";
	}
	
	@PostMapping("/adminLogin")
	public String sportyShoesAdminLoginValidation(@RequestParam("adminName") String name, 
				@RequestParam("adminPassword") String pass) {
		if(service.loginValidate(name, pass)) {
			return "redirect:/mainapp/adminHome";
		}
		return "adminLoginFailed";
	}
	
	@GetMapping("/adminHome")
	public String getAdminHomePage() {
		return "adminHome";
	}
	
	@GetMapping("/addProduct")
	public String manageAdminProduct() {
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String processProductDetails(@RequestParam("prodId") String productId,
			@RequestParam("productname") String productName,
			@RequestParam("brandname") String brandName,
			@RequestParam("prodprice") String productPrice,
			@RequestParam("prodtype") String productType,
			@RequestParam("imageurl") String imageUrl,
			@RequestParam("prodfdesc") String productDesc) {
		
		service.addProductService(Integer.parseInt(productId), productName, brandName, productPrice, productType, imageUrl, productDesc);
		return "redirect:/mainapp/addProduct";
		
	}
	
	@GetMapping("/manageProducts")
	public String manageAdminProducts(ModelMap model) {
		model.put("footwears", service.fetchFootwearProduct());
		return "manageProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id) {
		service.deleteProduct(id);
		return "redirect:/mainapp/manageProducts";
	}
	
	@GetMapping("/userSignup")
	public String userSignup() {
		return "userSignup";
	}
	
	@PostMapping("/userSignup")
	public String getNewUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("pass") String password) {
		service.putUserRecords(firstName, lastName, email, password);
		return "signupSuccess";
	}
	
	@GetMapping("/userDetails")
	public String adminViewUserDetails(ModelMap model) {
		model.put("allUsers", service.fetchAllUsers());
		return "adminViewUsers";
	}
	
	@PostMapping("/userDetails")
	public String adminViewSearchUser(ModelMap model, @RequestParam("username") String userName) {
		model.put("searchedUser", service.searchUsers(userName));
		return "adminSearchUser";
	}
	
	@GetMapping("/updateProduct")
	public String getProductById(@RequestParam int id,ModelMap model) {
		Footwear footwear = service.fetchFootwearObject(id);
		model.put("footwearObj", footwear);
		return "adminUpdateProduct";
	}
	
	
	@PostMapping("/updateProduct")
	public String updateProductById(@RequestParam int id,
			@RequestParam("prodName") String productName,
			@RequestParam("prodBrand") String brandName,
			@RequestParam("prodPrice") String productPrice,
			@RequestParam("prodType") String productType,
			@RequestParam("prodImgUrl") String imageUrl,
			@RequestParam("prodDesc") String productDesc) {
		System.out.println("inside vivek updateProduct");
		service.updateFootwearProduct(id, productName, brandName, productPrice, productType, imageUrl, productDesc);
		return "redirect:/mainapp/manageProducts";
	}
	
	@GetMapping("/buyProduct")
	public String buyProduct(@RequestParam int id) {
		service.buyProduct(id);
		return "redirect:/mainapp/sportyHome";
	}
	
	@GetMapping("/purchaseReport")
	public String purchaseReport(ModelMap model) {
		model.put("footwears", service.fetchProductsPurchased());
		return "purchaseReport";
	}
}
