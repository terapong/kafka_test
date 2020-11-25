package toto.kafka.springboot.custom.config;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConnectorConfig extends AbstractConfig {
	
	private static final Logger log = LoggerFactory.getLogger(MyConnectorConfig.class);
	
	public static ConfigDef config = myConfigDef();

	public MyConnectorConfig(Map<?, ?> originals) {
		super(myConfigDef(), originals);
		log.info("[+TOTO] ================== Initialize Connector properties");
		log.info("[+TOTO] originals: " + originals);
		log.info("[+TOTO] ================== Initialize Connector properties");
	}

	protected static ConfigDef myConfigDef() {
		return new ConfigDef()
				.define("bucket", ConfigDef.Type.STRING, ConfigDef.Importance.HIGH,	"Name of the bucket to import objects from")
				.define("prefix.whitelist", ConfigDef.Type.LIST, ConfigDef.Importance.HIGH, "Whitelist of object key prefixes")
				.define("topic", ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "myTopic")
				.define(MyConfig.KAFKA_TOPIC, ConfigDef.Type.STRING, ConfigDef.Importance.MEDIUM, "myTopic");
	}
}