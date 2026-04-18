package net.mcreator.unusualend.init;

import net.mcreator.unusualend.UnusualEnd;
import net.mcreator.unusualend.world.structures.VoidLimitedJigsawStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UnusualendModStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, UnusualEnd.MODID);
    public static RegistryObject<StructureType<VoidLimitedJigsawStructure>> VOID_LIMITED_JIGSAW = STRUCTURES.register("void_limited_jigsaw",
            () -> () -> VoidLimitedJigsawStructure.CODEC);
}