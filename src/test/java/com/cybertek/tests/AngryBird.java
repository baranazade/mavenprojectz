package com.cybertek.tests;


import com.github.javafaker.Faker;

public class AngryBird {
    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println(faker.funnyName().name());
        faker.name().fullName();
    }


}
