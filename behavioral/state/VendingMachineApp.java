package state;

import state.model.VendingMachine;

/**
 * Demo client for the State pattern (vending machine).
 * Runs a couple of transactions to show how behavior changes by state.
 */
public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.insertCoin(1.0); // Invalid until an item is selected (IdleState)

        vm.selectItem("A1");
        vm.insertCoin(1.5);
        vm.dispenseItem();

        System.out.println("\n--- Second Transaction ---");
        vm.selectItem("B2");
        vm.insertCoin(2.0);
        vm.dispenseItem();
    }
}