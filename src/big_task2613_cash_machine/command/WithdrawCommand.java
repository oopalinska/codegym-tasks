package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.CurrencyManipulator;
import big_task2613_cash_machine.CurrencyManipulatorFactory;
import big_task2613_cash_machine.exception.InsufficientFundsException;
import big_task2613_cash_machine.exception.InterruptedOperationException;

import java.util.Map;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptedOperationException {
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            ConsoleHelper.writeMessage("Please enter the amount to withdraw:");
            String answer = ConsoleHelper.readString();
            try {
                int amount = Integer.parseInt(answer);
                if (manipulator.isAmountAvailable(amount)) {
                    Map<Integer, Integer> withdrawn = manipulator.withdrawAmount(amount);
                    for (Map.Entry<Integer, Integer> entry : withdrawn.entrySet()) {
                        ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                    }
                    ConsoleHelper.writeMessage("Your transaction was successful!");
                    break;
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Your data is invalid. Try again.");
            } catch (InsufficientFundsException ex) {
                ConsoleHelper.writeMessage("We are very sorry - the banknotes in this ATM are insufficient to perform this withdrawal...");
            }
        }
    }
}

