package cn.com.hystrix.bidinfo.elasticsearch;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchListener {

    @Autowired
    private RestHighLevelClient client;

    @KafkaListener(topics = "scrapy")
    public void listen(String content) {
        IndexRequest request = new IndexRequest("scrapy", "biding");
        request.source(content,  XContentType.JSON);
        client.indexAsync(request, new ActionListener<IndexResponse>() {

            @Override
            public void onResponse(IndexResponse indexResponse) {
                System.out.println("入库成功:" + indexResponse.getId());
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("入库失败:" + e.getMessage());
            }
        });

    }


}
