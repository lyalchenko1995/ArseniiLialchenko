package com.epam.tc.hw7.pageObjects.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DTO {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;
}
