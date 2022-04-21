package com.rns.interview.task.service.processor;

import com.rns.interview.task.entity.RanFlat;
import com.rns.interview.task.entity.TubeType;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(7)
public class RanFlatProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        Arrays.stream(RanFlat.values())
                .filter(rf -> content.lastIndexOf(rf.getDisplayName()) >= 0)
                .findAny().ifPresent(ranFlat -> {
            builder.updateContent(content.substring(0, content.indexOf(ranFlat.getDisplayName())).trim());
            builder.setRanFlat(ranFlat);
        });
    }
}
