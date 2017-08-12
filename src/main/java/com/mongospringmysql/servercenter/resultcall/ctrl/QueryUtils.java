package com.mongospringmysql.servercenter.resultcall.ctrl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;

public class QueryUtils {
	public static Map<String, String> aptypeMap = new LinkedHashMap<String, String>();
	static {
		aptypeMap.put("1", "类型1");
		aptypeMap.put("2", "类型2");
		aptypeMap.put("3", "类型3");
		aptypeMap.put("0", "其他");
	}
	/**
	 * 列表查询条件
	 * @param request
	 * @return
	 */
	public static Criteria query(HttpServletRequest request){
		String thispage = request.getParameter("thispage");
		String starttime_p = request.getParameter("starttime_p");
		String endtime_p = request.getParameter("endtime_p");
		String aptype_p = request.getParameter("aptype_p");
		Criteria criteria=new Criteria();
		criteria.and("identifytime").gte(starttime_p).lte(endtime_p);
		
		if(!isNullOrEmpty(aptype_p)){
			criteria.and("aptype").is(Integer.parseInt(aptype_p));
		}
		
		if(isNullOrEmpty(thispage)){
			thispage = "1";
		}
		request.setAttribute("starttime_p", starttime_p);
		request.setAttribute("endtime_p", endtime_p);
		request.setAttribute("aptype_p", aptype_p);
		request.setAttribute("thispage", thispage);
		
		return criteria;
	}
	/**
     * 判断字符串是否为NULL或空
     * @param s
     * @return
     */
    public static boolean isNullOrEmpty(String s){

        if(s==null) return true;
        if("".equals(s.trim())) return true;
        return false;
    }
}
