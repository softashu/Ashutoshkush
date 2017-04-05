package ashu.poc.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

@Path("UnifiedApi")
public class UnifiedRestApi {

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response responseMsg(@HeaderParam("Content-Type") String streamType, @HeaderParam("Accept") String accept,
			final InputStream jsonStream) throws UnsupportedEncodingException, IOException, ParseException {

		Response response = null;
		// convert json/xml stream into JSON java object.
		final JSONParser jsonParser = new JSONParser();
		if (streamType.equals(MediaType.APPLICATION_XML)) {
			final String xml = IOUtils.toString(jsonStream, StandardCharsets.UTF_8);
			final JSON json = (JSON) new XMLSerializer().read(xml);
			response = Response.status(200).entity(json.toString()).build();
		} else if (streamType.equals(MediaType.APPLICATION_JSON)) {
			final JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new InputStreamReader(jsonStream, StandardCharsets.UTF_8));
			// now we have to convert it to our Entity
			response = Response.status(200).entity(jsonObject.toJSONString()).build();
		}
		return response;
	}

}
