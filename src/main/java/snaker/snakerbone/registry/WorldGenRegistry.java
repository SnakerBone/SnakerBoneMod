package snaker.snakerbone.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import snaker.snakerbone.SnakerBone;
import snaker.snakerbone.utility.SnakerBoneResourceLocation;

import java.util.function.Supplier;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class WorldGenRegistry {
    public static DeferredRegister<Biome> SB_BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, SnakerBone.MODID);
//    public static final ResourceKey<Biome> SHADER_PLAINS = register(SnakerBoneRegistries.SHADER_PLAINS);
//    public static final ResourceKey<Biome> SHADER_HILLS = register(SnakerBoneRegistries.SHADER_HILLS);
//    public static void registerBiomes() {
//
//        register(SHADER_PLAINS, ShaderPlains::getBiome);
//        register(SHADER_HILLS, ShaderHills::getBiome);
//
//    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier) {
        return SB_BIOMES.register(key.location().getPath(), biomeSupplier);
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new SnakerBoneResourceLocation(name));
    }
}
