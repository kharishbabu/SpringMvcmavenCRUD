package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Bean;
import com.bean.Changebean;
import com.model.Model;
import com.service.Serviceinterface;


@Controller

public class Regcontroller {
	@Autowired

 Serviceinterface regservice;
	  @RequestMapping(value = { "/go"}, method = RequestMethod.GET)
	  

	  public String homePage(Model model) {
		  System.out.println("controlllllllerrrrrrrrrrrrr");
	        return "home";
	    }
	  @RequestMapping(value="/hi",method=RequestMethod.GET)
	  public String hi() 
	  {
		  System.out.println("enter hello");
	  	return "hi";
	  }
	@RequestMapping("/home")

	public ModelAndView home()
	{
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	
		return new ModelAndView("home");

		}
		@RequestMapping("/home1")

		public ModelAndView home1()
		{
		System.out.println("haiiiiiiiiiiiiiiiiiii");
		
			return new ModelAndView("home1");

			}
	@RequestMapping("/contact")

	public ModelAndView contact(@ModelAttribute() Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) {
		

		
			/*Model model=new Model();
			List acc=regservice.getEmaillll();
			for (Iterator iterator = acc.iterator(); iterator.hasNext();) {
				model = (Model) iterator.next();
				
			}
			String aff=model.getFn();
			System.out.println("addressss"+aff);
	
			req.getSession().setAttribute("address",aff);
*/
			
			return new ModelAndView("contact");


		}
	@RequestMapping("/about")

	public ModelAndView about()
	{
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	
		return new ModelAndView("about");

		}
	@RequestMapping("/reg")

	public ModelAndView reg(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) {
		System.out.println("haiiiiiiiiiiiiiiiiiii");
	
		return new ModelAndView("register");

		}
	@RequestMapping("/log")

	public ModelAndView logg(@ModelAttribute("command") Bean bean,HttpServletRequest req,HttpServletResponse res) {
		System.out.println("haiiiiiiiiiiiiiiiiiii");
	
		return new ModelAndView("Login");

		}
	@RequestMapping("/cancel")

