package com.transglobe.esp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.transglobe.esp.bean.CasePremium;

@Repository
public class JdbcEvbQueryRepository implements EvbQueryRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CasePremium> getCasePremiumList(String dataDate, String internalId) {
		String sql = String.format("select GENDER_PH, INITIAL_CASE_CNT, INITIAL_PREM_SUM, NEXT_CASE_CNT, NEXT_PREM_SUM "
					+ " ,CHARGE_YEAR,FIRST_YEAR_NEXT_CASE_CNT,FIRST_YEAR_NEXT_PREM_SUM"
					+ " from SDM.SDM_EVB_EC " 
					+ " where internal_id = '%s' and data_date = to_date('%s', 'YYYYMMDD')"
					, internalId, dataDate);
		
		List<CasePremium> list = new ArrayList<>();
		jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					CasePremium casePremium = new CasePremium();
					casePremium.setGender(rs.getString("GENDER_PH"));
					casePremium.setInitialCaseCnt(rs.getLong("INITIAL_CASE_CNT"));
					casePremium.setInitialPremSum(rs.getBigDecimal("INITIAL_PREM_SUM"));
					casePremium.setNextCaseCnt(rs.getLong("NEXT_CASE_CNT"));
					casePremium.setNextPremSum(rs.getBigDecimal("NEXT_PREM_SUM"));
					casePremium.setChargeYear(rs.getString("CHARGE_YEAR"));
					casePremium.setFirstYearNextCaseCnt(rs.getInt("FIRST_YEAR_NEXT_CASE_CNT"));
					casePremium.setFirstYearNextPremSum(rs.getBigDecimal("FIRST_YEAR_NEXT_PREM_SUM"));
					list.add(casePremium);
				}
				return null;
			}
			
		});
		
		return list;
	}

}
