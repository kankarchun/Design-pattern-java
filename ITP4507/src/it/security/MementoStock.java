package it.security;


import it.security.Stock;
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
public class MementoStock {

    private String code, name, exchange;
    private int quantity;
    private Security _s;

    public MementoStock(Security s) {
        this._s = s;
        this.code = s.getCode();
        this.name = s.getName();
        this.quantity = s.getQuantity();
        this.exchange = ((Stock) s).getExchange();
    }

    public void restore() {//set saved value into saved security
        this._s.setCode(code);
        this._s.setName(name);
        this._s.setQuantity(quantity);
        ((Stock) this._s).setExchange(exchange);

    }

    public Security getSecurity() {
        return _s;
    }
}
