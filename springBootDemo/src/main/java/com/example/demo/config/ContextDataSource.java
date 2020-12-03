package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *데이터베이스 설정
 */
@Configuration
// 아노 테이션 기반 트랜잭션 관리를 사용 합니다.
// <tx:annotation-driven>
@EnableTransactionManagement
public class ContextDataSource {
	 /**
	 * @return
	 */
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/adt");
		dataSource.setUsername("root");
		dataSource.setPassword("mdd");
		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}

	/**
	 * 
	 * @return
	 */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
