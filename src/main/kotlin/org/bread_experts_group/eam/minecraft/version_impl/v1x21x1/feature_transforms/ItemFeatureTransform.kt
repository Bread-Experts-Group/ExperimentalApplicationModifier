package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.transform.FeatureTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_item_Item_inventoryTick
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_item_Item_useOn
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.InteractionResult
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.context.UseOnContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class ItemFeatureTransform(input: MinecraftItem) : FeatureTransform<MinecraftItem, MinecraftItemFeature>(
	input,
	MinecraftFeatures.ITEM
) {
	override fun createInstance(clazz: Class<*>): Any =
		clazz.getConstructor(MinecraftItem::class.java).newInstance(input)

	override fun startTransform(name: String): (ClassBuilder) -> Any = { classBuilder ->
		classBuilder.withSuperclass(Item.classDesc)
		input::class.java.declaredMethods.forEach {
			when (it.name) {
				"inventoryTick" -> {
					classBuilder.withMethodBody(
						net_minecraft_world_item_Item_inventoryTick,
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ItemStack.classDesc,
							Level.classDesc,
							Entity.classDesc,
							ConstantDescs.CD_int,
							ConstantDescs.CD_boolean
						),
						ClassFile.ACC_PUBLIC or ClassFile.ACC_FINAL
					) { codeBuilder ->
						codeBuilder
							.getReferenceField(name, MinecraftItem.mimicClassDesc)
							.invokeSpecialNewMimic(ItemStack.mimicClassDesc, 1)
							.invokeSpecialNewMimic(Level.mimicClassDesc, 2)
							.invokeSpecialNewMimic(Entity.mimicClassDesc, 3)
							.iload(4)
							.iload(5)
							.invokevirtual(
								MinecraftItem.mimicClassDesc,
								"inventoryTick",
								MethodTypeDesc.of(
									ConstantDescs.CD_void,
									ItemStack.mimicClassDesc,
									Level.mimicClassDesc,
									Entity.mimicClassDesc,
									ConstantDescs.CD_int,
									ConstantDescs.CD_boolean
								)
							)
							.return_()
					}
				}
				"useOn" -> classBuilder.withMethodBody(
					net_minecraft_world_item_Item_useOn,
					MethodTypeDesc.of(
						InteractionResult.classDesc,
						UseOnContext.classDesc
					),
					ClassFile.ACC_PUBLIC or ClassFile.ACC_FINAL
				) { codeBuilder ->
					codeBuilder
						.getReferenceField(name, MinecraftItem.mimicClassDesc)
						.invokeSpecialNewMimic(UseOnContext.mimicClassDesc, 1)
						.invokevirtual(
							codeBuilder.constantPool().methodRefEntry(
								MinecraftItem.mimicClassDesc,
								"useOn",
								MethodTypeDesc.of(
									InteractionResult.mimicClassDesc,
									UseOnContext.mimicClassDesc
								)
							)
						)
						.getfield(InteractionResult.mimicClassDesc, "around", ConstantDescs.CD_Object)
						.checkcast(InteractionResult.classDesc)
						.areturn()
				}
			}
		}
		// todo implement item properties into MinecraftItem, then pass into here
		classBuilder.withMethodBody(
			ConstantDescs.INIT_NAME,
			MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftItem.mimicClassDesc),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.invokeSpecialNewMimic(Item.Properties.mimicClassDesc)
				.getfield(
					Item.Properties.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)
				.checkcast(Item.Properties.classDesc)
				.invokespecial(
					Item.classDesc,
					ConstantDescs.INIT_NAME,
					MethodTypeDesc.of(ConstantDescs.CD_void, Item.Properties.classDesc)
				)
				.aload(0)
				.aload(1)
				.putReferenceField(name, MinecraftItem.mimicClassDesc)
				.return_()
		}
		classBuilder.withReferenceField(MinecraftItem.mimicClassDesc)
	}
}