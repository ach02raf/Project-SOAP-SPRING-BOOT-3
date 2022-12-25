package com.example.consumingwebservices.consumingwebservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.ws.ip2geo.*;

public class ipClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ipClient.class);

    public ResolveIPResponse getClientIp(String ip) {
        ResolveIP request = new ResolveIP();
        request.setIpAddress(ip);
        request.setLicenseKey("free");
        log.info("Requesting location for " + ip);
        ResolveIPResponse information = (ResolveIPResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://ws.cdyne.com/ip2geo/ip2geo.asmx", request,
                        new SoapActionCallback(
                                "http://ws.cdyne.com/ResolveIP"));

        log.info("info =", information.getResolveIPResult().toString());

        return information;
    }
}
