package big_task2613_cash_machine.command;

import big_task2613_cash_machine.exception.InterruptedOperationException;

interface Command {
    void execute() throws InterruptedOperationException;
}
