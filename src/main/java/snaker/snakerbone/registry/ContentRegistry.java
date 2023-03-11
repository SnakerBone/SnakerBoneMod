package snaker.snakerbone.registry;

import com.mojang.serialization.Codec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.block.*;
import snaker.snakerbone.block.blockentity.*;
import snaker.snakerbone.block.blockitem.*;
import snaker.snakerbone.data.RegistryContants;
import snaker.snakerbone.item.CosmoSpine;
import snaker.snakerbone.item.EntityKiller;
import snaker.snakerbone.item.FactorialSword;
import snaker.snakerbone.loot.LootModifiers;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import snaker.snakerbone.utility.Utilities;

import java.util.function.Supplier;

import static net.minecraftforge.registries.ForgeRegistries.*;
import static snaker.snakerbone.SnakerBone.*;

/**
 * Created by SnakerBone on 12/12/2022
 **/
public class ContentRegistry {

    /**
     * Deferred Registers
     **/
    public static final DeferredRegister<Item> SB_ITEMS = DeferredRegister.create(ITEMS, MODID);
    public static final DeferredRegister<Block> SB_BLOCKS = DeferredRegister.create(BLOCKS, MODID);
    public static DeferredRegister<BlockEntityType<?>> SB_BLOCK_ENTITIES = DeferredRegister.create(BLOCK_ENTITY_TYPES, MODID);
    public static final DeferredRegister<SoundEvent> SB_SOUND_EVENTS = DeferredRegister.create(SOUND_EVENTS, MODID);
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SB_LOOT_MODIFIERS = DeferredRegister.create(Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MODID);

