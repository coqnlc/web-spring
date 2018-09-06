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
	
	private final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://127.0.0.1:3306/web_demo?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private final String USERNAME = "root";
	private final String PASSWORD = "lc1234";
	
	@Bean
	public DruidDataSource druidDataSource() {
		//数据库配置
		DruidDataSource source = new DruidDataSource();
		source.setDriverClassName(CLASS_NAME);
		source.setUrl(URL);
		source.setUsername(USERNAME);
		source.setPassword(PASSWORD);
		//连接池配置
		source.setInitialSize(20);
		source.setMinIdle(10);
		source.setMaxActive(30);
		//过滤器配置
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
