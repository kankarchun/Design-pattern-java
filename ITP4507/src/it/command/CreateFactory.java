package it.command;

import it.security.AbstractSecurityFactory;
import it.security.BondFactory;
import it.security.StockFactory;
import java.util.HashMap;
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
public class CreateFactory implements AbstractCommandFactory {

    @Override
    public Command createCommand(Scanner in, Vector data, Stack undo, Stack redo) {
        AbstractSecurityFactory af = null;
        String error = null;
        String obj = null;
        Command com;
        System.out.println("Enter security type(bo=bond/st=stock)");
        String type = in.nextLine();
        HashMap<String, AbstractSecurityFactory> map = new HashMap();
        map.put("bo", new BondFactory());
        map.put("st", new StockFactory());
        //if input is valid command, execute it
        //else set error message
        if (map.containsKey(type)) {
            af = map.get(type);
            System.out.println(af);
            obj = in.nextLine();
            error=null;
        } else {
            error = "No this security type";
        }
        com = new CreateCommand(data, undo, redo, obj, af, error);
        //if no error, push the command into undo stack
        if (error == null) {
            undo.push(com);
        }
        return com;
    }

}
