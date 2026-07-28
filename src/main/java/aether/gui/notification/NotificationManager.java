package aether.gui.notification;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public final class NotificationManager {


    private final List<Notification> notifications =
            new ArrayList<>();



    public void add(
            String title,
            String message
    ) {

        add(
                title,
                message,
                3000
        );

    }



    public void add(
            String title,
            String message,
            long duration
    ) {


        notifications.add(
                new Notification(
                        title,
                        message,
                        duration
                )
        );

    }



    public void tick() {


        Iterator<Notification> iterator =
                notifications.iterator();



        while (iterator.hasNext()) {


            Notification notification =
                    iterator.next();



            if (notification.isExpired()) {


                iterator.remove();


            }

        }

    }



    public List<Notification> getNotifications() {


        return notifications;

    }

}
