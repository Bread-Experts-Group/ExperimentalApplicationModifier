package org.bread_experts_group.eam

import org.bread_experts_group.generic.logging.LogMessage

data class EAMLogMessage(
    val message: String
) : LogMessage {
    val nano: Long = System.nanoTime()
}