package aether.event;


import java.util.ArrayList;
import java.util.List;



public final class EventBus {


    private final List<Listener> listeners =
            new ArrayList<>();



    public void register(
            Listener listener
    ) {


        if (listener == null) {

            return;

        }



        if (!listeners.contains(listener)) {

            listeners.add(
                    listener
            );

        }

    }





    public void unregister(
            Listener listener
    ) {


        listeners.remove(
                listener
        );

    }





    public void post(
            Event event
    ) {


        if (event == null) {

            return;

        }



        for (Listener listener :
                new ArrayList<>(listeners)) {


            listener.onEvent(
                    event
            );

        }

    }





    public List<Listener> getListeners() {

        return listeners;

    }


}
