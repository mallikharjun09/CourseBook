package com.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

@Controller
public class BooksController {

	@Autowired
	private BookService bs;
	@Autowired
	private UserService us;
	@Autowired
	private User_Roles_Service uas;

	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping("/index")
	public ModelAndView showhome() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	/*
	 * @RequestMapping(value="/ulogin",method=RequestMethod.GET) public
	 * ModelAndView showLogin(@RequestParam(required=false)String
	 * authfailed,String logout,String denied,Principal p){ String msg="";
	 * System.out.println(msg); if(authfailed!=null){ msg=
	 * "Invalid username or password"; System.out.println("in auth failed"+msg);
	 * } else if(logout!=null){ msg="User Successfully logged out";
	 * System.out.println("in auth failed logout"+msg); }
	 * 
	 * else if(denied!=null){ msg="Access denied for this user";
	 * System.out.println("in auth failed denii"+msg); }
	 * 
	 * return new ModelAndView("Login","msg",msg); }
	 * 
	 * @RequestMapping("/logout") public ModelAndView
	 * showLogout(HttpServletRequest request,HttpServletResponse response){ try{
	 * Authentication
	 * auth=SecurityContextHolder.getContext().getAuthentication(); new
	 * SecurityContextLogoutHandler().logout(request,response,auth); HttpSession
	 * session=request.getSession(false); if(session!=null){
	 * session.invalidate();
	 * 
	 * } }catch(Exception e){ System.out.println(e); } return new
	 * ModelAndView("index"); }
	 */
	
    @RequestMapping("/cart")
    public ModelAndView showCart()
    {
    	return new ModelAndView("cart");
    }
    @RequestMapping("address")
    public ModelAndView showAddress(){
    	return new ModelAndView("address");
    }
    @RequestMapping("pay")
    public ModelAndView showPayment(){
    	return new ModelAndView("Success");
    }
    
	

	@RequestMapping("/home")
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping("/ViewAll")
	public @ResponseBody ModelAndView showBooks() {
		ModelAndView model = new ModelAndView("ViewAll");
		return model;
	}

	@RequestMapping("/newbook")
	public ModelAndView showForm() {
		return new ModelAndView("AddNewBook");
	}

	@RequestMapping("/newuser")
	public ModelAndView showUserForm() {
		return new ModelAndView("Register");
	}

	@RequestMapping("/storeBook")
	public String addBook(HttpServletRequest request, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "AddNewBook";
		}
		String filename = book.getImg().getOriginalFilename();
		book.setImage(filename);

		try {
			byte[] bytes = new byte[book.getImg().getInputStream().available()];
			book.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(book.getImg().getInputStream());
			MultipartFile file = book.getImg();
			String path = request.getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			OutputStream os = new FileOutputStream(store);
			System.out.println(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		bs.addBook(book);
		return "ViewAll";
	}

	@RequestMapping("upload")
	public ModelAndView upload() {

		return new ModelAndView("file");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList() {
		List blist = bs.getAllBooks();
		Gson x = new Gson();
		String json = x.toJson(blist);
		return json;
	}
    @RequestMapping("/adminlogin")
    public ModelAndView showLog(){
    	   return new ModelAndView("adminlogin");
    }
	@RequestMapping(value = "/show", produces = "application/json")
	public @ResponseBody String showSample() {
		String json = new Gson().toJson("Hai");
		return json;
	}

	@RequestMapping("/takeImg")
	public ModelAndView takeImg() {
		return new ModelAndView("TakeImage");
	}

	@RequestMapping("/delete")
	public ModelAndView deleteBook(@RequestParam int id) {
		bs.deleteBook(id);
		ModelAndView model = new ModelAndView("redirect:ViewAll");
		return model;
	}

	@RequestMapping(value = "viewPro", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Book books) {
		Book book = bs.getSingleBook(id);
		return new ModelAndView("ViewPro", "book", book);
		// return new ModelAndView("ViewPro");
	}

	@RequestMapping(value = "editBook", method = RequestMethod.GET)
	public ModelAndView editBook(@RequestParam int id, @ModelAttribute Book books) {
		Book book = bs.getSingleBook(id);
		return new ModelAndView("EditBook", "book", book);
	}

	@RequestMapping("/update")
	public ModelAndView updateBook(@RequestParam int id) {
		ModelAndView obj = new ModelAndView("update");
		List list = bs.getAllBooks();
		return new ModelAndView("redirect:ViewAll");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET ) 
	public String login(Model model) {
		return "public/login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	    return "redirect:/index";
	}	
	
	@RequestMapping("/register")
    public String addUser(@Valid @ModelAttribute("user")User user,BindingResult result){
    	if(result.hasErrors()){
    		return "Register";
    	}
    	us.addUser(user);
    	User_Roles ua=new User_Roles();
    	ua.setRole("ROLE_USER");
    	return "index";
    }

	
	@RequestMapping("/accessdenied") 
	public String error403() {		
		return "403Page";
	}

	@RequestMapping("/loginError") 
	public String loginError(Model model) {
		model.addAttribute("error", "Invalid Login Details!");		
		return "adminlogin";		
	}
	
	

	@ModelAttribute("book")
	public Book createBook() {
		return new Book();
	}

	@ModelAttribute("books")
	public Book objBook() {
		return new Book();
	}

	
	@RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showUsers() {
		List blist = us.getAllUsers();
		Gson x = new Gson();
		String json = x.toJson(blist);
		return json;
	}

	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		us.deleteUser(id);
		ModelAndView model = new ModelAndView("redirect:ViewAll");
		return model;
	}

	@RequestMapping(value = "editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam int id, @ModelAttribute User users) {
		User user = us.getSingleUser(id);
		return new ModelAndView("EditUser", "user", user);
	}

	@ModelAttribute("user")
	public User createuser() {
		return new User();
	}

	@ModelAttribute("users")
	public User objuser() {
		return new User();
	}

}