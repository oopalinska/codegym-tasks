package big_task2613_cash_machine.command;

import big_task2613_cash_machine.ConsoleHelper;
import big_task2613_cash_machine.exception.InterruptedOperationException;

public class LoginCommand implements Command {
    private static final String CARD_NUMBER = "123456789012";
    private static final String PIN = "1234";

    @Override
    public void execute() throws InterruptedOperationException {
        String inputCardNumber;
        String inputPIN;
        while (true) {
            ConsoleHelper.writeMessage("Please enter a 12-digit credit card number.");
            inputCardNumber = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Please enter a 4-digit PIN code.");
            inputPIN = ConsoleHelper.readString();
            if (inputCardNumber.length() != 12 || inputPIN.length() != 4 ||
                    !inputCardNumber.matches("[0-9]+") || !inputPIN.matches("[0-9]+")) {
                ConsoleHelper.writeMessage("Unfortunately, your data is invalid. Try again.");
            } else if (inputCardNumber.equals(CARD_NUMBER) && inputPIN.equals(PIN)) {
                ConsoleHelper.writeMessage("Verification was successful!");
                break;
            }
        }
    }
}