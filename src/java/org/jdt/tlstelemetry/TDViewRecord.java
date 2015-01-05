/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdt.tlstelemetry;

/**
 *
 * @author wgoulet
 */
public class TDViewRecord {
	private String cipherSuite;
	private String protocol;
	private String issuer;
	private String subject;
	private String keysize;
	private String sigalg;
	private String clientname;

	/**
	 * @return the cipherSuite
	 */
	public String getCipherSuite() {
		return cipherSuite;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @return the issuer
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the keysize
	 */
	public String getKeysize() {
		return keysize;
	}

	/**
	 * @param cipherSuite the cipherSuite to set
	 */
	public void setCipherSuite(String cipherSuite) {
		this.cipherSuite = cipherSuite;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @param issuer the issuer to set
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param keysize the keysize to set
	 */
	public void setKeysize(String keysize) {
		this.keysize = keysize;
	}

	/**
	 * @return the sigalg
	 */
	public String getSigalg() {
		return sigalg;
	}

	/**
	 * @param sigalg the sigalg to set
	 */
	public void setSigalg(String sigalg) {
		this.sigalg = sigalg;
	}

	/**
	 * @return the clientname
	 */
	public String getClientname() {
		return clientname;
	}

	/**
	 * @param clientname the clientname to set
	 */
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	
}
