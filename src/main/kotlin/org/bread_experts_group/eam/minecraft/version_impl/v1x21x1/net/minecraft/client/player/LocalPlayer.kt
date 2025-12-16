package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.player

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_player_LocalPlayer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.player.LocalPlayer -> geb:
# {"fileName":"LocalPlayer.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> g
    int POSITION_REMINDER_INTERVAL -> cJ
    int WATER_VISION_MAX_TIME -> cK
    int WATER_VISION_QUICK_TIME -> cL
    float WATER_VISION_QUICK_PERCENT -> cM
    double SUFFOCATING_COLLISION_CHECK_SCALE -> cN
    double MINOR_COLLISION_ANGLE_THRESHOLD_RADIAN -> cO
    net.minecraft.client.multiplayer.ClientPacketListener connection -> h
    net.minecraft.stats.StatsCounter stats -> cP
    net.minecraft.client.ClientRecipeBook recipeBook -> cQ
    java.util.List ambientSoundHandlers -> cR
    int permissionLevel -> cS
    double xLast -> cT
    double yLast1 -> cU
    double zLast -> cV
    float yRotLast -> cW
    float xRotLast -> cX
    boolean lastOnGround -> cY
    boolean crouching -> cZ
    boolean wasShiftKeyDown -> da
    boolean wasSprinting -> db
    int positionReminder -> dc
    boolean flashOnSetHealth -> dd
    net.minecraft.client.player.Input input -> cz
    net.minecraft.client.Minecraft minecraft -> cA
    int sprintTriggerTime -> cB
    float yBob -> cD
    float xBob -> cE
    float yBobO -> cF
    float xBobO -> cG
    int jumpRidingTicks -> de
    float jumpRidingScale -> df
    float spinningEffectIntensity -> cH
    float oSpinningEffectIntensity -> cI
    boolean startedUsingItem -> dg
    net.minecraft.world.InteractionHand usingItemHand -> dh
    boolean handsBusy -> di
    boolean autoJumpEnabled -> dj
    int autoJumpTime -> dk
    boolean wasFallFlying -> dl
    int waterVisionTime -> dm
    boolean showDeathScreen -> dn
    boolean doLimitedCrafting -> do
    112:167:void <init>(net.minecraft.client.Minecraft,net.minecraft.client.multiplayer.ClientLevel,net.minecraft.client.multiplayer.ClientPacketListener,net.minecraft.stats.StatsCounter,net.minecraft.client.ClientRecipeBook,boolean,boolean) -> <init>
    171:171:boolean hurt(net.minecraft.world.damagesource.DamageSource,float) -> a
    177:177:void heal(float) -> c
    181:193:boolean startRiding(net.minecraft.world.entity.Entity,boolean) -> a
    198:200:void removeVehicle() -> bJ
    204:204:float getViewXRot(float) -> h
    209:212:float getViewYRot(float) -> i
    217:238:void tick() -> l
    241:246:float getCurrentMood() -> d
    250:302:void sendPosition() -> E
    305:311:void sendIsSprintingIfNeeded() -> F
    314:317:boolean drop(boolean) -> a
    322:324:void swing(net.minecraft.world.InteractionHand) -> a
    328:330:void respawn() -> fW
    334:338:void actuallyHurt(net.minecraft.world.damagesource.DamageSource,float) -> f
    342:344:void closeContainer() -> s
    348:350:void clientSideCloseContainer() -> e
    353:371:void hurtTo(float) -> H
    375:376:void onUpdateAbilities() -> z
    380:380:boolean isLocalPlayer() -> g
    385:385:boolean isSuppressingSlidingDownLadder() -> fz
    390:390:boolean canSpawnSprintParticle() -> br
    394:395:void sendRidingJump() -> h
    398:399:void sendOpenInventory() -> i
    402:402:net.minecraft.stats.StatsCounter getStats() -> j
    406:406:net.minecraft.client.ClientRecipeBook getRecipeBook() -> m
    410:414:void removeRecipeHighlight(net.minecraft.world.item.crafting.RecipeHolder) -> a
    418:418:int getPermissionLevel() -> G
    422:423:void setPermissionLevel(int) -> a
    427:428:void displayClientMessage(net.minecraft.network.chat.Component,boolean) -> a
    431:462:void moveTowardsClosestSpace(double,double) -> c
    466:468:boolean suffocatesAt(net.minecraft.core.BlockPos) -> c
    472:475:void setExperienceValues(float,int,int) -> a
    479:480:void sendSystemMessage(net.minecraft.network.chat.Component) -> a
    484:489:void handleEntityEvent(byte) -> b
    492:493:void setShowDeathScreen(boolean) -> b
    496:496:boolean shouldShowDeathScreen() -> o
    500:501:void setDoLimitedCrafting(boolean) -> x
    504:504:boolean getDoLimitedCrafting() -> p
    509:510:void playSound(net.minecraft.sounds.SoundEvent,float,float) -> a
    514:515:void playNotifySound(net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    519:519:boolean isEffectiveAi() -> db
    524:533:void startUsingItem(net.minecraft.world.InteractionHand) -> c
    537:537:boolean isUsingItem() -> fr
    542:544:void stopUsingItem() -> fx
    549:549:net.minecraft.world.InteractionHand getUsedItemHand() -> fs
    554:571:void onSyncedDataUpdated(net.minecraft.network.syncher.EntityDataAccessor) -> a
    575:575:net.minecraft.world.entity.PlayerRideableJumping jumpableVehicle() -> q
    579:579:float getJumpRidingScale() -> v
    584:584:boolean isTextFilteringEnabled() -> Z
    589:594:void openTextEdit(net.minecraft.world.level.block.entity.SignBlockEntity,boolean) -> a
    598:599:void openMinecartCommandBlock(net.minecraft.world.level.BaseCommandBlock) -> a
    603:604:void openCommandBlock(net.minecraft.world.level.block.entity.CommandBlockEntity) -> a
    608:609:void openStructureBlock(net.minecraft.world.level.block.entity.StructureBlockEntity) -> a
    613:614:void openJigsawBlock(net.minecraft.world.level.block.entity.JigsawBlockEntity) -> a
    618:621:void openItemGui(net.minecraft.world.item.ItemStack,net.minecraft.world.InteractionHand) -> a
    625:626:void crit(net.minecraft.world.entity.Entity) -> b
    630:631:void magicCrit(net.minecraft.world.entity.Entity) -> c
    635:635:boolean isShiftKeyDown() -> bW
    640:640:boolean isCrouching() -> cb
    644:644:boolean isMovingSlowly() -> w
    649:660:void serverAiStep() -> fm
    663:663:boolean isControlledCamera() -> x
    667:683:void resetPos() -> y
    687:856:void aiStep() -> m_
    859:859:net.minecraft.world.level.block.Portal$Transition getActivePortalLocalTransition() -> A
    865:869:void tickDeath() -> ed
    872:897:void handleConfusionTransitionEffect(boolean) -> y
    901:909:void rideTick() -> u
    912:912:boolean isHandsBusy() -> B
    918:923:net.minecraft.world.effect.MobEffectInstance removeEffectNoUpdate(net.minecraft.core.Holder) -> d
    928:932:void move(net.minecraft.world.entity.MoverType,net.minecraft.world.phys.Vec3) -> a
    935:935:boolean isAutoJumpEnabled() -> C
    939:1136:void updateAutoJump(float,float) -> g
    1140:1152:boolean isHorizontalCollisionMinor(net.minecraft.world.phys.Vec3) -> d
    1156:1162:boolean canAutoJump() -> H
    1166:1167:boolean isMoving() -> I
    1171:1177:boolean canStartSprinting() -> J
    1181:1181:boolean vehicleCanSprint(net.minecraft.world.entity.Entity) -> d
    1187:1188:boolean hasEnoughImpulseToStartSprinting() -> L
    1192:1192:boolean hasEnoughFoodToStartSprinting() -> N
    1196:1206:float getWaterVision() -> D
    1210:1214:void onGameModeChanged(net.minecraft.world.level.GameType) -> a
    1218:1218:boolean isUnderWater() -> bk
    1223:1239:boolean updateIsUnderwater() -> fQ
    1244:1251:net.minecraft.world.phys.Vec3 getRopeHoldPosition(float) -> s
    1256:1257:void updateTutorialInventoryAction(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack,net.minecraft.world.inventory.ClickAction) -> a
    1261:1261:float getVisualRotationYInDegrees() -> dF
    1076:1076:java.util.stream.Stream lambda$updateAutoJump$0(net.minecraft.world.phys.shapes.VoxelShape) -> a
    99:99:void <clinit>() -> <clinit>
 */
class LocalPlayer(around: Any) : AbstractClientPlayer(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_player_LocalPlayer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = LocalPlayer::class.classDesc
	}
}