package com.mongospringmysql.servercenter.resultcall.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongospringmysql.servercenter.page.Page;
import com.mongospringmysql.servercenter.resultcall.domian.ResultCallStatBean;

public interface IIdCardResultService {
	/**
	 * 分页
	 * @param collectionName
	 * @param entityClass
	 * @param query
	 * @param thispage
	 * @return
	 */
	<T> Page<T> queryWithPager(String collectionName,Class<T> entityClass, Query query, int thispage);
	
	
	List<ResultCallStatBean> queryWithStat(String collectionName,Class<ResultCallStatBean> entityClass,
			Criteria criteria,String[] fields,String[] groupFields);
	
	
	<T> T  findById(String id, Class<T> entityClass, String collectionName);
}
