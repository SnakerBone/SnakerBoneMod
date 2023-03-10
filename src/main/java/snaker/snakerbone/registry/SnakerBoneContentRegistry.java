package snaker.snakerbone.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.block.shader.fire.FireBlock;
import snaker.snakerbone.block.shader.fire.FireBlockEntity;
import snaker.snakerbone.block.shader.fire.FireBlockItem;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlock;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockEntity;
import snaker.snakerbone.block.shader.multicolour.MultiColourBlockItem;
import snaker.snakerbone.block.shader.snow.SnowBlock;
import snaker.snakerbone.block.shader.snow.SnowBlockEntity;
import snaker.snakerbone.block.shader.snow.SnowBlockItem;
import snaker.snakerbone.block.shader.stars.StarsBlock;
import snaker.snakerbone.block.shader.stars.StarsBlockEntity;
import snaker.snakerbone.block.shader.stars.StarsBlockItem;
import snaker.snakerbone.block.shader.swirl.SwirlBlock;
import snaker.snakerbone.block.shader.swirl.SwirlBlockEntity;
import snaker.snakerbone.block.shader.swirl.SwirlBlockItem;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlock;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlockEntity;
import snaker.snakerbone.block.shader.watercolour.WaterColourBlockItem;
import snaker.snakerbone.data.SnakerBoneRegistries;
import snaker.snakerbone.item.EntityKiller;
import snaker.snakerbone.item.FactorialSword;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;
import snaker.snakerbone.utility.SnakerBoneUtilities;

import java.util.function.Supplier;

import static net.minecraftforge.registries.ForgeRegistries.*;
import static snaker.snakerbone.SnakerBone.*;

/**
 * Created by SnakerBone on 12/12/2022
 **/
public class SnakerBoneContentRegistry {

    /**
     * Deferred Registers
     **/
    public static final DeferredRegister<Item> SB_ITEMS = DeferredRegister.create(ITEMS, MODID);
    public static final DeferredRegister<Block> SB_BLOCKS = DeferredRegister.create(BLOCKS, MODID);
    public static DeferredRegister<BlockEntityType<?>> SB_BLOCK_ENTITIES = DeferredRegister.create(BLOCK_ENTITY_TYPES, MODID);
    public static final DeferredRegister<SoundEvent> SB_SOUND_EVENTS = DeferredRegister.create(SOUND_EVENTS, MODID);

