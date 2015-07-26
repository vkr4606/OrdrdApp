package com.ordrd.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/ordrd_app";
	private static final String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_MODEL_PACKAGE = "com.ordrd.model";

	@Bean
	public EntityManagerFactory entityManagerFactory() throws IOException {
		LocalContainerEntityManagerFactoryBean localSessionFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());

		localSessionFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.connection.pool_size", "10");
		localSessionFactoryBean.setJpaProperties(hibernateProperties);

		localSessionFactoryBean.setPackagesToScan(DB_MODEL_PACKAGE);

		localSessionFactoryBean.afterPropertiesSet();
		return localSessionFactoryBean.getObject();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(MYSQL_JDBC_DRIVER_CLASS);
		dataSource.setUrl(JDBC_MYSQL_URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		return new JpaTransactionManager(entityManagerFactory());
	}
}
