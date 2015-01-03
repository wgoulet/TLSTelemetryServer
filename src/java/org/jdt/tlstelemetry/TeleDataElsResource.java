/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdt.tlstelemetry;


import com.google.gson.Gson;
import org.jdt.TDObject;
import java.security.cert.Certificate;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

/**
 * REST Web Service
 *
 * @author wgoulet
 */
@Path("/tde")
public class TeleDataElsResource {

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of TeleDataElsResource
	 */
	public TeleDataElsResource() {
	}

	/**
	 * Retrieves representation of an instance of org.jdt.tlstelemetry.TeleDataElsResource
	 * @return an instance of java.lang.String
	 */
	@GET
        @Produces("application/json")
	public String getJson() {
		//TODO return proper representation object
		throw new UnsupportedOperationException();
	}

	/**
	 * POST method for creating an instance of TeleDataResource
	 * @param content representation for the new resource
	 * @return an HTTP response with content of the created resource
	 */
	@POST
        @Consumes("application/json")
        @Produces("application/json")
	public Response postJson(String content) {
		Gson gson = new Gson();
		TDObject obj = gson.fromJson(content, TDObject.class);

		return Response.created(context.getAbsolutePath()).build();
	}

	/**
	 * Sub-resource locator method for {id}
	 */
	@Path("{id}")
	public TeleDataResource getTeleDataResource(@PathParam("id") String id) {
		return TeleDataResource.getInstance(id);
	}
}
