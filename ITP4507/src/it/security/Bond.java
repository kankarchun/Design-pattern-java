package it.security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class Bond extends Security {

    private float yield;

    public Bond(String code, String name, float yield) {
        super(code, name);
        this.yield = yield;
    }

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }

    public String toString() {
        return "Yield: " + getYield();
    }
}
