package it.command;

import it.security.Security;
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
public class DisplayCommand implements Command {

    private Security s;
    private String code;

    private Vector data;
    private Stack undo, redo;
    private final String all = "##";

    public DisplayCommand(Vector data, Stack undo, Stack redo, String code) {
        this.data = data;
        this.undo = undo;
        this.redo = redo;
        this.code = code;
    }

    @Override
    public void execute() {  //print the security if match the vector data
        String error = null;
        System.out.println("Security information");
        if (!code.equals(all)) {
            for (int i = 0; i < data.size(); i++) {
                s = (Security) data.get(i);
                if (s.getCode().equals(code)) {
                    System.out.println("Code: " + s.getCode());
                    System.out.println("Name: " + s.getName());
                    System.out.println("Quantity: " + s.getQuantity());
                    System.out.println(s);
                    error=null;
                    break;
                } else {
                    //set error message
                    error = "No this security";
                }
            }
            //print error message if no security
            if (error != null) {
                System.out.println(error);
            }
        } else if (code.equals(all)) {
            System.out.println("Code\tName\t\t\tQuantity\tOption");
            for (int i = 0; i < data.size(); i++) {
                s = (Security) data.get(i);
                System.out.print(s.getCode() + "\t" + s.getName() + "\t\t\t" + s.getQuantity() + "\t\t");
                System.out.println(s);
            }
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
