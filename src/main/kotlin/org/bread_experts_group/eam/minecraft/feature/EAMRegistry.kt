package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.logging.ColoredHandler
import java.lang.constant.ClassDesc

open class EAMRegistry<T>(val namespace: String) {
	companion object {
		val classDesc: ClassDesc = ClassDesc.of(EAMRegistry::class.qualifiedName)
	}

	private val elements = mutableMapOf<String, MutableMap<String, T>>()
	private val logger = ColoredHandler.newLogger("TMP logger EAM Registry")
	private var locked = false
	protected fun add(id: Identifier, o: T): T {
		if (locked) throw IllegalStateException("Locked registry")
		val last = elements.getOrPut(id.namespace) {
			logger.info("Creating new namespace sub-registry for \"${id.namespace}\"")
			mutableMapOf()
		}.put(id.subject, o)
		if (last != null) throw IllegalArgumentException("Overwriting $id with $o!")
		return o
	}

	protected fun add(id: String, o: T): T = this.add(Identifier(this.namespace, id), o)

	class EAMEntryIterator<T>(elements: MutableMap<String, MutableMap<String, T>>) : Iterator<Pair<Identifier, T>> {
		private val base1 = elements.iterator()
		private var base2Id = ""
		private var base2: Iterator<Map.Entry<String, T>>? = null
		private fun loadNext() {
			val next = base1.next()
			base2Id = next.key
			base2 = next.value.iterator()
		}

		override fun hasNext(): Boolean = base2.let {
			if (it == null) {
				if (!base1.hasNext()) return false
				loadNext()
				return true
			} else {
				if (it.hasNext()) return true
				else {
					base2 = null
					return hasNext()
				}
			}
		}

		override fun next(): Pair<Identifier, T> = base2.let {
			if (it != null) {
				val next = it.next()
				return Identifier(base2Id, next.key) to next.value
			}
			loadNext()
			return next()
		}
	}

	@Suppress("unused")
	fun entryIterator(): EAMEntryIterator<T> = EAMEntryIterator(elements)
}