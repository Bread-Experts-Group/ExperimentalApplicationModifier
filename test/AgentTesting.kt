import org.bread_experts_group.eam.minecraft.v1x21x1.PoseStack
import org.bread_experts_group.eamlaunch.api.Mapping

fun main() {
    val unobfuscated = Mapping.of(PoseStack::class)

    unobfuscated.let {
        println(it.unobfuscated)
        println(it.obfuscated)
        it.members.forEach(::println)
    }
}