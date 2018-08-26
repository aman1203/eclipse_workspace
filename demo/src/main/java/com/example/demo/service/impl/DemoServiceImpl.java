package com.example.demo.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.common.BaseResult;
import com.example.demo.common.Tool;
import com.example.demo.dao.DemoDao;
import com.example.demo.model.Message;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DemoServiceImpl implements DemoService {
  private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private DemoDao demoDao;
  /**
   * 接收消息
   */
  @Override
  /*@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = Constants.exchange),
      key = Constants.key,
      value = @Queue(value = Constants.quene, autoDelete = "true", durable = "true")))*/
  public void getMessage(String message) {
    logger.info("begin to recieve message,{}", message);
    try {
      Message msg = Tool.dealMessage(message);
      demoDao.save(msg);
    } catch (Exception e) {
      logger.error("parse message error", e);
    }
  }

  /**
   * 发送消息
   */
  @Override
  public void sendMessage(Message message, String exchange, String routeKey) {
    if (message == null) {
      return;
    }
    ObjectMapper om = new ObjectMapper();
    String msg = "";
    try {
      msg = om.writeValueAsString(message);
    } catch (JsonProcessingException e) {
      logger.error("parse message error ,{}",message);
    }
    rabbitTemplate.convertAndSend(exchange, routeKey, msg);
  }

  @Override
  @Cacheable(cacheNames="cache1")
  public BaseResult findOne(long id) {
    Message msg = demoDao.findById(id).orElse(null);
    return msg==null?new BaseResult<>(1, 1, "查找数据不存在"):new BaseResult(1, 1, msg, "查找成功");
  }
  
  @Override
  @CacheEvict(cacheNames="cache1")
  public BaseResult deleteOne(long id){
    try {
      demoDao.deleteById(id);
    }catch(Exception e) {
      return new BaseResult(-1,1,"删除数据失败，数据不存在");
    }
    return new BaseResult(1,1,"删除数据成功");
  }

  @Override
  @Cacheable(cacheNames="cache1")
  public BaseResult getAll() {
    List<Message> list = demoDao.findAll();
    return list==null||list.size()==0?new BaseResult(1,1,"没有数据"):new BaseResult(1, 1, list, "查询成功，一共"+list.size()+"条");
  }
}
