package com.sefersezer.stringsmilarity.ws.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sefersezer.stringsmilarity.repository.DataReader;
import com.sefersezer.stringsmilarity.util.Config;
import com.sefersezer.stringsmilarity.ws.DataReaderService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataReaderServiceImpl implements DataReaderService {

    @Autowired
    private Config config;

    @Autowired
    private DataReader dataReader;

    @Override
    public ResponseEntity<List<String>> search(String term) {
        System.out.println("text is: " + term);
        /**
         * TODO
         * filter term on dataSource
         */
        List<String> responseList = new ArrayList<>();
        dataReader.read(config.getTextDataSource())
            .stream().filter(row -> {
            if (row[0].contains(term)) {
                return true;
            }
            return false;
        })
            .forEach(row -> responseList.add(row[0]));
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
