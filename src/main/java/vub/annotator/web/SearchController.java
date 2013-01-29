package vub.annotator.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vub.annotator.web.pojo.SearchResult;

@Component
@RequestMapping("/search")
public class SearchController   {

	private static final Logger logger = Logger.getLogger(SearchController.class);	
	
	/**
	search
	method: GET
	path: /search?text=foobar
	returns: an object with total and rows fields. total is an integer denoting the total number of annotations matched by the search, while rows is a list containing what might be a subset of these annotations.
	If implemented, this method should also support the limit and offset query parameters for paging through results.
	$ curl http://example.com/api/search?text=annotation
	{
	  "total": 43127,
	  "rows": [
	    {
	      "id": "d41d8cd98f00b204e9800998ecf8427e",
	      "text": "Updated annotation text",
	      ...
	    },
	    ...
	  ]
	}
	*/
	@RequestMapping(method = RequestMethod.GET, value = "" )
	public @ResponseBody SearchResult search( @RequestParam String limit, @RequestParam String uri ){
		logger.debug("search limit:"+limit+" uri:"+uri);
		return SearchResult.getMockObject();
	}

}