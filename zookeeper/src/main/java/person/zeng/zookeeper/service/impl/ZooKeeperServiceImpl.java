package person.zeng.zookeeper.service.impl;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.zeng.zookeeper.config.ZooKeeperProperties;
import person.zeng.zookeeper.service.ZooKeeperService;

@Service
// @ConditionalOnBean(name= {"ZooKeeperProperties","ZooKeeperWatcher"})
public class ZooKeeperServiceImpl implements ZooKeeperService, InitializingBean {
  private ZooKeeper zooKeeper;
  @Autowired
  private ZooKeeperProperties zookeeperProperties;
  @Autowired
  private Watcher zooKeeperWatcher;

  @Override
  public void createNode(String path, String data) {
    try {
      String createResult =
          zooKeeper.create("/" + path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      addWatcher(path);
    } catch (KeeperException | InterruptedException e) {
      System.out.println("创建节点失败" + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public String getDate(String path) {
    try {
      byte[] byteArray = zooKeeper.getData("/" + path, zooKeeperWatcher, null);
      String data = new String(byteArray);
      return data;
    } catch (KeeperException | InterruptedException e) {
      e.printStackTrace();
      return "error";
    }
  }

  @Override
  public void addWatcher(String path) {
    getDate(path);
  }

  @Override
  public void setData(String path, String data) {
    try {
      zooKeeper.setData("/" + path, data.getBytes(), -1);
      addWatcher(path);
    } catch (KeeperException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteNode(String path) {
    try {
      zooKeeper.delete("/" + path, -1);
    } catch (InterruptedException | KeeperException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    {
      try {
        zooKeeper = new ZooKeeper(zookeeperProperties.getConnect(), 2000, null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
