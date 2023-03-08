package snaker.snakerbone.util;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 5/03/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnakerBoneAttackType {
    public static void factorialAttackAOE(LivingEntity attacker) {

        Level world = attacker.level;

        if (!world.isClientSide) {

            double x = attacker.getX();
            double y = attacker.getY();
            double z = attacker.getZ();

            AABB aabb = new AABB(x, y, z, x, y, z).inflate(8);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, aabb);
            DamageSource source = DamageSource.playerAttack((Player) attacker).bypassArmor();

            float amount = SnakerBoneMath.factorial(entities.size());

            for (LivingEntity entity : entities) {

                if (entity != attacker) {

                    entity.hurt(source, amount);

                }
            }
        }
    }
}
