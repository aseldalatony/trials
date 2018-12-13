package trials.zookeeper.zkclient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class App {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper keeper = new ZooKeeper("localhost:2181", 2000, e -> System.out.println("create:" + e.getState()));
		keeper.getChildren("/TestNode", true).stream().map(x -> x.concat(":node")).forEach(System.out::println);
		keeper.getData("/TestNode", e -> System.out.println("data:" + e.getType()), null);
		TimeUnit.SECONDS.sleep(30);
		System.out.println(Long.toHexString(keeper.getSessionId()));
	}
}
