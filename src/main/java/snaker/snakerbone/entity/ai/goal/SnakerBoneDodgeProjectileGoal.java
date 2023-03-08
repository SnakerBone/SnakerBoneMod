package snaker.snakerbone.entity.ai.goal;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 28/02/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class SnakerBoneDodgeProjectileGoal extends Goal {
    private final Mob mob;

    public SnakerBoneDodgeProjectileGoal(Mob owner) {

        mob = owner;

    }

    @Override
    public void tick() {

        Level world = mob.level;

        List<Projectile> projectiles = world.getEntitiesOfClass(Projectile.class, mob.getBoundingBox().inflate(16), projectile -> mob.distanceTo(projectile) <= 24 + projectile.getBbWidth() / 2);

        if (!world.isClientSide) {

            for (Projectile projectile : projectiles) {

                Vec3 motion = new Vec3(projectile.getX() - projectile.xo, projectile.getY() - projectile.yo, projectile.getZ() - projectile.zo);

                if (motion.length() < 0.1 || projectile.tickCount <= 1) {

                    continue;

                }

                float delta = (float) projectile.getDeltaMovement().normalize().dot(mob.position().subtract(projectile.position()).normalize());

                if (delta > 0.96) {

                    Vec3 position = projectile.getDeltaMovement().cross(new Vec3(0, 0.25, 0)).normalize().scale(0.6);

                    Vec3 addLeft = mob.position().add(position.scale(0.5));
                    Vec3 addRight = mob.position().add(position.scale(-0.5));

                    Vec3 subLeft = addLeft.subtract(projectile.position());
                    Vec3 subRight = addRight.subtract(projectile.position());

                    if (subRight.dot(projectile.getDeltaMovement()) > subLeft.dot(projectile.getDeltaMovement())) {

                        position = position.scale(-0.25);

                    }

                    mob.setDeltaMovement(mob.getDeltaMovement().add(position));
                }
            }
        }
    }

    @Override
    public boolean requiresUpdateEveryTick() {

        return true;

    }

    @Override
    public boolean canUse() {

        return true;

    }
}
