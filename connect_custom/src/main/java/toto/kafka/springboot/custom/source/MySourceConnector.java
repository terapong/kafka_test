package toto.kafka.springboot.custom.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import toto.kafka.springboot.custom.config.MyConnectorConfig;
import toto.kafka.springboot.custom.util.VersionUtil;

public class MySourceConnector extends SourceConnector {
	
	private static final Logger log = LoggerFactory.getLogger(MyConnectorConfig.class);
	
	private MyConnectorConfig myConnectorConfig;
	private Map<String, String> configProps;

    @Override
    public void start(Map<String, String> props) {
    	log.info("[+TOTO] ================== start(Map<String, String> props)");
    	log.info("[+TOTO] props: " + props);
    	log.info("[+TOTO] ================== start(Map<String, String> props)");
    	
        this.myConnectorConfig = new MyConnectorConfig(props);
        this.configProps = Collections.unmodifiableMap(props);
    }

	@Override
	public String version() {
		log.info("[+TOTO] ================== version()");
    	log.info("[+TOTO] version: " + VersionUtil.getVersion());
    	log.info("[+TOTO] ================== version()");
    	return VersionUtil.getVersion();
	}

	@Override
	public Class<? extends Task> taskClass() {
		log.info("[+TOTO] ================== taskClass()");
    	log.info("[+TOTO] taskClass: MySourceTask.class");
    	log.info("[+TOTO] ================== taskClass()");
		return MySourceTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int maxTasks) {
		log.info("[+TOTO] ================== taskConfigs(int maxTasks)");
		log.info("[+TOTO] maxTasks: " + maxTasks);
		
		List<Map<String, String>> taskConfigs = new ArrayList<>(maxTasks);
	    Map<String, String> taskProps = new HashMap<>(configProps);
	    for (int i = 0; i < maxTasks; i++) {
	      taskConfigs.add(taskProps);
	      log.info("[+TOTO] taskProps: " + taskProps);
	    }
	    log.info("[+TOTO] ================== taskConfigs(int maxTasks)");
	    return taskConfigs;
	}

	@Override
	public void stop() {
		log.info("[+TOTO] ================== stop()");
		log.info("[+TOTO] ================== stop()");
	}

	@Override
	public ConfigDef config() {
		log.info("[+TOTO] ================== config()");
		log.info("[+TOTO] ================== config()");
		return myConnectorConfig.config;
	}
}
