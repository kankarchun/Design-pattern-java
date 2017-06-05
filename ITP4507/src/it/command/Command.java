package it.command;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public interface Command {

    public abstract void execute();

    public abstract String showCmd();

    public abstract void undo();

    public abstract void redo();
}
