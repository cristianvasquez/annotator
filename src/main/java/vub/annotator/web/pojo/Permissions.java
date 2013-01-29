package vub.annotator.web.pojo;

import java.util.List;

public class Permissions{
   	private List<String> admin;
   	private List<String> delete;
   	private List<String> read;
   	private List<String> update;

 	public List<String> getAdmin(){
		return this.admin;
	}
	public void setAdmin(List<String> admin){
		this.admin = admin;
	}
 	public List<String> getDelete(){
		return this.delete;
	}
	public void setDelete(List<String> delete){
		this.delete = delete;
	}
 	public List<String> getRead(){
		return this.read;
	}
	public void setRead(List<String> read){
		this.read = read;
	}
 	public List<String> getUpdate(){
		return this.update;
	}
	public void setUpdate(List<String> update){
		this.update = update;
	}
}