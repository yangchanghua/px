package com.ych.oc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ricyang on 16-8-16.
 */
@Component
public class OutliersDBCreator {

    @Resource
    private DataSource dataSource;

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    public void createTables() {
        this.jdbcTemplate.getJdbcOperations().execute("create table projects("
                + "id INTEGER IDENTITY PRIMARY KEY,"
                + "domain VARCHAR(64),"
                + "sub_domain VARCHAR(64)"
                + "start_date DATE"
                + "spent_hours INTEGER"
                + ")");
    }

    public void insertDefaultValues() {
        Project project = new Project("exercise", "running", new Date(), 100);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(project);
        this.jdbcTemplate.update("insert INTO projects values(:domain, :subDomain, :startDate, :hours)", parameterSource);
    }

    public void destroyTables() {
        this.jdbcTemplate.getJdbcOperations().execute("DROP TABLE projects");
    }
}
