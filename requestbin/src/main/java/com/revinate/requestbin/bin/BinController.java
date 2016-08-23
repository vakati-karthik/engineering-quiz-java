package com.revinate.requestbin.bin;


import com.revinate.requestbin.bin.model.Bin;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * A Bin is an entity that has a URL and who store any HTTP request that was made against it.
 * It also have an inspect sub resource that allow to inspect the requests made on this bin.
 */
@RestController
@RequestMapping("/bin")
public class BinController {

    /**
     * @return the list of all Bins available on the server.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Bin> getAll() {
        throw new NotImplementedException("To be implemented");
    }

    /**
     * Allow the creation of a Bin.
     * @return newly created Bin
     */
    @RequestMapping(method = RequestMethod.POST)
    public Bin create() {
        throw new NotImplementedException("To be implemented");
    }

    /**
     * @param id of the Bin
     * @return the description of the Bin with all Requests having been made against it.
     */
    @RequestMapping( value = "/bin/{id}/inspect", method= RequestMethod.GET)
    public Bin inspect(String id) {
        throw new NotImplementedException("To be implemented");
    }


    /**
     * Store a GET request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.GET)
    public void get(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }

    /**
     * Store a HEAD request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.HEAD)
    public void head(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }


    /**
     * Store a OPTIONS request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.OPTIONS)
    public void options(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }

    /**
     * Store a PUT request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.PUT)
    public void put(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }


    /**
     * Store a PATCH request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.PATCH)
    public void patch(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }

    /**
     * Store a POST request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.POST)
    public void post(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }

    /**
     * Store a DELETE request
     * @param id of the Bin
     * @param req Raw HTTP request
     */
    @RequestMapping(value = "/bin/{id}", method = RequestMethod.DELETE)
    public void delete(@PathParam("id") String id, HttpServletRequest req){
        throw new NotImplementedException("To be implemented");
    }
}
