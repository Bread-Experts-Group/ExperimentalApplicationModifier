package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_LayeredDraw
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_LayeredDraw_Layer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.LayeredDraw -> fib:
# {"fileName":"LayeredDraw.java","id":"sourceFile"}
    float Z_SEPARATION -> a
    java.util.List layers -> b
    9:12:void <init>() -> <init>
    20:20:net.minecraft.client.gui.LayeredDraw add(net.minecraft.client.gui.LayeredDraw,java.util.function.BooleanSupplier) -> a
    28:31:void render(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> a
    35:39:void renderInner(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> b
    21:24:void lambda$add$0(java.util.function.BooleanSupplier,net.minecraft.client.gui.LayeredDraw,net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> a
 */
class LayeredDraw(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_LayeredDraw)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = LayeredDraw::class.classDesc
	}

	fun add(layer: Layer) {
		clazz.getMethod("a", Layer.clazz).invoke(around, layer.around)
	}

	/*
	net.minecraft.client.gui.LayeredDraw$Layer -> fib$a:
	# {"fileName":"LayeredDraw.java","id":"sourceFile"}
    void render(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> render
	 */
	open class Layer(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_gui_LayeredDraw_Layer)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Layer::class.classDesc
		}
	}
}