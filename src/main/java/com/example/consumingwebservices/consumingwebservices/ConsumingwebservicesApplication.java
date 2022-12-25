package com.example.consumingwebservices.consumingwebservices;

import com.example.ws.ip2geo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingwebservicesApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(ipClient ipclient) {
		return args -> {
			String ip = "104.101.127.255";
			if (args.length > 0) {
				ip = args[0];
			}
			ResolveIPResponse ipResponse = ipclient.getClientIp(ip);

			IPInformation information = ipResponse.getResolveIPResult();
			System.err.println("contry name: " + information);

		};
	}

}
