package eu.socialsensor.framework.common.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaCluster implements JSONable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7926531925761955502L;


	public MediaCluster(String id) {
		this.id = id;
	}
	
	// Unique id of a Media cluster
	@Expose
	@SerializedName(value = "id")
	private String id;
		
	@Expose
	@SerializedName(value = "members")
	private Set<String> members = new HashSet<String>();
	
	@Expose
	@SerializedName(value = "count")
	private int count = 0;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Set<String> getMembers() {
        return members;
    }

    public void addMembers(Set<String> members) {
        this.members.addAll(members);
        this.count = this.members.size();
    }
    
    public void addMember(String member) {
        this.members.add(member);
        this.count = this.members.size();
    }
    
    public int getCount() {
        return count;
    }
    
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.create();
    	return gson.toJson(this);
	}
	
}
