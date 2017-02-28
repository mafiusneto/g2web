package br.com.g2soft.g2web.util;

public final class Constants {

	public static final String SLASH = "/";
	
	public static final String CLIENT_ID = SLASH + "{clientId}";
	public static final String COMPANY_ID = SLASH + "{companyId}";
	public static final String COUNTER_ID = SLASH + "{counterId}";
	
	/* Client */
	public static final String URL_CLIENT = SLASH + "client";
	public static final String URL_ADDRESS = SLASH + "address";
	public static final String URL_BUNCH = SLASH + "bunch";
	public static final String URL_CLIENT_ADDRESS = CLIENT_ID + URL_ADDRESS;
	public static final String URL_CLIENT_BUNCH = CLIENT_ID + URL_BUNCH;
	
	/* Company */
	public static final String URL_COMPANY = SLASH + "company";
	public static final String URL_COMPANY_ADDRESS = COMPANY_ID + URL_ADDRESS;
	
	/* Counter */
	public static final String URL_COUNTER = SLASH + "counter";
	public static final String URL_COUNTER_ADDRESS = COUNTER_ID + URL_ADDRESS;
	
	public Constants(){		
	}
}
