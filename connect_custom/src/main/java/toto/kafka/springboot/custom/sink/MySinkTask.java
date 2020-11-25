package toto.kafka.springboot.custom.sink;

import java.util.Collection;
import java.util.Map;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import toto.kafka.springboot.custom.config.MyConnectorConfig;
import toto.kafka.springboot.custom.util.VersionUtil;

public class MySinkTask extends SinkTask {
	
	private static final Logger log = LoggerFactory.getLogger(MySinkTask.class);
	
	private MySinkSender sender;
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
    	this.sender = new MySinkSender();
	}

	@Override
	public void put(Collection<SinkRecord> records) {
		log.info("[+TOTO] ================== put(Collection<SinkRecord> records)");
		for(SinkRecord r : records) {
		      log.trace("Putting record to topic {}, partition {} and offset {}", r.topic(), 
		          r.kafkaPartition(),
		          r.kafkaOffset());
		      sender.sendRecord(r);
		    }
		log.info("[+TOTO] ================== put(Collection<SinkRecord> records)");
	}

	@Override
	public void stop() {
		log.info("[+TOTO] ================== stop()");
		log.info("[+TOTO] ================== stop()");
	}
}
