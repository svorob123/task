package com.rns.interview.task.service.processor;

import com.rns.interview.task.entity.Cord;
import com.rns.interview.task.service.BadFormatException;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(3)
public class GeometryProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        try {
            String content = builder.getContent();
            String[] splittedContent = content.split(" ");
            String bulkValue = splittedContent[0];
            String width = bulkValue.substring(0, bulkValue.indexOf("/"));
            Cord cord = Arrays.stream(Cord.values())
                    .filter(c -> bulkValue.indexOf(c.name()) > 0)
                    .findAny().orElseThrow(BadFormatException::new);
            String height = bulkValue.substring(bulkValue.indexOf("/") + 1, bulkValue.indexOf(cord.name()));
            String diameter = bulkValue.substring(bulkValue.indexOf(cord.name()));

            builder.setWidth(Integer.parseInt(width));
            builder.setHeight(Integer.parseInt(height));
            builder.setConstruction(cord);
            builder.setDiameter(diameter);

            builder.updateContent(content.substring(content.indexOf(diameter) + diameter.length()).trim());
        } catch (Exception e) {
            throw new BadFormatException();
        }
    }
}
