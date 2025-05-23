package net.mcreator.unusualend.client.gui;

import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.unusualend.world.inventory.InfuserGUIMenu;
import net.mcreator.unusualend.procedures.ReturnShinyProcedure;
import net.mcreator.unusualend.procedures.ReturnPrismaticProcedure;
import net.mcreator.unusualend.procedures.ReturnCitrineProcedure;
import net.mcreator.unusualend.network.InfuserGUIButtonMessage;
import net.mcreator.unusualend.UnusualEnd;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import net.neoforged.neoforge.network.PacketDistributor;

public class InfuserGUIScreen extends AbstractContainerScreen<InfuserGUIMenu> {
	private final static HashMap<String, Object> guistate = InfuserGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_1_base;
	ImageButton imagebutton_1_base1;
	ImageButton imagebutton_1_base2;
	ImageButton imagebutton_4_base;
	ImageButton imagebutton_4_base1;
	ImageButton imagebutton_4_base2;
	ImageButton imagebutton_8_base;
	ImageButton imagebutton_8_base1;
	ImageButton imagebutton_8_base2;

	public InfuserGUIScreen(InfuserGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = UnusualEnd.makeUEID("textures/screens/infuser_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics,mouseX,mouseY,partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 31 && mouseX < leftPos + 51 && mouseY > topPos + 12 && mouseY < topPos + 51)
			guiGraphics.renderTooltip(font, Component.translatable("text.infuser.citrine"), mouseX, mouseY);
		if (mouseX > leftPos + 85 && mouseX < leftPos + 105 && mouseY > topPos + 12 && mouseY < topPos + 51)
			guiGraphics.renderTooltip(font, Component.translatable("text.infuser.shiny"), mouseX, mouseY);
		if (mouseX > leftPos + 139 && mouseX < leftPos + 159 && mouseY > topPos + 12 && mouseY < topPos + 51)
			guiGraphics.renderTooltip(font, Component.translatable("text.infuser.prismatic"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (ReturnCitrineProcedure.execute(world, x, y, z, 1)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 62, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 2)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 55, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 3)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 48, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 4)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 41, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 5)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 34, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 6)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 27, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 7)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 20, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnCitrineProcedure.execute(world, x, y, z, 8)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, this.topPos + 13, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 1)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 62, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 2)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 55, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 3)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 48, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 4)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 41, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 5)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 34, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 6)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 27, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 7)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 20, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnShinyProcedure.execute(world, x, y, z, 8)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, this.topPos + 13, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 1)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 62, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 2)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 55, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 3)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 48, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 4)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 41, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 5)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 34, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 6)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 27, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 7)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 20, 0, 0, 16, 7, 16, 7);
		}
		if (ReturnPrismaticProcedure.execute(world, x, y, z, 8)) {
			guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, this.topPos + 13, 0, 0, 16, 7, 16, 7);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_1_base = new ImageButton(this.leftPos - 2, this.topPos + 51, 18, 12,
				new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(0, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_1_base", imagebutton_1_base);
		this.addRenderableWidget(imagebutton_1_base);
		imagebutton_1_base1 = new ImageButton(this.leftPos + 87, this.topPos + 38, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base1.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base1.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(1, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_1_base1", imagebutton_1_base1);
		this.addRenderableWidget(imagebutton_1_base1);
		imagebutton_1_base2 = new ImageButton(this.leftPos + 141, this.topPos + 38, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base2.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_1_base2.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(2, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_1_base2", imagebutton_1_base2);
		this.addRenderableWidget(imagebutton_1_base2);
		imagebutton_4_base = new ImageButton(this.leftPos + 33, this.topPos + 25, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(3, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_4_base", imagebutton_4_base);
		this.addRenderableWidget(imagebutton_4_base);
		imagebutton_4_base1 = new ImageButton(this.leftPos + 87, this.topPos + 25, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base1.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base1.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(4, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_4_base1", imagebutton_4_base1);
		this.addRenderableWidget(imagebutton_4_base1);
		imagebutton_4_base2 = new ImageButton(this.leftPos + 141, this.topPos + 25, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base2.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_4_base2.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(5, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_4_base2", imagebutton_4_base2);
		this.addRenderableWidget(imagebutton_4_base2);
		imagebutton_8_base = new ImageButton(this.leftPos + 33, this.topPos + 12, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(6, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_8_base", imagebutton_8_base);
		this.addRenderableWidget(imagebutton_8_base);
		imagebutton_8_base1 = new ImageButton(this.leftPos + 87, this.topPos + 12, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base1.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base1.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(7, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_8_base1", imagebutton_8_base1);
		this.addRenderableWidget(imagebutton_8_base1);
		imagebutton_8_base2 = new ImageButton(this.leftPos + 141, this.topPos + 12, 18, 12, new WidgetSprites(UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base2.png"), UnusualEnd.makeUEID("textures/screens/atlas/imagebutton_8_base2.png")), e -> {
			PacketDistributor.SERVER.noArg().send(new InfuserGUIButtonMessage(8, x, y, z));
			InfuserGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 18, 24, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_8_base2", imagebutton_8_base2);
		this.addRenderableWidget(imagebutton_8_base2);
	}
}
