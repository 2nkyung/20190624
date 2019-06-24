package com.osf.sp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NaverTranslationDAOImpl {

	@Resource
	private SqlSession ss;
	
	public List<Map<String,Object>> selectTranslationHisList(){
		return ss.selectList("com.osf.sp.mapper.NaverTranslationMapper.selectList");
	}
	
	
}
