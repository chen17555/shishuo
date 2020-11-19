package com.chenzhiheng.service.impl;

import com.chenzhiheng.service.ElasticsearchService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    @Autowired
    private TransportClient client;


    @Override
    public List goSearch(String words) {
        //创建需要搜索的inde和type
        SearchRequestBuilder requestBuilder = client.prepareSearch("sysout").setTypes("question");
        //设置搜索建议
        CompletionSuggestionBuilder completionSuggestionBuilder = new CompletionSuggestionBuilder("title.suggest")
                .prefix(words).size(10);
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
                String temp = pp.getText().toString();
                if(temp.length() > 20){
                    temp = temp.substring(0,20);
                }
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List searchByTitleOrContent(String words) {
        //建立bool查询，如果没有组合查询，直接写QueryBuilder
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        //使用should实现或者查询
        boolBuilder.must(QueryBuilders.matchQuery("title",words));

        SearchRequestBuilder searchRequestBuilder = this.client.prepareSearch("sysout")
                .setTypes("question")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH) //设置查询类型：1.SearchType.DFS_QUERY_THEN_FETCH 精确查询； 2.SearchType.SCAN 扫描查询,无序
                .setQuery(boolBuilder)
                .setFrom(0)
                .setSize(10);

        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.postTags("</span>");
        searchRequestBuilder.highlighter(highlightBuilder);
        //执行结果
        SearchResponse response = searchRequestBuilder.get();
        //接受结果
        List<Map<String,Object>> result = new ArrayList<>();
        //遍历结果
        for(SearchHit hit:response.getHits()){
            Map<String, Object> source = hit.getSource();
            //处理高亮片段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField nameField = highlightFields.get("title");
            if(nameField!=null){
                Text[] fragments = nameField.fragments();
                String nameTmp ="";
                for(Text text:fragments){
                    nameTmp+=text;
                }
                //将高亮片段组装到结果中去
                source.put("title",nameTmp);
            }
            result.add(source);
        }
        return result;
    }
}
