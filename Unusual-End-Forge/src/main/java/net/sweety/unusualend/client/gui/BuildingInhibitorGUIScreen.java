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
import net.sweety.unusualend.procedures.ReturnBuildingInhibIsActiveProcedure;
import net.sweety.unusualend.util.ProcedureHelper;
import net.sweety.unusualend.world.inventory.BuildingInhibitorGUIMenu;

import java.util.HashMap;

public class BuildingInhibitorGUIScreen extends AbstractContainerScreen<BuildingInhibitorGUIMenu> {
	private final static HashMap<String, Object> guistate = BuildingInhibitorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public BuildingInhibitorGUIScreen(BuildingInhibitorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 126;
	}

	private static final ResourceLocation texture = new ResourceLocation("unusualend:textures/screens/building_inhibitor_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if ((Math.round(ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive")) > 0))
			if (mouseX > leftPos + 122 && mouseX < leftPos + 146 && mouseY > topPos + 11 && mouseY < topPos + 35)
				guiGraphics.renderTooltip(font, Component.literal(ReturnBuildingInhibIsActiveProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if ((Math.round(ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive")) > 0))
			if (mouseX > leftPos + 99 && mouseX < leftPos + 123 && mouseY > topPos + 11 && mouseY < topPos + 35)
				guiGraphics.renderTooltip(font, Component.literal(ReturnBuildingInhibIsActiveProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if ((ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "isActive") > 0)) {
			guiGraphics.blit(new ResourceLocation("unusualend:textures/screens/inhibiter_active_arrow.png"), this.leftPos + 100, this.topPos + 11, 0, 0, 19, 6, 19, 6);
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
		guiGraphics.drawString(this.font,

				(Math.round(ProcedureHelper.getBlockEntityDouble(world, BlockPos.containing(x, y, z), "Fuel")) + "/32\u25C6"), 103, 22, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