	public ModelAndView cancel(@ModelAttribute() Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) {
		System.out.println("haiiiiiiiiiiiiiiiiiii");
	
		return new ModelAndView("index1");

		}
@RequestMapping(value="/regss",method=RequestMethod.POST)

public ModelAndView register(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) {
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	Model model=new Model();
	BeanUtils.copyProperties(bean, model);
	System.out.println(bean.getFirstname());
	System.out.println(bean.getMiddlename());

	/*model.setMn(bean.getMn());
	model.setFn(bean.getFn());
	
	System.out.println("addddddddddddddddd");*/
	List l=regservice.listtttt();
	System.out.println("list sizeeeeeeeeeeeeeeeee"+l.size());
	if(l.size()==0)
	{
	model.setType("Admin");
	model.setStatus("Yes");

	}
	else{
	model.setType("User");
	model.setStatus("Yes");
	}
	regservice.adgfgfd(model);
	return new ModelAndView("success");

	}
@RequestMapping("/logs")

public ModelAndView log(@ModelAttribute("command") Bean bean,HttpServletRequest req,HttpServletResponse res) {
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	Model model=new Model();
	
	String un=bean.getUsername();
	String pwd=bean.getPassword();
	System.out.println("userrrrrrrrr"+un);
	System.out.println("passssssss"+pwd);

	/*model.setMn(bean.getMn());
	model.setFn(bean.getFn());
	
	System.out.println("addddddddddddddddd");*/
	List<Model> l=regservice.fetchdetails(un,pwd);
	if(l.size()>0)
	{
		req.getSession().setAttribute("uname", un);
	
		return new ModelAndView("logsuccess");
	}
	return new ModelAndView("logfail");

	}


@RequestMapping("/viewdetails")

public ModelAndView viewdetails(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) {
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	Model model=new Model();
	List<?> li=regservice.addlist();
	for (Iterator iterator = li.iterator(); iterator.hasNext();) {
		model = (Model) iterator.next();
		
	}
	req.getSession().setAttribute("adminlist",li);
	return new ModelAndView("viewdetailsdisplay");
	
}

@RequestMapping("/adminlist")

public ModelAndView adminlist(@ModelAttribute() Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {
	System.out.println("haiiiiiiiiiiiiiiiiiii");
	System.out.println("haiiiiiiiiiiiiiiiii");
	PrintWriter out=null;
	out=res.getWriter();

	List<?> li=regservice.addlist();
req.getSession().setAttribute("li",li);
	JsonConfig jsonConfig = new JsonConfig();
	//System.out.println("json1"+jsonConfig);
	jsonConfig.setExcludes(new String[]{"li"});
	jsonConfig.setIgnoreDefaultExcludes(false);
	jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

	JSONArray array = JSONArray.fromObject(li,jsonConfig);
	System.out.println("array"+array);
	out.print(array);
	out.flush();
	out.close();
	return new ModelAndView("viewdetails");


			}

@RequestMapping("/displayedit")

public ModelAndView displayedit(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {
Model model=new Model();
String un=req.getParameter("cbox");
System.out.println("unnnnnnnnnnnncboxxxxxxx"+un);
List l=regservice.sdgdgdg(un);
for (Iterator iterator = l.iterator(); iterator.hasNext();) {
	model = (Model) iterator.next();
	
}
BeanUtils.copyProperties(model,bean);


	   return new ModelAndView("editdetails");
}


@RequestMapping("/editsuc")

public ModelAndView editsuc(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {
Model model=new Model();
String un=req.getParameter("cbox");
System.out.println("unnnnnnnnnnnncboxxxxxxx"+un);
BeanUtils.copyProperties(bean,model);
regservice.updatee(model);
return new ModelAndView("editsuccess");
}
@RequestMapping("/del")

public ModelAndView del(@ModelAttribute("command") Bean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {
Model model=new Model();
String un1=req.getParameter("cbox");


regservice.dell(un1);
return new ModelAndView("delsuccess");


}


@RequestMapping("/change")

public ModelAndView change(@ModelAttribute("command") Changebean bean,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {
	
	
	
	return new ModelAndView("changepassword");

}


@RequestMapping("/changss")

public ModelAndView changss(@ModelAttribute("command") Changebean bean1,BindingResult result,HttpServletRequest req,HttpServletResponse res) throws IOException {

Model model=new Model();

String oldp=bean1.getOldpassword();
String pwd1=bean1.getPassword();
String pwd2=bean1.getConfirmpassword();
String uname=(String)req.getSession().getAttribute("uname");
List<?> liuse=regservice.getPassworduse(oldp,uname);
	 System.out.println("password list"+liuse.size());
   if(liuse.size()==0)
   {
  	 
  	 result.rejectValue("oldpassword", "", "Invalid Old Password");
   return new ModelAndView("changepassword");	
   }
	String pwd=(String)req.getSession().getAttribute("password");
	/*if(!oldp.matches(pwd))
	{
	result.rejectValue("oldpassword","","Invalid Old Password");	
	return new ModelAndView("changepwduser");
	}*/
	
   
/*	String una=(String)req.getSession().getAttribute("uname");
	String ad="Yes";
	List lii=regservice.edit(una,ad);
	Model model=new Model();
	for (Iterator iterator = lii.iterator(); iterator.hasNext();) {
		model = (Model) iterator.next();
		
	}
	String ema=model.getEmail();*/
		model.setConfirmpassword(pwd2);
				model.setPassword(pwd1);
				System.out.println("passsssssss"+pwd1);
				System.out.println("passsssssss"+pwd2);

				
				regservice.upda(pwd1,pwd2,uname);
				return new ModelAndView("changesuccess");
}
}
