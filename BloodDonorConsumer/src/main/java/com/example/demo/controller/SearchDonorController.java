package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchDonorController {

	@Autowired
	public RestTemplate template;
	
	@Autowired
	public LoadBalancerClient balancedClient;
	
	@GetMapping("/findDonor/{bloodGroup}")
	public String searchDonor(@PathVariable String bloodGroup) {
		ServiceInstance instance = balancedClient.choose("search-blooddonor-service");
		
		System.out.println(instance.getUri());
		String baseUrl = instance.getUri().toString();
		baseUrl = baseUrl + "/search/" + bloodGroup;
		String response = template.getForObject(baseUrl, String.class);
		return response;
	}
	//When this service is called in different tabs, we can see IP addresses listed in console.
//	2019-03-15 10:56:10.571  INFO 31512 --- [nio-4030-exec-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client: search-blooddonor-service instantiated a LoadBalancer: DynamicServerListLoadBalancer:{NFLoadBalancer:name=search-blooddonor-service,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
//	2019-03-15 10:56:10.576  INFO 31512 --- [nio-4030-exec-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
//	2019-03-15 10:56:10.593  INFO 31512 --- [nio-4030-exec-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: search-blooddonor-service.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
//	2019-03-15 10:56:10.595  INFO 31512 --- [nio-4030-exec-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client search-blooddonor-service initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=search-blooddonor-service,current list of Servers=[192.168.20.46:53454, 192.168.20.46:53394, 192.168.20.46:53334],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:3;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
//	},Server stats: [[Server:192.168.20.46:53454;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
//	, [Server:192.168.20.46:53394;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
//	, [Server:192.168.20.46:53334;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@18ab350b
//	http://192.168.20.46:53454
//	2019-03-15 10:56:11.581  INFO 31512 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: search-blooddonor-service.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
//	http://192.168.20.46:53394
//	http://192.168.20.46:53334
}
