package com.jtmproject.server;

import com.jtmproject.actions.StringUtils;

/**
 * This class stores the IPs for connection with the server
 * @author Javier Tejedor
 */
public class ServerUrls {

	private static ServerUrls sip;
	private String ipStore = "http://www.jtmplace.com/teje"; //for tests, later set the official jtm-store url
	
	/**
	 * return an instance of ServerIPs. (Singleton Class)
	 * @return
	 */
	public static ServerUrls getSip(){
		if(sip == null){
			sip = new ServerUrls();
		}
		return sip;
	}

	/**
	 * returns the IP for connecting with the server-store
	 * @return
	 */
	public String getIpStore() {
		return ipStore;
	}

	/**
	 * sets the IP for connecting with the server-store
	 * @param ipStore
	 */
	public void setIpStore(String ipStore) {
		this.ipStore = StringUtils.filterIp(ipStore);
		CheckCorrectServer.setChecked(false);
	}
	
	/**
	 * returns the url of store jtm on the server
	 * @return
	 */
	public String getUrlJtm(){
		return ServerUrls.getSip().getIpStore() + "/files/jtm/";
	}
}
