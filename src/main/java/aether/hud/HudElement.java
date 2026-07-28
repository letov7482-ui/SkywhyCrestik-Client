package aether.hud;

import net.minecraft.client.gui.DrawContext;

public abstract class HudElement {

    private final String name;

    protected float x;
    protected float y;

    protected float width;
    protected float height;

    private boolean enabled = true;

    private boolean dragging;

    private float dragOffsetX;
    private float dragOffsetY;


    public HudElement(
            String name,
            float x,
            float y
    ) {

        this.name = name;

        this.x = x;
        this.y = y;
    }


    public final void render(DrawContext context) {

        if (!enabled) {
            return;
        }

        draw(context);
    }


    protected abstract void draw(DrawContext context);


    public void tick() {
    }


    public String getName() {
        return name;
    }


    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }


    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }


    public void setPosition(
            float x,
            float y
    ) {

        this.x = x;
        this.y = y;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(
            boolean enabled
    ) {

        this.enabled = enabled;
    }


    public boolean isHovering(
            double mouseX,
            double mouseY
    ) {

        return mouseX >= x &&
                mouseX <= x + width &&
                mouseY >= y &&
                mouseY <= y + height;
    }


    public void mousePressed(
            double mouseX,
            double mouseY
    ) {

        if (isHovering(mouseX, mouseY)) {

            dragging = true;

            dragOffsetX =
                    (float) mouseX - x;

            dragOffsetY =
                    (float) mouseY - y;
        }
    }


    public void mouseDragged(
            double mouseX,
            double mouseY
    ) {

        if (!dragging) {
            return;
        }

        x =
                (float) mouseX - dragOffsetX;

        y =
                (float) mouseY - dragOffsetY;
    }


    public void mouseReleased() {

        dragging = false;
    }

}
