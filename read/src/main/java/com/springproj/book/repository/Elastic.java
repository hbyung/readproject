package com.springproj.book.repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class Elastic {
	
	String hostname = "localhost";
	int port = 9200;
	HttpHost host = new HttpHost(hostname, port);
	RestClientBuilder restClientBuilder = RestClient.builder(host);
	RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
	
	public List<Map<String,Object>> simpleSearch(String index, Map<String,Object> query, Map<String,SortOrder> sort){
		
		// search에 index 조건 걸기
		SearchRequest searchRequest = new SearchRequest(index);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		
		// query에 있는 셋 쿼리 조건으로 걸기
		for(String key : query.keySet()) {

			searchSourceBuilder.query(QueryBuilders.matchQuery(key, query.get(key)));

		}
		
		// sort 에 있는 셋을 정렬 조건으로 걸기
		for(String key : sort.keySet()) {
			searchSourceBuilder.sort(new FieldSortBuilder(key).order(sort.get(key)));
		}
			
		searchRequest.source(searchSourceBuilder);
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		try(RestHighLevelClient client = new RestHighLevelClient(restClientBuilder)) {
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			SearchHits searchHits = response.getHits();
			for(SearchHit hit : searchHits) {
				Map<String, Object> sourceMap = hit.getSourceAsMap();
				list.add(sourceMap);
			}
		} catch (IOException e) {}
		
		return list;
		
	}
	
	public Map<String,Object> getReponse(String index, String id){
		
		GetResponse response = null; 
		
		GetRequest getRequest = new GetRequest(index, id);
		RequestOptions options = RequestOptions.DEFAULT;
		try (RestHighLevelClient client = new RestHighLevelClient(restClientBuilder)) {
			response = client.get(getRequest, options);
		} catch (IOException e) {}
		
		return response.getSourceAsMap();
	}
	
	 
	
	
}