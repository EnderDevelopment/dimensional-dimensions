package com.enderdevelopment.dimensionmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, "dimension_mod");

    public static final RegistryObject<EntityType<SandwormEntity>> SANDWORM = ENTITIES.register("sandworm",
            () -> EntityType.Builder.of(SandwormEntity::new, MobCategory.MONSTER)
                    .sized(2.0f, 2.0f)
                    .build("sandworm"));

    public static final RegistryObject<EntityType<GhostEntity>> GHOST = ENTITIES.register("ghost",
            () -> EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build("ghost"));

    public static final RegistryObject<EntityType<MimicEntity>> MIMIC = ENTITIES.register("mimic",
            () -> EntityType.Builder.of(MimicEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 0.9f)
                    .build("mimic"));
}