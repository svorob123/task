package com.rns.interview.task.entity;

public enum Season {
    WINTER_STUDDED("Зимние (шипованные)"),
    WINTER("Зимние (нешипованные)"),
    SUMMER("Летние"),
    ALL_SEASON("Всесезонные"),
    CROSS_ROAD("Внедорожные");

    private String displayName;

    Season(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
