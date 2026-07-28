package aether.gui.notification;


public final class Notification {


    private final String title;

    private final String message;


    private final long created;


    private final long duration;



    private float animation;



    public Notification(
            String title,
            String message,
            long duration
    ) {

        this.title = title;

        this.message = message;

        this.duration = duration;

        this.created =
                System.currentTimeMillis();

    }



    public boolean isExpired() {


        return System.currentTimeMillis()
                -
                created
                >
                duration;

    }



    public String getTitle() {

        return title;

    }



    public String getMessage() {

        return message;

    }



    public float getProgress() {


        long time =
                System.currentTimeMillis()
                        -
                        created;


        return Math.min(
                1f,
                time /
                (float) duration
        );

    }



    public float getAnimation() {

        return animation;

    }



    public void setAnimation(
            float animation
    ) {

        this.animation =
                animation;

    }

}
