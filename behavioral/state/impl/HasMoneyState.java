package state.impl;

import state.intf.MachineState;
import state.model.VendingMachine;

/**
 * Concrete State: money has been inserted, so the next valid action is dispensing.
 */
class HasMoneyState implements MachineState {
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Cannot change item after inserting money.");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Money already inserted.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Dispensing item: " + context.getSelectedItem());

        // Move to a temporary "dispensing" state while the machine is working.
        context.setState(new DispensingState());

        // Simulate dispensing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Item dispensed successfully.");

        // Transaction finished: reset back to the initial (idle) state.
        context.reset();
    }
}