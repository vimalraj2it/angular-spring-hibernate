package com.cracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cracker.dao.SupplierDao;
import com.cracker.domain.OrderDetails;
import com.cracker.domain.Products;
import com.cracker.domain.Supplier;
import com.cracker.domain.UserCrk;
import com.cracker.service.OrderDetailsService;
import com.cracker.service.ProductsService;
import com.cracker.service.SupplierService;
import com.cracker.service.UserService;
import com.cracker.util.ResponseJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mail.service.Constant;
import com.mail.service.MailService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class DaoController {
	
	
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="productsService")
	private ProductsService productsService;
	
	@Autowired(required=true)
	@Qualifier(value="supplierService")
	private SupplierService supplierService;
	
	@Autowired(required=true)
	@Qualifier(value="orderDetailsService")
	private OrderDetailsService orderDetailsService;
	
	
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	
	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	
	
	@RequestMapping(value = "/header.do", method = RequestMethod.POST)
	public void headerJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		headerMap.put("label", "Order Items");
		headerMap.put("ctrl","orderItemCtrl");
		list.add(headerMap);
		
		headerMap = new HashMap<String, String>();
		headerMap.put("label", "Confirm Oder");
		headerMap.put("ctrl","confirmOrderCtrl");
		list.add(headerMap);
		
		
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(new Gson().toJson(list));
		pw.flush();
		pw.close();
		
	}
	
	@RequestMapping(value = "/supplier.do", method = RequestMethod.POST)
	public void productDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Supplier> list = supplierService.list();
		String resultMap = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(list);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(new Gson().toJson(resultMap));
		pw.flush();
		pw.close();
		
	}
	
	@RequestMapping(value = "/order.do", method = RequestMethod.POST)
	public void orderDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HashMap<String,String> resultMap = new HashMap<String, String>();
		
		
		String line = request.getReader().readLine();
		System.out.println(line);
		
		Gson gson = new Gson();
		ResponseJson element = gson.fromJson (line, ResponseJson.class);
		
		System.out.println();
	
		String userId = null;
		String order = null;
		ArrayList<OrderDetails> list = new ArrayList<OrderDetails>();
	
		try {
			UserCrk user = element.getUser();
			userService.save(user);
			 user = userService.get(user.getUser_name());
			
			
			
			setObject(list,element.getSuppliers());
			
			
			orderDetailsService.save(list, user);
			
			MailService mail = new MailService();
			
			String status = mail.sentMail(user.getEmail(),user.getUser_name());
			if(status.equals(Constant.sent))
				resultMap.put("msg", "Order success. Please Check your email - "+user.getEmail());
			else if(status.equals(Constant.error))
				resultMap.put("msg", "Order success. unable deliver mail.");
				
			
			
		} catch (Exception e) {
			resultMap.put("msg", "Order Failed");
			e.printStackTrace();
		}
		
				
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(new Gson().toJson(resultMap));
		pw.flush();
		
	}
	
	
	private void setObject(ArrayList<OrderDetails> list, ArrayList<Supplier> suppliers){
		for (Supplier supplier : suppliers) {
		
			
			
			for (Products product : supplier.getProductSet()) {
				OrderDetails order = new OrderDetails(); 
				order.setSupplierId(supplier.getSupp_code()); 
				order.setProduct(product.getProd_name());
				order.setQuantity(product.getQuan());
				order.setOrder_on(new Date());
				order.setAmt(product.getProd_price());
				order.setTotal_amt(product.getTot());
				list.add(order);
			}
			
			
		}
		
		System.out.println(new Gson().toJson(list));
		
	}  
			/*public static void saveUser(UserCrk user){
				UserService service = new UserService();
				try {
					service.saveUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public static void deleteUser(UserCrk user){
				UserService service = new UserService();
				try {
					service.deleteUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public static ArrayList<Supplier> getSupplierList(){
				SupplierService vService  = new SupplierService();
				
				return vService.getSupplierList();
				
			}*/
			
			public static void main(String[] args) {
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
				Products product= new Products();
				product.setBanner("banner1");
				product.setProd_code("123");
				product.setProd_name("dfsdfsd");
				product.setProd_price(55);
				
				
				Supplier supplier = new Supplier();
				supplier.setSupp_code("sony");
				supplier.setSupp_name("sony Fireworks");
				
				Set<Products> set = new HashSet<Products>();
				set.add(product);
				product= new Products();
				product.setBanner("banner2");
				product.setProd_code("122");
				product.setProd_name("dfs2dfsd");
				product.setProd_price(55);
				set.add(product);
				 
				supplier.setProductSet(set);
				product.setSupplierItem(supplier);
				SupplierDao dao = context.getBean(SupplierDao.class);
				dao.save(supplier);
				
				ArrayList<Supplier> list = dao.list();
				System.out.println("List : "+list.get(0).getProductSet().size());
				
				/*ProductsDao dao = context.getBean(ProductsDao.class);
				dao.save(product);*/
				
				
			}
}
