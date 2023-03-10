package snaker.snakerbone.entity.ai;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import snaker.snakerbone.entity.projectile.ExplosiveHommingArrow;
import snaker.snakerbone.entity.projectile.HommingArrow;
import snaker.snakerbone.registry.SnakerBoneContentRegistry;
import snaker.snakerbone.registry.SnakerBoneEntityRegistry;
import snaker.snakerbone.utility.SnakerBoneMath;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class SnakerBoneHommingAttackGoal extends Goal {
    private final Mob mob;
    private final boolean explosiveArrow;
    private final float arrowVelocity;
    private final float arrowInaccuracy;
    private final int arrowDelay;

    public SnakerBoneHommingAttackGoal(Mob owner, boolean explosive, float velocity, float inaccuracy, int delay) {

        mob = owner;
        explosiveArrow = explosive;
        arrowVelocity = velocity;
        arrowInaccuracy = inaccuracy;
        arrowDelay = delay;

    }

    public boolean canUse() {

        return mob.getTarget() != null;

    }

    public boolean requiresUpdateEveryTick() {

        return true;

    }

    public void tick() {

        LivingEntity target = mob.getTarget();

        if (target != null && mob.tickCount % arrowDelay == 0) {

            if (target.distanceToSqr(mob) < 4096 && mob.hasLineOfSight(target)) {

                Level level = mob.level;

                double x = target.getX() - mob.getX();
                double y = target.getY() - mob.getY();
                double z = target.getZ() - mob.getZ();

                mob.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.25);
                mob.setXRot((float) SnakerBoneMath.rotateTowards(y, (x * x + z * z)));
                mob.xRotO = mob.getXRot();

                level.playSound(null, target.getX(), target.getY(), target.getZ(), SnakerBoneContentRegistry.SHOOT.get(), SoundSource.BLOCKS, 1, 1);

                if (explosiveArrow) {

                    ExplosiveHommingArrow explosiveHommingArrow = new ExplosiveHommingArrow(SnakerBoneEntityRegistry.EXPLOSIVE_HOMMING_ARROW.get(), mob, level);

                    explosiveHommingArrow.shoot(x, y, z, arrowVelocity, arrowInaccuracy);
                    level.addFreshEntity(explosiveHommingArrow);

                } else {

                    HommingArrow hommingArrow = new HommingArrow(SnakerBoneEntityRegistry.HOMMING_ARROW.get(), mob, level);

                    hommingArrow.shoot(x, y, z, arrowVelocity, arrowInaccuracy);
                    level.addFreshEntity(hommingArrow);
                }
            }
        }
    }
}
