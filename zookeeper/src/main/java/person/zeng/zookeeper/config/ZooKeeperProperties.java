package person.zeng.zookeeper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类
 * 
 * @author Administrator
 *
 */
@Primary
@Configuration
@ConfigurationProperties(prefix = "zookeeper")
@PropertySource({"classpath:application.properties"})
public class ZooKeeperProperties {
  private String connect;

  public String getConnect() {
    return connect;
  }

  public void setConnect(String connect) {
    this.connect = connect;
  }
}
