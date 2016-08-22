package com.revinate.requestbin.bin.model;


import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;


/**
 * Skeleton class that exposes some basic information that we want to store about Request.
 */
public class Request {

    public String getMethod() {
        throw new NotImplementedException("To be implemented");
    }

    public Map<String, List<String>> getHeaders() {
        throw new NotImplementedException("To be implemented");
    }

    public String getBody() {
        throw new NotImplementedException("To be implemented");
    }

}
