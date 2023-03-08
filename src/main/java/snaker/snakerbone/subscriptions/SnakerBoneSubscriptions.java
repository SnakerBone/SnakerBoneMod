package snaker.snakerbone.subscriptions;

import codechicken.lib.model.ModelRegistryHelper;
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
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.block.shader.fire.render.FireBlockRender;
import snaker.snakerbone.block.shader.multicolour.render.MultiColourBlockRender;
import snaker.snakerbone.block.shader.snow.render.SnowBlockRender;
import snaker.snakerbone.block.shader.stars.render.StarsBlockRender;
import snaker.snakerbone.block.shader.swirl.render.SwirlBlockRender;
import snaker.snakerbone.block.shader.watercolour.render.WaterColourBlockRender;
import snaker.snakerbone.entity.boss.utterfly.Utterfly;
import snaker.snakerbone.entity.boss.utterfly.render.UtterflyRender;
import snaker.snakerbone.entity.creature.flutterfly.Flutterfly;
import snaker.snakerbone.entity.creature.flutterfly.render.FlutterflyRender;
import snaker.snakerbone.entity.creature.glider.Glider;
import snaker.snakerbone.entity.creature.glider.render.GliderRender;
import snaker.snakerbone.entity.mob.cosmo.Cosmo;
import snaker.snakerbone.entity.mob.cosmo.render.CosmoRender;
import snaker.snakerbone.entity.mob.flare.Flare;
import snaker.snakerbone.entity.mob.flare.render.FlareRender;
import snaker.snakerbone.entity.mob.snipe.Snipe;
import snaker.snakerbone.entity.mob.snipe.render.SnipeRender;
import snaker.snakerbone.entity.projectile.explosive_homming_arrow.render.ExplosiveHommingArrowRender;
import snaker.snakerbone.entity.projectile.homming_arrow.render.HommingArrowRender;
import snaker.snakerbone.entity.projectile.laser.render.LaserRender;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import snaker.snakerbone.registry.SnakerBoneEntityRegistry;
import snaker.snakerbone.util.SnakerBoneResourceLocation;
import snaker.snakerbone.world.biome.ShaderHills;
import snaker.snakerbone.world.biome.ShaderPlains;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import static net.minecraft.world.entity.SpawnPlacements.Type.ON_GROUND;
import static net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.*;

/**
 * Created by SnakerBone on 2/01/2023
 **/
@SuppressWarnings({CUSTOM_SET, DEPRECATION, UNUSED})
public class SnakerBoneSubscriptions {
    @Mod.EventBusSubscriber(modid = SnakerBone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class SnakerBoneModEvents {

        private static final ModelRegistryHelper model = new ModelRegistryHelper();

        @SubscribeEvent
        public static void addEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(SnakerBoneEntityRegistry.COSMO.get(), Cosmo.attributes());
            event.put(SnakerBoneEntityRegistry.SNIPE.get(), Snipe.attributes());
            event.put(SnakerBoneEntityRegistry.FLARE.get(), Flare.attributes());
            event.put(SnakerBoneEntityRegistry.GLIDER.get(), Glider.attributes());
            event.put(SnakerBoneEntityRegistry.FLUTTERFLY.get(), Flutterfly.attributes());
            event.put(SnakerBoneEntityRegistry.UTTERFLY.get(), Utterfly.attributes());
        }

        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(SnakerBoneEntityRegistry.COSMO.get(), CosmoRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.SNIPE.get(), SnipeRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.FLARE.get(), FlareRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.GLIDER.get(), GliderRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.FLUTTERFLY.get(), FlutterflyRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.UTTERFLY.get(), UtterflyRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.HOMMING_ARROW.get(), HommingArrowRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.EXPLOSIVE_HOMMING_ARROW.get(), ExplosiveHommingArrowRender::new);
            EntityRenderers.register(SnakerBoneEntityRegistry.LASER.get(), LaserRender::new);
        }

        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            registerSpawn(SnakerBoneEntityRegistry.COSMO.get(), Cosmo::spawnRules);
            registerSpawn(SnakerBoneEntityRegistry.SNIPE.get(), Snipe::spawnRules);
            registerSpawn(SnakerBoneEntityRegistry.FLARE.get(), Flare::spawnRules);
            registerSpawn(SnakerBoneEntityRegistry.GLIDER.get(), Glider::spawnRules);
            registerSpawn(SnakerBoneEntityRegistry.FLUTTERFLY.get(), Flutterfly::spawnRules);
            registerSpawn(SnakerBoneEntityRegistry.UTTERFLY.get(), Utterfly::spawnRules);

            Regions.register(new ShaderHills.BiomeRegion(new SnakerBoneResourceLocation("overworld"), 20));
            Regions.register(new ShaderPlains.BiomeRegion(new SnakerBoneResourceLocation("overworld"), 20));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SnakerBone.MODID, ShaderHills.RuleData.getRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SnakerBone.MODID, ShaderPlains.RuleData.getRules());
        }

        public static <M extends Mob> void registerSpawn(EntityType<M> type, SpawnPlacements.SpawnPredicate<M> rules) {
            SpawnPlacements.register(type, ON_GROUND, MOTION_BLOCKING_NO_LEAVES, rules);
        }
    }

    @Mod.EventBusSubscriber(modid = SnakerBone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class SnakerBoneModClientEvents {
        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.SWIRL_BE.get(), SwirlBlockRender::new);
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.SNOW_BE.get(), SnowBlockRender::new);
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.WATERCOLOUR_BE.get(), WaterColourBlockRender::new);
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.MULTICOLOUR_BE.get(), MultiColourBlockRender::new);
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.FIRE_BE.get(), FireBlockRender::new);
            event.registerBlockEntityRenderer(SnakerBoneContentRegistry.STARS_BE.get(), StarsBlockRender::new);
        }
    }
}