package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
public class ApiRequest<T> {
    @JsonIgnore
    @ToString.Exclude
    private String uuid;
    private String appCode;
    private String path;
    private String httpMethod;
    private String remoteHost;
    private Map<String, List<String>> headers;
    private T data;
}

