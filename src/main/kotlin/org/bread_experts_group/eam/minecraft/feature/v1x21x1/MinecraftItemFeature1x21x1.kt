package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.InteractionResult
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item.Properties.Companion.mimicClassDesc
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Items
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.context.UseOnContext
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class MinecraftItemFeature1x21x1 : MinecraftItemFeature() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftItemFeature> = MinecraftFeatures.ITEM

	private var c = 0
	private val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
	private val cl = object : ClassLoader() {
		fun define(n: String, b: ByteArray) = this.defineClass(n, b, 0, b.size)
	}

	override fun register(id: Identifier, item: MinecraftItem): MinecraftItem {
		val mcItem = if (item::class == MinecraftItem::class) Item(
			Item.Properties()
				.stacksTo(32)
				.food(
					FoodProperties.Builder()
						.nutrition(20)
						.build()
				)
		) else {
			val name = item::class.qualifiedName ?: "eamInternal${c++}"
			val around = cl.define(
				name,
				cf.build(ClassDesc.of(name)) { classBuilder ->
					classBuilder.withSuperclass(Item.classDesc)
					item::class.java.declaredMethods.forEach {
						when (it.name) {
							"inventoryTick" -> {
								// todo potential idea to invoking the needed classes/primitives using the params here..
								val params = listOf(ItemStack.classDesc, Level.classDesc, Entity.classDesc,
									ConstantDescs.CD_int, ConstantDescs.CD_boolean)
								classBuilder.withMethodBody(
									net_minecraft_world_item_Item_inventoryTick,
									MethodTypeDesc.of(
										ConstantDescs.CD_void,
										params
									),
									ACC_PUBLIC or ACC_FINAL
								) { codeBuilder ->
									codeBuilder
										.getReferenceField(name, MinecraftItem.mimicClassDesc)
										.invokeSpecialNewMimicClass(ItemStack.mimicClassDesc, 1)
										.invokeSpecialNewMimicClass(Level.mimicClassDesc, 2)
										.invokeSpecialNewMimicClass(Entity.mimicClassDesc, 3)
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
								ACC_PUBLIC or ACC_FINAL
							) { codeBuilder ->
								codeBuilder
									.getReferenceField(name, MinecraftItem.mimicClassDesc)
									.new_(UseOnContext.mimicClassDesc)
									.dup()
									.aload(1)
									.invokespecial(
										UseOnContext.mimicClassDesc,
										"<init>",
										MethodTypeDesc.of(
											ConstantDescs.CD_void,
											ConstantDescs.CD_Object
										)
									)
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
					classBuilder.withMethodBody(
						"<init>",
						MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftItem.mimicClassDesc),
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.aload(0)
							.new_(mimicClassDesc)
							.dup()
							.invokespecial(
								mimicClassDesc,
								"<init>",
								MethodTypeDesc.of(ConstantDescs.CD_void),
							)
							.getfield(
								mimicClassDesc,
								"around",
								ConstantDescs.CD_Object
							)
							.checkcast(Item.Properties.classDesc)
							.invokespecial(
								Item.classDesc,
								"<init>",
								MethodTypeDesc.of(ConstantDescs.CD_void, Item.Properties.classDesc)
							)
							.aload(0)
							.aload(1)
							.putfield(
								ClassDesc.of(name),
								"reference",
								MinecraftItem.mimicClassDesc
							)
							.return_()
					}
					classBuilder.withField(
						"reference",
						MinecraftItem.mimicClassDesc,
						ACC_FINAL or ACC_PRIVATE
					)
				}
			).getConstructor(MinecraftItem::class.java).newInstance(item)
			Item(around)
		}
		Items.registerItem(ResourceLocation.parse("${id.namespace}:${id.subject}"), mcItem)
		return item
	}
}