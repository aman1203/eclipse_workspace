package com.example.demo.service;

import com.example.demo.common.BaseResult;
import com.example.demo.model.Message;
public interface DemoService {
	public void getMessage(String message);
	public void sendMessage(Message message,String exchange,String routeKey);
	public BaseResult findOne(long id);
	public BaseResult deleteOne(long id);
	public BaseResult getAll();
}
