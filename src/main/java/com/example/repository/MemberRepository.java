package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};

	public List<Member> findByName(String partOfName) {
		//String str="%"+partOfName+"%";
		String sql = "select id,name,age,dep_id from members where name like :partOfName order by id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("partOfName","%"+partOfName+"%" );
		List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER);
		return memberList;

	}

	/*
	 * public List<Member> find() { String sql =
	 * "select id,name,age,dep_id from members where name like '%ロー%'";
	 * SqlParameterSource param = new MapSqlParameterSource(); List<Member>
	 * memberList = template.query(sql, MEMBER_ROW_MAPPER); return memberList; }
	 */

	

}
