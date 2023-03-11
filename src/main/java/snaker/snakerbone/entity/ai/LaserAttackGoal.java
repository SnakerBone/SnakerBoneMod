package snaker.snakerbone.entity.ai;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import snaker.snakerbone.entity.projectile.Laser;
import snaker.snakerbone.registry.ContentRegistry;
import snaker.snakerbone.registry.EntityRegistry;
import snaker.snakerbone.utility.Maths;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class LaserAttackGoal extends Goal {
    private final Mob mob;
    private final float laserInaccuracy;
    private final float laserVelocity;
    private final int laserDelay;

    public LaserAttackGoal(Mob owner, float velocity, float inaccuracy, int delay) {
        mob = owner;
        laserVelocity = velocity;
        laserInaccuracy = inaccuracy;
        laserDelay = delay;
    }

    public boolean canUse() {
        return mob.getTarget() != null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target != null && mob.tickCount % laserDelay == 0) {
            if (target.distanceToSqr(mob) < 4096 && mob.hasLineOfSight(target)) {
                Level level = mob.level;
                double x = target.getX() - mob.getX();
                double y = target.getY() - mob.getY();
                double z = target.getZ() - mob.getZ();
                mob.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.25);
                mob.setXRot((float) Maths.rotateTowards(y, (x * x + z * z)));
                mob.xRotO = mob.getXRot();
                Laser laser = new Laser(EntityRegistry.LASER.get(), mob, level);
                laser.shoot(x, y, z, laserVelocity, laserInaccuracy);
                level.addFreshEntity(laser);
                level.playSound(null, target.getX(), target.getY(), target.getZ(), ContentRegistry.BULLET.get(), SoundSource.BLOCKS, 1, 1);
            }
        }
    }
}
