package com.mongospringmysql.basedao.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongospringmysql.servercenter.page.Page;

public interface BaseDao {

	<T> T findById(Class<T> entityClass, String id);
	<T> T findById(String id, Class<T> entityClass,String collectionName);

	<T> List<T> findAll(Class<T> entityClass);

	void remove(Object obj);

	void add(Object obj);

	void saveOrUpdate(Object obj);

	<T> Long count(Class<T> entityClass, Query query);

	void add(Object obj, String collectionName);

	<T> Long tableNameCount(String collectionName, Query query);
	
	<T> Page<T> queryWithPager(String collectionName,Class<T> entityClass, Query query, int thispage);
	/**
	 * 查询统计分组
	 * @param collectionName 集合名
	 * @param entityClass
	 * @param criteria 查询条件
	 * @param fields 需要展示的字段
	 * @param groupFields 需要分组的字段
	 * @return
	 */
	<T> List<T> queryWithStat(String collectionName,Class<T> entityClass,
			Criteria criteria,String[] fields,String[] groupFields);
}
