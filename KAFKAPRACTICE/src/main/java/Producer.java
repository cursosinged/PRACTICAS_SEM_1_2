import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class Producer {


 /*   public static void main(String[] args) {

        Properties properties= new Properties();

       // properties.setProperty("boostrap.servers","localhost:9092");
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");

        properties.setProperty("key.serializers",String.class.getName());


    }
*/
    public static void main(String[] args) throws InterruptedException {
        String bootstrapServers = "localhost:9092"; // "127.0.0.1:9092";
        Thread.sleep(100);


        // Creating Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // properties.setProperty("bootstrap.servers", bootstrapServers);

        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // properties.setProperty("key.serializer", StringSerializer.class.getName());

        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // properties.setProperty("value.serializer", StringSerializer.class.getName());

        // Creating Producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a producer record
        for(int i=0; i<10; i++) {  //Loops de inserción
String key_id="key_"+i;
            try {

                ProducerRecord<String, String> record = new ProducerRecord<>("topic_baz_1",key_id ,"Testing Message! " + i);
                Thread.sleep(2000);
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {

                        System.out.println("--- IMPRIMIENDO RESULTADO ----");
                        System.out.println(recordMetadata.topic());
                        System.out.println(recordMetadata.offset());
                        System.out.println(recordMetadata.partition());

                    }
                });

            }
            catch(InterruptedException e)
            {
                    e.getLocalizedMessage();

            }

        }

        producer.flush(); // wait for data to send the data
        producer.close(); // flush and close producer

    }
}
