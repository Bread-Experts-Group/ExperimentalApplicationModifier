package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.FeatureProvider
import org.bread_experts_group.eam.minecraft.feature.MinecraftFeatureImplementation
import org.bread_experts_group.logging.ColoredHandler
import java.util.logging.Logger

object MinecraftProvider : FeatureProvider<MinecraftFeatureImplementation<*>> {
	override val features: MutableList<MinecraftFeatureImplementation<*>> = mutableListOf()
	override val supportedFeatures: MutableMap<FeatureExpression<out MinecraftFeatureImplementation<*>>, MutableList<MinecraftFeatureImplementation<*>>> = mutableMapOf()
	override val logger: Logger = ColoredHandler.newLogger("TMP logger")
}