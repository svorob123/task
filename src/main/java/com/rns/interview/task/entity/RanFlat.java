package com.rns.interview.task.entity;

public enum RanFlat {

    RunFlat("RunFlat"),
    Run_Flat("Run Flat"),
    ROF("ROF"),
    ZP("ZP"),
    SSR("SSR"),
    ZPS("ZPS"),
    HRS("HRS"),
    RFT("RFT");

    private String displayName;

    RanFlat(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
