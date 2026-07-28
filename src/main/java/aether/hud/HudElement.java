package aether.hud;


import net.minecraft.client.gui.DrawContext;


public abstract class HudElement {


    private final String name;


    private boolean enabled = true;



    protected float x;

    protected float y;



    public HudElement(
            String name,
            float x,
            float y
    ) {

        this.name = name;

        this.x = x;

        this.y = y;

    }



    public abstract void render(
            DrawContext context,
            float tickDelta
    );



    public String getName() {

        return name;

    }



    public boolean isEnabled() {

        return enabled;

    }



    public void setEnabled(
            boolean enabled
    ) {

        this.enabled = enabled;

    }



    public float getX() {

        return x;

    }



    public float getY() {

        return y;

    }



    public void setPosition(
            float x,
            float y
    ) {

        this.x = x;

        this.y = y;

    }

}
