//κλαση animal
package com.company;

import java.io.*;

public class Animal implements Serializable {
    private String code;
    private  String name;
    private  String homogeneity;
    private double weight;
    private int age;
    //δημιουργια constuctor περνωντας ως ορισματα τις ιδιοτητες του καθε ζωου επειδη ολα τα ζωα εχουν τις συγκεκριμενες ιδιοτητες
    public Animal(String code, String name, String homogeneity, double weight, int age) {
        this.code = code;
        this.name = name;
        this.homogeneity = homogeneity;
        this.weight = weight;
        this.age = age;
    }
    //δημιουργουμε getters και setters
    //χρειαζομαι τους setters ωστε στην επεξεργασια να αλλαζω τις  τιμες που εχω περσαει στο καθε ζωο μεσω του constructor
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomogeneity() {
        return homogeneity;
    }

    public void setHomogeneity(String homogeneity) {
        this.homogeneity = homogeneity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
