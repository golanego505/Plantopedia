package org.launchcode.plantopedia.models;

import java.util.ArrayList;

public class Images {
    private ArrayList<Image> flower;
    private ArrayList<Image> leaf;
    private ArrayList<Image> habit;
    private ArrayList<Image> fruit;
    private ArrayList<Image> bark;
    private ArrayList<Image> other;

    public ArrayList<Image> getFlower() {
        return flower;
    }

    public void setFlower(ArrayList<Image> flower) {
        this.flower = flower;
    }

    public ArrayList<Image> getLeaf() {
        return leaf;
    }

    public void setLeaf(ArrayList<Image> leaf) {
        this.leaf = leaf;
    }

    public ArrayList<Image> getHabit() {
        return habit;
    }

    public void setHabit(ArrayList<Image> habit) {
        this.habit = habit;
    }

    public ArrayList<Image> getFruit() {
        return fruit;
    }

    public void setFruit(ArrayList<Image> fruit) {
        this.fruit = fruit;
    }

    public ArrayList<Image> getBark() {
        return bark;
    }

    public void setBark(ArrayList<Image> bark) {
        this.bark = bark;
    }

    public ArrayList<Image> getOther() {
        return other;
    }

    public void setOther(ArrayList<Image> other) {
        this.other = other;
    }
}
