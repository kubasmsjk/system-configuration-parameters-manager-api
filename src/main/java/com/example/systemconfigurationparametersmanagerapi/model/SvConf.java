package com.example.systemconfigurationparametersmanagerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class SvConf {

    @Id
    @Column(unique = true, length = 25, nullable = false)
    @NotBlank(message = "The attrName cannot be null and empty.")
    @Size(max = 25, message = "The attrName must consist max 25 characters.")
    private String attrName;
    @Column(length = 25, nullable = false)
    @NotBlank(message = "The attrValue cannot be null and empty.")
    @Size(max = 25, message = "The attrValue must consist max 25 characters.")
    private String attrValue;
    @Column(length = 50, nullable = false, columnDefinition = "VARCHAR(50) DEFAULT '-'")
    @NotBlank(message = "The attrDesc cannot be null and empty.")
    @Size(max = 50, message = "The attrDesc must consist max 50 characters.")
    private String attrDesc;

    public SvConf() {

    }

    public SvConf(String attrName, String attrValue, String attrDesc) {
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.attrDesc = attrDesc;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }
}