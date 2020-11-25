package toto.kafka.springboot.custom.monitor;

import org.apache.kafka.connect.connector.ConnectorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitoringThread extends Thread {
	
	private static final Logger log = LoggerFactory.getLogger(MonitoringThread.class);
	
	private final Long pollInterval;

	public MonitoringThread(ConnectorContext context, Long pollInterval) {
		this.pollInterval = pollInterval;
	}

	@Override
	public void run() {
//		while (shutdownLatch.getCount() > 0) {
//			if (sourceHasChanged()) {
//				context.requestTaskReconfiguration();
//			}
//
//			try {
//				shutdownLatch.await(pollInterval, TimeUnit.MILLISECONDS);
//			} catch (InterruptedException e) {
//				log.warn("MonitoringThread interrupted: ", e);
//			}
//		}
	}
}
