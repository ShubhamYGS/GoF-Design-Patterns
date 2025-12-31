package abstractfactory.impl;

import abstractfactory.intf.Button;

/**
 * macOS-style Button implementation. Prints demo messages to console.
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a macOS-style button.");
    }

    @Override
    public void onClick() {
        System.out.println("MacOS button clicked.");
    }
}