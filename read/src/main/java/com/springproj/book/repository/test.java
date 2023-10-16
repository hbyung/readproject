package com.springproj.book.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.sort.SortOrder;

public class test {
  public static void main(String[] args) throws IOException {
		
		Elastic elastic1 = new Elastic();
		
		String index = "book";
		
		Map<String,Object> query = new HashMap<>();
		query.put("title","위대한");
		
		Map<String,SortOrder> sort = new HashMap<>();
		Map<String, Object> searchdate = null;
		Object summary = null;
		BookVO vo = new BookVO();
	
		List<Map<String, Object>> list = elastic1.simpleSearch(index, query, sort);
		for(Map<String, Object> map : list) {
			System.out.println(map);
			searchdate = map;
			
		}
		
	}

}



