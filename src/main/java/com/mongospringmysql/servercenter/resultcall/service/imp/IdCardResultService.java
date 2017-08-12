package com.mongospringmysql.servercenter.resultcall.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongospringmysql.servercenter.page.Page;
import com.mongospringmysql.servercenter.resultcall.dao.IIdCardResultDao;
import com.mongospringmysql.servercenter.resultcall.domian.ResultCallStatBean;
import com.mongospringmysql.servercenter.resultcall.service.IIdCardResultService;

@Service
public class IdCardResultService implements IIdCardResultService {
	@Autowired
	private IIdCardResultDao idCardResultDao;

	@Override
	public <T> Page<T> queryWithPager(String collectionName,
			Class<T> entityClass, Query query, int thispage) {
		// TODO Auto-generated method stub
		return idCardResultDao.queryWithPager(collectionName, entityClass,
				query, thispage);
	}

	@Override
	public List<ResultCallStatBean> queryWithStat(String collectionName,
			Class<ResultCallStatBean> entityClass, Criteria criteria,
			String[] fields, String[] groupFields) {
		// TODO Auto-generated method stub
		return idCardResultDao.queryWithStat(collectionName, entityClass,
				criteria, fields, groupFields);
	}

	@Override
	public <T> T  findById(String id, Class<T> entityClass,
			String collectionName) {
		// TODO Auto-generated method stub
		return idCardResultDao.findById(id, entityClass, collectionName);
	}

}
