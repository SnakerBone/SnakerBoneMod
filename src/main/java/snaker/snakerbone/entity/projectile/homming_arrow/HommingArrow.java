package snaker.snakerbone.entity.projectile.homming_arrow;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import java.util.Comparator;
import java.util.List;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Author: Pupnewfster
 * <br>
 * Source: ProjectE
 **/
@SuppressWarnings(CUSTOM_SET)
public class HommingArrow extends AbstractArrow {
    private static final EntityDataAccessor<Integer> TARGET_ID = SynchedEntityData.defineId(HommingArrow.class, EntityDataSerializers.INT);
    private static final int NO_TARGET = -1;
    private int COOLDOWN = 0;

    public HommingArrow(EntityType<? extends AbstractArrow> type, Level world) {

        super(type, world);

    }

    public HommingArrow(EntityType<? extends AbstractArrow> type, double x, double y, double z, Level world) {

        super(type, x, y, z, world);

    }

    public HommingArrow(EntityType<? extends AbstractArrow> type, LivingEntity shooter, Level world) {

        super(type, shooter, world);

    }

    private boolean hasTarget() {

        return (getTarget() != null && getTarget() instanceof Player);

    }

    private LivingEntity getTarget() {

        return (LivingEntity) level.getEntity(entityData.get(TARGET_ID));

    }

    private void findNewTarget() {

        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8, 8, 8));

        if (!targets.isEmpty()) {

            targets.sort(Comparator.comparing(HommingArrow.this::distanceToSqr, Double::compare));

            entityData.set(TARGET_ID, targets.get(0).getId());

        }

        COOLDOWN = 5;
    }

    private double clampAbs(double param, double maxMagnitude) {

        if (Math.abs(param) > maxMagnitude) {

            if (param < 0) {

                param = -Math.abs(maxMagnitude);

            } else {

                param = Math.abs(maxMagnitude);

            }
        }

        return param;
    }

    private double wrap180Radian(double radian) {

        radian %= 2 * Math.PI;

        while (radian >= Math.PI) {

            radian -= 2 * Math.PI;

        }

        while (radian < -Math.PI) {

            radian += 2 * Math.PI;

        }

        return radian;
    }

    private double angleBetween(Vec3 v1, Vec3 v2) {

        double dotVector = v1.dot(v2) / (v1.length() * v2.length());

        if (dotVector < -1.0) {

            dotVector = -1.0;

        }
        if (dotVector > 1.0) {

            dotVector = 1.0;

        }

        return Math.acos(dotVector);
    }

    private Vec3 transform(Vec3 axis, double angle, Vec3 normal) {

        double m0 = 1;
        double m1 = 0;
        double m2 = 0;

        double m10 = 0;
        double m11 = 1;
        double m12 = 0;

        double m20 = 0;
        double m21 = 0;
        double m22 = 1;

        double magnitude = Math.sqrt(axis.x * axis.x + axis.y * axis.y + axis.z * axis.z);

        if (magnitude >= 1.0E-10) {

            magnitude = 1.0 / magnitude;

            double ax = axis.x * magnitude;
            double ay = axis.y * magnitude;
            double az = axis.z * magnitude;

            double angleSin = Math.sin(angle);
            double angleCos = Math.cos(angle);
            double t = 1 - angleCos;

            double xz = ax * az;
            double xy = ax * ay;
            double yz = ay * az;

            m0 = t * ax * ax + angleCos;
            m1 = t * xy - angleSin * az;
            m2 = t * xz + angleSin * ay;

            m10 = t * xy + angleSin * az;
            m11 = t * ay * ay + angleCos;
            m12 = t * yz - angleSin * ax;

            m20 = t * xz - angleSin * ay;
            m21 = t * yz + angleSin * ax;
            m22 = t * az * az + angleCos;

        }

        return new Vec3(m0 * normal.x + m1 * normal.y + m2 * normal.z, m10 * normal.x + m11 * normal.y + m12 * normal.z, m20 * normal.x + m21 * normal.y + m22 * normal.z);
    }

    @Override
    public void defineSynchedData() {

        super.defineSynchedData();

        entityData.define(TARGET_ID, NO_TARGET);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        super.onHitEntity(result);

        Entity entity = result.getEntity();

        DamageSource source;

        source = DamageSource.arrow(this, null);

        entity.hurt(source, 5);

        kill();

    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {

        return super.getDefaultHitGroundSoundEvent();

    }

    @Override
    protected ItemStack getPickupItem() {

        return ItemStack.EMPTY;

    }

    @Override
    public void tick() {

        if (!level.isClientSide && this.tickCount > 3) {

            this.setNoGravity(true);

            if (hasTarget() && (!getTarget().isAlive())) {

                entityData.set(TARGET_ID, NO_TARGET);
            }

            if (!hasTarget() && COOLDOWN <= 0) {

                findNewTarget();

            } else {

                COOLDOWN--;

            }
        }

        if (tickCount > 3 && hasTarget()) {

            double x = getDeltaMovement().x();
            double y = getDeltaMovement().y();
            double z = getDeltaMovement().z();

            Entity target = getTarget();

            Vec3 arrowVector = new Vec3(getX(), getY(), getZ());
            Vec3 targetVector = new Vec3(target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ());
            Vec3 viewVector = targetVector.subtract(arrowVector);
            Vec3 xyzVector = new Vec3(x, y, z);

            double radianWrap = wrap180Radian(angleBetween(xyzVector, viewVector));

            radianWrap = clampAbs(radianWrap, Math.PI / 2);

            Vec3 crossVector = xyzVector.cross(viewVector).normalize();
            Vec3 adjustedViewVector = transform(crossVector, radianWrap, xyzVector);

            shoot(adjustedViewVector.x, adjustedViewVector.y, adjustedViewVector.z, 1F, 0);

        }

        if (inGround && tickCount > 5) {

            kill();

        }

        super.tick();
    }

    @Override
    public boolean isOnFire() {

        return false;

    }

    @Override
    public Packet<?> getAddEntityPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);

    }
}
