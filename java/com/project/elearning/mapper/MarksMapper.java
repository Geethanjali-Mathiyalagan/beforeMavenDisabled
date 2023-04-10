package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Mark;

public class MarksMapper implements RowMapper<Mark>{

	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mark mark= new Mark();
		Float percentage=rs.getFloat("percentage");
		
		mark.setPercentage(percentage);
		return mark;
	}

}
