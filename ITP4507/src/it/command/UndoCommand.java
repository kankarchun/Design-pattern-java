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
public class UndoCommand implements Command {

    private Stack undo;

    public UndoCommand(Stack undo) {
        this.undo = undo;
    }

    @Override
    public void execute() {
        if (undo.empty()) {
            //show error if no undo object
            System.out.println("cannot undo empty");
        } else {
            //execute the command undo in undo stack
            Command c = (Command) undo.pop();
            c.undo();

            System.out.println("undo completed");
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
