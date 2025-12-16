package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_TitleScreen
import java.lang.constant.ClassDesc

class TitleScreen(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_screens_TitleScreen)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = TitleScreen::class.classDesc
	}
}