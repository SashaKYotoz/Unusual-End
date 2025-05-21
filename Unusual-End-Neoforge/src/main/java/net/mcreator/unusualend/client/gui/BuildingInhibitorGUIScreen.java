package net.mcreator.unusualend.client.gui;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.block.entity.BuildingInhibitorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.unusualend.world.inventory.BuildingInhibitorGUIMenu;
import net.mcreator.unusualend.procedures.ReturnBuildingInhibIsActiveProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BuildingInhibitorGUIScreen extends AbstractContainerScreen<BuildingInhibitorGUIMenu> {
    private final static HashMap<String, Object> guistate = BuildingInhibitorGUIMenu.guistate;
    private final Level level;
    private final int x, y, z;
    private final BlockPos pos;
    private final Player player;

    public BuildingInhibitorGUIScreen(BuildingInhibitorGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.level = container.level;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.pos = container.pos;
        this.player = container.entity;
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
        UnusualEnd.LOGGER.info(pos != null && level.getBlockEntity(pos) instanceof BuildingInhibitorBlockEntity entity);
        guiGraphics.drawString(this.font,
                (getBlockEntity() != null
                        ? getBlockEntity().getPersistentData().getDouble("Fuel") + "/32"
                        : "0/32"), 103, 22, -12829636, false);
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
