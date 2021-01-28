package com.example.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.consumer.ConsumerConfig;  
import org.apache.kafka.clients.consumer.ConsumerRecord;  
import org.apache.kafka.clients.consumer.ConsumerRecords;  
import org.apache.kafka.clients.consumer.KafkaConsumer;  
import org.apache.kafka.common.serialization.StringDeserializer; 
import java.time.Duration;  
import java.util.Arrays;  
import java.util.Collections;  
import java.util.Properties;  

@SpringBootApplication
public class KafkaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaconsumerApplication.class, args);

		String bootstrapServers="kafka:9092";  
        //String grp_id="third_app";  
		String topic="firsttopic";
		
		//Creating consumer properties  
        Properties properties=new Properties();  
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
        //properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  
        //creating consumer  
        KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(properties);  
        //Subscribing  
                consumer.subscribe(Arrays.asList(topic));  
        //polling  
        while(true){  
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));  
            for(ConsumerRecord<String,String> record: records){  
                //logger.info("Key: "+ record.key() + ", Value:" +record.value());  
				//logger.info("Partition:" + record.partition()+",Offset:"+record.offset());  
				System.out.println("Key: "+ record.key() + ", Value:" +record.value());
            }  
  
  
        }
	}

}
