package trials.zookeeper.zkclient.monitor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class MonitoredApp {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk = new ZooKeeper("localhost:2181", 2000, w -> System.out.println(w));
		zk.create("/apps/node", "created".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		while (true) {
			TimeUnit.SECONDS.sleep(10);
		}
	}

}
