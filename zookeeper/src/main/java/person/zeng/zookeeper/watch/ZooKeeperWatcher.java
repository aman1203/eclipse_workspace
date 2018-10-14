package person.zeng.zookeeper.watch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 * zookeeper监视器
 * @author Administrator
 *
 */
@Component
public class ZooKeeperWatcher implements Watcher{

  @Override
  public void process(WatchedEvent paramWatchedEvent) {
    System.out.println("触发监控事件 path:"+paramWatchedEvent.getPath());
    System.out.println("触发监控事件 intValue:"+paramWatchedEvent.getType().getIntValue());
    System.out.println("触发监控事件 name:"+paramWatchedEvent.getType().name());
  }
}
