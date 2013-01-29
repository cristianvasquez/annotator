package vub.annotator.web.pojo;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
{
	    "id": "39fc339cf058bd22176771b3e3187329",  # unique id (added by backend)
	    "annotator_schema_version": "v1.0",        # schema version: default v1.0
	    "created": "2011-05-24T18:52:08.036814",   # created datetime in iso8601 format (added by backend)
	    "updated": "2011-05-26T12:17:05.012544",   # updated datetime in iso8601 format (added by backend)
	    "text": "A note I wrote",                  # content of annotation
	    "quote": "the text that was annotated",    # the annotated text (added by frontend)
	    "uri": "http://example.com",               # URI of annotated document (added by frontend)
	    "ranges": [                                # list of ranges covered by annotation (usually only one entry)
	      {
	        "start": "/p[69]/span/span",           # (relative) XPath to start element
	        "end": "/p[70]/span/span",             # (relative) XPath to end element
	        "startOffset": 0,                      # character offset within start element
	        "endOffset": 120                       # character offset within end element
	      }
	    ],
	    "user": "alice",                           # user id of annotation owner (can also be an object with an 'id' property)
	    "consumer": "annotateit",                  # consumer key of backend
	    "tags": [ "review", "error" ],             # list of tags (from Tags plugin)
	    "permissions": {                           # annotation permissions (from Permissions/AnnotateItPermissions plugin)
	      "read": ["group:__world__"],
	      "admin": [],
	      "update": [],
	      "delete": []
	    }
	  }
	  */


public class Annotation{

	private String id;
   	private Permissions permissions;
   	private String quote;
   	private List<Ranges> ranges;
   	private List<String> tags;
   	private String text;
   	private String uri;
   	private String user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
 	public Permissions getPermissions(){
		return this.permissions;
	}
	public void setPermissions(Permissions permissions){
		this.permissions = permissions;
	}
 	public String getQuote(){
		return this.quote;
	}
	public void setQuote(String quote){
		this.quote = quote;
	}
 	public List<Ranges> getRanges(){
		return this.ranges;
	}
	public void setRanges(List<Ranges> ranges){
		this.ranges = ranges;
	}
 	public List<String> getTags(){
		return this.tags;
	}
	public void setTags(List<String> tags){
		this.tags = tags;
	}
 	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
 	public String getUri(){
		return this.uri;
	}
	public void setUri(String uri){
		this.uri = uri;
	}
 	public String getUser(){
		return this.user;
	}
	public void setUser(String user){
		this.user = user;
	}
	
	public static String getMockString(){
		return "{\"permissions\":{\"read\":[],\"update\":[],\"delete\":[],\"admin\":[]},\"user\":\"Cristian\",\"text\":\"sdfsdfsdfsdf\",\"tags\":[],\"ranges\":[{\"start\":\"/p[1]\",\"startOffset\":725,\"end\":\"/p[2]\",\"endOffset\":0}],\"quote\":\"escriptions.\",\"uri\":\"http://this/document/only\"}";
	}

	public static Annotation getMockObject(){
	    ObjectMapper mapper = new ObjectMapper();
	    Annotation annotation = null;
		try {
			annotation = mapper.readValue(new StringReader(getMockString()), Annotation.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return annotation;
	}

}