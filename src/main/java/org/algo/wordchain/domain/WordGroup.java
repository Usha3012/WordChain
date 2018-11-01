package org.algo.wordchain.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WordGroup {
	private List<String> group;
	private int size;
    public WordGroup(List<String> group,int size){
    	this.group=group;
    	this.size=size;
    }
	
	public List<String> getGroup() {
		return group;
	}
	public void setGroup(List<String> group) {
		this.group = group;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String lastAddedWord(){
		return Optional.ofNullable(group.get(getSize()-1))
		        .get(); 
	            
	}
}