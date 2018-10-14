package person.zeng.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import person.zeng.zookeeper.config.ZooKeeperProperties;

@SpringBootApplication
@EnableConfigurationProperties(ZooKeeperProperties.class)
public class ZookeeperApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZookeeperApplication.class, args);
	}
}
