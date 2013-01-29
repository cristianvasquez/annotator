package vub.annotator.web.pojo;

import java.util.Arrays;
import java.util.List;


/**
 * {
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
 * @author cvasquez
 *
 */
public class SearchResult {
   	private String total;
   	private List<Annotation> rows;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Annotation> getRows() {
		return rows;
	}
	public void setRows(List<Annotation> rows) {
		this.rows = rows;
	}
	
	public static SearchResult getMockObject(){
	    SearchResult result = new SearchResult();
	    result.setRows(Arrays.asList(Annotation.getMockObject()));
	    result.setTotal("1");
	    return result;
	}
}