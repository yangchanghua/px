package com.ych.oc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by ricyang on 16-8-16.
 */
@Repository
public class ProjectRepo {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    public void addProject(Project project) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(project);
        this.jdbcTemplate.update("insert into projects (domain, sub_domain, start_date, hours) "
                + "values (:domain, :subDomain, :startDate, :hours)", parameterSource);
    }
}
