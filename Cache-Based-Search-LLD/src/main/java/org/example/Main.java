package org.example;

import org.example.commands.CommandFactory;
import org.example.exceptions.CommandNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // command link inputs
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String[] cmd = sc.nextLine().split(" ");
            try {
                CommandFactory.getInstance().executeCommand(cmd);
            } catch (CommandNotFoundException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }
    }
}