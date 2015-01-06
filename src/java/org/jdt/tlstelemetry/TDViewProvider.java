/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdt.tlstelemetry;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
/**
 *
 * @author wgoulet
 */
public class TDViewProvider {
	private String tdrecord;
	private Vector<TDViewRecord> tdelements;


	public TDViewProvider()
	{
		tdrecord = new String("InitialTest");
		tdelements = new Vector<TDViewRecord>();
	}

	public Vector<TDViewRecord> getTDelements()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TLSTelemetryServerPU");
                EntityManager em = emf.createEntityManager();
		Query qry = em.createNativeQuery("select * from tdbackingstore",TDBackingStore.class);
	
		List<TDBackingStore> results = qry.getResultList();

		for(TDBackingStore td : results)
		{
			TDViewRecord rec = new TDViewRecord();
			rec.setCipherSuite(td.getCipherSuite());
			rec.setProtocol(td.getProtocol());
			rec.setClientaddress(td.getClientaddress());
			rec.setClientport(td.getClientport());
			try{
				for(byte[] certdata : td.getCertData())
				{
					CertificateFactory fc = CertificateFactory.getInstance("X509");
					ByteArrayInputStream io = new ByteArrayInputStream(certdata);
					X509Certificate cert = (X509Certificate)fc.generateCertificate(io);
					rec.setIssuer(cert.getIssuerDN().toString());
					rec.setSubject(cert.getSubjectDN().toString());
					rec.setSigalg(cert.getSigAlgName());
				}
			}
			catch(Exception e)
			{
				tdrecord = "Error";
			}
			tdelements.add(rec);
			
		}

		return tdelements;
	}
		

	public void setTDRecord(String s)
	{
		this.tdrecord = s;
	}

	public String getTDRecord()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TLSTelemetryServerPU");
                EntityManager em = emf.createEntityManager();
		Query qry = em.createNativeQuery("select * from tdbackingstore",TDBackingStore.class);
	
		List<TDBackingStore> results = qry.getResultList();

		for(TDBackingStore td : results)
		{
			tdrecord += td.getCipherSuite();
			try{
				for(byte[] certdata : td.getCertData())
				{
					CertificateFactory fc = CertificateFactory.getInstance("X509");
					ByteArrayInputStream io = new ByteArrayInputStream(certdata);
					X509Certificate cert = (X509Certificate)fc.generateCertificate(io);
					tdrecord += cert.getIssuerDN().toString();
				}
			}
			catch(Exception e)
			{
				tdrecord = "Error";
			}
			
		}


		return tdrecord;
	}

	
}
