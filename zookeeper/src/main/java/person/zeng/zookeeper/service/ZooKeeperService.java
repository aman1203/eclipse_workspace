package person.zeng.zookeeper.service;

/**
 * zookeeper 操作接口
 * 
 * @author Administrator
 *
 */
public interface ZooKeeperService {
  /**
   * 创建新的节点
   */
  public void createNode(String path,String data);
  /**
   * 获取节点数据
   * @param path
   * @return
   */
  public String getDate(String path);

  /**
   * 添加监视器
   * 
   * @param path
   */
  public void addWatcher(String path);
  /**
   * 更新节点数据
   * @param path
   */
  public void setData(String path,String data);
  /**
   * 删除节点
   * @param path
   */
  public void deleteNode(String path);

}
