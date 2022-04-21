package com.rns.interview.task.service;

import com.rns.interview.task.entity.Tire;
import com.rns.interview.task.service.processor.FileContentProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileParseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileParseService.class);

    private List<FileContentProcessor> contentProcessors;

    @Autowired
    public FileParseService(List<FileContentProcessor> processors) {

        this.contentProcessors = processors;
    }

    public List<Tire> process(InputStream inputStream) throws IOException {
        List<Tire> tireList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            String line = reader.readLine();
            TireBuilder builder = new TireBuilder(line.trim());
            boolean failedToParse = false;
            try {
                contentProcessors.forEach(
                        fileContentProcessor -> fileContentProcessor.process(builder)
                );
            } catch (BadFormatException e) {
                failedToParse = true;
                LOGGER.warn("Can't read tire properties due to ", e);
            } catch (Exception e) {
                LOGGER.error("Alarm!!! Do something!!! ", e);
            } finally {
                Tire tire = builder.build();
                if (failedToParse) {
                    //Возможно лучше оставить какие-то успешно прочтинанные поля.
                    //Но для текущей реализации это отметка плохо сконфигуренной строки пропертей
                    tire.setProperties(null);
                }
                tireList.add(tire);
            }
        }
        return tireList;
    }

}