    /**
     * Spawn Eggs
     **/
    public static final RegistryObject<Item> COSMO_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.COSMO_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.COSMO, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> SNIPE_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.SNIPE_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.SNIPE, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> FLARE_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.FLARE_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.FLARE, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> GLIDER_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.GLIDER_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.GLIDER, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> FLUTTERFLY_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.FLUTTERFLY_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.FLUTTERFLY, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));
    public static final RegistryObject<Item> UTTERFLY_SPAWN_EGG = SB_ITEMS.register(SnakerBoneRegistries.UTTERFLY_SPAWN_EGG, () -> new ForgeSpawnEggItem(SnakerBoneEntityRegistry.UTTERFLY, SnakerBoneUtilities.randomHex(), SnakerBoneUtilities.randomHex(), new Item.Properties().tab(SnakerBone.SNAKERBONE_MOBS)));

    /**
     * Items
     **/
    public static final RegistryObject<Item> ENTITY_KILLER = SB_ITEMS.register(SnakerBoneRegistries.ENTITY_KILLER, EntityKiller::new);
    public static final RegistryObject<Item> FACTORIAL_SWORD = SB_ITEMS.register(SnakerBoneRegistries.FACTORIAL_SWORD, FactorialSword::new);

    /**
     * Block Items
     **/
    public static final RegistryObject<Item> SWIRL_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.SWIRL_BLOCK, () -> new SwirlBlockItem(SnakerBoneContentRegistry.SWIRL_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> SNOW_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.SNOW_BLOCK, () -> new SnowBlockItem(SnakerBoneContentRegistry.SNOW_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> WATERCOLOUR_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.WATERCOLOUR_BLOCK, () -> new WaterColourBlockItem(SnakerBoneContentRegistry.WATERCOLOUR_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> MULTICOLOUR_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.MULTICOLOUR_BLOCK, () -> new MultiColourBlockItem(SnakerBoneContentRegistry.MULTICOLOUR_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> FIRE_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.FIRE_BLOCK, () -> new FireBlockItem(SnakerBoneContentRegistry.FIRE_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));
    public static final RegistryObject<Item> STARS_BLOCK_ITEM = SB_ITEMS.register(SnakerBoneRegistries.STARS_BLOCK, () -> new StarsBlockItem(SnakerBoneContentRegistry.STARS_BLOCK.get(), new Item.Properties().tab(SNAKERBONE_BLOCKS)));

    /**
     * Blocks
     **/
    public static final RegistryObject<Block> SWIRL_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.SWIRL_BLOCK, SwirlBlock::new);
    public static final RegistryObject<Block> SNOW_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.SNOW_BLOCK, SnowBlock::new);
    public static final RegistryObject<Block> WATERCOLOUR_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.WATERCOLOUR_BLOCK, WaterColourBlock::new);
    public static final RegistryObject<Block> MULTICOLOUR_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.MULTICOLOUR_BLOCK, MultiColourBlock::new);
    public static final RegistryObject<Block> FIRE_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.FIRE_BLOCK, FireBlock::new);
    public static final RegistryObject<Block> STARS_BLOCK = registerBlockWithoutItem(SnakerBoneRegistries.STARS_BLOCK, StarsBlock::new);

    /**
     * Block Entities
     **/
    public static final RegistryObject<BlockEntityType<SwirlBlockEntity>> SWIRL_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.SWIRL_BE, () -> BlockEntityType.Builder.of(SwirlBlockEntity::new, SWIRL_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<SnowBlockEntity>> SNOW_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.SNOW_BE, () -> BlockEntityType.Builder.of(SnowBlockEntity::new, SNOW_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<WaterColourBlockEntity>> WATERCOLOUR_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.WATERCOLOUR_BE, () -> BlockEntityType.Builder.of(WaterColourBlockEntity::new, WATERCOLOUR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<MultiColourBlockEntity>> MULTICOLOUR_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.MULTICOLOUR_BE, () -> BlockEntityType.Builder.of(MultiColourBlockEntity::new, MULTICOLOUR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<FireBlockEntity>> FIRE_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.FIRE_BE, () -> BlockEntityType.Builder.of(FireBlockEntity::new, FIRE_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<StarsBlockEntity>> STARS_BE = SB_BLOCK_ENTITIES.register(SnakerBoneRegistries.STARS_BE, () -> BlockEntityType.Builder.of(StarsBlockEntity::new, STARS_BLOCK.get()).build(null));

    /**
     * Sound Events
     **/
    public static final RegistryObject<SoundEvent> CONFUSE = SB_SOUND_EVENTS.register(SnakerBoneRegistries.CONFUSE, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.CONFUSE)));
    public static final RegistryObject<SoundEvent> EARTH = SB_SOUND_EVENTS.register(SnakerBoneRegistries.EARTH, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.EARTH)));
    public static final RegistryObject<SoundEvent> FOG = SB_SOUND_EVENTS.register(SnakerBoneRegistries.FOG, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.FOG)));
    public static final RegistryObject<SoundEvent> GAZE = SB_SOUND_EVENTS.register(SnakerBoneRegistries.GAZE, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.GAZE)));
    public static final RegistryObject<SoundEvent> NIGHT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.NIGHT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.NIGHT)));
    public static final RegistryObject<SoundEvent> TING = SB_SOUND_EVENTS.register(SnakerBoneRegistries.TING, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.TING)));
    public static final RegistryObject<SoundEvent> BULLET = SB_SOUND_EVENTS.register(SnakerBoneRegistries.BULLET, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.BULLET)));
    public static final RegistryObject<SoundEvent> COSMO_HURT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.COSMO_HURT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.COSMO_HURT)));
    public static final RegistryObject<SoundEvent> SHOOT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.UTTERFLY_SHOOT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.UTTERFLY_SHOOT)));
    public static final RegistryObject<SoundEvent> UTTERFLY_AMBIENT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.UTTERFLY_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.UTTERFLY_AMBIENT)));
    public static final RegistryObject<SoundEvent> FLUTTERFLY_AMBIENT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.FLUTTERFLY_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.FLUTTERFLY_AMBIENT)));
    public static final RegistryObject<SoundEvent> SNIPE_HURT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.SNIPE_HURT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.SNIPE_HURT)));
    public static final RegistryObject<SoundEvent> SNIPE_AMBIENT = SB_SOUND_EVENTS.register(SnakerBoneRegistries.SNIPE_AMBIENT, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.SNIPE_AMBIENT)));
    public static final RegistryObject<SoundEvent> ENTITY_DEATH = SB_SOUND_EVENTS.register(SnakerBoneRegistries.ENTITY_DEATH, () -> new SoundEvent(new SnakerBoneResourceLocation(SnakerBoneRegistries.ENTITY_DEATH)));

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
