package com.cognizant.loan.service;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.loan.model.Account;
import com.cognizant.loan.model.Loan;

@Service
public class LoanService {
	List<Loan> list = new ArrayList<>();
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	LoadBalancerClient loadBalancerClient;
	public LoanService() {
		list.add(new Loan("5424325", "car", 40000, 3422, 18));
	}

	public List<Loan> getDetails() {
		return list;
	}

	/* to return the httpentity object */
	public HttpEntity<?> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	/* using the restTemplate and the discovery client 
	 * discovery client should be imported from org.springframeworkk
	 */
	public ResponseEntity<Account> getAccountUsingDiscovery()
	{
		if(discoveryClient == null)
		{
			System.out.print("it is null");
		}
		List<ServiceInstance> instances = discoveryClient.getInstances("ACCOUNT-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);
		String baseurl = serviceInstance.getUri().toString();
		baseurl += "/account/ac";
     return		restTemplate.exchange(baseurl, HttpMethod.GET,getHttpEntity(),Account.class);
     
	}
	public ResponseEntity<Account> usingLoadBalancer()
	{
		ServiceInstance choose = loadBalancerClient.choose("ACCOUNT-SERVICE");
		String baseUrl = choose.getUri().toString();
		System.out.println(baseUrl);
		baseUrl +=  "/account/ac";
		return 
				restTemplate.exchange(baseUrl,HttpMethod.GET,getHttpEntity(),Account.class);
	}
}

/*
 * using the rest template	 1. create a HTTPheader 2. setAccept or set the data
 * as the json value 3. pass the header into the newly created HTTPEntity's
 * constructor 4. pass the entity object into the resttemplate.exchange() 4.
 */
//public ResponseEntity<List<Account>> getAllAccounts(){
////get the http entity from loan service class
//
//HttpEntity<String> entity = (HttpEntity<String>)getHttpEntity();
////use the resttemplate to get the data
//
//return	restTemplate.exchange("http://account-service/account/getall",HttpMethod.GET,entity,String.class).getBody();
//
///* using feign template to get the data */
//
//
//}