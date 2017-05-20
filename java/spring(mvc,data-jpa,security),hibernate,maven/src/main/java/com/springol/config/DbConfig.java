package com.springol.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@EnableJpaRepositories(basePackages = "com.springol.repository")
public class DbConfig {
	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("database.driverClassName"));
		basicDataSource.setUrl(env.getProperty("database.url"));
		basicDataSource.setUsername(env.getProperty("database.username"));
		basicDataSource.setPassword(env.getProperty("database.password"));
		DatabasePopulatorUtils.execute(createDatabasePopulator(), basicDataSource);
		return basicDataSource;
	}

	private DatabasePopulator createDatabasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("springol.sql"));
		return databasePopulator;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		entityManagerFactory.setPackagesToScan("com.springol.model");
		entityManagerFactory.setJpaPropertyMap(hibernateJpaProperties());
		return entityManagerFactory;
	}

	private Map<String, ?> hibernateJpaProperties() {
		HashMap<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		// properties.put("hibernate.hbm2ddl.import_files", "insert-data.sql");
		properties.put("hibernate.c3p0.min_size", "2");
		properties.put("hibernate.c3p0.max_size", "5");
		properties.put("hibernate.c3p0.timeout", "300"); // 5mins
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}
}
