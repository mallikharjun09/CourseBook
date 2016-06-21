package com.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping("/")
    public ModelAndView showIndex(){
    	ModelAndView model=new ModelAndView("index");
    	return model;
    }
    @RequestMapping("/home")
    public ModelAndView showHome(){
    	ModelAndView model=new ModelAndView("index");
    	return model;
    }
    @RequestMapping("/ViewAll")
    public @ResponseBody ModelAndView showBooks(){
    	ModelAndView model=new ModelAndView("ViewAll");
    	return model;
    }
    @RequestMapping("/newbook")
    public ModelAndView showForm(){
    	return new ModelAndView("AddNewBook");
    }
    @RequestMapping("/newuser")
    public ModelAndView showUserForm(){
    	return new ModelAndView("Register");
    }
    @RequestMapping("/storeBook")
    public ModelAndView addBook(HttpServletRequest request,@ModelAttribute("book")Book book){
    	String filename=book.getImg().getOriginalFilename();
    	book.setImage(filename);
    	
    	try{
    		byte[] bytes=new byte[book.getImg().getInputStream().available()];
    		book.getImg().getInputStream().read(bytes);
    		BufferedInputStream buffer=new BufferedInputStream(book.getImg().getInputStream());
    		MultipartFile file=book.getImg();
    		String path=request.getServletContext().getRealPath("/")+"resources/images";
    		File rootPath=new File(path);
    		if(!rootPath.exists())
    			rootPath.mkdirs();
    		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
    		OutputStream os=new FileOutputStream(store);
    		os.write(bytes);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	bs.addBook(book);
    	return new ModelAndView("redirect:ViewAll");
    }
    
    @RequestMapping("upload")
    public ModelAndView upload(){
    	
    	return new ModelAndView("file");
    }
    @RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
    public @ResponseBody String showList(){
    	List blist=bs.getAllBooks();
    	Gson x=new Gson();
    	String json=x.toJson(blist);
    	return json;
    }
    @RequestMapping(value="/show",produces="application/json")
    public @ResponseBody String showSample(){
    	String json=new Gson().toJson("Hai");
    	return json;
    }
    
    @RequestMapping("/takeImg")
    public ModelAndView takeImg(){
    	return new ModelAndView("TakeImage");
    }
    @RequestMapping("/delete")
    public ModelAndView deleteBook(@RequestParam int id){
    	bs.deleteBook(id);
    	ModelAndView model=new ModelAndView("redirect:ViewAll");
    	return model;
    }
    @RequestMapping(value="viewPro",method=RequestMethod.GET)
    public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Book books){
    	Book book=bs.getSingleBook(id);
    	return new ModelAndView("ViewPro","book",book);
    	//return new ModelAndView("ViewPro");
    }
    @RequestMapping(value="editBook",method=RequestMethod.GET)
    public ModelAndView editBook(@RequestParam int id, @ModelAttribute Book books){
    	Book book=bs.getSingleBook(id);
    	return new ModelAndView("EditBook","book",book);
    }
    
    @RequestMapping("/update")
    public ModelAndView updateBook(@RequestParam int id){
    	bs.updateBook(id);
    	return new ModelAndView("redirect:ViewAll");
    }
    
    @ModelAttribute("book")
    public Book createBook(){
    	return new Book();
    }
    @ModelAttribute("books")
    public Book objBook(){
    	return new Book();
    }
    
    @RequestMapping("/storeUser")
    public ModelAndView addUser(@ModelAttribute("user")User user){
    	us.addUser(user);
    	
    	return new ModelAndView("redirect:newuser");
    }

    @RequestMapping(value="/listUser",method=RequestMethod.GET,produces="application/json")
    public @ResponseBody String showUsers(){
    	List blist=us.getAllUsers();
    	Gson x=new Gson();
    	String json=x.toJson(blist);
    	return json;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(@RequestParam int id){
    	us.deleteUser(id);
    	ModelAndView model=new ModelAndView("redirect:ViewAll");
    	return model;
    }

    @RequestMapping(value="editUser",method=RequestMethod.GET)
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User users){
    	User user=us.getSingleUser(id);
    	return new ModelAndView("EditUser","user",user);
    }



    @ModelAttribute("user")
    public User createuser(){
    	return new User();
    }
    @ModelAttribute("users")
    public User objuser(){
    	return new User();
    }
   
}