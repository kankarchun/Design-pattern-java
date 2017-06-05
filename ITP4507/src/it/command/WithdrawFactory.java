package it.command;


import it.security.Security;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1
 */
public class WithdrawFactory implements AbstractCommandFactory {

    @Override
    public Command createCommand(Scanner in,Vector data, Stack undo, Stack redo) {
        Security s = null;
        Command com;
        String error = null;
        int withdraw = 0;
        System.out.println("Enter code:");
        String code = in.nextLine();
        for (int i = 0; i < data.size(); i++) {
            s = (Security) data.get(i);
            if (s.getCode().equals(code)) {
                System.out.println("Quantity to withdraw");
                withdraw = Integer.parseInt(in.nextLine());
                error=null;
                if (withdraw > s.getQuantity()) {
                    error="Invaild quantity (current quantity < withdrawal quantity).";
                }
                break;
            }else{
                error="No this security";
            }
        }
        com=new WithdrawCommand(undo, redo, s, withdraw,error);
        if (error == null) {
            undo.push(com);
        }
        return com;
    }
}
