package com.enderdevelopment.dimensionmod.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalLong;

public class DimensionRegistry {
    public static final DeferredRegister<DimensionType> DIMENSION_TYPES = DeferredRegister.create(Registries.DIMENSION_TYPE, "dimension_mod");

    public static final RegistryObject<DimensionType> DUNE_DIMENSION_TYPE = DIMENSION_TYPES.register("dune",
            () -> DimensionType.create(
                    OptionalLong.empty(),
                    true,
                    false,
                    false,
                    true,
                    1.0,
                    false,
                    false,
                    -64,
                    320,
                    320,
                    BlockTags.INFINIBURN_OVERWORLD,
                    ResourceKey.create(Registries.DIMENSION, new ResourceLocation("dimension_mod:dune")),
                    0.0f,
                    new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));

    public static final RegistryObject<DimensionType> LIVING_WORLD_DIMENSION_TYPE = DIMENSION_TYPES.register("living_world",
            () -> DimensionType.create(
                    OptionalLong.empty(),
                    true,
                    false,
                    false,
                    true,
                    1.0,
                    false,
                    false,
                    -64,
                    320,
                    320,
                    BlockTags.INFINIBURN_OVERWORLD,
                    ResourceKey.create(Registries.DIMENSION, new ResourceLocation("dimension_mod:living_world")),
                    0.0f,
                    new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));

    public static final RegistryObject<DimensionType> FORGOTTEN_WORLD_DIMENSION_TYPE = DIMENSION_TYPES.register("forgotten_world",
            () -> DimensionType.create(
                    OptionalLong.empty(),
                    true,
                    false,
                    false,
                    true,
                    1.0,
                    false,
                    false,
                    -64,
                    320,
                    320,
                    BlockTags.INFINIBURN_OVERWORLD,
                    ResourceKey.create(Registries.DIMENSION, new ResourceLocation("dimension_mod:forgotten_world")),
                    0.0f,
                    new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));

    public static final RegistryObject<DimensionType> WORLD_OF_DECEPTION_DIMENSION_TYPE = DIMENSION_TYPES.register("world_of_deception",
            () -> DimensionType.create(
                    OptionalLong.empty(),
                    true,
                    false,
                    false,
                    true,
                    1.0,
                    false,
                    false,
                    -64,
                    320,
                    320,
                    BlockTags.INFINIBURN_OVERWORLD,
                    ResourceKey.create(Registries.DIMENSION, new ResourceLocation("dimension_mod:world_of_deception")),
                    0.0f,
                    new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));
}