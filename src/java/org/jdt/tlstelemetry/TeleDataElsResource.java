/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdt.tlstelemetry;


import com.google.gson.Gson;
import java.security.SecureRandom;
import org.jdt.TDObject;
import java.security.cert.Certificate;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import java.util.Random;

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TLSTelemetryServerPU");
                EntityManager em = emf.createEntityManager();
		TDBackingStore td = new TDBackingStore();
		
		// Replace with better ID generator later
		SecureRandom rnd = new SecureRandom();
		td.setId(rnd.nextLong());
		td.setCipherSuite(obj.getCipher());
		td.setProtocol(obj.getProtocol());
		td.setClientname(obj.getClientname());
		for(byte[] certdata : obj.getCertData())
		{
			td.addCertData(certdata);
		}
		em.getTransaction().begin();
		em.persist(td);
		em.getTransaction().commit();

		return Response.created(context.getAbsolutePath()).build();
	}

}
