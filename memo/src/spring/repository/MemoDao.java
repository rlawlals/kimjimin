package spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import spring.entity.MemoDto;

public class MemoDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<MemoDto> list(){
		String sql = "select * from memo";
		RowMapper<MemoDto> mapper = new RowMapper<MemoDto>() {

			@Override
			public MemoDto mapRow(ResultSet rs, int index) throws SQLException {
				MemoDto dto = new MemoDto();
				dto.setId(rs.getInt("id"));
				dto.setWhen(rs.getString("when"));
				dto.setContent(rs.getString("content"));
				return dto;
			}
			
		};
		
		List<MemoDto> list = jdbcTemplate.query(sql, mapper);
		return list;
	}
	
	public void write(String content) {
		String sql = "insert into memo values(memo_seq.nextval,sysdate,?)";
		Object[] param = {content};
		jdbcTemplate.update(sql, param);
	}

}
