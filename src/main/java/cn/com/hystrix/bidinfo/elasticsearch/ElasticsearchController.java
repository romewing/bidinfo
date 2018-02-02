package cn.com.hystrix.bidinfo.elasticsearch;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class ElasticsearchController {

    @Autowired
    private RestHighLevelClient client;


    @PostMapping(value = "/market/bided")
    @ResponseBody
    public void search(@RequestParam(defaultValue = "0") int from, @RequestParam(defaultValue = "15") int size) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        SearchRequest request = new SearchRequest("scrapy");
        request.types("biding");
        request.source(searchSourceBuilder);
        try {
            SearchResponse response = client.search(request);
            response.getHits().forEach(hit -> {
                Map<String, Object> map = hit.getSourceAsMap();

            });
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("do over");

    }


}
