package com.example.activity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.activity.service.ActivityDemoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class ActivityApplicationTests {
  @Autowired
  private ActivityDemoServiceImpl service;
	/**
	 * 启动流程引擎
	 */
	//@Test
	public void startprocessEngin() {
	  String processKey = "myProcess";
	  ProcessInstance pi = service.getRuntimeService().startProcessInstanceByKey(processKey);
	  System.out.println("流程引擎实启动，id: "+pi.getId()+",  key: "+pi.getProcessDefinitionKey());
	}
	
	/**
	 * 查找流程定义
	 */
	@Test
	public void queryProcessDef() {
	  String processDefKey = "myProcess";
	  List<ProcessDefinition> list = service.getRepositoryService()
	          .createProcessDefinitionQuery()
	          .processDefinitionKey(processDefKey)
	          .orderByProcessDefinitionKey()
	          .asc()//升序排列
	          .list();
	 Optional.ofNullable(list).ifPresent((x)->{
	   x.forEach((i)->{
	     System.out.println("流程定义id: "+i.getId()+", 流程定义名称："+i.getName()+", "
	         + "流程定义key: "+i.getKey());
	   });
	 });
	}
	/**
	 * 查找当前用户的任务
	 */
	//@Test
	public void findTaskListByPerson() {
	  String userName = "总经理";
	  List<Task> list = service.getTaskService()
	          .createTaskQuery()
	          .taskAssignee(userName)
	          .list();
	  
	 Optional<List<Task>> optional = Optional.ofNullable(list);
	 Consumer<List<Task>> consumer = (t)->{
	   t.forEach((task)->{
	     System.out.println("任务id: "+task.getId()+", 任务名称:"+task.getName()+
	         " 流程实例id:"+task.getProcessInstanceId()+", 流程定义id:"+task.getProcessDefinitionId()+
	         " 流程对象id:"+task.getExecutionId());
	   });
	 };
	 optional.ifPresent(consumer);
	}
	/**
	 * 完成指定人的的当前任务
	 */
	//@Test
	public void completeTask() {
	  String userName = "总经理";
	  //分配给该员工的任务
	  List<Task> list = service.getTaskService()
	          .createTaskQuery()
	          .taskAssignee(userName)
	          .list();
	  
	 //完成任务
	  Consumer<List<Task>> consumer = (T)->{
	    TaskService taskService = service.getTaskService();
	    T.forEach((x)->{
	      taskService.complete(x.getId());
	      System.out.println(userName+"已经完成"+x.getName()+"任务");
	    });
	  };
	  
	  Optional<List<Task>> optional = Optional.ofNullable(list);
	  optional.ifPresent(consumer);
	}
}
