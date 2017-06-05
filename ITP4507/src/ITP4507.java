
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1n
 */
import java.util.Scanner;
import it.command.DepositFactory;
import it.command.UndoFactory;
import it.command.ShowListFactory;
import it.command.QuitFactory;
import it.command.RedoFactory;
import it.command.UpdateNameFactory;
import it.command.Command;
import it.command.DisplayFactory;
import it.command.CreateFactory;
import it.command.WithdrawFactory;
import it.command.AbstractCommandFactory;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class ITP4507 {

    public static Scanner in = new Scanner(System.in);
    public static Vector data = new Vector();
    public static Stack undo = new Stack();
    public static Stack redo = new Stack();

    public static void main(String[] args) {
        String choose;
        HashMap<String, AbstractCommandFactory> map = new HashMap();
        map.put("n", new CreateFactory());
        map.put("s", new DisplayFactory());
        map.put("d", new DepositFactory());
        map.put("w", new WithdrawFactory());
        map.put("c", new UpdateNameFactory());
        map.put("l", new ShowListFactory());
        map.put("u", new UndoFactory());
        map.put("r", new RedoFactory());
        map.put("q", new QuitFactory());
        do {
            System.out.println("Advanced Security Management System");
            System.out.println("Please enter command: [n | s | d | w | c | u | r | l | q]");
            System.out.println("n = create security, s = show security, d = deposit security, w = withdraw security,\n"
                    + "c = update name of security, u = undo, r = redo, l = list undo/redo, q= exit system");

            choose = in.nextLine();
            System.out.println("");
            //if create object, clear the redo stack
            switch (choose) {
                case "n":
                    redo.clear();
            }
            //if input is valid command, execute it
            //else show error message
            if (map.containsKey(choose)) {
                Command com = map.get(choose).createCommand(in, data, undo, redo);
                com.execute();

                System.out.println("");
            } else {
                System.out.println("Please input correct command");
            }
        } while (true);
    }
}
