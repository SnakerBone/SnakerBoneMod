package snaker.snakerbone.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.data.SnakerBoneRegistries;
import snaker.snakerbone.entity.boss.utterfly.Utterfly;
import snaker.snakerbone.entity.creature.flutterfly.Flutterfly;
import snaker.snakerbone.entity.creature.glider.Glider;
import snaker.snakerbone.entity.mob.cosmo.Cosmo;
import snaker.snakerbone.entity.mob.flare.Flare;
import snaker.snakerbone.entity.mob.snipe.Snipe;
import snaker.snakerbone.entity.projectile.explosive_homming_arrow.ExplosiveHommingArrow;
import snaker.snakerbone.entity.projectile.homming_arrow.HommingArrow;
import snaker.snakerbone.entity.projectile.laser.Laser;
import snaker.snakerbone.util.SnakerBoneResourceLocation;

import static net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES;
import static snaker.snakerbone.SnakerBone.MODID;
import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnakerBoneEntityRegistry {

    /**
     * Deferred Registers
     **/
    public static final DeferredRegister<EntityType<?>> SB_ENTITIES = DeferredRegister.create(ENTITY_TYPES, MODID);

    /**
     * Entities
     **/
    public static final RegistryObject<EntityType<Cosmo>> COSMO = SB_ENTITIES.register(SnakerBoneRegistries.COSMO, () -> EntityType.Builder.of(Cosmo::new, MobCategory.MONSTER).sized(1, 2).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.COSMO).toString()));
    public static final RegistryObject<EntityType<Snipe>> SNIPE = SB_ENTITIES.register(SnakerBoneRegistries.SNIPE, () -> EntityType.Builder.of(Snipe::new, MobCategory.MONSTER).sized(1, 1.5F).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.SNIPE).toString()));
    public static final RegistryObject<EntityType<Flare>> FLARE = SB_ENTITIES.register(SnakerBoneRegistries.FLARE, () -> EntityType.Builder.of(Flare::new, MobCategory.MONSTER).sized(1, 2).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.FLARE).toString()));
    public static final RegistryObject<EntityType<Glider>> GLIDER = SB_ENTITIES.register(SnakerBoneRegistries.GLIDER, () -> EntityType.Builder.of(Glider::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.GLIDER).toString()));
    public static final RegistryObject<EntityType<Flutterfly>> FLUTTERFLY = SB_ENTITIES.register(SnakerBoneRegistries.FLUTTERFLY, () -> EntityType.Builder.of(Flutterfly::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.FLUTTERFLY).toString()));
    public static final RegistryObject<EntityType<Utterfly>> UTTERFLY = SB_ENTITIES.register(SnakerBoneRegistries.UTTERFLY, () -> EntityType.Builder.of(Utterfly::new, MobCategory.MONSTER).sized(6f, 3f).build(new SnakerBoneResourceLocation(SnakerBoneRegistries.UTTERFLY).toString()));
    public static final RegistryObject<EntityType<HommingArrow>> HOMMING_ARROW = SB_ENTITIES.register(SnakerBoneRegistries.HOMMING_ARROW, () -> EntityType.Builder.of((EntityType.EntityFactory<HommingArrow>) HommingArrow::new, MobCategory.MISC).sized(0.1F, 0.1F).build(SnakerBoneRegistries.HOMMING_ARROW));
    public static final RegistryObject<EntityType<ExplosiveHommingArrow>> EXPLOSIVE_HOMMING_ARROW = SB_ENTITIES.register(SnakerBoneRegistries.EXPLOSIVE_HOMMING_ARROW, () -> EntityType.Builder.of((EntityType.EntityFactory<ExplosiveHommingArrow>) ExplosiveHommingArrow::new, MobCategory.MISC).sized(0.1F, 0.1F).build(SnakerBoneRegistries.EXPLOSIVE_HOMMING_ARROW));
    public static final RegistryObject<EntityType<Laser>> LASER = SB_ENTITIES.register(SnakerBoneRegistries.LASER, () -> EntityType.Builder.of((EntityType.EntityFactory<Laser>) Laser::new, MobCategory.MISC).sized(0.1F, 0.1F).build(SnakerBoneRegistries.LASER));


}
