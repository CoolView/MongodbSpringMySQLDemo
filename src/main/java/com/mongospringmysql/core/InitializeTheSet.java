package com.mongospringmysql.core;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


public class InitializeTheSet implements
		ApplicationListener<ContextRefreshedEvent> {
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		// 查询系统设置，如果为空则使用Constants下默认值
		System.out.println("==================容器启动完成，执行此方法，如：加载系统设置等");
		
	}
}
