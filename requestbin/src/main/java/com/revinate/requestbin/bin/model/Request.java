package com.revinate.requestbin.bin.model;


import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;


/**
 * Skeleton class that exposes some basic information that we want to store about a Request.
 * {
 *     "method": "POST",
 *     "body": "Hello World",
 *     "headers": {
 *         "Content-Type": ["application/json"]
 *     }
 * }
 *
 *
 * Add whatever you feel is missing.
 */
public class Request {

    public String getMethod() {
        throw new NotImplementedException("To be implemented");
    }

    public Map<String, String> getHeaders() {
        throw new NotImplementedException("To be implemented");
    }

    public String getBody() {
        throw new NotImplementedException("To be implemented");
    }

}
