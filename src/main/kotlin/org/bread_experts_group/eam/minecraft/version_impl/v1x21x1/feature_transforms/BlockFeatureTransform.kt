package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import org.bread_experts_group.eam.minecraft.test_mods.TestBlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_EntityBlock
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class BlockFeatureTransform(input: MinecraftBlock) : FeatureTransform<MinecraftBlock>(input, "MinecraftBlock") {
	override fun createInstance(clazz: Class<*>): Any =
		clazz.getConstructor(MinecraftBlock::class.java).newInstance(input)

	override fun startTransform(name: String): (ClassBuilder) -> Any = { classBuilder ->
		classBuilder.withSuperclass(Block.classDesc)
		classBuilder.withInterfaceSymbols(ClassDesc.of(net_minecraft_world_level_block_EntityBlock))
		classBuilder.withMethodBody(
			"a",
			MethodTypeDesc.of(
				BlockEntity.classDesc,
				BlockPos.classDesc,
				BlockState.classDesc
			),
			ClassFile.ACC_PUBLIC or ClassFile.ACC_FINAL
		) { codeBuilder ->
			codeBuilder
//				.new_(TestBlockEntity::class.classDesc)
//				.dup()
				.invokeSpecialNewMimicClass(BlockPos.mimicClassDesc, 1)
				.invokeSpecialNewMimicClass(BlockState.mimicClassDesc, 2)
//				.invokespecial(
//					TestBlockEntity::class.classDesc,
//					"<init>",
//					MethodTypeDesc.of(
//						ConstantDescs.CD_void,
//						BlockPos.mimicClassDesc,
//						BlockState.mimicClassDesc
//					)
//				)
				.invokestatic(
					TestBlockEntity::class.classDesc,
					"nativeBlockEntity",
					MethodTypeDesc.of(
						ConstantDescs.CD_Object,
						BlockPos.mimicClassDesc,
						BlockState.mimicClassDesc
					)
				)
//				.getfield(
//					TestBlockEntity::class.classDesc,
//					"around",
//					ConstantDescs.CD_Object
//				)
				.checkcast(BlockEntity.classDesc)
				.areturn()
		}
		classBuilder.withMethodBody(
			"<init>",
			MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftBlock.mimicClassDesc),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.invokestatic(
					BlockBehaviour.Properties.classDesc,
					"a",
					MethodTypeDesc.of(BlockBehaviour.Properties.classDesc)
				)
				// todo figure out why it's throwing no method found later
				/*.invokestatic(
					BlockBehaviour.Properties.mimicClassDesc,
					"of",
					MethodTypeDesc.of(BlockBehaviour.Properties.mimicClassDesc)
				)
				.getfield(
					BlockBehaviour.Properties.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)*/
				.checkcast(BlockBehaviour.Properties.classDesc)
				.invokespecial(
					Block.classDesc,
					"<init>",
					MethodTypeDesc.of(ConstantDescs.CD_void, BlockBehaviour.Properties.classDesc)
				)
				.aload(0)
				.aload(1)
				.putfield(
					ClassDesc.of(name),
					"reference",
					MinecraftBlock.mimicClassDesc
				)
				.return_()
		}
		classBuilder.withField(
			"reference",
			MinecraftBlock.mimicClassDesc,
			ClassFile.ACC_FINAL or ClassFile.ACC_PRIVATE
		)
	}
}