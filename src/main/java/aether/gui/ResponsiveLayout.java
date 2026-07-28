package aether.gui;


public final class ResponsiveLayout {


    private ResponsiveLayout() {
    }



    public static float scale(
            int screenWidth,
            int screenHeight
    ) {


        float scaleWidth =
                screenWidth / 1920f;


        float scaleHeight =
                screenHeight / 1080f;


        float scale =
                Math.min(
                        scaleWidth,
                        scaleHeight
                );


        return Math.max(
                0.75f,
                Math.min(
                        scale,
                        1.25f
                )
        );

    }



    public static float centerX(
            float width,
            float screenWidth
    ) {

        return (screenWidth - width) / 2f;

    }



    public static float centerY(
            float height,
            float screenHeight
    ) {

        return (screenHeight - height) / 2f;

    }

}
