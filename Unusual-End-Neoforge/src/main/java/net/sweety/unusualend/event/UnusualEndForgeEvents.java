package net.sweety.unusualend.event;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.configuration.UEConfig;
import net.sweety.unusualend.entity.*;
import net.sweety.unusualend.init.*;
import net.sweety.unusualend.network.UnusualEndVariables;
import net.sweety.unusualend.procedures.*;
import net.sweety.unusualend.world.inventory.InfuserGUIMenu;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class UnusualEndForgeEvents {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        if (event.getLevel().getBlockState(event.getPos()).is(UnusualEndBlocks.VOID_EXPLOSIVE.get())) {
            if (player.getMainHandItem().is(ItemTags.create(UnusualEnd.makeUEID("explosive_igniter")))
                    || player.getOffhandItem().is(ItemTags.create(UnusualEnd.makeUEID("explosive_igniter")))) {
                if (event != null)
                    event.setCanceled(true);
                if (player.getMainHandItem().is(ItemTags.create(UnusualEnd.makeUEID("explosive_igniter"))))
                    player.swing(InteractionHand.MAIN_HAND, true);
                else
                    player.swing(InteractionHand.OFF_HAND, true);
                SpawnExplosiveProcedure.execute(player.level(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
            }
        }
        if (player.isVehicle()) {
            if ((player.getFirstPassenger()) instanceof GlubEntity) {
                if (player.isShiftKeyDown()) {
                    (player.getFirstPassenger()).stopRiding();
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerWanderingTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

                new ItemStack(UnusualEndItems.ENDERFIREFLY_BUCKET.get()), 2, 5, 0.05f));
        event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 15),

                new ItemStack(UnusualEndItems.VOID_TOTEM.get()), 1, 5, 0.05f));
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.LURKER_SLUDGE.get(), UnusualEndPotions.LEVITATION);
        event.getBuilder().addMix(UnusualEndPotions.HASTE, Items.REDSTONE, UnusualEndPotions.ADVANCED_HASTE);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.GOLEM_ORB.get(), UnusualEndPotions.BUILDING_POTION);
        event.getBuilder().addRecipe(Ingredient.of(UnusualEndItems.CHORUS_JUICE.get()), Ingredient.of(UnusualEndItems.CHORUS_PETAL.get()), UnusualEndItems.CHORUS_TEA.get().getDefaultInstance());
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.BOLOK_SCALE.get(), UnusualEndPotions.HEAVINESS_POTION);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.END_BLOB.get(), UnusualEndPotions.END_INFECTION);
        event.getBuilder().addStartMix(UnusualEndItems.WARPED_POTION.get(), UnusualEndPotions.HEALTH_BOOST);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.GLOOPILON_SLICE.get(), UnusualEndPotions.HASTE);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.ENDERBULB_LENS.get(), Potions.LONG_NIGHT_VISION);
        event.getBuilder().addMix(Potions.STRONG_REGENERATION, UnusualEndItems.SHINY_CRYSTAL.get(), UnusualEndPotions.REGENERATION_II);
        event.getBuilder().addMix(Potions.LONG_REGENERATION, UnusualEndItems.SHINY_CRYSTAL.get(), UnusualEndPotions.REGENERATION);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.CITRINE_CHUNK.get(), UnusualEndPotions.SERENITY_POTION);
        event.getBuilder().addMix(Potions.AWKWARD, UnusualEndItems.PRISMALITE_GEM.get(), UnusualEndPotions.SWIFT_STRIKES_POTION);
        event.getBuilder().addRecipe(Ingredient.of(Items.GLASS_BOTTLE), Ingredient.of(UnusualEndItems.WARPED_SPORES.get()), UnusualEndItems.WARPED_POTION.get().getDefaultInstance());
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();
        if (player.containerMenu instanceof InfuserGUIMenu)
            InfuserGUIWhileThisGUIIsOpenTickProcedure.execute(player);
        UnusualEndVariables.PlayerVariables variables = player.getData(UnusualEndVariables.PLAYER_VARIABLES.get());
        if (variables.teleporting) {
            if ((player.getPersistentData().getString("TargetDimension")).equals("" + player.level().dimension())) {
                if (!((level.getBlockState(BlockPos.containing(player.getPersistentData().getDouble("TargetX"), player.getPersistentData().getDouble("TargetY") - 1, player.getPersistentData().getDouble("TargetZ"))))
                        .getBlock() == UnusualEndBlocks.TELEPORTATION_ANCHOR.get())) {
                    player.teleportTo((Mth.nextDouble(RandomSource.create(), -1000, 1000)), (Mth.nextDouble(RandomSource.create(), 100, 120)), (Mth.nextDouble(RandomSource.create(), -1000, 1000)));
                    if (player instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((Mth.nextDouble(RandomSource.create(), -1000, 1000)), (Mth.nextDouble(RandomSource.create(), 100, 120)), (Mth.nextDouble(RandomSource.create(), -1000, 1000)), player.getYRot(),
                                player.getXRot());
                    if (!player.level().isClientSide()) {
                        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 80, 0));
                        player.displayClientMessage(Component.literal((Component.translatable("text.unusualend.tp_error").getString())), true);
                    }
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.PORTAL, (player.getX()), (player.getY()), (player.getZ()), 50, 0.5, 1.5, 0.5, 0);
                    if (!level.isClientSide()) {
                        level.playSound(null, BlockPos.containing(player.getX(), player.getY(), player.getZ()), SoundEvents.ENDER_EYE_DEATH, SoundSource.PLAYERS, 1, 1);
                    } else
                        level.playLocalSound((player.getX()), (player.getY()), (player.getZ()), SoundEvents.ENDER_EYE_DEATH, SoundSource.PLAYERS, 1, 1, false);
                }
                variables.teleporting = false;
                variables.syncPlayerVariables(player);
            }
        }
        if (player.getOffhandItem().is(UnusualEndBlocks.DRAGLING_PLUSH.get().asItem())
                && !player.getMainHandItem().is(UnusualEndBlocks.DRAGLING_PLUSH.get().asItem())) {
            player.getCooldowns().addCooldown(UnusualEndBlocks.DRAGLING_PLUSH.get().asItem(), 20);
        }
    }

    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();
        if (event.getEffect().value().equals(UnusualEndMiscRegister.CRYSTALLIZATION.get()))
            CrystallizationEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        if (event.getEffect().value().equals(UnusualEndMiscRegister.ENDER_INFECTION.get()))
            EnderInfectionEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @SubscribeEvent
    public static void addAttributeModifier(ItemAttributeModifierEvent event) {
        ItemStack itemstack = event.getItemStack();
        AttributeModifier modifier;
        if (itemstack.getMaxStackSize() == 1) {
            if (itemstack.getItem() == UnusualEndItems.WARPED_BOOTS.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("f654bc63-b67e-40ee-b11c-2d8abaab9f3e"), 0.5D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                event.addModifier(NeoForgeMod.SWIM_SPEED, modifier, EquipmentSlotGroup.FEET);
            }
            if (itemstack.getItem() == UnusualEndItems.BOUNCY_DAGGER.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("94fe2560-d356-4499-110c-94c8bb6c1bb2"), -0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("94fe2560-d376-4499-110c-64c8bb6c1bb3"), 2.0D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ATTACK_KNOCKBACK, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.WARPED_SPEAR.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("33fe2130-d356-4749-110c-94c8bb6c1bb8"), 2.0D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.WARPED_CHESTPLATE.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("34fe2560-d356-4799-110c-99c8bb6c1bb2"), -0.05D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                event.addModifier(Attributes.MOVEMENT_SPEED, modifier, EquipmentSlotGroup.CHEST);
            }
            if (itemstack.getItem() == UnusualEndItems.PEARLESCENT_SWORD.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("574188c2-554a-11ee-8c99-0242ac120002"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("e5c352ec-554a-11ee-8c99-0242ac120002"), 1.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.BLOCK_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.PEARLESCENT_AXE.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("674188c2-554a-11ee-8c99-0242ac120002"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("65c352ec-554a-11ee-8c99-0242ac120002"), 1.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.BLOCK_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.PEARLESCENT_PICKAXE.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("584188c2-554a-11ee-8c99-0242ac120002"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("e5c952ec-554a-11ee-8c99-0242ac120002"), 1.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.BLOCK_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.PEARLESCENT_HOE.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("574108c2-554a-11ee-8c99-0242ac120002"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("e5c352fc-554a-11ee-8c99-0242ac120002"), 1.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.BLOCK_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.PEARLESCENT_SHOVEL.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("573188c2-554a-11ee-8c99-0242ac120002"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("e5c352ec-554a-11fe-8c99-0242ac120002"), 1.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.BLOCK_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.ANCIENT_SWORD.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("573188c2-554a-11ee-8c99-0242ac128802"), 0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.CITRINE_AMULET.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("584182c5-332a-12ee-8c99-0242ac128802"), 1.0D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.LUCK, modifier, EquipmentSlotGroup.OFFHAND);
            }
            if (itemstack.getItem() == UnusualEndItems.SCALE_HORSE_ARMOR.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("784142c5-312a-12ee-8c49-0242ac128802"), 2.0D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                event.addModifier(NeoForgeMod.SWIM_SPEED, modifier, EquipmentSlotGroup.BODY);
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("704142c5-312a-12ee-8c49-0242ac125502"), 1.0D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.STEP_HEIGHT, modifier, EquipmentSlotGroup.BODY);
            }
            if (itemstack.getItem() == UnusualEndItems.WARPED_ANCHOR.get()) {
                modifier = new AttributeModifier(UnusualEndMiscRegister.getModEffectLocation("0c948739-fac0-431d-854c-9ed62408760d"), -0.5D, AttributeModifier.Operation.ADD_VALUE);
                event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modifier, EquipmentSlotGroup.MAINHAND);
            }
        }
    }

    @SubscribeEvent
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
        LivingEntity entity = event.getEntity();
        Level level = event.getEntity().level();
        if ((entity.getMainHandItem().is(UnusualEndItems.ENDERBLOB_SHIELD.get())
                || entity.getOffhandItem().is(UnusualEndItems.ENDERBLOB_SHIELD.get())) && entity.isBlocking()) {
            if (level instanceof ServerLevel serverLevel)
                serverLevel.sendParticles(ParticleTypes.REVERSE_PORTAL, event.getEntity().getX(), event.getEntity().getY() + 1.3f, event.getEntity().getZ(), 1, 0.6, 0.4, 0.6, 0);
        }
    }

    @SuppressWarnings("removal")
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Entity sourceEntity = event.getSource().getEntity();
        if (entity instanceof Shulker) {
            if (sourceEntity instanceof BolokEntity) {
                if (Math.random() < 0.7) {
                    if (entity.level() instanceof ServerLevel _level) {
                        Entity entityToSpawn = UnusualendModEntities.SPUNKLER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.level().getRandom().nextFloat() * 360F);
                        }
                    }
                }
            }
        }
        if ((sourceEntity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == UnusualEndItems.CITRINE_AMULET.get()) {
            CitrineTalismanTriggerProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        }
        if (ModList.get().isLoaded("curios")) {
//            if (sourceEntity instanceof LivingEntity livingEntity && CuriosApi.getCuriosHelper().findEquippedCurio(UnusualEndItems.CITRINE_AMULET.get(), livingEntity).isPresent()) {
//                CitrineTalismanTriggerProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
//            }
        }
        if (entity instanceof LargeBubbleEntity) {
            if (entity.level() instanceof ServerLevel _level)
                _level.sendParticles(UnusualEndMiscRegister.WARPED_BUBBLES.get(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 20, 1, 1, 1, 0.1);
            if (entity.level() instanceof Level level) {
                if (!level.isClientSide())
                    level.playSound(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 1, 1);
                else
                    level.playLocalSound(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 1, 1, false);
            }
            if (!entity.level().isClientSide())
                entity.discard();
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        LevelAccessor level = event.getLevel();
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        BlockState blockState = event.getState();
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (blockState.is(UnusualEndBlocks.SHINY_GLOOPSTONE.get())) {
            if (!player.isCreative()) {
                if (Math.random() < 0.02) {
                    if (level instanceof Level _level) {
                        if (!_level.isClientSide())
                            _level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 1, 1);
                        else
                            _level.playLocalSound(x, y, z, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 1, 1, false);
                    }
                    for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
                        if (level instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null)
                                entityToSpawn.setYRot(level.getRandom().nextFloat() * 360F);
                        }
                        if (level instanceof ServerLevel _level) {
                            _level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.2), (z + 0.5), 10, 1.3, 1.3, 1.3, 0);
                            _level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + 0.5), (y + 0.2), (z + 0.5), 5, 1.3, 1.3, 1.3, 0);
                        }
                    }
                    for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 0, 1); index1++) {
                        if (level instanceof ServerLevel _level) {
                            Entity entityToSpawn = UnusualendModEntities.ENDER_BLOB.get().spawn(_level, BlockPos.containing(x + 0.5, y + 0.2, z + 0.5), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setYRot(level.getRandom().nextFloat() * 360F);
                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        BlockState blockState = event.getPlacedBlock();
        Entity entity = event.getEntity();
        LevelAccessor accessor = event.getLevel();
        if (blockState.is(UnusualEndBlocks.BUILDING_INHIBITOR.get())) {
            if (!accessor.isClientSide() && entity != null) {
                BlockPos pos = BlockPos.containing(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                BlockEntity blockentity = accessor.getBlockEntity(pos);
                if (blockentity != null)
                    blockentity.getPersistentData().putString("Owner", entity.getStringUUID());
                if (accessor instanceof Level level)
                    level.sendBlockUpdated(pos, blockState, blockState, 3);
            }
        }
    }

    @SubscribeEvent
    public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemstack = event.getItemStack();
        if (itemstack.is(UnusualEndItems.GOLEM_ORB.get()))
            event.setBurnTime(640000);
        else if (itemstack.is(UnusualEndBlocks.CHORUS_CANE.get().asItem()))
            event.setBurnTime(50);
        else if (itemstack.is(UnusualEndBlocks.BLOOMING_CHORUS_CANE.get().asItem()))
            event.setBurnTime(50);
        else if (itemstack.is(UnusualEndBlocks.CHORUS_CANE_BLOCK.get().asItem()))
            event.setBurnTime(400);
        else if (itemstack.is(UnusualEndBlocks.STRIPPED_CHORUS_CANE_BLOCK.get().asItem()))
            event.setBurnTime(400);
    }

    @SubscribeEvent
    public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getEntity().level() instanceof ServerLevel level)
            level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, event.getEntity().position(), Vec2.ZERO, level, 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(),
                    ("stopsound " + event.getEntity().getDisplayName().getString() + " music"));
    }


    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        Entity sourceEntity = event.getSource().getEntity();
        Entity immediateSourceentity = event.getContainer().getSource().getEntity();
        if (entity != null) {
            Level level = event.getEntity().level();
            double x = event.getEntity().getX();
            double y = event.getEntity().getY();
            double z = event.getEntity().getZ();
            double amount = event.getAmount();
            double X;
            double Y;
            double Z;
            if (entity.getItemBySlot(EquipmentSlot.HEAD).is(UnusualEndItems.CHORUS_HELMET.get())) {
                if (!entity.isShiftKeyDown()) {
                    if (Math.random() < UEConfig.CHORUS_HELMET_PROBABILITY_TO_TELEPORT.get() / 100) {
                        for (int index0 = 0; index0 < 1000; index0++) {
                            X = x + Mth.nextInt(RandomSource.create(), -5, 5);
                            Y = y + Mth.nextInt(RandomSource.create(), -2, 2);
                            Z = z + Mth.nextInt(RandomSource.create(), -5, 5);
                            if ((level.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.CAVE_AIR || (level.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.VOID_AIR
                                    || (level.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.AIR) {
                                if (level.getBlockState(BlockPos.containing(X, Y - 1, Z)).canOcclude()) {
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo(X, Y, Z);
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport(X, Y, Z, _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (level instanceof ServerLevel _level)
                                        _level.sendParticles(ParticleTypes.PORTAL, X, Y, Z, 30, 0.5, 1.5, 0.5, 0);
                                    if (!level.isClientSide()) {
                                        level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1);
                                    } else
                                        level.playLocalSound(x, y, z, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1, 1, false);
                                    if (amount <= UEConfig.MAX_DAMAGE_CHORUS_HELMET_CAN_DODGE_WITH_TP_.get()) {
                                        if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
                                                && _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().get(UnusualEnd.makeUEID("use_chorus_helmet"))).isDone())) {
                                            if (entity instanceof ServerPlayer _player) {
                                                AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("use_chorus_helmet"));
                                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    for (String criteria : _ap.getRemainingCriteria())
                                                        _player.getAdvancements().award(_adv, criteria);
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (immediateSourceentity == null || sourceEntity == null)
                return;
            boolean swing;
            double swing_curve, original_curve, swing_offset, dis;
            if (sourceEntity instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().is(UnusualEndItems.ANCIENT_SWORD.get())) {
                if (immediateSourceentity == sourceEntity) {
                    swing_offset = 1.5;
                    swing_curve = Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
                    original_curve = swing_curve;
                    if (swing_curve > 0.1) {
                        swing = true;
                    } else if (swing_curve < -0.1) {
                        swing = false;
                    } else {
                        if (Math.random() < 0.5) {
                            swing = true;
                            swing_curve = Mth.nextDouble(RandomSource.create(), 0.2, 0.5);
                        } else {
                            swing = false;
                            swing_curve = Mth.nextDouble(RandomSource.create(), -0.5, -0.2);
                        }
                        original_curve = swing_curve;
                    }
                    for (int index0 = 0; index0 < 30; index0++) {
                        if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                            sourceEntity.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4, sourceEntity.getName().getString(), sourceEntity.getDisplayName(),
                                            sourceEntity.level().getServer(), sourceEntity),
                                    ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.1 0.1 0.1 0 3"));
                        }
                        if (Math.random() < 0.1) {
                            if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                                sourceEntity.getServer().getCommands()
                                        .performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4,
                                                        sourceEntity.getName().getString(), sourceEntity.getDisplayName(), sourceEntity.level().getServer(), sourceEntity),
                                                ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:end_rod ~ ~ ~"));
                            }
                        }
                        if (Math.random() < 0.3) {
                            if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                                sourceEntity.getServer().getCommands()
                                        .performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4,
                                                        sourceEntity.getName().getString(), sourceEntity.getDisplayName(), sourceEntity.level().getServer(), sourceEntity),
                                                ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve - 0.5) + " ^1.8 run particle minecraft:squid_ink ~ ~ ~"));
                            }
                        }
                        swing_offset = swing_offset - 0.1;
                        if (swing)
                            swing_curve = swing_curve - original_curve / 10;
                        else
                            swing_curve = swing_curve - original_curve / 10;
                    }
                }
                dis = Math.sqrt(Math.pow(entity.getX() - sourceEntity.getX(), 2) + Math.pow(entity.getY() - sourceEntity.getY(), 2) + Math.pow(entity.getZ() - sourceEntity.getZ(), 2));
                if (!entity.getType().is(Tags.EntityTypes.BOSSES))
                    entity.setDeltaMovement(new Vec3((((sourceEntity.getX() - entity.getX()) / dis) * 1), (((sourceEntity.getY() - entity.getY()) / dis) * 1), (((sourceEntity.getZ() - entity.getZ()) / dis) * 1)));
            }
            if (sourceEntity instanceof EnderblobQueenEntity) {
                sourceEntity.setSprinting(true);
                swing_offset = 2;
                swing_curve = 1;
                original_curve = swing_curve;
                for (int index0 = 0; index0 < 30; index0++) {
                    if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                        sourceEntity.getServer().getCommands()
                                .performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4, sourceEntity.getName().getString(),
                                                sourceEntity.getDisplayName(), sourceEntity.level().getServer(), sourceEntity),
                                        ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:block unusualend:void_particles_block ~ ~ ~ 0.1 0.1 0.1 0 3"));
                    }
                    if (Math.random() < 0.1) {
                        if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                            sourceEntity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4,
                                    sourceEntity.getName().getString(), sourceEntity.getDisplayName(), sourceEntity.level().getServer(), sourceEntity), ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:end_rod ~ ~ ~"));
                        }
                    }
                    if (Math.random() < 0.3) {
                        if (!sourceEntity.level().isClientSide() && sourceEntity.getServer() != null) {
                            sourceEntity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, sourceEntity.position(), sourceEntity.getRotationVector(), sourceEntity.level() instanceof ServerLevel ? (ServerLevel) sourceEntity.level() : null, 4,
                                            sourceEntity.getName().getString(), sourceEntity.getDisplayName(), sourceEntity.level().getServer(), sourceEntity),
                                    ("execute anchored eyes positioned ^" + swing_offset + " ^" + (swing_curve + 0.6) + " ^2 run particle minecraft:squid_ink ~ ~ ~"));
                        }
                    }
                    swing_offset = swing_offset - 0.1;
                    swing_curve = swing_curve - original_curve / 10;
                }
                UnusualEnd.queueServerWork(11, () -> sourceEntity.setSprinting(false));
            }
            double speed;
            double yaw;
            if (entity.isBlocking()) {
                if (entity.getMainHandItem().is(UnusualEndItems.ENDERBLOB_SHIELD.get()) || entity.getOffhandItem().is(UnusualEndItems.ENDERBLOB_SHIELD.get())) {
                    Entity immediateSourceEntity = event.getSource().getDirectEntity();
                    if ((!(immediateSourceEntity instanceof ServerPlayer) || UEConfig.SHIELD_PVP.get()) && immediateSourceEntity != null) {
                        speed = 0.8;
                        yaw = entity.getYRot();
                        immediateSourceEntity.setDeltaMovement(new Vec3((speed * Math.cos((yaw + 90) * (Math.PI / 180))), (immediateSourceEntity.getDeltaMovement().y() + 0.1), (speed * Math.sin((yaw + 90) * (Math.PI / 180)))));
                        if (entity instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(UnusualEnd.makeUEID("forced_social_distancing"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }
            }
            if (entity.hasEffect(UnusualEndMiscRegister.CRYSTALLIZATION)) {
                entity.getPersistentData().putDouble("CrystalDamages", (entity.getPersistentData().getDouble("CrystalDamages") + event.getAmount()));
                event.setCanceled(true);
            }
            if (entity instanceof EnderlingEntity entity1) {
                if (!entity1.level().isClientSide())
                    entity1.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 0, false, false));
                entity.setDeltaMovement(new Vec3(0, (-0.1), 0));
                if (level instanceof ServerLevel _level)
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                            "particle dust_color_transition 0.827 0.216 0.741 1.5 0.047 0.047 0.047 ~ ~1 ~ 0.2 0.3 0.2 0 20 normal");
            }
            if (sourceEntity instanceof Endermite || sourceEntity instanceof EnderblobEntity) {
                if (entity instanceof EnderMan) {
                    if (Math.random() < 0.5) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.ENDER_INFECTION, 36000, 0));
                    }
                } else {
                    if (Math.random() < UEConfig.ENDERMITES_PROBABILITY_TO_INFECT.get() / 100) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.ENDER_INFECTION, 600, 0));
                    }
                }
            }
            double dividedby = 0;
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UnusualEndItems.WARPED_CHESTPLATE.get()) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, false, true));
                if (!(entity == sourceEntity)) {
                    if (sourceEntity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.HEAVINESS, 40, 1, false, true));
                }
            }
            if (entity instanceof VoidBombEntity || entity instanceof VoidCrackEntity) {
                if (event != null) {
                    event.setCanceled(true);
                }
            }
            if (sourceEntity instanceof DraglingEntity) {
                if (Math.random() < UEConfig.DRAGLING_DISRUPTION.get() / 100) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(UnusualEndMiscRegister.DISRUPTION, 60, 0));
                }
            }
            if (sourceEntity instanceof EnderbulbEntity) {
                dividedby = 1;
                {
                    Entity _ent = sourceEntity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @s ~ ~ ~ facing entity " + entity));
                    }
                }
                for (int index0 = 0; index0 < 25; index0++) {
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.WITCH, (sourceEntity.getX() + (entity.getX() - sourceEntity.getX()) / dividedby), (sourceEntity.getY() + 0.8 + (entity.getY() - sourceEntity.getY()) / dividedby),
                                (sourceEntity.getZ() + (entity.getZ() - sourceEntity.getZ()) / dividedby), 1, 0, 0, 0, 0);
                    dividedby = dividedby + 0.4;
                }
                if (sourceEntity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
                if (!level.isClientSide())
                    level.playSound(null, BlockPos.containing(sourceEntity.getX(), sourceEntity.getY(), sourceEntity.getZ()), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1, 2);
                else
                    level.playLocalSound((sourceEntity.getX()), (sourceEntity.getY()), (sourceEntity.getZ()), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1, 2, false);
            }
            if (sourceEntity instanceof DraglingEntity) {
                if ((sourceEntity instanceof DraglingEntity _datEntL28 && _datEntL28.getEntityData().get(DraglingEntity.DATA_atk))) {
                    if (sourceEntity instanceof DraglingEntity _datEntSetL)
                        _datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, false);
                    UnusualEnd.queueServerWork(1, () -> {
                        if (sourceEntity instanceof DraglingEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
                    });
                } else {
                    if (sourceEntity instanceof DraglingEntity _datEntSetL)
                        _datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, true);
                }
                UnusualEnd.queueServerWork(20, () -> {
                    if ((sourceEntity instanceof DraglingEntity _datEntL33 && _datEntL33.getEntityData().get(DraglingEntity.DATA_atk))) {
                        if (sourceEntity instanceof DraglingEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(DraglingEntity.DATA_atk, false);
                    }
                });
            }
            if (sourceEntity instanceof SummonedDraglingEntity) {
                if ((sourceEntity instanceof SummonedDraglingEntity _datEntL37 && _datEntL37.getEntityData().get(SummonedDraglingEntity.DATA_atk))) {
                    if (sourceEntity instanceof SummonedDraglingEntity _datEntSetL)
                        _datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, false);
                    UnusualEnd.queueServerWork(1, () -> {
                        if (sourceEntity instanceof SummonedDraglingEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
                    });
                } else {
                    if (sourceEntity instanceof SummonedDraglingEntity _datEntSetL)
                        _datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, true);
                }
                UnusualEnd.queueServerWork(20, () -> {
                    if ((sourceEntity instanceof SummonedDraglingEntity _datEntL42 && _datEntL42.getEntityData().get(SummonedDraglingEntity.DATA_atk))) {
                        if (sourceEntity instanceof SummonedDraglingEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(SummonedDraglingEntity.DATA_atk, false);
                    }
                });
            }
            if (entity.hasEffect(UnusualEndMiscRegister.SERENITY)) {
                if (event.getSource().is(DamageTypes.FALL)) {
                    entity.fallDistance = 0;
                    if (level instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 30, 1, 0.5, 1, 0);
                    DivideSerenityProcedure.execute(entity);
                }
            }
            if (entity instanceof SmallEnderbulbEntity) {
                if (sourceEntity instanceof Frog) {
                    entity.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 20);
                }
            }
            if (sourceEntity instanceof FlampyrEntity) {
                if (entity instanceof Endermite || entity instanceof EnderblobEntity || entity instanceof EnderbulbEntity || entity instanceof SmallEnderbulbEntity) {
                    entity.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15);
                }
            }
            if (entity instanceof Player) {
                if (event.getSource().is(DamageTypes.FALL)) {
                    if (level.getBlockState(BlockPos.containing(x, y - 1, z)).is(UnusualEndBlocks.BOUNCY_GLOOPSLATE.get())) {
                        if (amount < 3) {
                            entity.fallDistance = 0;
                        }
                    }
                }
            }
        }
    }
}