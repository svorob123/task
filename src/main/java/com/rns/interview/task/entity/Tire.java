package com.rns.interview.task.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tire {

    @Getter
    @Id
    @GeneratedValue
    private long id;
    @Setter
    @Getter
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(length = 15)
    private Brand brand;
    @NotNull
    @Setter
    @Getter
    @Column(length = 40)
    private String model;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private TireProperties properties;

}
