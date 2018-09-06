package com.example.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * Druid配置
 * @author 李超
 *
 */
@ComponentScan
@Configuration
public class DruidConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbc = new JdbcTemplate(druidDataSource());
		return jdbc;
	}
	
	@Bean
	public DruidDataSource druidDataSource() {
		DruidDataSource source = new DruidDataSource();		
		source.setUrl(env.getProperty("spring.dataSource.url"));
		source.setUrl(env.getProperty("spring.dataSource.username"));
		source.setUrl(env.getProperty("spring.dataSource.password"));
		
		List<Filter> filterList = new LinkedList();
		filterList.add(filter());
		source.setProxyFilters(filterList);	
		return source;
	}
	
	@Bean
	public Filter filter() {
		StatFilter filter = new StatFilter();
		//SQL执行时间超过N秒判定为慢日志
		filter.setSlowSqlMillis(1000);
		//显示慢日志
		filter.setLogSlowSql(true);
		//合并SQL（有时一些相同的慢日志过多影响阅读，开启合并功能）
		filter.setMergeSql(true);
		return filter;
	}
}
