package org.bread_experts_group.eam.minecraft.test_mods

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class TestBlockEntity(around: Any) : BlockEntity(around) {
	companion object {
		@JvmStatic
		fun nativeBlockEntity(pos: BlockPos, state: BlockState): Any {
			val entity = TestBlockEntity(0)
			return entity.implementNative(BlockEntity::class.java, true) { classBuilder, name ->
				classBuilder.withSuperclass(classDesc)
				classBuilder.withMethodBody(
					"<init>",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						BlockEntityType.classDesc,
						BlockPos.classDesc,
						BlockState.classDesc
					),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.aload(0)
						.aload(1)
						.aload(2)
						.aload(3)
						.invokespecial(
							classDesc,
							"<init>",
							MethodTypeDesc.of(
								ConstantDescs.CD_void,
								BlockEntityType.classDesc,
								BlockPos.classDesc,
								BlockState.classDesc
							)
						)
						.return_()
				}

			}.newInstance(TEST_ENTITY.around, pos.around, state.around)
		}
	}
}