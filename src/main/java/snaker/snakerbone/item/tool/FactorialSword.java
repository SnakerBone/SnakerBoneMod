package snaker.snakerbone.item.tool;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import snaker.snakerbone.util.SnakerBoneAttackType;

import static snaker.snakerbone.SnakerBone.SNAKERBONE_ITEMS;

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
