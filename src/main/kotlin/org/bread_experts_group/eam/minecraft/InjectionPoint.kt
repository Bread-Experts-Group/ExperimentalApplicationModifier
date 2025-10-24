package org.bread_experts_group.eam.minecraft

/**
 * Used for placing transforms before or after specified injection points in native classes.
 */
enum class InjectionPoint {
	/**
	 * Instructs the builder to place the native code **before** the transform.
	 */
	BEFORE,
	/**
	 * Instructs the builder to place the native code **after** the transform.
	 */
	AFTER
}