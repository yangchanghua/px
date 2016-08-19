package com.ych.oc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ricyang on 16-8-18.
 */
@Repository
public class PracticeLogDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Transactional
    public int newPracticeLog(PracticeLog practiceLog) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("project_id", practiceLog.getProject().getId());
        sqlParameterSource.addValue("practice_date", practiceLog.getPracticeDate());
        sqlParameterSource.addValue("hours", practiceLog.getHours());
        sqlParameterSource.addValue("note", practiceLog.getNote());
        KeyHolder holder = new GeneratedKeyHolder();
        this.jdbcTemplate.update("insert into practice (project_id, practice_date, hours, note) "
                + "values(:project_id, :practice_date, :hours, :note)", sqlParameterSource, holder);
        return holder.getKey().intValue();
    }

    @Transactional
    public Collection<PracticeLog> getAll() {
        return this.jdbcTemplate.query("select * from practice", new PracticeRowMapper());
    }

    private static class PracticeRowMapper implements RowMapper<PracticeLog> {

        @Override
        public PracticeLog mapRow(ResultSet rs, int rowNum) throws SQLException {
            PracticeLog obj = new PracticeLog();
            obj.setId(rs.getInt("id"));
            obj.setPracticeDate(rs.getDate("practice_date"));
            obj.setHours(rs.getInt("hours"));
            obj.setNote(rs.getString("note"));

            Project project = new Project();
            project.setId(rs.getInt("project_id"));
            obj.setProject(project);
            return obj;
        }
    }
}
