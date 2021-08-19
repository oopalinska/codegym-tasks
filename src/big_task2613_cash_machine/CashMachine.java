package big_task2613_cash_machine;

import big_task2613_cash_machine.command.CommandExecutor;
import big_task2613_cash_machine.exception.InterruptedOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Operation operation;
            CommandExecutor.execute(Operation.LOGIN);
            do {
                operation = ConsoleHelper.requestOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptedOperationException e) {
            ConsoleHelper.writeMessage("Goodbye!");
        }
    }
}
