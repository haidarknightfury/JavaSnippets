package com.example.patterns.specification_pattern.simple.selector;

import java.util.function.Predicate;

import com.example.patterns.specification_pattern.simple.employee.AbstractEmployee;
import com.example.patterns.specification_pattern.simple.property.Sector;

public class SectorSelector implements Predicate<AbstractEmployee> {

    private final Sector sector;

    public SectorSelector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public boolean test(AbstractEmployee emp) {
        return emp.getSector().equals(this.sector);
    }

}
