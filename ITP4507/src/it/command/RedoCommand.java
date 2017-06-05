package it.command;


import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1
 */
public class RedoCommand implements Command {

    private Stack redo;

    public RedoCommand(Stack redo) {
        this.redo = redo;
    }

    @Override
    public void execute() {
        if (redo.empty()) {
            //show error if no redo object
            System.out.println("cannot redo empty");
        } else {
            //execute the command redo in redo stack
            Command c = (Command) redo.pop();
            c.redo();
            System.out.println("redo completed");
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
