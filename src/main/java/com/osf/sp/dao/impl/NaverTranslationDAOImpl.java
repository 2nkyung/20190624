package com.osf.sp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.osf.sp.dao.NaverTranslationDAO;

@Repository
public class NaverTranslationDAOImpl implements NaverTranslationDAO{

	@Resource
	private SqlSession ss;
	
	public List<Map<String,Object>> selectTranslationHisList(){
		return ss.selectList("NaverTranslationMapper.selectList");
	}
	
	
}
