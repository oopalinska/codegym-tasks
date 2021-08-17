package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.CurrencyManipulator;
import big_task2613_cash_machine.CurrencyManipulatorFactory;
import big_task2613_cash_machine.exception.InterruptedOperationException;

class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptedOperationException {
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] input = ConsoleHelper.getTwoValidNumbers(currencyCode);
        int denomination = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        manipulator.addAmount(denomination, count);
    }
}
