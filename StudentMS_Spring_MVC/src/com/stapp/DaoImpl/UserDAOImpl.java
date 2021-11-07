package com.stapp.DaoImpl;

import com.mysql.jdbc.PreparedStatement;
import com.stapp.DAO.UserDAO;
import com.stapp.Entity.UserEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDAOImpl implements UserDAO<Long, UserEntity> {

	
	private JdbcTemplate JdbcTemplate;
	private Datasource datasource = new Datasource();
	private DriverManagerDataSource con = datasource.getDataSource();
	
	public UserDAOImpl() {
		
		datasource = new Datasource();
		this.JdbcTemplate = new JdbcTemplate(con);
	}
	@Override
	public Long save(UserEntity user) {
		
		String sql = "Select max(id) as id from user";
		 Integer id = JdbcTemplate.queryForObject(sql,Integer.class);
		 if(id==null) {
			 id = 0;
		 }
		 id = id+1;
		 
		 sql = "insert into user(id,NAME,email,contact_number,PASSWORD) values(?,?,?"
		 		+ ",?,?";
		 int res = JdbcTemplate.update(sql,id,user.getName(),user.getEmail(),
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
		
		
		return null;
	}
	
	public UserEntity login(String email,String password) {
		System.out.println(email+" "+password);
		String sql = "Select id,name,password,contact_number,email,orgid,role from user where email=? and password=?";
		return JdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement psc =  (PreparedStatement) con.prepareStatement(sql.toString());
				 psc.setString(1,email);
				 psc.setString(2,password);
				return psc;
			}
		}, new ResultSetExtractor<UserEntity>() {

			@Override
			public UserEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				UserEntity ue = new UserEntity();
				if(rs.next()) {
				ue.setId(rs.getLong("id"));
				ue.setName(rs.getString("name"));
				ue.setContactNum(rs.getNString("contact_number"));
				ue.setEmail(rs.getString("email"));
				ue.setOrgId(rs.getLong("orgid"));
				ue.setRole(rs.getString("role"));
				}
				return ue;
			}
			
		});
	}

	@Override
	public Long deleteUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
