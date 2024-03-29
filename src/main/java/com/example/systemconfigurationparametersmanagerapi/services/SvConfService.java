package com.example.systemconfigurationparametersmanagerapi.services;

import com.example.systemconfigurationparametersmanagerapi.model.SvConf;

public interface SvConfService {
    void addSvConf(SvConf svConf);

    SvConf getSvConfByAttrName(String attrName);

    void updateSvConf(SvConf svConf);

    void deleteSvConfByAttrName(String attrName);
}
