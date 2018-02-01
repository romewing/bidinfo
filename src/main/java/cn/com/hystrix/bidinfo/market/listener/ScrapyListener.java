package cn.com.hystrix.bidinfo.market.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ScrapyListener {

    public void listen(String content) {
        System.out.println(content);
    }
}
