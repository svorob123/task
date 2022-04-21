package com.rns.interview.task.service.processor;

import com.rns.interview.task.entity.Season;
import com.rns.interview.task.service.BadFormatException;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(5)
public class SeasonProcessor implements FileContentProcessor{

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        Season season = Arrays.stream(Season.values())
                .filter(s-> content.lastIndexOf(s.getDisplayName()) > 0)
                .findAny().orElseThrow(BadFormatException::new);
        builder.updateContent(content.substring(0, content.length() - season.getDisplayName().length()).trim());
        builder.setSeason(season);
    }
}
