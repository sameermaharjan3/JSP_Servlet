package com.example.web;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BeerExpertTest {

    @Test
    public void getBrands() {
        BeerExpert be = new BeerExpert();

        List actual = be.getBrands("amber");
        List amberList = Arrays.asList("Jack Amber","Red Moose");
        Assert.assertEquals(actual,amberList);
    }

    @Test
    public void getBrandsTwo(){
        BeerExpert be = new BeerExpert();

        List actual = be.getBrands("light");
        List amberList = Arrays.asList("Jail Pale Ale","Gout Stout");
        Assert.assertEquals(actual,amberList);
    }
}