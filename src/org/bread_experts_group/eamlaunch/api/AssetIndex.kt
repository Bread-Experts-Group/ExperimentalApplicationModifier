package org.bread_experts_group.eamlaunch.api

import java.math.BigDecimal

data class AssetIndex(
    val objects: Map<String, Object>
) {
    data class Object(
        val hash: SHA1,
        val size: BigDecimal
    )
}