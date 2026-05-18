package net.sweety.unusualend.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.network.InfuserGUIPacket;
import net.sweety.unusualend.world.inventory.InfuserGUIMenu;

public class InfuserGUIScreen extends AbstractContainerScreen<InfuserGUIMenu> {
    private final Level level;
    private final BlockPos pos;
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
        this.level = container.level;
        this.pos = container.pos;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = UnusualEnd.makeUEID("textures/screens/infuser_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
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
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(texture, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        for (int i = 1; i <= 8; i++) {
            if (this.hasCharge("Citrine", i)) {
                int yPos = this.topPos + 62 - ((i - 1) * 7);
                guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/citrine_charge.png"), this.leftPos + 14, yPos, 16, 7, 0.0F, 0.0F, 16, 7, 16, 7);
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (this.hasCharge("Shiny", i)) {
                int yPos = this.topPos + 62 - ((i - 1) * 7);
                guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/shiny_charge.png"), this.leftPos + 68, yPos, 16, 7, 0.0F, 0.0F, 16, 7, 16, 7);
            }
        }
        for (int i = 1; i <= 8; i++) {
            if (this.hasCharge("Prismatic", i)) {
                int yPos = this.topPos + 62 - ((i - 1) * 7);
                guiGraphics.blit(UnusualEnd.makeUEID("textures/screens/prismatic_charge.png"), this.leftPos + 122, yPos, 16, 7, 0.0F, 0.0F, 16, 7, 16, 7);
            }
        }
        RenderSystem.disableBlend();
    }

    private boolean hasCharge(String tag, double value) {
        if (pos != null) {
            BlockEntity blockEntity = this.level.getBlockEntity(pos);
            if (blockEntity != null) {
                UnusualEnd.LOGGER.debug(blockEntity.getPersistentData().getDouble(tag));
                return blockEntity.getPersistentData().getDouble(tag) >= value;
            }
        }
        return false;
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

    private ImageButton createInfuserButton(int xOffset, int yOffset, String textureName, int packetId) {
        return new ImageButton(
                this.leftPos + xOffset,
                this.topPos + yOffset,
                18, 12,
                new WidgetSprites(
                        UnusualEnd.makeUEID("textures/screens/atlas/" + textureName + "_base.png"),
                        UnusualEnd.makeUEID("textures/screens/atlas/" + textureName + "_highlined.png")
                ),
                e -> PacketDistributor.sendToServer(new InfuserGUIPacket(packetId, pos.getX(), pos.getY(), pos.getZ()))
        ) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
                guiGraphics.blit(
                        sprites.get(isActive(), isHoveredOrFocused()),
                        getX(), getY(),
                        0.0F, 0.0F,
                        width, height,
                        width, height
                );
            }
        };
    }

    @Override
    public void init() {
        super.init();
        this.addRenderableWidget(imagebutton_1_base = createInfuserButton(33, 38, "imagebutton_1", 0));
        this.addRenderableWidget(imagebutton_1_base1 = createInfuserButton(87, 38, "imagebutton_1", 1));
        this.addRenderableWidget(imagebutton_1_base2 = createInfuserButton(141, 38, "imagebutton_1", 2));
        this.addRenderableWidget(imagebutton_4_base = createInfuserButton(33, 25, "imagebutton_4", 3));
        this.addRenderableWidget(imagebutton_4_base1 = createInfuserButton(87, 25, "imagebutton_4", 4));
        this.addRenderableWidget(imagebutton_4_base2 = createInfuserButton(141, 25, "imagebutton_4", 5));
        this.addRenderableWidget(imagebutton_8_base = createInfuserButton(33, 12, "imagebutton_8", 6));
        this.addRenderableWidget(imagebutton_8_base1 = createInfuserButton(87, 12, "imagebutton_8", 7));
        this.addRenderableWidget(imagebutton_8_base2 = createInfuserButton(141, 12, "imagebutton_8", 8));
    }
}