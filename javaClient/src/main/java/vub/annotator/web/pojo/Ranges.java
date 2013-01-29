
package vub.annotator.web.pojo;

import java.util.List;

public class Ranges{
   	private String end;
   	private Number endOffset;
   	private String start;
   	private Number startOffset;

 	public String getEnd(){
		return this.end;
	}
	public void setEnd(String end){
		this.end = end;
	}
 	public Number getEndOffset(){
		return this.endOffset;
	}
	public void setEndOffset(Number endOffset){
		this.endOffset = endOffset;
	}
 	public String getStart(){
		return this.start;
	}
	public void setStart(String start){
		this.start = start;
	}
 	public Number getStartOffset(){
		return this.startOffset;
	}
	public void setStartOffset(Number startOffset){
		this.startOffset = startOffset;
	}
}
