package com.ych.oc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.activation.DataSource;

/**
 * Created by ricyang on 16-7-27.
 */
@Configuration
@ComponentScan({"com.ych.oc.data", "com.ych.oc.web"})
@ImportResource(value="classpath:spring.database.xml")
public class SpringAppConfig {

    @Value("classpath:schema.sql")
    private Resource schema;

    @Value("classpath:user_data.sql")
    private Resource userData;

    @Bean(name="dataSource")
    public JndiObjectFactoryBean dataSource() {
        System.out.println("init data source...");
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setJndiName("java:/comp/env/jdbc/outliers_datasource");
        return dataSource;
    }
}
