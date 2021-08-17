package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.CurrencyManipulator;
import big_task2613_cash_machine.CurrencyManipulatorFactory;

class DepositCommand implements Command {
    @Override
    public void execute() {
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        String[] input = ConsoleHelper.getTwoValidNumbers(currencyCode);
        int denomination = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(denomination, count);
    }
}
