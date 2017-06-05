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
public interface AbstractSecurityFactory {

    public Security getSecurity(String code, String name, String option);

}
