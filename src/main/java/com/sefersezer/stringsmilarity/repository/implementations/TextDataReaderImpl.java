package com.sefersezer.stringsmilarity.repository.implementations;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Component;
import com.sefersezer.stringsmilarity.repository.DataReader;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class TextDataReaderImpl implements DataReader {

    private List<String[]> fileRead(String path) {
        CsvParserSettings settings = new CsvParserSettings();
//        settings.getFormat().setDelimiter(delimiter);
        settings.getFormat().setLineSeparator("\n");
        settings.getFormat().setQuote('"');
        settings.setHeaderExtractionEnabled(true);
//        settings.setMaxCharsPerColumn(-1);

        CsvParser parser = new CsvParser(settings);
        return parser.parseAll(getReader(path));
    }

    private Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(Files.newInputStream(Paths.get(relativePath)), "UTF-8");
        } catch (Exception e) {
            throw new IllegalStateException("Unable to read input", e);
        }
    }

    @Override
    public List<String[]> read(String source) {
        return fileRead(source);
    }
}
