package com.sefersezer.stringsmilarity.model;

import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

@Data
public class Word {

    @Parsed(index = 0)
    private String text;
}
