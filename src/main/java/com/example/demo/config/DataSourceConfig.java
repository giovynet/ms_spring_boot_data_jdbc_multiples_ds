package com.example.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataSourceConfig {

	@Bean(name = "dsOne")
	@ConfigurationProperties(prefix = "spring.first-datasource")
	public DataSource dataSourceOne() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "jdbcTemplateOne")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplateOne(@Qualifier("dsOne") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}

	@Bean(name = "dsTwo")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource dataSourceTwo() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplateTwo")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplateTwo(@Qualifier("dsTwo") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
	
	@Bean(name="tmOne")
    @Autowired
    @Primary
    DataSourceTransactionManager tmOne(@Qualifier ("dsOne") DataSource ds) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(ds);
        return txm;
    }
    @Bean(name="tmTwo")
    @Autowired
    DataSourceTransactionManager tmTwo(@Qualifier ("dsTwo") DataSource ds) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(ds);
        return txm;
    }
	
    
    
    /******************************************************************
     * Chained tx manager to control at the same time tmOne and tmTwo
     *****************************************************************/
    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager (
    @Qualifier("tmOne")  PlatformTransactionManager platformlTransactionManagerOne,
    @Qualifier("tmTwo")  PlatformTransactionManager platformlTransactionManagerTwo) {
        return new ChainedTransactionManager(platformlTransactionManagerTwo,
        		platformlTransactionManagerOne);
    }
   
    
    
    /*****************************************************
     * Annotations creation made for simplified use...
     *****************************************************/
	
	//Applies rollback for Exception type too... 
    //because by default spring applies undo transactions only for Runtime Exceptions...
    
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
	@Transactional(
			transactionManager = "chainedTransactionManager",
			propagation=Propagation.REQUIRED, 
			rollbackForClassName={"Exception"}
		)
    public @interface ChainedTransaction {}
    

}