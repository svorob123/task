package com.rns.interview.task.service.processor;

import com.rns.interview.task.service.BadFormatException;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Spliterator;

@Component
@Order(2)
public class ModelProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        String model = findConfigModel(content);
        builder.updateContent(content.substring(model.length()).trim());
        builder.setModel(model);
    }

    private String findConfigModel(String content) {
        String delimiter = " ";
        String[] contentParts = content.split(delimiter);
        for (int i = 0; i < contentParts.length; i++) {
            if (contentParts[i].matches("[0-9]{1,3}/[0-9]{1,3}R?D?[0-9]+C?")) {
                StringBuilder builder = new StringBuilder();
                String nameSpliterator = "";
                for (int j = 0; j < i; j++) {
                    builder.append(nameSpliterator);
                    builder.append(contentParts[j]);
                    nameSpliterator = delimiter;
                }
                return builder.toString();
            }
        }
        throw new BadFormatException();
    }
}
