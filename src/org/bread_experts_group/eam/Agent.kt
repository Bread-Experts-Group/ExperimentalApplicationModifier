package org.bread_experts_group.eam

import java.lang.instrument.Instrumentation

@Suppress("unused")
class Agent {
	companion object {
		@JvmStatic
		fun premain(agentArgs: String?, instrumentation: Instrumentation) {
		}
	}
}