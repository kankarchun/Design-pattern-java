package it.command;


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
public class UndoFactory implements AbstractCommandFactory {

    @Override
    public Command createCommand(Scanner in,Vector data, Stack undo, Stack redo) {
        return new UndoCommand(undo);
    }

}
