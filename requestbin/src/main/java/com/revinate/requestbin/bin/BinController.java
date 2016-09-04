package com.revinate.requestbin.bin;

import com.revinate.requestbin.bin.model.Bin;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


/**
 * A Bin is an entity that has a URL and who store any HTTP request that was made against it.
 * It also have an inspect sub resource that allow to inspect the requests made on this bin.
 */
@RestController
@RequestMapping("/bin")
public class BinController {

}
