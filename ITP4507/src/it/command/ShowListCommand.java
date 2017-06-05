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
public class ShowListCommand implements Command {

    private Stack undo, redo;

    public ShowListCommand(Stack undo, Stack redo) {
        this.undo = undo;
        this.redo = redo;
    }

    @Override
    public void execute() { //print string of command of undo redo stack
        System.out.println("Undo List:");
        if (undo.empty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < undo.size(); i++) {
                System.out.println(((Command) undo.get(i)).showCmd());
            }
        }
        System.out.println("");
        System.out.println("Redo List:");
        if (redo.empty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < redo.size(); i++) {
                System.out.println(((Command) redo.get(i)).showCmd());
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
