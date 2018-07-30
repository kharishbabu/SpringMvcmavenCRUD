/*package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import org.springframework.jdbc.core.RowMapper;

import com.model.Model;


public class Daoimplementation implements Daointerface{
	@Autowired
	private SessionFactory sessionFactory;
	DataSource dataSource ;
	
    public DataSource getDataSource()

    {

        return this.dataSource;

    }

 

    public void setDataSource(DataSource dataSource)

    {

        this.dataSource = dataSource;

    }

  
	public void add(Model model) {
		try{
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(model);	
		}catch(Exception e){}
	}


	public void adgfgfd(Model model) {
	
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().save(model);	
			System.out.println("successsaveeeeeeeee");
		
		}
	
	  
	 @Autowired  
	 DataSource dataSource;  
	  
	 public void adgfgfd(Model model) {  
	  
	  String sql = "INSERT INTO model "  
	    + "(fn,mn,un,pwd) VALUES (?,?,?,?)";  
	  
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	  
	  jdbcTemplate.update(  
	    sql,  
	    new Object[] { model.getFn(), model.getMn(),model.getUn(),model.getPwd() });  
	  
	 }

	public List<Model> fetchdetails(String un,String pwd) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM Model where un='"+un+"' and  pwd='"+pwd+"'";
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		    List<Model> listContact = jdbcTemplate.query(sql, new RowMapper<Model>() {
		 
		      
		        public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Model aContact = new Model();
		 
		            aContact.setId(rs.getString("id"));
		            aContact.setFn(rs.getString("fn"));
		            aContact.setMn(rs.getString("mn"));
		            aContact.setUn(rs.getString("un"));
		            aContact.setPwd(rs.getString("pwd"));
		 
		            return aContact;
		        }
		 
		    });
		 
		    return listContact;
		}
	

}
*/





package com.dao;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

	import javax.sql.DataSource;

	import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Model;




	@Repository
	@Transactional

	public class Daoimplementation implements Daointerface {
		@Autowired
		private SessionFactory sessionFactory;
	/*	private Session session;*/
		/*private Session session;*/
		
		DataSource dataSource ;
		
		    public DataSource getDataSource()
		
		    {
		
		        return this.dataSource;
		
		    }
		
		 
		
		    public void setDataSource(DataSource dataSource)
		
		    {
		
		        this.dataSource = dataSource;
		
		    }



			public void adgfgfd(Model model) {
				// TODO Auto-generated method stub
				 sessionFactory.getCurrentSession().save(model);
			}



			public List<Model> fetchdetails(String un, String pwd) {
				String tttt="Yes";
				List liu=sessionFactory.getCurrentSession().createQuery("from Model where username='"+un+"' and password='"+pwd+"' and status='"+tttt+"'").list();
				
				return liu;
				// TODO Auto-generated method stub
				
			}



			public List<?> addlist() {
				// TODO Auto-generated method stub
				String st="Yes";
			String h="User";
				// TODO Auto-generated method stub
				List<?> li=sessionFactory.getCurrentSession().createQuery("from Model where status='"+st+"' and type='"+h+"'").list();
				return li;
			}



			public List sdgdgdg(String un) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				List<?> li=sessionFactory.getCurrentSession().createQuery("from Model where username='"+un+"'").list();
				return li;
			}



			public void updatee(Model model) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().update(model);
			}



			public void dell(String un1) {
				String s="No";
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().createQuery("update Model set status='"+s+"' where username='"+un1+"'").executeUpdate();	
			}



			public List<?> getPassworduse(String oldp, String uname) {
			
				List<?> liuse=sessionFactory.getCurrentSession().createQuery("from Model where password='"+oldp+"'  and username='"+uname+"'").list();
				// TODO Auto-generated method stub
				return liuse;
			}



			public List edit(String una, String ad) {
				List lii=sessionFactory.getCurrentSession().createQuery("from Model where username='"+una+"' and status='"+ad+"'").list();
				
				return lii;
	}



			public void upda(String pwd1, String pwd2, String uname) {
				// TODO Auto-generated method stub
				sessionFactory.getCurrentSession().createQuery("update Model set password='"+pwd1+"', confirmpassword='"+pwd2+"' where username='"+uname+"'").executeUpdate();	
			}



			public List listtttt() {
				String aa="Yes";
List lii=sessionFactory.getCurrentSession().createQuery("from Model where status='"+aa+"'").list();
				
				return lii;
	}
	}
			
		