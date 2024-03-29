package com.example.systemconfigurationparametersmanagerapi.endpoints;

import com.example.systemconfigurationparametersmanagerapi.model.SvConf;
import com.example.systemconfigurationparametersmanagerapi.services.SvConfService;
import com.example.systemconfigurationparametersmanagerapi.svconf.*;
import com.example.systemconfigurationparametersmanagerapi.validator.ObjectValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SVConfEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/systemconfigurationparametersmanagerapi/svConf";

    private final SvConfService svConfService;
    private final ObjectValidator<SvConf> objectValidator;

    public SVConfEndpoint(SvConfService svConfService, ObjectValidator<SvConf> objectValidator) {
        this.svConfService = svConfService;
        this.objectValidator = objectValidator;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addSvConfRequest")
    @ResponsePayload
    public AddSvConfResponse addSvConf(@RequestPayload AddSvConfRequest request) {
        SvConf svConf = new SvConf();
        BeanUtils.copyProperties(request.getSvConfInfo(), svConf);
        objectValidator.validate(svConf);

        svConfService.addSvConf(svConf);
        ServiceStatus serviceStatus = createServiceStatus("SUCCESS", "SvConf has been added.");
        AddSvConfResponse addSvConfResponse = new AddSvConfResponse();
        addSvConfResponse.setServiceStatus(serviceStatus);
        return addSvConfResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSvConfRequest")
    @ResponsePayload
    public GetSvConfResponse getSvConf(@RequestPayload GetSvConfRequest request) {
        SvConfInfo svConfInfo = new SvConfInfo();
        BeanUtils.copyProperties(svConfService.getSvConfByAttrName(request.getAttrName()), svConfInfo);

        GetSvConfResponse getSvConfResponse = new GetSvConfResponse();
        getSvConfResponse.setSvConfInfo(svConfInfo);
        return getSvConfResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateSvConfRequest")
    @ResponsePayload
    public UpdateSvConfResponse updateSvConf(@RequestPayload UpdateSvConfRequest request) {
        SvConf svConf = new SvConf();
        BeanUtils.copyProperties(request.getSvConfInfo(), svConf);
        objectValidator.validate(svConf);

        svConfService.updateSvConf(svConf);
        ServiceStatus serviceStatus = createServiceStatus("SUCCESS", "SvConf has been updated.");
        UpdateSvConfResponse updateSvConfResponse = new UpdateSvConfResponse();
        updateSvConfResponse.setServiceStatus(serviceStatus);
        return updateSvConfResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteSvConfRequest")
    @ResponsePayload
    public DeleteSvConfResponse deleteSvConf(@RequestPayload DeleteSvConfRequest request) {
        svConfService.deleteSvConfByAttrName(request.getAttrName());

        ServiceStatus serviceStatus = createServiceStatus("SUCCESS", "SvConf has been deleted.");
        DeleteSvConfResponse deleteSvConfResponse = new DeleteSvConfResponse();
        deleteSvConfResponse.setServiceStatus(serviceStatus);
        return deleteSvConfResponse;
    }

    private ServiceStatus createServiceStatus(String status, String message) {
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus(status);
        serviceStatus.setMessage(message);
        return serviceStatus;
    }
}
