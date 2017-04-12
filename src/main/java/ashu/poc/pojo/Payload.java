package ashu.poc.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Payload implements Serializable {

	/**
	 * SVID
	 */
	private static final long serialVersionUID = 8158595572869730988L;
	private final Map<String, Object> other = new HashMap<String, Object>();

	public Map<String, Object> any() {
		return other;
	}

	public void set(final String name, final Object value) {
		other.put(name, value);
	}

	public Map<String, Object> getOther() {
		return other;
	}
}