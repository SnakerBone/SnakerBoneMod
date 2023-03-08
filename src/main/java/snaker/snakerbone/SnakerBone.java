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
import snaker.snakerbone.client.SnakerBoneShaders;
import snaker.snakerbone.config.SnakerBoneCommonConfig;
import snaker.snakerbone.data.SnakerBoneRegistries;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import snaker.snakerbone.registry.SnakerBoneEntityRegistry;
import snaker.snakerbone.registry.SnakerBoneWorldGenRegistry;
import snaker.snakerbone.util.SnakerBoneTools;
import software.bernie.geckolib3.GeckoLib;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 12/12/2022
 **/
@SuppressWarnings(CUSTOM_SET)
@Mod(SnakerBone.MODID)
public class SnakerBone {

    public static final String MODID = "snakerbone";
    public static final Logger LOGGER = LogManager.getLogger();

    public SnakerBone() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(SnakerBoneShaders::register);

        GeckoLib.initialize();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SnakerBoneCommonConfig.configSpec, "snakerbone-common.toml");

        SnakerBoneEntityRegistry.SB_ENTITIES.register(bus);

        SnakerBoneContentRegistry.SB_ITEMS.register(bus);
        SnakerBoneContentRegistry.SB_BLOCKS.register(bus);
        SnakerBoneContentRegistry.SB_BLOCK_ENTITIES.register(bus);
        SnakerBoneContentRegistry.SB_SOUND_EVENTS.register(bus);
        SnakerBoneWorldGenRegistry.SB_BIOMES.register(bus);

        SnakerBoneWorldGenRegistry.registerBiomes();

        MinecraftForge.EVENT_BUS.register(new SnakerBoneTools());
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab SNAKERBONE_ITEMS = new CreativeModeTab(SnakerBoneRegistries.SNAKERBONE_ITEMS) {

        @Override
        public ItemStack makeIcon() {

            return new ItemStack(SnakerBoneContentRegistry.ENTITY_KILLER.get());

        }
    };

    public static final CreativeModeTab SNAKERBONE_BLOCKS = new CreativeModeTab(SnakerBoneRegistries.SNAKERBONE_BLOCKS) {

        @Override
        public ItemStack makeIcon() {

            return new ItemStack(SnakerBoneContentRegistry.SNOW_BLOCK.get());

        }
    };

    public static final CreativeModeTab SNAKERBONE_MOBS = new CreativeModeTab(SnakerBoneRegistries.SNAKERBONE_MOBS) {

        @Override
        public ItemStack makeIcon() {

            return new ItemStack(SnakerBoneContentRegistry.COSMO_SPAWN_EGG.get());

        }
    };
}
