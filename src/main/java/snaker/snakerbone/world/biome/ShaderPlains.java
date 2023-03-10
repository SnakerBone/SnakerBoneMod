package snaker.snakerbone.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import snaker.snakerbone.registry.SnakerBoneEntityRegistry;
import snaker.snakerbone.registry.SnakerBoneWorldGenRegistry;
import terrablender.api.Region;
import terrablender.api.RegionType;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static net.minecraft.world.level.biome.Biomes.PLAINS;
import static snaker.snakerbone.utility.SnakerBoneUtilities.hexToInt;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class ShaderPlains {
    public static Biome getBiome() {

        MobSpawnSettings.Builder SpawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder BiomeBuilder = new BiomeGenerationSettings.Builder();

        addMobSpawn(SpawnBuilder, MobCategory.MONSTER, SnakerBoneEntityRegistry.COSMO, 15, 1, 3);
        addMobSpawn(SpawnBuilder, MobCategory.MONSTER, SnakerBoneEntityRegistry.FLARE, 15, 1, 3);

        return generateBiome(Biome.Precipitation.NONE, 0.8F, 0, hexToInt("18ADBD"), hexToInt("58AAB2"), hexToInt("064C53"), SpawnBuilder, BiomeBuilder, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);

    }

    protected static int calculateSkyColor(float colour) {

        float hsv = colour / 3;

        hsv = Mth.clamp(hsv, -1, 1);

        return Mth.hsvToRgb(0.62222224F - hsv * 0.05F, 0.5F + hsv * 0.1F, 1);

    }

    private static Biome generateBiome(Biome.Precipitation precipitation, float temperature, float downfall, int fogColour, int waterColour, int waterFogColour, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, AmbientMoodSettings mood, @Nullable Music music) {

        return new Biome.BiomeBuilder().precipitation(precipitation).temperature(temperature).downfall(downfall).specialEffects(new BiomeSpecialEffects.Builder().waterColor(waterColour).waterFogColor(waterFogColour).fogColor(fogColour).skyColor(calculateSkyColor(temperature)).ambientMoodSound(mood).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();

    }

    private static <M extends Mob> void addMobSpawn(MobSpawnSettings.Builder builder, MobCategory category, EntityType<M> type, int weight, int min, int max) {

        builder.addSpawn(category, new MobSpawnSettings.SpawnerData(type, weight, min, max));

        BiomeDefaultFeatures.commonSpawns(builder);

    }

    private static <M extends Mob> void addMobSpawn(MobSpawnSettings.Builder builder, MobCategory category, RegistryObject<EntityType<M>> type, int weight, int min, int max) {

        builder.addSpawn(category, new MobSpawnSettings.SpawnerData(type.get(), weight, min, max));

        BiomeDefaultFeatures.commonSpawns(builder);

    }

    public static class RuleData {
        private static final SurfaceRules.RuleSource SWIRL_BLOCK = makeStateRule(SnakerBoneContentRegistry.SWIRL_BLOCK.get());
        private static final SurfaceRules.RuleSource STARS_BLOCK = makeStateRule(SnakerBoneContentRegistry.STARS_BLOCK.get());
        private static final SurfaceRules.RuleSource WATERCOLOUR_BLOCK = makeStateRule(SnakerBoneContentRegistry.WATERCOLOUR_BLOCK.get());

        public static SurfaceRules.RuleSource getRules() {

            SurfaceRules.ConditionSource WaterBlockCheck = SurfaceRules.waterBlockCheck(-1, 0);

            SurfaceRules.RuleSource surface = SurfaceRules.sequence(SurfaceRules.ifTrue(WaterBlockCheck, STARS_BLOCK), SWIRL_BLOCK);

            return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(SnakerBoneWorldGenRegistry.SHADER_PLAINS), WATERCOLOUR_BLOCK), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, surface));

        }

        private static SurfaceRules.RuleSource makeStateRule(Block block) {

            return SurfaceRules.state(block.defaultBlockState());

        }
    }

    public static class BiomeRegion extends Region {
        public BiomeRegion(ResourceLocation name, int weight) {

            super(name, RegionType.OVERWORLD, weight);

        }

        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {

            this.addModifiedVanillaOverworldBiomes(mapper, builder -> builder.replaceBiome(PLAINS, SnakerBoneWorldGenRegistry.SHADER_PLAINS));

        }
    }
}
