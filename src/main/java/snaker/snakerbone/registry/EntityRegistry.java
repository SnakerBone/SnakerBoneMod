package snaker.snakerbone.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.data.RegistryContants;
import snaker.snakerbone.entity.boss.Utterfly;
import snaker.snakerbone.entity.creature.Flutterfly;
import snaker.snakerbone.entity.creature.Glider;
import snaker.snakerbone.entity.mob.Cosmo;
import snaker.snakerbone.entity.mob.Flare;
import snaker.snakerbone.entity.mob.Snipe;
import snaker.snakerbone.entity.projectile.ExplosiveHommingArrow;
import snaker.snakerbone.entity.projectile.HommingArrow;
import snaker.snakerbone.entity.projectile.Laser;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;

import static net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES;
import static snaker.snakerbone.SnakerBone.MODID;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class EntityRegistry {

    /**
     * Deferred Registers
     **/
    public static final DeferredRegister<EntityType<?>> SB_ENTITIES = DeferredRegister.create(ENTITY_TYPES, MODID);

    /**
     * Entities
     **/
    public static final RegistryObject<EntityType<Cosmo>> COSMO = SB_ENTITIES.register(RegistryContants.COSMO, () -> EntityType.Builder.of(Cosmo::new, MobCategory.MONSTER).sized(1, 2).build(new SnakerBoneResourceLocation(RegistryContants.COSMO).toString()));
    public static final RegistryObject<EntityType<Snipe>> SNIPE = SB_ENTITIES.register(RegistryContants.SNIPE, () -> EntityType.Builder.of(Snipe::new, MobCategory.MONSTER).sized(1, 1.5F).build(new SnakerBoneResourceLocation(RegistryContants.SNIPE).toString()));
    public static final RegistryObject<EntityType<Flare>> FLARE = SB_ENTITIES.register(RegistryContants.FLARE, () -> EntityType.Builder.of(Flare::new, MobCategory.MONSTER).sized(1, 2).build(new SnakerBoneResourceLocation(RegistryContants.FLARE).toString()));
    public static final RegistryObject<EntityType<Glider>> GLIDER = SB_ENTITIES.register(RegistryContants.GLIDER, () -> EntityType.Builder.of(Glider::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new SnakerBoneResourceLocation(RegistryContants.GLIDER).toString()));
    public static final RegistryObject<EntityType<Flutterfly>> FLUTTERFLY = SB_ENTITIES.register(RegistryContants.FLUTTERFLY, () -> EntityType.Builder.of(Flutterfly::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new SnakerBoneResourceLocation(RegistryContants.FLUTTERFLY).toString()));
    public static final RegistryObject<EntityType<Utterfly>> UTTERFLY = SB_ENTITIES.register(RegistryContants.UTTERFLY, () -> EntityType.Builder.of(Utterfly::new, MobCategory.MONSTER).sized(6f, 3f).build(new SnakerBoneResourceLocation(RegistryContants.UTTERFLY).toString()));
    public static final RegistryObject<EntityType<HommingArrow>> HOMMING_ARROW = SB_ENTITIES.register(RegistryContants.HOMMING_ARROW, () -> EntityType.Builder.of((EntityType.EntityFactory<HommingArrow>) HommingArrow::new, MobCategory.MISC).sized(0.1F, 0.1F).build(RegistryContants.HOMMING_ARROW));
    public static final RegistryObject<EntityType<ExplosiveHommingArrow>> EXPLOSIVE_HOMMING_ARROW = SB_ENTITIES.register(RegistryContants.EXPLOSIVE_HOMMING_ARROW, () -> EntityType.Builder.of((EntityType.EntityFactory<ExplosiveHommingArrow>) ExplosiveHommingArrow::new, MobCategory.MISC).sized(0.1F, 0.1F).build(RegistryContants.EXPLOSIVE_HOMMING_ARROW));
    public static final RegistryObject<EntityType<Laser>> LASER = SB_ENTITIES.register(RegistryContants.LASER, () -> EntityType.Builder.of((EntityType.EntityFactory<Laser>) Laser::new, MobCategory.MISC).sized(0.1F, 0.1F).build(RegistryContants.LASER));
}
