package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.DaoException;

@Repository
public class ParameterDaoImpl implements ParameterDao {

	@Autowired
	@Qualifier("jdbcTemplateOne")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplateOne;

	@Autowired
	@Qualifier("jdbcTemplateTwo")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplateTwo;

	/**********************
	 * DATA SOURCE ONE
	 *********************/

	/**
	 * Example Spring Data JDBC using named parameter jdbc template with auto-map
	 * params from dto.
	 */
	@Override
	public Long insertParameterDsOne(ParameterDto parameterDto) throws DaoException {
		Long id = null;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			String sql = "INSERT INTO \"public\".parameter \r\n"
					+ "	( id_group_parameter, name) VALUES ( :idGroupParameter, :name )";

			namedParameterJdbcTemplateOne.update(sql, new BeanPropertySqlParameterSource(parameterDto), keyHolder,
					new String[] { "id" });

			id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

			System.out.println("Insert done. Record Id: " + id);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
		return id;

	}

	/**
	 * Example Spring Data JDBC using named parameter jdbc template with hashMap to
	 * map params.
	 */
	@Override
	public Long insertGroupParameterDsOne(GroupParameterDto groupParameterDto) throws DaoException {
		Long id = null;
		try {
			// prepare keyHolder
			KeyHolder keyHolder = new GeneratedKeyHolder();

			// create sql sentence
			String sql = "INSERT INTO \"public\".group_parameter \r\n" + "	( name ) VALUES ( :name )";

			// get parameters into map
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("name", groupParameterDto.getName());

			// execute insert, array's value id corresponds with id field of
			// GroupParameterDto
			namedParameterJdbcTemplateOne.update(sql, params, keyHolder, new String[] { "id" });

			// get id generated
			id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

			System.out.println("Insert done. Record Id: " + id);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

		return id;
	}

	/**
	 * Example Spring Data JDBC using named parameter jdbc template update with
	 * auto-map params from dto.
	 */
	@Override
	public void updateGroupParameterDsOne(GroupParameterDto groupParameterDto) throws DaoException {
		try {

			String sql = "UPDATE \"public\".group_parameter SET name = :name WHERE id = :id";

			int affectedRows = namedParameterJdbcTemplateOne.update(sql,
					new BeanPropertySqlParameterSource(groupParameterDto));
			System.out.println("Update done. Affected rows: " + affectedRows);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	/**********************
	 * DATA SOURCE TWO
	 *********************/

	/**
	 * Example Spring Data JDBC using named parameter jdbc template with auto-map
	 * params from dto.
	 */
	@Override
	public Long insertParameterDsTwo(ParameterDto parameterDto) throws DaoException {
		Long id = null;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			String sql = "INSERT INTO \"public\".parameter \r\n"
					+ "	( id_group_parameter, name) VALUES ( :idGroupParameter, :name )";

			namedParameterJdbcTemplateTwo.update(sql, new BeanPropertySqlParameterSource(parameterDto), keyHolder,
					new String[] { "id" });

			id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

			System.out.println("Insert done. Record Id: " + id);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
		return id;

	}

	/**
	 * Example Spring Data JDBC using named parameter jdbc template with hashMap to
	 * map params.
	 */
	@Override
	public Long insertGroupParameterDsTwo(GroupParameterDto groupParameterDto) throws DaoException {
		Long id = null;
		try {
			// prepare keyHolder
			KeyHolder keyHolder = new GeneratedKeyHolder();

			// create sql sentence
			String sql = "INSERT INTO group_parameter " + "	( name ) VALUES ( :name )";

			// get parameters into map
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("name", groupParameterDto.getName());

			// execute insert, array's value id corresponds with id field of
			// GroupParameterDto
			namedParameterJdbcTemplateTwo.update(sql, params, keyHolder, new String[] { "id" });

			// get id generated
			id = keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;

			System.out.println("Insert done. Record Id: " + id);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

		return id;
	}

	/**
	 * Example Spring Data JDBC using named parameter jdbc template update with
	 * auto-map params from dto.
	 */
	@Override
	public void updateGroupParameterDsTwo(GroupParameterDto groupParameterDto) throws DaoException {
		try {

			String sql = "UPDATE \"public\".group_parameter SET name = :name WHERE id = :id";

			int affectedRows = namedParameterJdbcTemplateTwo.update(sql,
					new BeanPropertySqlParameterSource(groupParameterDto));
			System.out.println("Update done. Affected rows: " + affectedRows);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
	}

	
	/**
	 * Example select with ResultSetExtractor...
	 */	
	@Override
	public List<GroupParameterDto> selectListGroupParameterDsOne() throws DaoException {
		List<GroupParameterDto> lst = null;
		try {

			String sql = "SELECT gp.id, gp.name\r\n" + "FROM \"public\".group_parameter gp ";
			
			lst = namedParameterJdbcTemplateOne.query(sql, new ResultSetExtractor<List<GroupParameterDto>>() {
				@Override
				public List<GroupParameterDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<GroupParameterDto> lst = new ArrayList<>();
					while (rs.next()) {
						lst.add(new GroupParameterDto(rs.getLong("id"), rs.getString("name")));
					}
					return lst;
				}
			});

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}
		return lst;
	}
	
	
	/**
	 * Example select with RowMaper...
	 */	
	@Override
	public List<GroupParameterDto> selectListGroupParameterDsTwo() throws DaoException {
		List<GroupParameterDto> lst = null;
		try {

			String sql = "SELECT gp.id, gp.name\r\n" + "FROM \"public\".group_parameter gp ";						
			
			lst =namedParameterJdbcTemplateTwo.query(sql,(rs,rowNum) -> 
				new GroupParameterDto(rs.getLong("id"), rs.getString("name")));

			
			//			lst =namedParameterJdbcTemplateTwo.query(sql, new RowMapper<GroupParameterDto>() {
//				@Override
//				public GroupParameterDto  mapRow(ResultSet rs, int rowNum) throws SQLException {
//					return new GroupParameterDto(rs.getLong("id"), rs.getString("name"));
//				}
//				
//			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	

}
