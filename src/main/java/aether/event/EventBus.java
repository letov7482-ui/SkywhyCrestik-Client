package aether.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventBus {

    private final List<Object> listeners = new CopyOnWriteArrayList<>();

    public void register(Object listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unregister(Object listener) {
        listeners.remove(listener);
    }

    public boolean isRegistered(Object listener) {
        return listeners.contains(listener);
    }

    public List<Object> getListeners() {
        return List.copyOf(listeners);
    }

    public void clear() {
        listeners.clear();
    }
}
