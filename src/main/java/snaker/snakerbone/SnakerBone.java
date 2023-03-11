package snaker.snakerbone;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import snaker.snakerbone.client.Shaders;
import snaker.snakerbone.config.CommonConfig;
import snaker.snakerbone.data.RegistryContants;
import snaker.snakerbone.registry.ContentRegistry;
import snaker.snakerbone.registry.EntityRegistry;
import snaker.snakerbone.registry.WorldGenRegistry;
import snaker.snakerbone.utility.Utilities;
import software.bernie.geckolib3.GeckoLib;

/**
 * Created by SnakerBone on 12/12/2022
 **/
@Mod(SnakerBone.MODID)
public class SnakerBone {
    public static final String MODID = "snakerbone";
    public static final Logger LOGGER = LogManager.getLogger();

    public SnakerBone() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.configSpec, "snakerbone-common.toml");
        ContentRegistry.SB_ITEMS.register(bus);
        ContentRegistry.SB_BLOCKS.register(bus);
        ContentRegistry.SB_BLOCK_ENTITIES.register(bus);
        ContentRegistry.SB_SOUND_EVENTS.register(bus);
        ContentRegistry.SB_LOOT_MODIFIERS.register(bus);
        EntityRegistry.SB_ENTITIES.register(bus);
        WorldGenRegistry.SB_BIOMES.register(bus);
//        SnakerBoneWorldGenRegistry.registerBiomes();
        bus.addListener(Shaders::register);
        MinecraftForge.EVENT_BUS.register(new Utilities());
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab SNAKERBONE_ITEMS = new CreativeModeTab(RegistryContants.SNAKERBONE_ITEMS) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ContentRegistry.ENTITY_KILLER.get());
        }
    };
    public static final CreativeModeTab SNAKERBONE_BLOCKS = new CreativeModeTab(RegistryContants.SNAKERBONE_BLOCKS) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ContentRegistry.SNOW_BLOCK.get());
        }
    };
    public static final CreativeModeTab SNAKERBONE_MOBS = new CreativeModeTab(RegistryContants.SNAKERBONE_MOBS) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ContentRegistry.COSMO_SPAWN_EGG.get());
        }
    };
}
