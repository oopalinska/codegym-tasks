package big_task2613_cash_machine;

import big_task2613_cash_machine.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do {
            operation = ConsoleHelper.requestOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }
}
