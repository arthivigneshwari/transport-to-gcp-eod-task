package com.morrisons.supplychain.logistics.transportplanner.config;

import java.io.IOException;
import java.util.HashMap;

/*import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "/com/morrisons/**", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
@Profile("!it & !ut")
public class DataSourceConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String userName;

	@Bean(name = "transportPlannerDs")
	public DataSource tpDatasource() throws IOException {

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driverClass);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(userName);

		DataSource dataSource = new CustomDataSource(hikariConfig);
		log.debug("transportPlannerDs datasource created");
		return dataSource;
	}

	@Bean(name = "transportPlannerJdbc")
	public JdbcTemplate tpJdbcTemplate(@Qualifier("transportPlannerDs") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager(Environment env) throws IOException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(tpDatasource());
		em.setPackagesToScan("/com/morrisons/**");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}

}*/
