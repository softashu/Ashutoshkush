package ashu.poc.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.json.simple.JSONObject;

public class JsonObjectMessageBodyWriter implements MessageBodyWriter<JSONObject> {

	@Override
	public long getSize(JSONObject jsonObject, Class<?> arg1, Type type, Annotation[] annotations,
			MediaType mediaType) {
		return jsonObject.size();
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type type, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeTo(JSONObject arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream arg6) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
	}

}
