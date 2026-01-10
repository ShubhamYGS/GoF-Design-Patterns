package state.impl;

import state.intf.MachineState;
import state.model.VendingMachine;

/**
 * Concrete State: an item is selected, so the machine is waiting for the user to insert coins.
 */
class ItemSelectedState implements MachineState {
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item already selected: " + context.getSelectedItem());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Inserted $" + amount + " for item: " + context.getSelectedItem());
        context.setInsertedAmount(amount);

        // Next: money received, so the machine can dispense now.
        context.setState(new HasMoneyState());
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Insert coin before dispensing.");
    }
}