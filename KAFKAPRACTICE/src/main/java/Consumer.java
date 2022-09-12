import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.w3c.dom.ls.LSException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        String bootstrapServers = "127.0.0.1:9092";
        String groupId = "baz-kafka-app2";
        String topic = "topic_baz_1";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
      //  properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //earliest, latest, none

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer(properties);

        kafkaConsumer.subscribe(Collections.singleton(topic));

        int posicionPaticion;
        List<RecordValues> par=new ArrayList<RecordValues>();
        List<RecordValues> impar=new ArrayList<>();
        RecordValues recordValues;
        while(true) {
            // recuperar datos
            for (ConsumerRecord record : kafkaConsumer.poll(Duration.ofMillis(100))) {
                posicionPaticion= record.partition();
                String key_id;

                if(posicionPaticion%2 ==0)
                {
                    key_id="1_K";
                //    recordValues = new RecordValues(record.key(),record.value(),record.offset(),record.partition());
                 //   par.add(recordValues)
                      System.out.println("KEY_" + key_id);//record.key());
                    System.out.println("VAL_" + record.value());
                    System.out.println("OFFSET_" + record.offset());
                    System.out.println("PARTITION_" + record.partition());
                    System.out.println("-----------");



                }

                else
                {
                    key_id="2_K";

                 //   recordValues = new RecordValues(record.key().toString(),record.value().toString(),record.offset(),record.partition());
                  //  impar.add(recordValues);


                    System.out.println("KEY_" + key_id);//record.key());
                    System.out.println("VAL_" + record.value());
                    System.out.println("OFFSET_" + record.offset());
                    System.out.println("PARTITION_" + record.partition());
                    System.out.println("-----------");


                }



            }

        }

    }
}