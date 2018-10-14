package person.zeng.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import person.zeng.zookeeper.common.BaseResult;
import person.zeng.zookeeper.service.ZooKeeperService;

@Controller
public class ZooKeeperController {
  @Autowired
  private ZooKeeperService service;

  @GetMapping("/createNode/{path}/{data}")
  @ResponseBody
  public BaseResult createNode(@PathVariable("path") String path,
      @PathVariable("data") String data) {
    service.createNode(path, data);
    return new BaseResult<String>(0, "0x11111", path + ":" + data, "创建节点成功");
  }

  @GetMapping("/getData/{path}")
  @ResponseBody
  public BaseResult getData(@PathVariable("path") String path) {
    String data = service.getDate(path);
    return new BaseResult<String>(0, "0x11111", path + ":" + data, "获取节点数据成功");
  }

  @GetMapping("/setData/{path}/{data}")
  @ResponseBody
  public BaseResult getData(@PathVariable("path") String path, @PathVariable("data") String data) {
    service.setData(path, data);
    return new BaseResult<String>(0, "0x11111", path + ":" + data, "更新节点数据成功");
  }
  
  @GetMapping("/deleteNode/{path}")
  @ResponseBody
  public BaseResult deleteNode(@PathVariable("path") String path) {
    service.deleteNode(path);
    return new BaseResult<String>(0, "0x11111", "/"+path, "删除节点成功");
  }
}
