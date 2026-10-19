package com.enderdevelopment.dimensionmod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "dimension_mod");

    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.5f)));

    public static final RegistryObject<Block> BONE_BLOCK = BLOCKS.register("bone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.5f)));

    public static final RegistryObject<Block> DECAY_BLOCK = BLOCKS.register("decay_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.5f)));

    public static final RegistryObject<Block> MIMIC_BLOCK = BLOCKS.register("mimic_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(0.5f)));
}