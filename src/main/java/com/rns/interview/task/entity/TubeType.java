package com.rns.interview.task.entity;

public enum TubeType {

    TT_TL("TL/TT"),
    TT("TT"),
    TL("TL");

    private String displayName;

    TubeType(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
