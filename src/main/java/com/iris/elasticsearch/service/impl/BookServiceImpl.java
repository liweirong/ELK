package com.iris.elasticsearch.service.impl;

/**
 * @author iris
 * @date 2019/6/24
 */

import com.iris.elasticsearch.model.BookBean;
import com.iris.elasticsearch.service.BookService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {



    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public Object search() {
        QueryBuilder moreLikeThisQuery = null;
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10000);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<Object> list = new ArrayList<>();
        if (searchHits.length > 0) {
            for (SearchHit hit : searchHits) {
                list.add(hit.getSourceAsMap());
            }
        }
        return list;

    }


}

