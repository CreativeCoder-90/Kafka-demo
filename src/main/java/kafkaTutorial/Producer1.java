package kafkaTutorial;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer1 {
    public static void main(String[] args) {
        //creating producer properties
        String bootstrapServers = "127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //creating the producer
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        //writing data(record) into producer
        ProducerRecord<String,String> record =  new ProducerRecord<String, String>("my_message", "Hello kafka");
        //here 'my_message' is the topic name and 'Hello kafka' is the topic name

        //sending the data
        producer.send(record);
        producer.flush();
        producer.close();

    }
}