    /**
     * Spawn Eggs
     **/
    public static final RegistryObject<Item> COSMO_SPAWN_EGG = SB_ITEMS.register(RegistryContants.COSMO_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.COSMO, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> SNIPE_SPAWN_EGG = SB_ITEMS.register(RegistryContants.SNIPE_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.SNIPE, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> FLARE_SPAWN_EGG = SB_ITEMS.register(RegistryContants.FLARE_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.FLARE, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> GLIDER_SPAWN_EGG = SB_ITEMS.register(RegistryContants.GLIDER_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.GLIDER, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> FLUTTERFLY_SPAWN_EGG = SB_ITEMS.register(RegistryContants.FLUTTERFLY_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.FLUTTERFLY, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> UTTERFLY_SPAWN_EGG = SB_ITEMS.register(RegistryContants.UTTERFLY_SPAWN_EGG, () -> new ForgeSpawnEggItem(EntityRegistry.UTTERFLY, Utilities.randomHex(), Utilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));

    /**
     * Items
     **/
    public static final RegistryObject<Item> ENTITY_KILLER = SB_ITEMS.register(RegistryContants.ENTITY_KILLER, () -> new EntityKiller(new Item.Properties().stacksTo(1).tab(SNAKERBONE_ITEMS)));
    public static final RegistryObject<Item> FACTORIAL_SWORD = SB_ITEMS.register(RegistryContants.FACTORIAL_SWORD, () -> new FactorialSword(Tiers.DIAMOND, 1, -2.4F, new Item.Properties().tab(SNAKERBONE_ITEMS)));
    public static final RegistryObject<Item> COSMO_SPINE = SB_ITEMS.register(RegistryContants.COSMO_SPINE, () -> new CosmoSpine(new Item.Properties().tab(SNAKERBONE_ITEMS)));

    /**
     * Block Items
     **/
    public static final RegistryObject<Item> SWIRL_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.SWIRL_BLOCK, () -> new SwirlBlockItem(ContentRegistry.SWIRL_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> SNOW_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.SNOW_BLOCK, () -> new SnowBlockItem(ContentRegistry.SNOW_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> WATERCOLOUR_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.WATERCOLOUR_BLOCK, () -> new WaterColourBlockItem(ContentRegistry.WATERCOLOUR_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> MULTICOLOUR_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.MULTICOLOUR_BLOCK, () -> new MultiColourBlockItem(ContentRegistry.MULTICOLOUR_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> FIRE_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.FIRE_BLOCK, () -> new FireBlockItem(ContentRegistry.FIRE_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> STARS_BLOCK_ITEM = SB_ITEMS.register(RegistryContants.STARS_BLOCK, () -> new StarsBlockItem(ContentRegistry.STARS_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));

    /**
     * Blocks
     **/
    public static final RegistryObject<Block> SWIRL_BLOCK = registerBlockWithoutItem(RegistryContants.SWIRL_BLOCK, SwirlBlock::new);
    public static final RegistryObject<Block> SNOW_BLOCK = registerBlockWithoutItem(RegistryContants.SNOW_BLOCK, SnowBlock::new);
    public static final RegistryObject<Block> WATERCOLOUR_BLOCK = registerBlockWithoutItem(RegistryContants.WATERCOLOUR_BLOCK, WaterColourBlock::new);
    public static final RegistryObject<Block> MULTICOLOUR_BLOCK = registerBlockWithoutItem(RegistryContants.MULTICOLOUR_BLOCK, MultiColourBlock::new);
    public static final RegistryObject<Block> FIRE_BLOCK = registerBlockWithoutItem(RegistryContants.FIRE_BLOCK, FireBlock::new);
    public static final RegistryObject<Block> STARS_BLOCK = registerBlockWithoutItem(RegistryContants.STARS_BLOCK, StarsBlock::new);

    /**
     * Block Entities
     **/
    public static final RegistryObject<BlockEntityType<SwirlBlockEntity>> SWIRL_BE = SB_BLOCK_ENTITIES.register(RegistryContants.SWIRL_BE, () -> BlockEntityType.Builder.of(SwirlBlockEntity::new, SWIRL_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<SnowBlockEntity>> SNOW_BE = SB_BLOCK_ENTITIES.register(RegistryContants.SNOW_BE, () -> BlockEntityType.Builder.of(SnowBlockEntity::new, SNOW_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<WaterColourBlockEntity>> WATERCOLOUR_BE = SB_BLOCK_ENTITIES.register(RegistryContants.WATERCOLOUR_BE, () -> BlockEntityType.Builder.of(WaterColourBlockEntity::new, WATERCOLOUR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<MultiColourBlockEntity>> MULTICOLOUR_BE = SB_BLOCK_ENTITIES.register(RegistryContants.MULTICOLOUR_BE, () -> BlockEntityType.Builder.of(MultiColourBlockEntity::new, MULTICOLOUR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<FireBlockEntity>> FIRE_BE = SB_BLOCK_ENTITIES.register(RegistryContants.FIRE_BE, () -> BlockEntityType.Builder.of(FireBlockEntity::new, FIRE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<StarsBlockEntity>> STARS_BE = SB_BLOCK_ENTITIES.register(RegistryContants.STARS_BE, () -> BlockEntityType.Builder.of(StarsBlockEntity::new, STARS_BLOCK.get()).build(null));

    /**
     * Sound Events
     **/
    public static final RegistryObject<SoundEvent> CONFUSE = SB_SOUND_EVENTS.register(RegistryContants.CONFUSE, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.CONFUSE)));
    public static final RegistryObject<SoundEvent> EARTH = SB_SOUND_EVENTS.register(RegistryContants.EARTH, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.EARTH)));
    public static final RegistryObject<SoundEvent> FOG = SB_SOUND_EVENTS.register(RegistryContants.FOG, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.FOG)));
    public static final RegistryObject<SoundEvent> GAZE = SB_SOUND_EVENTS.register(RegistryContants.GAZE, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.GAZE)));
    public static final RegistryObject<SoundEvent> NIGHT = SB_SOUND_EVENTS.register(RegistryContants.NIGHT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.NIGHT)));
    public static final RegistryObject<SoundEvent> TING = SB_SOUND_EVENTS.register(RegistryContants.TING, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.TING)));
    public static final RegistryObject<SoundEvent> BULLET = SB_SOUND_EVENTS.register(RegistryContants.BULLET, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.BULLET)));
    public static final RegistryObject<SoundEvent> COSMO_HURT = SB_SOUND_EVENTS.register(RegistryContants.COSMO_HURT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.COSMO_HURT)));
    public static final RegistryObject<SoundEvent> SHOOT = SB_SOUND_EVENTS.register(RegistryContants.UTTERFLY_SHOOT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.UTTERFLY_SHOOT)));
    public static final RegistryObject<SoundEvent> UTTERFLY_AMBIENT = SB_SOUND_EVENTS.register(RegistryContants.UTTERFLY_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.UTTERFLY_AMBIENT)));
    public static final RegistryObject<SoundEvent> FLUTTERFLY_AMBIENT = SB_SOUND_EVENTS.register(RegistryContants.FLUTTERFLY_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.FLUTTERFLY_AMBIENT)));
    public static final RegistryObject<SoundEvent> SNIPE_HURT = SB_SOUND_EVENTS.register(RegistryContants.SNIPE_HURT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.SNIPE_HURT)));
    public static final RegistryObject<SoundEvent> SNIPE_AMBIENT = SB_SOUND_EVENTS.register(RegistryContants.SNIPE_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.SNIPE_AMBIENT)));
    public static final RegistryObject<SoundEvent> ENTITY_DEATH = SB_SOUND_EVENTS.register(RegistryContants.ENTITY_DEATH, () -> new SoundEvent(new SnakerBoneResourceLocation(RegistryContants.ENTITY_DEATH)));

    /**
     * Loot Modifiers
     **/
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT = SB_LOOT_MODIFIERS.register(RegistryContants.ADD_LOOT, LootModifiers.AddItem.CODEC);

    private static <T extends Block> RegistryObject<T> registerBlock(String blockName, Supplier<T> blockObj) {
        RegistryObject<T> block = SB_BLOCKS.register(blockName, blockObj);
        bindItemProperties(blockName, block);
        return block;
    }

    private static <T extends Block> void bindItemProperties(String blockName, RegistryObject<T> blockObj) {
        SB_ITEMS.register(blockName, () -> new BlockItem(blockObj.get(), new Item.Properties().tab(SNAKERBONE_MOBS)));
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return SB_BLOCKS.register(name, block);
    }
}
