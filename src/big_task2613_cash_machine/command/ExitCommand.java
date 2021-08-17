package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.exception.InterruptedOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptedOperationException {
        ConsoleHelper.writeMessage("Do you really want to exit? Y/N :");
        String answer = ConsoleHelper.readString().trim();
        if (answer.equalsIgnoreCase("y")) {
            ConsoleHelper.writeMessage("Goodbye!");
        } else if (answer.equalsIgnoreCase("n")) {
            // TO-DO
        }
    }
}