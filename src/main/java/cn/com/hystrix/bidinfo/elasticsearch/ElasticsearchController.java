package cn.com.hystrix.bidinfo.elasticsearch;


import cn.com.hystrix.bidinfo.market.BidedNotice;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

@RestController
public class ElasticsearchController {

    @Autowired
    private RestHighLevelClient client;


    @GetMapping(value = "/market/bided")
    public Page<BidedNotice> search(@PageableDefault Pageable pageable) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(pageable.getOffset());
        searchSourceBuilder.size(pageable.getPageSize());
        SearchRequest request = new SearchRequest("scrapy");
        request.types("biding");
        request.source(searchSourceBuilder);
        List<BidedNotice> bidedNoticeList = new ArrayList<>();
        long total = 0;
        try {
            SearchResponse response = client.search(request);
            total = response.getHits().getTotalHits();
            response.getHits().forEach(hit -> {
                Map<String, Object> map = hit.getSourceAsMap();
                BidedNotice bidedNotice = new BidedNotice();
                try {
                    copyProperties(bidedNotice, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                bidedNoticeList.add(bidedNotice);

            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        Page<BidedNotice> page = new PageImpl<>(bidedNoticeList, pageable, total);
        return page;


    }


}
