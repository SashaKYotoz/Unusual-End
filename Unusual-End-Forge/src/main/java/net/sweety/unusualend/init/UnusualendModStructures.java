package net.sweety.unusualend.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.world.structures.VoidLimitedJigsawStructure;

public class UnusualendModStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, UnusualEnd.MODID);
    public static RegistryObject<StructureType<VoidLimitedJigsawStructure>> VOID_LIMITED_JIGSAW = STRUCTURES.register("void_limited_jigsaw",
            () -> () -> VoidLimitedJigsawStructure.CODEC);
}