package state.impl;

import state.intf.MachineState;
import state.model.VendingMachine;

/**
 * Concrete State: machine is idle and waiting for the user to choose an item.
 */
public class IdleState implements MachineState {
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item selected: " + itemCode);
        context.setSelectedItem(itemCode);

        // Next: item chosen, so move to a state that accepts coins.
        context.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please select an item before inserting coins.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("No item selected. Nothing to dispense.");
    }
}