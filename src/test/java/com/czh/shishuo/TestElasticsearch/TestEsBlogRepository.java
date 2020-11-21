package com.czh.shishuo.TestElasticsearch;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.czh.shishuo.service.ElasticsearchService;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEsBlogRepository {

    @Autowired
    TransportClient client;

    @Autowired
    ElasticsearchService elasticsearchService;

    @Test
    public void testSearch(){
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchQuery("title","mysql"));

        SearchRequestBuilder searchRequestBuilder = this.client.prepareSearch("sysout")
                .setTypes("question")
                .setQuery(boolBuilder)
                .setFrom(0)
                .setSize(10);

        SearchResponse response = searchRequestBuilder.get();
        List<Map<String,Object>> result = new ArrayList<>();

        for(SearchHit hit:response.getHits()){
            result.add(hit.getSourceAsMap());
        }
        System.out.println(result);
    }


    @Test
    public void  Test() throws UnknownHostException {
        //返回的map，进行数据封装
        Map<String,Object> msgMap = new HashMap<String,Object>();
        //创建需要搜索的inde和type
        SearchRequestBuilder requestBuilder = client.prepareSearch("sysout").setTypes("question");
        //设置搜索建议
        CompletionSuggestionBuilder completionSuggestionBuilder = new CompletionSuggestionBuilder("title.suggest")
                .prefix("java").size(10);
        SuggestBuilder suggestBuilder = new SuggestBuilder().addSuggestion("title.suggest", completionSuggestionBuilder);

        requestBuilder.suggest(suggestBuilder);
        //进行搜索
        SearchResponse suggestResponse = requestBuilder.execute().actionGet();

        //用来处理的接受结果
        List<String> result = new ArrayList<>();

        List<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> entries = suggestResponse.getSuggest()
                .getSuggestion("title.suggest").getEntries();
        //处理结果
        for(Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> op:entries){
            List<? extends Suggest.Suggestion.Entry.Option> options = op.getOptions();
            for(Suggest.Suggestion.Entry.Option pp : options){
                result.add(pp.getText().toString());
            }
        }

        System.out.println(result);
        msgMap.put("result",result);


    }
}
