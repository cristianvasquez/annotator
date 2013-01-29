package vub.annotator.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//@Component
//@RequestMapping("/")
public class Root   {

	/**
	 * Why URIQA is a constant?
	 * 
	 * It is not recommended to dynamically prepare the URL at run time, 
	 * especially based on ServletRequest. This is primarily because 
	 * you have no idea of the URL that users would be using to access the application - 
	 * the application server could be behind a web server, a firewall or a load balancer. 
	 */
	public static String URIQA = "http://localhost:8080/annotator/api";
	private static final Logger logger = Logger.getLogger(Root.class);	
	
	/**
	root
	method: GET
	path: /
	returns: object containing store metadata, including API version
	Example:

	$ curl http://example.com/api/
	{
	  "name": "Annotator Store API",
	  "version": "2.0.0"
	}
	 */
	@RequestMapping(method = RequestMethod.GET, value = "" )
	public @ResponseBody Map<String, String> root(){
		logger.debug("GET: root");
		Map<String, String> result = new HashMap<String, String>();
		result.put("name", "Annotator Store API");
		result.put("version", "2.0.0");
		return result;	
	}

}