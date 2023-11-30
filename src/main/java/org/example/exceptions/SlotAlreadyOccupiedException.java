package org.example.exceptions;

public class SlotAlreadyOccupiedException extends RuntimeException {
    public SlotAlreadyOccupiedException() {
        super("Slot already occupied for the screen") ;
    }
}
