package com.example.consumingwebservices.consumingwebservices;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.ws.ip2geo.*;

public class ipClient extends WebServiceGatewaySupport {

    public ResolveIPResponse getClientIp(String ip) {
        ResolveIP request = new ResolveIP();
        request.setIpAddress(ip);
        request.setLicenseKey("free");

        ResolveIPResponse information = (ResolveIPResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://ws.cdyne.com/ip2geo/ip2geo.asmx", request,
                        new SoapActionCallback(
                                "http://ws.cdyne.com/ResolveIP"));

        return information;
    }
}
