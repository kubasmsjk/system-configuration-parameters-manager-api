package com.example.systemconfigurationparametersmanagerapi.services;

import com.example.systemconfigurationparametersmanagerapi.exceptions.SvConfExistsStatusException;
import com.example.systemconfigurationparametersmanagerapi.model.SvConf;
import com.example.systemconfigurationparametersmanagerapi.repository.SvConfRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SvConfServiceImpl implements SvConfService {

    private final SvConfRepository svConfRepository;

    public SvConfServiceImpl(SvConfRepository svConfRepository) {
        this.svConfRepository = svConfRepository;
    }

    @Override
    public void addSvConf(SvConf svConf) {
        Optional<SvConf> svConfOptional = svConfRepository.findByAttrName(svConf.getAttrName());
        if (svConfOptional.isEmpty()) {
            svConfRepository.save(svConf);
        } else {
            throw new SvConfExistsStatusException("SvConf with attrName: " + svConf.getAttrName() + " already exists.");
        }
    }

    @Override
    public SvConf getSvConfByAttrName(String attrName) {
        Optional<SvConf> svConfOptional = svConfRepository.findByAttrName(attrName);
        if (svConfOptional.isPresent()) {
            return svConfOptional.get();
        } else {
            throw new SvConfExistsStatusException("SvConf with attrName: " + attrName + " not exists.");
        }
    }

    @Override
    public void updateSvConf(SvConf svConf) {
        Optional<SvConf> svConfOptional = svConfRepository.findByAttrName(svConf.getAttrName());
        if (svConfOptional.isPresent()) {
            svConfRepository.save(svConf);
        } else {
            throw new SvConfExistsStatusException("SvConf with attrName: " + svConf.getAttrName() + " not exists.");
        }
    }

    @Override
    public void deleteSvConfByAttrName(String attrName) {
        Optional<SvConf> svConfOptional = svConfRepository.findByAttrName(attrName);
        if (svConfOptional.isPresent()) {
            svConfRepository.deleteByAttrName(attrName);
        } else {
            throw new SvConfExistsStatusException("SvConf with attrName: " + attrName + " not exists.");
        }
    }
}
