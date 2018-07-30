package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;









import com.dao.Daointerface;
import com.model.Model;

public class Serviceclass implements Serviceinterface{

	@Autowired

Daointerface regdao;

	public void adgfgfd(Model model) {
		// TODO Auto-generated method stub
		regdao.adgfgfd(model);
	}


	public  List<Model> fetchdetails(String un, String pwd) {
	
		return regdao.fetchdetails(un,pwd);
	}


	public List<?> addlist() {
		// TODO Auto-generated method stub
		return regdao.addlist();
	}


	public List sdgdgdg(String un) {
		// TODO Auto-generated method stub
		return regdao.sdgdgdg(un);
	}


	public void updatee(Model model) {
		// TODO Auto-generated method stub
		regdao.updatee(model);
	}


	public void dell(String un1) {
		// TODO Auto-generated method stub
		regdao.dell(un1);
	}


	public List<?> getPassworduse(String oldp, String uname) {
		// TODO Auto-generated method stub
		return regdao.getPassworduse(oldp,uname);
	}


	public List edit(String una, String ad) {
		// TODO Auto-generated method stub
		return regdao.edit(una,ad);
	}




	public void upda(String pwd1, String pwd2, String uname) {
		// TODO Auto-generated method stub
		 regdao.upda(pwd1,pwd2,uname);
	}


	public List listtttt() {
		// TODO Auto-generated method stub
		return regdao.listtttt();
	}

}
