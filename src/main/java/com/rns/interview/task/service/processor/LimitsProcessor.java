package com.rns.interview.task.service.processor;

import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class LimitsProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        String[] splittedContent = content.split(" ");
        String bulkValue = splittedContent[0];
        String speedIndex = bulkValue.replaceAll("[^A-Z]+", "");
        String pressure = bulkValue.substring(0, bulkValue.indexOf(speedIndex));

        builder.setPressure(pressure);
        builder.setSpeedIndex(speedIndex);

        builder.updateContent(content.substring(content.indexOf(speedIndex) + speedIndex.length()).trim());
    }
}
