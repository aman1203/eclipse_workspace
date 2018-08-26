package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.common.AppContext;
import com.example.demo.common.BaseResult;
import com.example.demo.common.Constants;
import com.example.demo.model.Message;
import com.example.demo.service.DemoService;

@Controller
//@Scope("prototype")
public class DemoController {
  private long count;
  @Autowired
  private DemoService demoService;
  @RequestMapping(value="/sendMessage/{count}",method = RequestMethod.GET)
  @ResponseBody
  public BaseResult<Long> sendMessage(@PathVariable("count")long count){
    long counts = count;
    while(count>0) {
      Message message = new Message("zengjie", "湖北", 12, "男", "780280399@qq.com");
      demoService.sendMessage(message, Constants.exchange, Constants.key);
      count--;
    }
    BaseResult<Long> result = new BaseResult<Long>(1, 1, counts, "发送数据："+counts+"条");
    return result;
  }
  @GetMapping("/getOne/{id}")
  @ResponseBody
  public BaseResult getPersonById(@PathVariable("id") long id){
   return demoService.findOne(id);
  }
  @GetMapping("/deleteOne/{id}")
  @ResponseBody
  public BaseResult deletePersonById(@PathVariable("id")long id) {
    return demoService.deleteOne(id);
  }
  
  @GetMapping("/evn")
  @ResponseBody
  public BaseResult<Map<String,String>> getEvn(){
    Environment evn = (Environment)AppContext.getBean(Environment.class);
    Map<String, String> map = new HashMap<String,String>();
    System.out.println(evn.getProperty("person.cache.redis.time-to-live"));
    return null;
  }
  @GetMapping("/getAll")
  @ResponseBody
  public BaseResult getAll() {
    return demoService.getAll();
  }
  @GetMapping("/exception")
  @ResponseBody
  public BaseResult exception(){
    int a = 1/0;
    return null;
  }
  @GetMapping(value="/push",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
  @ResponseBody
  public String push(HttpServletRequest request) {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String message = sdf.format(date);
    count++;
    return "data:"+message+",id:"+count+"\n\n";
  }
  
  @GetMapping(value="/page")
  public String page() {
    return "demo";
  }
}
