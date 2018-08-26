package com.example.activity.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityDemoServiceImpl {
  @Autowired
  private RuntimeService runtimeService;
  @Autowired
  private TaskService taskService;
  @Autowired
  private HistoryService historyService;
  @Autowired
  private RepositoryService repositoryService;
  @Autowired
  private ProcessEngineConfigurationImpl processEngineConfigurationImpl;
  public RuntimeService getRuntimeService() {
    return runtimeService;
  }
  public void setRuntimeService(RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }
  public TaskService getTaskService() {
    return taskService;
  }
  public void setTaskService(TaskService taskService) {
    this.taskService = taskService;
  }
  public HistoryService getHistoryService() {
    return historyService;
  }
  public void setHistoryService(HistoryService historyService) {
    this.historyService = historyService;
  }
  public RepositoryService getRepositoryService() {
    return repositoryService;
  }
  public void setRepositoryService(RepositoryService repositoryService) {
    this.repositoryService = repositoryService;
  }
  public ProcessEngineConfigurationImpl getProcessEngineConfigurationImpl() {
    return processEngineConfigurationImpl;
  }
  public void setProcessEngineConfigurationImpl(
      ProcessEngineConfigurationImpl processEngineConfigurationImpl) {
    this.processEngineConfigurationImpl = processEngineConfigurationImpl;
  }
  
}
