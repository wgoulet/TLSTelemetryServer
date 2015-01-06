/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdt.tlstelemetry;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Vector;

/**
 *
 * @author wgoulet
 */
@Entity
public class TDBackingStore implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ciphersuite;
	private String protocol;
	private String clientaddress;
	private int clientport;
	private Vector<byte[]> certdata;

	public TDBackingStore()
	{
		certdata = new Vector<byte[]>();
	}

	public String getProtocol()
	{
		return protocol;
	}

	public void setProtocol(String p)
	{
		this.protocol = p;
	}

	public String getCipherSuite()
	{
		return ciphersuite;
	}

	public void setCipherSuite(String c)
	{
		this.ciphersuite = c;
	}

	public Vector<byte[]> getCertData()
	{
		return certdata;
	}

	public void addCertData(byte[] data)
	{
		this.certdata.add(data);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TDBackingStore)) {
			return false;
		}
		TDBackingStore other = (TDBackingStore) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.jdt.tlstelemetry.TDBackingStore[ id=" + id + " ]";
	}

	/**
	 * @return the clientaddress
	 */
	public String getClientaddress() {
		return clientaddress;
	}

	/**
	 * @param clientaddress the clientaddress to set
	 */
	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}

	/**
	 * @return the clientport
	 */
	public int getClientport() {
		return clientport;
	}

	/**
	 * @param clientport the clientport to set
	 */
	public void setClientport(int clientport) {
		this.clientport = clientport;
	}
	
}
