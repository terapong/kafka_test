package toto.kafka.springboot.custom.source;

import toto.kafka.springboot.custom.config.MyConnectorConfig;
import toto.kafka.springboot.custom.util.VersionUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySourceTask extends SourceTask {

	private static final Logger log = LoggerFactory.getLogger(MySourceTask.class);
	
	private MyConnectorConfig myConnectorConfig;

	@Override
	public String version() {
		log.info("[+TOTO] ================== version()");
    	log.info("[+TOTO] version: " + VersionUtil.getVersion());
    	log.info("[+TOTO] ================== version()");
    	return VersionUtil.getVersion();
	}

	@Override
	public void start(Map<String, String> props) {
		log.info("[+TOTO] ================== start(Map<String, String> props)");
    	log.info("[+TOTO] props: " + props);
    	log.info("[+TOTO] ================== start(Map<String, String> props)");
    	
    	this.myConnectorConfig = new MyConnectorConfig(props);
	}

	@Override
	public List<SourceRecord> poll() throws InterruptedException {
		log.info("[+TOTO] ================== poll()");
		log.info("[+TOTO] ================== poll()");
		return null;
	}

	@Override
	public void stop() {
		log.info("[+TOTO] ================== stop()");
		log.info("[+TOTO] ================== stop()");
	}
	
	
}
