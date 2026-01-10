package state.model;

import state.impl.IdleState;
import state.intf.MachineState;

/**
 * Context in the State pattern.
 * Delegates user actions to the current MachineState, which can also switch the next state.
 */
public class VendingMachine {
    private MachineState currentState;
    private String selectedItem;
    private double insertedAmount;

    public VendingMachine() {
        this.currentState = new IdleState(); // Initial state
    }

    // Called by states to transition the machine to the next state.
    public void setState(MachineState newState) {
        this.currentState = newState;
    }

    // Context data that states can read/write.
    public void setSelectedItem(String itemCode) {
        this.selectedItem = itemCode;
    }

    public void setInsertedAmount(double amount) {
        this.insertedAmount = amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    // Public API: user selects an item. The current state decides what happens.
    public void selectItem(String itemCode) {
        currentState.selectItem(this, itemCode);
    }

    // Public API: user inserts money. The current state decides what happens.
    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    // Public API: user requests dispensing. The current state decides what happens.
    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    /**
     * Resets the machine for the next customer/transaction.
     */
    public void reset() {
        this.selectedItem = "";
        this.insertedAmount = 0.0;
        this.currentState = new IdleState();
    }
}