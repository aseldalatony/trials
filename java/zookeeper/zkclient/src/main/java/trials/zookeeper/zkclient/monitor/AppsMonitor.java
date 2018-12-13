package trials.zookeeper.zkclient.monitor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class AppsMonitor implements Watcher {
	private ZooKeeper zk;
	private String node = "/apps";

	public AppsMonitor() throws KeeperException, InterruptedException, IOException {
		zk = new ZooKeeper("localhost:2181", 2000, this);

		if (zk.exists(node, this) == null) {
			zk.create(node, "apps".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		zk.getChildren(node, this);
	}

	public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
		new AppsMonitor();

		while (true) {
			TimeUnit.SECONDS.sleep(10);
		}
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeChildrenChanged) {
			try {
				List<String> children = zk.getChildren(node, this);
				System.out.println(event.getPath());
				System.out.println(children);
			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
