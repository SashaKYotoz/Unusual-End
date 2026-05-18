package net.sweety.unusualend.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.block.entity.BuildingInhibitorBlockEntity;
import net.sweety.unusualend.procedures.ReturnBuildingInhibIsActiveProcedure;
import net.sweety.unusualend.world.inventory.BuildingInhibitorGUIMenu;

import java.util.HashMap;

public class BuildingInhibitorGUIScreen extends AbstractContainerScreen<BuildingInhibitorGUIMenu> {
    private final Level level;
    private final int x, y, z;
    private final Player player;

    public BuildingInhibitorGUIScreen(BuildingInhibitorGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.level = container.level;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.player = container.player;
        this.imageWidth = 176;
        this.imageHeight = 126;
    }

    private static final ResourceLocation texture = UnusualEnd.makeUEID("textures/screens/building_inhibitor_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (toShow())
            if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 11 && mouseY < topPos + 35)
                guiGraphics.renderTooltip(font, Component.literal(ReturnBuildingInhibIsActiveProcedure.execute(level, x, y, z)), mouseX, mouseY);
        if (toShow())
            if (mouseX > leftPos + 99 && mouseX < leftPos + 123 && mouseY > topPos + 11 && mouseY < topPos + 35)
                guiGraphics.renderTooltip(font, Component.literal(ReturnBuildingInhibIsActiveProcedure.execute(level, x, y, z)), mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        if (toShow()) {
            guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/inhibiter_active_arrow.png"), this.leftPos + 100, this.topPos + 11, 0, 0, 19, 6, 19, 6);
        }
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        String s = "%s/32".formatted(getBlockEntity() != null && getBlockEntity().getPersistentData().getDouble("Fuel") > 0
                ? Math.round(getBlockEntity().getPersistentData().getDouble("Fuel")) : 0);
        guiGraphics.drawString(this.font, s, 103, 22, -12829636, false);
    }

    private BuildingInhibitorBlockEntity getBlockEntity() {
        for (int x = -7; x < 7; x++) {
            for (int y = -7; y < 7; y++) {
                for (int z = -7; z < 7; z++) {
                    BlockPos pos1 = player.getOnPos().offset(x, y, z);
                    if (level.getBlockEntity(pos1) instanceof BuildingInhibitorBlockEntity entity)
                        return entity;
                }
            }
        }
        return null;
    }

    private boolean toShow() {
        return Math.round(
                getBlockEntity() == null ? 0
                        : getBlockEntity().getPersistentData().getDouble("isActive")
        ) > 0;
    }

    @Override
    public void init() {
        super.init();
    }
}
