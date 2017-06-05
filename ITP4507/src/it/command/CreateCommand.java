package it.command;

import it.security.AbstractSecurityFactory;
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
public class CreateCommand implements Command {

    private Security s;
    private AbstractSecurityFactory af;
    private String obj, error;

    private Vector data;
    private Stack undo, redo;

    public CreateCommand(Vector data, Stack undo, Stack redo, String obj, AbstractSecurityFactory af, String error) {
        this.data = data;
        this.undo = undo;
        this.redo = redo;
        this.obj = obj;
        this.af = af;
        this.error = error;
    }

    @Override
    public void execute() {
        if (error != null) {
            System.out.println(error);
        } else {
            try {
                String[] parts = obj.split(",");
                if(parts.length==0){
                    undo.pop();
                    System.out.println("Null input");
                    return;
                }
                for (int i = 0; i < data.size(); i++) {
                    s = (Security) data.get(i);
                    if (s.getCode().equals(parts[0])) {
                        undo.pop();
                        System.out.println("Already have same code");
                        return;
                    }
                }
                //create object split by ','
                s = af.getSecurity(parts[0], parts[1], parts[2]);

                //add the object into vector
                data.add(s);

                System.out.println("New security record created.");
            } catch (NumberFormatException ex) {
                //pop this command if throw exception
                undo.pop();
                //error message
                System.out.println("Please input correct format");
            }
        }
    }

    @Override
    public void undo() {
        //remove the security obj in vector
        data.remove(s);
        //put this command class in redo stack
        redo.push(this);
    }

    @Override
    public void redo() {
        //add back the security obj in vector
        data.add(s);
        //put this command class in undo stack
        undo.push(this);
    }

    @Override
    public String showCmd() { //string of show list of undo redo stack
        return "Create " + s.getCode();
    }
}
