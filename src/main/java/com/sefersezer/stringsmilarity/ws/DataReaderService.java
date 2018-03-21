package com.sefersezer.stringsmilarity.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/search")
public interface DataReaderService {

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    ResponseEntity<List<String>>  search(@RequestParam("text") String text);

}
