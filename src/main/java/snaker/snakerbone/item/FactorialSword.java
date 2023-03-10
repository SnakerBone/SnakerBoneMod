package snaker.snakerbone.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import snaker.snakerbone.utility.SnakerBoneAttackType;

import static snaker.snakerbone.SnakerBone.SNAKERBONE_ITEMS;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class FactorialSword extends SwordItem {
    public FactorialSword() {

        super(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().tab(SNAKERBONE_ITEMS));

    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {

        SnakerBoneAttackType.factorialAttackAOE(entity);

        return super.onEntitySwing(stack, entity);

    }

}
