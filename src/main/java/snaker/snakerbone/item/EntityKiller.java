package snaker.snakerbone.item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static snaker.snakerbone.SnakerBone.SNAKERBONE_ITEMS;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class EntityKiller extends Item {
    public EntityKiller() {

        super(new Item.Properties().stacksTo(1).tab(SNAKERBONE_ITEMS));

    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {

        entity.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);

        return super.onLeftClickEntity(stack, player, entity);

    }

    @Override
    public boolean isFoil(ItemStack stack) {

        return true;

    }
}
