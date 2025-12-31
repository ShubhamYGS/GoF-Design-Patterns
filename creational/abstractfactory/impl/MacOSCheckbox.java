package abstractfactory.impl;

import abstractfactory.intf.Checkbox;

/**
 * macOS-style Checkbox implementation. Prints demo messages to console.
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a macOS-style checkbox.");
    }

    @Override
    public void onSelect() {
        System.out.println("MacOS checkbox selected.");
    }
}