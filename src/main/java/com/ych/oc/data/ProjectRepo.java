package com.ych.oc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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

    @Transactional
    public void addProject(Project project) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(project);
        this.jdbcTemplate.update("insert into projects (domain, sub_domain, start_date, hours) "
                + "values (:domain, :subDomain, :startDate, :hours)", parameterSource);
    }

    @Transactional
    public Collection<Project> getProjects() {
        return this.jdbcTemplate.query("select * from projects", new ProjectMapper());
    }

    private static final class ProjectMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            Project project = new Project();
            project.setDomain(rs.getString("domain"));
            project.setSubDomain(rs.getString("sub_domain"));
            project.setStartDate(rs.getDate("start_date"));
            project.setHours(rs.getInt("hours"));
            return project;
        }
    }
}
