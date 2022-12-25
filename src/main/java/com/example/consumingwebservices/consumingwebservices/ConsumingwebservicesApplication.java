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
			String ip = "102.104.0.0";
			if (args.length > 0) {
				ip = args[0];
			}
			ResolveIPResponse ipResponse = ipclient.getClientIp(ip);

			System.out.println("yu:" + ipResponse.getResolveIPResult());
			IPInformation information = ipResponse.getResolveIPResult();
			System.err.println("contry name: " + information.getCountry());

		};
	}

}
