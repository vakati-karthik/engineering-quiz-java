package com.revinate.requestbin.bin;


import com.revinate.requestbin.bin.model.Bin;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bin")
public class BinController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Bin> getAll() {
        throw new NotImplementedException("To be implemented");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Bin create() {
        throw new NotImplementedException("To be implemented");
    }
}
