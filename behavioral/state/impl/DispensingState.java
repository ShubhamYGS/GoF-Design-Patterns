package state.impl;

import state.intf.MachineState;
import state.model.VendingMachine;

/**
 * Concrete State: dispensing is in progress.
 * While in this state, the machine ignores/blocks new actions.
 */
class DispensingState implements MachineState {
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Please wait, dispensing in progress.");
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {
        System.out.println("Please wait, dispensing in progress.");
    }

    @Override
    public void dispenseItem(VendingMachine context) {
        System.out.println("Already dispensing. Please wait.");
    }
}