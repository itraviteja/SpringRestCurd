package com.durga.javaconfigurations;


import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.durga.dao.impl","com.durga.service.impl","com.durga.controller"})
public class SpringRestDispatcherServlet extends WebMvcConfigurerAdapter 
{
	
	 @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

	      Properties props = new Properties();
	      // Setting JDBC properties
	      props.put(Environment.DRIVER,"oracle.jdbc.driver.OracleDriver");
	      props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
	      props.put(Environment.USER, "system");
	      props.put(Environment.PASS, "hadoop");

	      // Setting Hibernate properties
	      props.put(Environment.SHOW_SQL, "true");
	      /*props.put(Environment.HBM2DDL_AUTO,"create");*/
	      props.put(Environment.FORMAT_SQL,"true");
	      // Setting C3P0 properties
	     

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setPackagesToScan("com.durga.model");

	      return factoryBean;
	   }
	  
	   
}
