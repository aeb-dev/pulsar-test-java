package org.apache.pulsar.testclient;

import java.io.IOException;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;

public class SampleProducer {
    public static void main(String[] args) throws InterruptedException, IOException {
        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://pulsar-broker:6650").build();

        Producer<byte[]> producer = client.newProducer().topic("non-persistent://test/mw/horizon").create();

        byte[] array = new byte[750];
        while(true) {
            producer.sendAsync(array);
        }
    }
}