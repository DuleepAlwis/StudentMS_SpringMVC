package com.stapp.DaoImpl;

import com.stapp.DAO.UserDAO;
import com.stapp.Entity.UserEntity;

import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpl implements UserDAO<Long, UserEntity> {

	
	private JdbcTemplate JdbcTemplate;
	private Datasource datasource;
	
	public UserDAOImpl() {
		
		datasource = new Datasource();
		this.JdbcTemplate = new JdbcTemplate(datasource.getDataSource());
	}
	@Override
	public Long save(UserEntity user) {
		
		String sql = "Select max(id) as id from user";
		 int preId = JdbcTemplate.queryForObject(sql,Integer.class);
		 preId = preId+1;
		 
		 sql = "insert into user(id,NAME,email,contact_number,PASSWORD) values(?,?,?"
		 		+ ",?,?";
		 int res = JdbcTemplate.update(sql,preId,user.getName(),user.getEmail(),
				 user.getContactNum(),user.getPassword());
		 
		return (long)res;
	}

	@Override
	public Long update(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

}
