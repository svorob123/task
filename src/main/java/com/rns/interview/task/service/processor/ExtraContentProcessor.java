package com.rns.interview.task.service.processor;

import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(8)
public class ExtraContentProcessor implements FileContentProcessor{

    @Override
    public void process(TireBuilder builder) {
        if (!builder.getContent().isEmpty()) {
            builder.setSpecial(builder.getContent());
        }
    }
}
