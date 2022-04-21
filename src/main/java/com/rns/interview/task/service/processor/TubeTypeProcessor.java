package com.rns.interview.task.service.processor;

import com.rns.interview.task.entity.TubeType;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(6)
public class TubeTypeProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        Arrays.stream(TubeType.values())
                .filter(t -> content.lastIndexOf(t.getDisplayName()) >= 0)
                .findAny().ifPresent(tubeType -> {
            builder.updateContent(content.substring(0, content.indexOf(tubeType.getDisplayName())).trim());
            builder.setTubeType(tubeType);
        });
    }
}
