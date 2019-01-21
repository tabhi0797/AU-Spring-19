//package com.accolite.app.config;
//
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.accolite.app.dao.UserDao;
//import com.accolite.app.service.UserService;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.accolite.app")
//public class WebConfig 
//{
//
//	@Bean
//	public DriverManagerDataSource getDataSource() {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/test");
//		ds.setUsername("root");
//		ds.setPassword("root");
//
//		return ds;
//
//	}
//	
////	@Bean
////	public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource)
////	{
////		JdbcTemplate jt = new JdbcTemplate();
////		jt.setDataSource(dataSource);
////		
////		return jt;
////	}
////	
//	@Bean
//	public UserDao getUserDao() {
//		return new UserDao();
//	}
//	
//	@Bean
//	public UserService getUserService()
//	{
//		return new UserService();
//	}
//}
