package com.rns.interview.task.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class TireProperties {

    @Getter
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private Integer width;
    @NotNull
    private Integer height;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(length = 3)
    private Cord construction;
    @NotNull
    @Column(length = 10)
    private String diameter;
    @NotNull
    @Column(length = 10)
    private String pressure;
    @NotNull
    @Column(length = 10)
    private String speedIndex;
    @Column(length = 20)
    private String special;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private RanFlat ranFlat;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private TubeType tubeType;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(length = 15)
    private Season season;

}
