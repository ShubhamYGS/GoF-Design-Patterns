package abstractfactory.impl;

import abstractfactory.intf.Checkbox;

/**
 * Windows-style Checkbox implementation. Prints demo messages to console.
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a Windows-style checkbox.");
    }

    @Override
    public void onSelect() {
        System.out.println("Windows checkbox selected.");
    }
}