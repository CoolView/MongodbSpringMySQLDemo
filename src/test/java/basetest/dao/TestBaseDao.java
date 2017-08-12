package basetest.dao;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import basetest.BaseTest;
import basetest.User;

import com.mongospringmysql.basedao.dao.mongodb.MongoDBBaseDao;

public class TestBaseDao extends BaseTest{

	@Resource(name = "mongoDBBaseDao")
	MongoDBBaseDao mongoDBBaseDao;
	
	@Test
	public void testAdd(){
		User user=new User();
		Date creatTime=new Date();
		user.setCreateTime(creatTime);
		user.setAge(10);
		user.setUsername("黄江南");
		this.mongoDBBaseDao.add(user);
		System.out.println(user.getId());
	}
	
	
	@Test
	public void testFindAll(){
		List<User> userList=this.mongoDBBaseDao.findAll(User.class);
		for (User user : userList) {
			System.out.println("id:"+user.getId()+" username:"+user.getUsername()+"   age:"+user.getAge());
		}
		System.out.println("获取全部的数据----------------------"+new ObjectId().toString());
		
	}
	
	@Test
	public void testFindById(){
		User user=this.mongoDBBaseDao.findById(User.class, "59827218ce70267e15293f85");
		System.out.println(user.getUsername());
		System.out.println("获取单个对象----------------------");
	}
	@Test
	public void testUpdate(){
		User user=this.mongoDBBaseDao.findById(User.class, "59827218ce70267e15293f85");
		user.setUsername("黄江淮");
		this.mongoDBBaseDao.saveOrUpdate(user);
		User newUser=this.mongoDBBaseDao.findById(User.class, "59827218ce70267e15293f85");
		System.out.println(newUser.getUsername());
		System.out.println("修改数据成功");
		this.mongoDBBaseDao.saveOrUpdate(user);
	}
	@Test
	public void testRemove(){
		User user=this.mongoDBBaseDao.findById(User.class, "59827218ce70267e15293f85");
		this.mongoDBBaseDao.remove(user);
		User oldUser=this.mongoDBBaseDao.findById(User.class, "59827218ce70267e15293f85");
		if(oldUser==null){
			System.out.println(oldUser==null);
			System.out.println("删除对象成功");
		}
//		this.mongoDBBaseDao.add(user);
	}
	
	@Test
	public void testCount(){
		Query query=new Query();
		Criteria criteria=new Criteria();
		criteria.and("username").is("黄江南");
		query.addCriteria(criteria);
		long total=this.mongoDBBaseDao.count(User.class, query);
		System.out.println("用户总数:"+total);
	}
	
}
