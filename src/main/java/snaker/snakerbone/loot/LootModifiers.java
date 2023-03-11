package snaker.snakerbone.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * Created by SnakerBone on 11/03/2023
 **/
public class LootModifiers {
    public static class AddItem extends LootModifier {
        public static final Supplier<Codec<AddItem>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance).and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(type -> type.item)).apply(instance, AddItem::new)));
        private final Item item;

        public AddItem(LootItemCondition[] condition, Item itemToAdd) {
            super(condition);
            item = itemToAdd;
        }

        @Override
        public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext context) {
            if (context.getRandom().nextFloat() >= 0.25) {
                loot.add(new ItemStack(item));
            }
            return loot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
}
