package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.CurrencyManipulator;
import big_task2613_cash_machine.CurrencyManipulatorFactory;

class InfoCommand implements Command {
    @Override
    public void execute() {
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage(String.format("%s - %d", manipulator.getCurrencyCode(), manipulator.getTotalAmount()));
            }
        }
        if (!hasMoney) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}

