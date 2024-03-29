package com.example.systemconfigurationparametersmanagerapi.handler;

import com.example.systemconfigurationparametersmanagerapi.exceptions.ObjectNotValidException;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class GlobalExceptionsHandler extends SoapFaultMappingExceptionResolver {

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        if (ex instanceof ObjectNotValidException) {
            SoapFaultDetail detail = fault.addFaultDetail();
            ((ObjectNotValidException) ex).getValidFault().forEach((path, message) -> {
                SoapFaultDetailElement faultDetailElement = detail.addFaultDetailElement(QName.valueOf(path.toString()));
                faultDetailElement.addText(message);
            });
        }
    }
}
