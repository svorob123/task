package com.rns.interview.task.service;

import com.rns.interview.task.entity.Brand;
import com.rns.interview.task.entity.Cord;
import com.rns.interview.task.entity.RanFlat;
import com.rns.interview.task.entity.Season;
import com.rns.interview.task.entity.Tire;
import com.rns.interview.task.entity.TireProperties;
import com.rns.interview.task.entity.TubeType;

public class TireBuilder {

    private String content;
    private Tire tire;

    public TireBuilder(String content) {
        this.content = content;
        this.tire = new Tire();
        this.tire.setProperties(new TireProperties());
    }

    public String getContent() {
        return content;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public TireBuilder setBrand(Brand brand) {
        tire.setBrand(brand);
        return this;
    }

    public TireBuilder setModel(String model) {
        tire.setModel(model);
        return this;
    }

    public TireBuilder setWidth(int width) {
        tire.getProperties().setWidth(width);
        return this;
    }

    public TireBuilder setHeight(int height) {
        tire.getProperties().setHeight(height);
        return this;
    }

    public TireBuilder setConstruction(Cord construction) {
        tire.getProperties().setConstruction(construction);
        return this;
    }

    public TireBuilder setDiameter(String diameter) {
        tire.getProperties().setDiameter(diameter);
        return this;
    }

    public TireBuilder setPressure(String pressure) {
        tire.getProperties().setPressure(pressure);
        return this;
    }

    public TireBuilder setSpeedIndex(String speedIndex) {
        tire.getProperties().setSpeedIndex(speedIndex);
        return this;
    }

    public TireBuilder setSpecial(String special) {
        tire.getProperties().setSpecial(special);
        return this;
    }

    public TireBuilder setRanFlat(RanFlat ranFlat) {
        tire.getProperties().setRanFlat(ranFlat);
        return this;
    }

    public TireBuilder setTubeType(TubeType tubeType) {
        tire.getProperties().setTubeType(tubeType);
        return this;
    }

    public TireBuilder setSeason(Season season) {
        tire.getProperties().setSeason(season);
        return this;
    }

    public Tire build() {
        return tire;
    }

}
