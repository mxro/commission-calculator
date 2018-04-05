package de.mxro.commissioncalculator.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import de.mxro.commissioncalculator.model.domain.Range;

@Repository
@Qualifier("hsql")
public class HSQLRangeDaoImpl implements RangeDao {

	@Autowired
	DataSource dataSource;

	@Override
	public Range findRangeByAchievement(double achievement) {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		String sql = "SELECT * FROM RANGES WHERE :achievement >= start AND :achievement < end";
		
		Map<String, Object> params = new HashMap<>();
		params.put("achievement", achievement);
		
		return namedParameterJdbcTemplate.queryForObject(sql, params, new RangeMapper());

	}

	private static final class RangeMapper implements RowMapper<Range> {

		public Range mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Range.create(rs.getDouble("start"), rs.getDouble("end"), rs.getDouble("base"), rs.getDouble("rate"));

		}
	}

}
