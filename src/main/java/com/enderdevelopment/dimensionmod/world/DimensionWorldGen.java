package com.enderdevelopment.dimensionmod.world;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class DimensionWorldGen {
    public static final ResourceKey<DimensionType> DUNE_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation("dimension_mod:dune"));
    public static final ResourceKey<DimensionType> LIVING_WORLD_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation("dimension_mod:living_world"));
    public static final ResourceKey<DimensionType> FORGOTTEN_WORLD_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation("dimension_mod:forgotten_world"));
    public static final ResourceKey<DimensionType> WORLD_OF_DECEPTION_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation("dimension_mod:world_of_deception"));

    public static void bootstrapDimensionTypes(BootstapContext<DimensionType> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        registerDimensionType(context, DUNE_DIMENSION_TYPE, biomeRegistry, noiseSettings);
        registerDimensionType(context, LIVING_WORLD_DIMENSION_TYPE, biomeRegistry, noiseSettings);
        registerDimensionType(context, FORGOTTEN_WORLD_DIMENSION_TYPE, biomeRegistry, noiseSettings);
        registerDimensionType(context, WORLD_OF_DECEPTION_DIMENSION_TYPE, biomeRegistry, noiseSettings);
    }

    private static void registerDimensionType(BootstapContext<DimensionType> context, ResourceKey<DimensionType> key, HolderGetter<Biome> biomeRegistry, HolderGetter<NoiseGeneratorSettings> noiseSettings) {
        DimensionType dimensionType = new DimensionType(
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
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0f,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0));
        context.register(key, dimensionType);
    }

    public static ChunkGenerator createChunkGenerator(RegistryAccess registryAccess, ResourceKey<DimensionType> dimensionType) {
        HolderGetter<DimensionType> dimensionTypes = registryAccess.registryOrThrow(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomes = registryAccess.registryOrThrow(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettings = registryAccess.registryOrThrow(Registries.NOISE_SETTINGS);

        DimensionType dimensionTypeObj = dimensionTypes.getOrThrow(dimensionType);
        NoiseGeneratorSettings noiseSettings = noiseGeneratorSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);

        return new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(
                                List.of(
                                        Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(Biomes.PLAINS))
                                )
                        )
                ),
                noiseSettings
        );
    }
}