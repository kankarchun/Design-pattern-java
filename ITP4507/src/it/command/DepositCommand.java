package it.command;

import it.security.MementoStock;
import it.security.MementoBond;
import it.security.Stock;
import it.security.Bond;
import it.security.Security;
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
public class DepositCommand implements Command {

    private Security s;
    private int quantity,total;
    private Stack undo, redo;
    private Stack undoList, redoList;
    private String error;

    public DepositCommand(Stack undo, Stack redo, Security s, int quantity,String error) {
        this.undo = undo;
        this.redo = redo;
        this.s = s;
        this.quantity = quantity;
        undoList = new Stack();
        redoList = new Stack();
        this.error=error;
    }

    @Override
    public void execute() {
        //if have error, print the error
        if (error != null) {
            System.out.println(error);
        } else {
            Object m = null;
            //set the memento by different object
            if (s instanceof Bond) {
                m = createMementoBond(s);
            } else if (s instanceof Stock) {
                m = createMementoStock(s);
            }
            total=s.getQuantity()+quantity;
            //set the securit quantity
            s.setQuantity(total);
            //push memento in undo list stack
            undoList.push(m);

            System.out.println("Desposited " + quantity + " to " + s.getCode() + ". Current quantity is " + s.getQuantity());
        }
    }
    //save memento security to undolist or redolist
    public void saveBond(Security se) {
        undoList.push(new MementoBond(se));
    }

    public void saveBondRedo(Security se) {
        redoList.push(new MementoBond(se));
    }

    public void saveStock(Security se) {
        undoList.push(new MementoStock(se));
    }

    public void saveStockRedo(Security se) {
        redoList.push(new MementoStock(se));
    }

    @Override
    public void undo() { //restore the undolist memento object
        Object obj = undoList.pop();
        if (obj instanceof MementoBond) {
            MementoBond mb = (MementoBond) obj;
            Security b = mb.getSecurity();
            saveBondRedo(b);
            mb.restore();
            redo.push(this);
        } else if (obj instanceof MementoStock) {
            MementoStock ms = (MementoStock) obj;
            Security st = ms.getSecurity();
            saveStockRedo(st);
            ms.restore();
            redo.push(this);
        }
    }
    //create memento object
    public MementoBond createMementoBond(Security s) {
        return new MementoBond(s);
    }

    public MementoStock createMementoStock(Security s) {
        return new MementoStock(s);
    }

    @Override
    public void redo() {//restore the redolist memento object
        Object obj = redoList.pop();
        if (obj instanceof MementoBond) {
            MementoBond mb = (MementoBond) obj;
            Security b = mb.getSecurity();
            saveBond(b);
            mb.restore();
            undo.push(this);
        } else if (obj instanceof MementoStock) {
            MementoStock ms = (MementoStock) obj;
            Security st = ms.getSecurity();
            saveStock(st);
            ms.restore();
            undo.push(this);
        }
    }

    @Override
    public String showCmd() { //string of show list of undo redo stack
        return "Deposit " + quantity + " " + s.getCode();
    }
}
