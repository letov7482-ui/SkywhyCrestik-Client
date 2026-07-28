package aether.event.events;


import aether.event.Event;



public final class KeyEvent extends Event {


    private final int key;



    public KeyEvent(
            int key
    ) {

        this.key = key;

    }



    public int getKey() {

        return key;

    }

}
