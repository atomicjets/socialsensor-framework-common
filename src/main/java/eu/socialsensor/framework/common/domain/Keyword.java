
package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

/**
 * @author etzoannos - e.tzoannos@atc.gr
 */

public class Keyword implements JSONable {
	
	@Expose
	@SerializedName(value = "keyword")
	private String keyword;
	 
	@Expose
	@SerializedName(value = "score")
	private float score;

	public Keyword() {        
	 
	}
    
	public Keyword(String keyword, float score) {
		this.keyword = keyword;
		this.score = score;
	}
	
	public String getName() {
		return keyword;
	}

	public void setName(String keyword) {
		this.keyword = keyword;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
        	.create();
		return gson.toJson(this);
	}  

}
