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
public class DepositFactory implements AbstractCommandFactory {

    @Override
    public Command createCommand(Scanner in, Vector data, Stack undo, Stack redo) {
        Security s = null;
        Command com;
        String error = null;
        int quantity = 0;
        System.out.println("Enter code:");
        String code = in.nextLine();
        for (int i = 0; i < data.size(); i++) {
            s = (Security) data.get(i);
            if (s.getCode().equals(code)) {
                System.out.println("Quantity to deposit:");
                quantity = Integer.parseInt(in.nextLine());
                error = null;
                break;
            } else {
                //set error message
                error = "Invaild code";
            }
        }
        if (quantity < 0) {
            error = "deposit cannot less than 0";
        }
        com = new DepositCommand(undo, redo, s, quantity, error);
        //if no error, push the command into undo stack
        if (error == null) {
            undo.push(com);
        }
        return com;
    }

}
