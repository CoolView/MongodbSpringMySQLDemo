package com.mongospringmysql.servercenter.resultcall.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongospringmysql.servercenter.page.Page;
import com.mongospringmysql.servercenter.resultcall.domian.CardIdentifyBean;
import com.mongospringmysql.servercenter.resultcall.domian.CardPicBean;
import com.mongospringmysql.servercenter.resultcall.domian.ResultCallStatBean;
import com.mongospringmysql.servercenter.resultcall.service.IIdCardResultService;


@Controller
@RequestMapping("/idcardresultctrl")
public class IdCardResultCtrl {
	@Autowired
	private IIdCardResultService idCardResultService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		String idcard_p = request.getParameter("idcard_p");
		Query query=new Query();
		Criteria criteria = QueryUtils.query(request);
		query.addCriteria(criteria);
		
		Page<CardIdentifyBean> page = idCardResultService.queryWithPager(
				"tablename", CardIdentifyBean.class, query, 
				Integer.parseInt((String) request.getAttribute("thispage")));
		//
		List<ResultCallStatBean> list = idCardResultService.queryWithStat(
				"tablename", ResultCallStatBean.class, criteria, 
				new String[]{"aptype","results"}, new String[]{"aptype","results"});
//		QueryUtils.queryStat(list,"tablename", criteria, request);		
		request.setAttribute("statTableName", "身份证识别结果统计");
		request.setAttribute("page", page);
		request.setAttribute("idcard_p", idcard_p);
		request.setAttribute("aptypeMap", QueryUtils.aptypeMap);
		return "resultcall/idcardresult/list";
	}
	
	@RequestMapping("/toDetails")
	public String toDetails(@RequestParam("id") String id, HttpServletRequest request){
		CardIdentifyBean bean = idCardResultService.findById(id,CardIdentifyBean.class,"collectionName" );
		CardPicBean cardPicBean = idCardResultService.findById(bean.getCardpics(), CardPicBean.class, bean.getTablename());
		request.setAttribute("bean", bean);
		request.setAttribute("cardPicBean", cardPicBean);
		return "resultcall/idcardresult/details";
	}
	

	
}
