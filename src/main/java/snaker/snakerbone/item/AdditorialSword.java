package snaker.snakerbone.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import snaker.snakerbone.utility.AttackTypes;

/**
 * Created by SnakerBone on 8/03/2023
 **/
public class AdditorialSword extends SwordItem {
    public AdditorialSword(Tier tier, int damageModifier, float speedModifier, Properties properties) {
        super(tier, damageModifier, speedModifier, properties);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        AttackTypes.additorialAOE(entity);
        return super.onEntitySwing(stack, entity);
    }
}
