package toto.kafka.springboot.custom.sink;

import org.apache.kafka.connect.sink.SinkRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySinkSender {

	private static final Logger log = LoggerFactory.getLogger(MySinkSender.class);

	public void sendRecord(SinkRecord record) {
		try {
			log.info("[+TOTO] ================== start(Map<String, String> props)");
			log.info("[+TOTO] ================== Processed record details, topic: {}, Partition: {}, " + "Offset: {}",
					record.topic(), record.kafkaPartition(), record.kafkaOffset());
		} catch (Exception e) {
			log.info("[+TOTO] ================== Encountered exception in record processing....discarded."
					+ " Cause: {}, Stacktrace: {} ", e.getCause(), e.getStackTrace());
			return;
		}
	}
}
