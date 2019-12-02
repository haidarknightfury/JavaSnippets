package com.example.patterns.specification_pattern.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.patterns.specification_pattern.simple.employee.AbstractEmployee;
import com.example.patterns.specification_pattern.simple.employee.Boss;
import com.example.patterns.specification_pattern.simple.employee.Programmer;
import com.example.patterns.specification_pattern.simple.property.Sector;
import com.example.patterns.specification_pattern.simple.selector.AgeSelector;
import com.example.patterns.specification_pattern.simple.selector.SectorSelector;

public class App {

    public static void main(String[] args) {
        List<AbstractEmployee> employees = Arrays.asList(new Programmer("Haidar", 29), new Programmer("Baka", 21), new Boss("OneeChan", 30));
        List<AbstractEmployee> programmers = employees.stream().filter(new SectorSelector(Sector.IT)).collect(Collectors.toList());
        programmers.forEach(System.out::println);

        List<AbstractEmployee> itGreaterThan25 = employees.stream().filter(new SectorSelector(Sector.IT).and(new AgeSelector(25))).collect(Collectors.toList());
        System.out.println(itGreaterThan25);

    }
}
