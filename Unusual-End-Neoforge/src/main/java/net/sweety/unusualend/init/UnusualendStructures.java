package net.sweety.unusualend.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweety.unusualend.UnusualEnd;
import net.sweety.unusualend.world.structures.VoidLimitedJigsawStructure;

public class UnusualendStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, UnusualEnd.MODID);
    public static DeferredHolder<StructureType<?>,StructureType<VoidLimitedJigsawStructure>> VOID_LIMITED_JIGSAW = STRUCTURES.register("void_limited_jigsaw",
            () -> () -> VoidLimitedJigsawStructure.CODEC);
}