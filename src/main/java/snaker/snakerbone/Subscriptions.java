package snaker.snakerbone;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import snaker.snakerbone.client.render.block.*;
import snaker.snakerbone.client.render.entity.*;
import snaker.snakerbone.entity.boss.Utterfly;
import snaker.snakerbone.entity.creature.Flutterfly;
import snaker.snakerbone.entity.creature.Glider;
import snaker.snakerbone.entity.mob.Cosmo;
import snaker.snakerbone.entity.mob.Flare;
import snaker.snakerbone.entity.mob.Snipe;
import snaker.snakerbone.registry.ContentRegistry;
import snaker.snakerbone.registry.EntityRegistry;

import static net.minecraft.world.entity.SpawnPlacements.Type.ON_GROUND;
import static net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class Subscriptions {
    @Mod.EventBusSubscriber(modid = SnakerBone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class SnakerBoneModEvents {
        @SubscribeEvent
        public static void addEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(EntityRegistry.COSMO.get(), Cosmo.attributes());
            event.put(EntityRegistry.SNIPE.get(), Snipe.attributes());
            event.put(EntityRegistry.FLARE.get(), Flare.attributes());
            event.put(EntityRegistry.GLIDER.get(), Glider.attributes());
            event.put(EntityRegistry.FLUTTERFLY.get(), Flutterfly.attributes());
            event.put(EntityRegistry.UTTERFLY.get(), Utterfly.attributes());
        }

        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(EntityRegistry.COSMO.get(), CosmoRender::new);
            EntityRenderers.register(EntityRegistry.SNIPE.get(), SnipeRender::new);
            EntityRenderers.register(EntityRegistry.FLARE.get(), FlareRender::new);
            EntityRenderers.register(EntityRegistry.GLIDER.get(), GliderRender::new);
            EntityRenderers.register(EntityRegistry.FLUTTERFLY.get(), FlutterflyRender::new);
            EntityRenderers.register(EntityRegistry.UTTERFLY.get(), UtterflyRender::new);
            EntityRenderers.register(EntityRegistry.HOMMING_ARROW.get(), HommingArrowRender::new);
            EntityRenderers.register(EntityRegistry.EXPLOSIVE_HOMMING_ARROW.get(), ExplosiveHommingArrowRender::new);
            EntityRenderers.register(EntityRegistry.LASER.get(), LaserRender::new);
        }

        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            registerSpawn(EntityRegistry.COSMO.get(), Cosmo::spawnRules);
            registerSpawn(EntityRegistry.SNIPE.get(), Snipe::spawnRules);
            registerSpawn(EntityRegistry.FLARE.get(), Flare::spawnRules);
            registerSpawn(EntityRegistry.GLIDER.get(), Glider::spawnRules);
            registerSpawn(EntityRegistry.FLUTTERFLY.get(), Flutterfly::spawnRules);
            registerSpawn(EntityRegistry.UTTERFLY.get(), Utterfly::spawnRules);
//            Regions.register(new ShaderHills.BiomeRegion(new SnakerBoneResourceLocation("overworld"), 20));
//            Regions.register(new ShaderPlains.BiomeRegion(new SnakerBoneResourceLocation("overworld"), 20));
//            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SnakerBone.MODID, ShaderHills.RuleData.getRules());
//            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SnakerBone.MODID, ShaderPlains.RuleData.getRules());
        }

        public static <M extends Mob> void registerSpawn(EntityType<M> type, SpawnPlacements.SpawnPredicate<M> rules) {
            SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, rules);
        }
    }

    @Mod.EventBusSubscriber(modid = SnakerBone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class SnakerBoneModClientEvents {
        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ContentRegistry.SWIRL_BE.get(), SwirlBlockRender::new);
            event.registerBlockEntityRenderer(ContentRegistry.SNOW_BE.get(), SnowBlockRender::new);
            event.registerBlockEntityRenderer(ContentRegistry.WATERCOLOUR_BE.get(), WaterColourBlockRender::new);
            event.registerBlockEntityRenderer(ContentRegistry.MULTICOLOUR_BE.get(), MultiColourBlockRender::new);
            event.registerBlockEntityRenderer(ContentRegistry.FIRE_BE.get(), FireBlockRender::new);
            event.registerBlockEntityRenderer(ContentRegistry.STARS_BE.get(), StarsBlockRender::new);
        }
    }
}