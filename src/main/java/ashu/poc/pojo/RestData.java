package ashu.poc.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

@XmlRootElement
public class RestData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1397087532570385641L;
	private String name;
	private long timestamp;
	private final Map<String, Object> other = new HashMap<String, Object>();

	public RestData() {
	}

	@JsonAnyGetter
	public Map<String, Object> any() {
		return other;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		other.put(name, value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
