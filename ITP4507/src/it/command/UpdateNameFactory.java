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
public class UpdateNameFactory implements AbstractCommandFactory {

    @Override
    public Command createCommand(Scanner in, Vector data, Stack undo, Stack redo) {
        Security s = null;
        Command com;
        String newName = "";
        String oldName = "";
        String error=null;
        System.out.println("Enter code:");
        String code = in.nextLine();
        for (int i = 0; i < data.size(); i++) {
            s = (Security) data.get(i);
            if (s.getCode().equals(code)) {
                System.out.println("Enter new name:");
                newName = in.nextLine();
                oldName = s.getName();
                error=null;
                break;
            }else{
                error="No this security";
            }
        }
        com = new UpdateNameCommand(undo, redo, s, newName, oldName,error);
        if (error == null) {
            undo.push(com);
        }
        return com;
    }

}
