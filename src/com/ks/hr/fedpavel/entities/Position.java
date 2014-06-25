package com.ks.hr.fedpavel.entities;

import java.math.BigDecimal;

/**
 * Created by Pavel on 22.06.14.
 */
public class Position {
    private Integer id;
    private String name;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }


    public Position() {
    }

    public Position( String name, BigDecimal minSalary, BigDecimal maxSalary) {
        this.name = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Position(Integer id, String name, BigDecimal minSalary, BigDecimal maxSalary) {
        this.id = id;
        this.name = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
