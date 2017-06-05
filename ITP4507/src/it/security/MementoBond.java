package it.security;


import it.security.Bond;
import it.security.Security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class MementoBond {

    private String code, name;
    private float yield;
    private int quantity;
    private Security _s;

    public MementoBond(Security s) {
        this._s = s;
        this.code = s.getCode();
        this.name = s.getName();
        this.quantity = s.getQuantity();
        this.yield = ((Bond) s).getYield();
    }

    public void restore() {//set saved value into saved security
        this._s.setCode(code);
        this._s.setName(name);
        this._s.setQuantity(quantity);
        ((Bond) this._s).setYield(yield);
    }

    public Security getSecurity() {
        return _s;
    }
}
