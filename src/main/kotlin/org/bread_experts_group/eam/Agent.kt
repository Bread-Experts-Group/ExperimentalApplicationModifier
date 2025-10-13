package org.bread_experts_group.eam

import org.bread_experts_group.coder.Mappable.Companion.id
import org.bread_experts_group.command_line.Flag
import org.bread_experts_group.command_line.readArgs
import org.bread_experts_group.logging.ColoredHandler
import java.lang.instrument.Instrumentation

@Suppress("unused")
class Agent {
	companion object {
		private val modificationTypeFlag = Flag(
			"mod_type",
			"The type of modification to initiate on the loaded application." +
					"\nAvailable: ${EAMModificationType.entries.joinToString { it.id } }",
			required = 1,
			conv = {
				EAMModificationType.entries.id(it.lowercase()).enum.let { e ->
					if (e == null) throw IllegalArgumentException("You must specify a defined modification type.")
					e
				}
			}
		)
		private val modificationFlags = Flag<String>(
			"mod_arg",
			"An argument to pass down to the modification handler.",
			repeatable = true
		)

		@JvmStatic
		fun premain(agentArgs: String?, instrumentation: Instrumentation) {
			ColoredHandler.coloring = false
			val args = readArgs(
				agentArgs?.split(" ")?.toTypedArray() ?: emptyArray<String>(),
				"Bread Experts Group EAM (Experimental Application Modifier)",
				"Modifies applications. TODO: write a better usage",
				modificationTypeFlag,
				modificationFlags
			)
			val e = args.getRequired(modificationTypeFlag)
			e.instrument(instrumentation, args.gets(modificationFlags)?.toTypedArray() ?: emptyArray())
		}
	}
}