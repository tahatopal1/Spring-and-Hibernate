package com.project.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.project.entity.Sample;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.project")
@PropertySource("classpath:datasource.properties")
public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource dataSource() {
		
		// Create connection pool
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// Set the JDBC driver
		try {
			dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// Logging URL and the user
		logger.info("jdbc.url: " + environment.getProperty("jdbc.url"));
		logger.info("jdbc.user: " + environment.getProperty("jdbc.user"));
		
		// Set database connection properties
		dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		dataSource.setUser(environment.getProperty("jdbc.user"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		
		// Set connection pool properties
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return dataSource;
		
	}
	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		return properties;
	}
	
	// Helper method for reading the properties and convert to int
	private int getIntProperty(String prop) {
		
		String propVal = environment.getProperty(prop);
		
		// Convertion to int
		int propValInt = Integer.parseInt(propVal);
		
		return propValInt;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		// Create the session factory
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// Set the properties
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// Set up transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}

	
}
