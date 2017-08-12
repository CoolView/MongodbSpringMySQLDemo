package com.mongospringmysql.basedao.dao.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongospringmysql.basedao.dao.BaseDao;
import com.mongospringmysql.servercenter.Constants;
import com.mongospringmysql.servercenter.page.Page;

/**
 * mongodb数据泛型dao类
 * 
 * @author 黄江南
 * @version 1.0 2014-09-16
 */
@Repository(value = "mongoDBBaseDao")
public class MongoDBBaseDao implements BaseDao {
	@Autowired
	@Qualifier("mongoTemplate")
	protected MongoTemplate mongoTemplate;

	/**
	 * 根据主键id返回对象
	 * 
	 * @param id
	 *            唯一标识
	 * @return T 对象
	 */
	@Override
	public <T> T findById(Class<T> entityClass, String id) {
		return this.mongoTemplate.findById(id, entityClass);
	}
	@Override
	public <T> T findById(String id, Class<T> entityClass,String collectionName) {
		return this.mongoTemplate.findById(id,entityClass,collectionName);
	}

	/**
	 * 根据类获取全部的对象列表
	 * 
	 * @param entityClass
	 *            返回类型
	 * @return List<T> 返回对象列表
	 */
	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		return this.mongoTemplate.findAll(entityClass);
	}

	/**
	 * 删除一个对象
	 * 
	 * @param obj
	 *            要删除的Mongo对象
	 */
	@Override
	public void remove(Object obj) {
		this.mongoTemplate.remove(obj);
	}

	/**
	 * 添加对象
	 * 
	 * @param obj
	 *            要添加的Mongo对象
	 */
	@Override
	public void add(Object obj) {
		this.mongoTemplate.insert(obj);

	}
	/**
	 * 添加对象,指定表名
	 * 
	 * @param obj 要添加的Mongo对象
	 * @param collectionName 表名
	 *            
	 */
	@Override
	public void add(Object obj, String collectionName) {
//		MongoCredential credentialOne = MongoCredential.createCredential("admin", "PicServerCenter", "w?DWFYaGmf,$FMu".toCharArray());
//		MongoClient mongo = null;
//				mongo = new MongoClient(new ServerAddress("127.0.0.1:8990"), Arrays.asList(credentialOne));
//			// TODO Auto-generated catch block
//		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "pbgs_core");
		
		mongoTemplate.insert(obj, collectionName);

	}
	/**
	 * 修改对象
	 * 
	 * @param obj
	 *            要修改的Mongo对象
	 */
	@Override
	public void saveOrUpdate(Object obj) {
		this.mongoTemplate.save(obj);
	}

	/**
	 * 查询并分页
	 * 
	 * @param entityClass
	 *            对象类型
	 * @param query
	 *            查询条件
	 * @param page
	 *            分页
	 * @return
	 */
	@Override
	public <T> Page<T> queryWithPager(String collectionName,Class<T> entityClass, Query query, int thispage) {
		Long count = this.tableNameCount(collectionName, query);
		Page<T> page = new Page<T>(thispage,Constants.PAGESIZE_DEFAULT,count);
		query.skip((thispage - 1) * Constants.PAGESIZE_DEFAULT).limit(Constants.PAGESIZE_DEFAULT);
		page.setList(mongoTemplate.find(query, entityClass, collectionName));
		return page;
	}

	/**
	 * 
	 * @param entityClass
	 *            查询对象
	 * @param query
	 *            查询条件
	 * @return
	 */
	@Override
	public <T> Long count(Class<T> entityClass, Query query) {
		return this.mongoTemplate.count(query, entityClass);
	}

	/**
	 * 根据表名查找总数
	 */
	@Override
	public <T> Long tableNameCount(String collectionName, Query query) {
		// TODO Auto-generated method stub
		return mongoTemplate.count(query, collectionName);
		
	}

	@Override
	public <T> List<T> queryWithStat(String collectionName,
			Class<T> entityClass, Criteria criteria, String[] fields,
			String[] groupFields) {
		// TODO Auto-generated method stub
		TypedAggregation<T> agg = Aggregation.newAggregation(
				entityClass,
				Aggregation.match(criteria),
				Aggregation.project(fields),
                Aggregation.group(groupFields).count().as("totalNum"),
                Aggregation.sort(Sort.Direction.DESC, "totalNum")
            );
		AggregationResults<T> result = mongoTemplate.aggregate(agg,collectionName, entityClass);
//        System.out.println(agg.toString());
        List<T> resultList = result.getMappedResults();
		return resultList;
	}
	
}
