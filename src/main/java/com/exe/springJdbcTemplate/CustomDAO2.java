package com.exe.springJdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomDAO2 {

	private JdbcTemplate jdbcTemplate;
		
	/**������ ����*/
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void insertData(CustomDTO dto) {
		
		StringBuilder sql= new StringBuilder();
		sql.append("insert into custom (id,name,age) values (?,?,?)");
		
		jdbcTemplate.update(sql.toString(),dto.getId(),dto.getName(),dto.getAge());
			
	}
	
	public List<CustomDTO> getList(){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id,name,age from custom");
		
		/**RowMapper: ������ �ݺ������� ������ Ŭ����*/
		List<CustomDTO> lists = 
				jdbcTemplate.query(sql.toString(),
						new RowMapper<CustomDTO>(){
							
							public CustomDTO mapRow(ResultSet rs, int rowNum)throws SQLException{
								
								CustomDTO dto = new CustomDTO();
								
								dto.setId(rs.getInt("id"));
								dto.setName(rs.getString("name"));
								dto.setAge(rs.getInt("age"));
								
								return dto;
								
							}
							
				});
			return lists;
	}
			
	
	public CustomDTO getReadData(int id){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id,name,age from custom where id=?");

		CustomDTO dtoOne = jdbcTemplate.queryForObject(sql.toString(),
				new RowMapper<CustomDTO>() {
					
					public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
						
						CustomDTO dto = new CustomDTO();
						
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setAge(rs.getInt("age"));
						
						return dto;
					}
		},id);
		return dtoOne;
	}
	
	public void updateData(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update custom set name=?,age=? where id=?");
			
		jdbcTemplate.update(sql.toString(),
				dto.getName(),dto.getAge(),dto.getId());
		
	}
	
	public void deleteData(int id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete custom where id=?");
		
		jdbcTemplate.update(sql.toString(),id);
	}
	
	
	
	
}