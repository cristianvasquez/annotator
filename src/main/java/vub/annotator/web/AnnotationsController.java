package vub.annotator.web;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vub.annotator.web.pojo.Annotation;

@Component
@RequestMapping("/annotations")
public class AnnotationsController   {

	private static final Logger logger = Logger.getLogger(AnnotationsController.class);	
	
//	@Autowired
//	ServletContext context;
	
	/**
	index
	method: GET
	path: /annotations
	returns: a list of all annotation objects
	Example (see Annotation Format for details of the format of individual annotations):

	$ curl http://example.com/api/annotations
	[
	  {
	    "text": "Example annotation text",
	    "ranges": [ ... ],
	    ...
	  },
	  {
	    "text": "Another annotation",
	    "ranges": [ ... ],
	    ... 
	  },
	  ...
	]
	*/ 
	@RequestMapping(method = RequestMethod.GET, value = "" )
	@ResponseBody List<Annotation> index(){
		logger.debug("GET index");
		return Arrays.asList(Annotation.getMockObject());
	}
	
	/**
	create
	method: POST
	path: /annotations
	receives: an annotation object, sent with Content-Type: application/json
	returns: 303 SEE OTHER redirect to the appropriate read endpoint
	Example:

	$ curl -i -X POST \
	       -H 'Content-Type: application/json' \
	       -d '{"text": "Annotation text"}' \
	       http://example.com/api/annotations
	HTTP/1.0 303 SEE OTHER
	Location: http://example.com/api/annotations/d41d8cd98f00b204e9800998ecf8427e
	...
	*/ 
	@RequestMapping(method = RequestMethod.POST, value = "" )
	public ResponseEntity<Void> createAnnotation( @RequestBody String input ) {
	    logger.debug("POST createAnnotation");		
	    ObjectMapper mapper = new ObjectMapper();
	    Annotation annotation;
		try {
			annotation = mapper.readValue(new StringReader(input), Annotation.class);
		    logger.debug("In:"+ToStringBuilder.reflectionToString(annotation));		
		} catch (Exception e) {
			// TODO Handle each case Separately
			
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Location", Root.URIQA+"/annotations/"+"mockId");
		return new ResponseEntity<Void>(responseHeaders,HttpStatus.SEE_OTHER);	
	}
	
	/**
	read
	method: GET
	path: /annotations/<id>
	returns: an annotation object
	Example:

	$ curl http://example.com/api/annotations/d41d8cd98f00b204e9800998ecf8427e
	{
	  "id": "d41d8cd98f00b204e9800998ecf8427e",
	  "text": "Annotation text",
	  ...
	} 
	*/ 
	@RequestMapping(method = RequestMethod.GET, value = "/{id}" )
	public @ResponseBody Annotation read( @PathVariable String id ){
		Annotation result = Annotation.getMockObject();
		result.setId(id);
	    logger.debug("GET annotation:"+ToStringBuilder.reflectionToString(result));		
	    return result;
	}
	
	/**
	update
	method: PUT
	path: /annotations/<id>
	receives: a (partial) annotation object, sent with Content-Type: application/json
	returns: 303 SEE OTHER redirect to the appropriate read endpoint
	Example:

	$ curl -i -X PUT \
	       -H 'Content-Type: application/json' \
	       -d '{"text": "Updated annotation text"}' \
	       http://example.com/api/annotations/d41d8cd98f00b204e9800998ecf8427e
	HTTP/1.0 303 SEE OTHER
	Location: http://example.com/api/annotations/d41d8cd98f00b204e9800998ecf8427e
	...
	*/ 
	@RequestMapping(method = RequestMethod.PUT, value = "" )
	ResponseEntity<Void> update( @RequestBody String input ){
		 ObjectMapper mapper = new ObjectMapper();
		    Annotation annotation;
			try {
				annotation = mapper.readValue(new StringReader(input), Annotation.class);
			    logger.debug("Received annotation:"+ToStringBuilder.reflectionToString(annotation));		
			} catch (Exception e) {
				// TODO Handle each case Separately
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Location", Root.URIQA+"/annotations/"+annotation.getId());
			return new ResponseEntity<Void>(responseHeaders,HttpStatus.SEE_OTHER);	
	} 

	/**	
	delete
	method: DELETE
	path: /annotations/<id>
	returns: 204 NO CONTENT, and -- obviously -- no content
	$ curl -i -X DELETE http://example.com/api/annotations/d41d8cd98f00b204e9800998ecf8427e
	HTTP/1.0 204 NO CONTENT
	Content-Length: 0
	Search API
	You may also choose to implement a search API, which can be used by the Store plugin's loadFromSearch configuration option.
	*/ 
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}" )
	ResponseEntity<Void> delete( @PathVariable String id ){
	    logger.debug("Delete Id:"+id);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}