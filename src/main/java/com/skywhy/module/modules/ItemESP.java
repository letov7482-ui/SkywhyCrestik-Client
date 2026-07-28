package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.ItemEntity;

public class ItemESP extends Module {
    public ItemESP() { super("ItemESP", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null) return;
        for (ItemEntity item : mc.world.getEntitiesByClass(ItemEntity.class, e -> true)) {
            // Подсветка предметов на земле
            item.setGlowing(true);
        }
    }
}
