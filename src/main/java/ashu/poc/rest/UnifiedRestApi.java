package ashu.poc.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("UnifiedApi")
public class UnifiedRestApi {

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response responseMsg(final InputStream jsonStream)
			throws UnsupportedEncodingException, IOException, ParseException {
		// convert json/xml stream into JSON java object.
		final JSONParser jsonParser = new JSONParser();
		final JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(jsonStream, "UTF-8"));
		// now we have to convert it to our Entity
		return Response.status(200).entity(jsonObject.toJSONString()).build();
	}

}
