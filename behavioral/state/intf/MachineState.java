package state.intf;

import state.model.VendingMachine;

/**
 * State interface for the vending machine.
 * Each concrete state decides what to do for each user action (select/insert/dispense).
 */
public interface MachineState {
    void selectItem(VendingMachine context, String itemCode);

    void insertCoin(VendingMachine context, double amount);

    void dispenseItem(VendingMachine context);
}