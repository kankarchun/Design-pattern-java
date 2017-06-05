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
public class StockFactory implements AbstractSecurityFactory {

    @Override
    public Security getSecurity(String code, String name, String option) {
        return new Stock(code, name, option);
    }
    
    public String toString(){//create factory string
        return "Enter code,name and exchange";
    }
}
