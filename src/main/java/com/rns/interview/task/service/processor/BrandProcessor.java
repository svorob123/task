package com.rns.interview.task.service.processor;

import com.rns.interview.task.entity.Brand;
import com.rns.interview.task.service.BadFormatException;
import com.rns.interview.task.service.TireBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class BrandProcessor implements FileContentProcessor {

    @Override
    public void process(TireBuilder builder) {
        String content = builder.getContent();
        Brand brand = Arrays.stream(Brand.values())
                .filter(brnd -> content.indexOf(brnd.name()) == 0)
                .findAny().orElseThrow(BadFormatException::new);
        builder.updateContent(content.substring(brand.name().length()).trim());
        builder.setBrand(brand);
    }
}
