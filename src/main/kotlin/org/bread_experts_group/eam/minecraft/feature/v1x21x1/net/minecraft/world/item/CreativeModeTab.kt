package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.CreativeModeTab.Builder.Temp.runGenerator
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_Builder
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_ItemDisplayParameters
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_Output
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_Row
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTab_Type
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithLocalVars
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

/*
net.minecraft.world.item.CreativeModeTab -> cta:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation DEFAULT_BACKGROUND -> a
    net.minecraft.network.chat.Component displayName -> b
    net.minecraft.resources.ResourceLocation backgroundTexture -> c
    boolean canScroll -> d
    boolean showTitle -> e
    boolean alignedRight -> f
    net.minecraft.world.item.CreativeModeTab$Row row -> g
    int column -> h
    net.minecraft.world.item.CreativeModeTab$Type type -> i
    net.minecraft.world.item.ItemStack iconItemStack -> j
    java.util.Collection displayItems -> k
    java.util.Set displayItemsSearchTab -> l
    java.util.function.Supplier iconGenerator -> m
    net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator displayItemsGenerator -> n
    21:42:void <init>(net.minecraft.world.item.CreativeModeTab$Row,int,net.minecraft.world.item.CreativeModeTab$Type,net.minecraft.network.chat.Component,java.util.function.Supplier,net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator) -> <init>
    45:45:net.minecraft.resources.ResourceLocation createTextureLocation(java.lang.String) -> a
    49:49:net.minecraft.world.item.CreativeModeTab$Builder builder(net.minecraft.world.item.CreativeModeTab$Row,int) -> a
    53:53:net.minecraft.network.chat.Component getDisplayName() -> a
    57:60:net.minecraft.world.item.ItemStack getIconItem() -> b
    64:64:net.minecraft.resources.ResourceLocation getBackgroundTexture() -> c
    68:68:boolean showTitle() -> d
    72:72:boolean canScroll() -> e
    76:76:int column() -> f
    80:80:net.minecraft.world.item.CreativeModeTab$Row row() -> g
    84:84:boolean hasAnyItems() -> h
    88:88:boolean shouldDisplay() -> i
    92:92:boolean isAlignedRight() -> j
    96:96:net.minecraft.world.item.CreativeModeTab$Type getType() -> k
    100:108:void buildContents(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters) -> a
    111:111:java.util.Collection getDisplayItems() -> l
    115:115:java.util.Collection getSearchTabDisplayItems() -> m
    119:119:boolean contains(net.minecraft.world.item.ItemStack) -> a
    101:101:java.lang.IllegalStateException lambda$buildContents$0() -> n
    19:19:void <clinit>() -> <clinit>

net.minecraft.world.item.CreativeModeTab$ItemDisplayBuilder -> cta$c:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    java.util.Collection tabContents -> a
    java.util.Set searchTabContents -> b
    net.minecraft.world.item.CreativeModeTab tab -> c
    net.minecraft.world.flag.FeatureFlagSet featureFlagSet -> d
    219:227:void <init>(net.minecraft.world.item.CreativeModeTab,net.minecraft.world.flag.FeatureFlagSet) -> <init>
    231:255:void accept(net.minecraft.world.item.ItemStack,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a

net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters -> cta$d:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.flag.FeatureFlagSet enabledFeatures -> a
    boolean hasPermissions -> b
    net.minecraft.core.HolderLookup$Provider holders -> c
    122:122:void <init>(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> <init>
    124:124:boolean needsUpdate(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> a
    122:122:java.lang.String toString() -> toString
    122:122:int hashCode() -> hashCode
    122:122:boolean equals(java.lang.Object) -> equals
    122:122:net.minecraft.world.flag.FeatureFlagSet enabledFeatures() -> a
    122:122:boolean hasPermissions() -> b
    122:122:net.minecraft.core.HolderLookup$Provider holders() -> c

net.minecraft.world.item.CreativeModeTab$TabVisibility -> cta$g:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.item.CreativeModeTab$TabVisibility PARENT_AND_SEARCH_TABS -> a
    net.minecraft.world.item.CreativeModeTab$TabVisibility PARENT_TAB_ONLY -> b
    net.minecraft.world.item.CreativeModeTab$TabVisibility SEARCH_TAB_ONLY -> c
    net.minecraft.world.item.CreativeModeTab$TabVisibility[] $VALUES -> d
    258:258:net.minecraft.world.item.CreativeModeTab$TabVisibility[] values() -> values
    258:258:net.minecraft.world.item.CreativeModeTab$TabVisibility valueOf(java.lang.String) -> valueOf
    258:258:void <init>(java.lang.String,int) -> <init>
    258:258:net.minecraft.world.item.CreativeModeTab$TabVisibility[] $values() -> a
    258:261:void <clinit>() -> <clinit>
 */
class CreativeModeTab(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = CreativeModeTab::class.classDesc

		fun builder(row: Row, column: Int): Builder = Builder(
			clazz.getMethod("a", Row.clazz, Int::class.java)
				.invoke(null, row.around, column)
		)
	}

	/*
	net.minecraft.world.item.CreativeModeTab$Builder -> cta$a:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator EMPTY_GENERATOR -> a
    net.minecraft.world.item.CreativeModeTab$Row row -> b
    int column -> c
    net.minecraft.network.chat.Component displayName -> d
    java.util.function.Supplier iconGenerator -> e
    net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator displayItemsGenerator -> f
    boolean canScroll -> g
    boolean showTitle -> h
    boolean alignedRight -> i
    net.minecraft.world.item.CreativeModeTab$Type type -> j
    net.minecraft.resources.ResourceLocation backgroundTexture -> k
    150:162:void <init>(net.minecraft.world.item.CreativeModeTab$Row,int) -> <init>
    170:171:net.minecraft.world.item.CreativeModeTab$Builder icon(java.util.function.Supplier) -> a
    180:181:net.minecraft.world.item.CreativeModeTab$Builder alignedRight() -> a
    185:186:net.minecraft.world.item.CreativeModeTab$Builder hideTitle() -> b
    190:191:net.minecraft.world.item.CreativeModeTab$Builder noScrollBar() -> c
    195:196:net.minecraft.world.item.CreativeModeTab$Builder type(net.minecraft.world.item.CreativeModeTab$Type) -> a
    200:201:net.minecraft.world.item.CreativeModeTab$Builder backgroundTexture(net.minecraft.resources.ResourceLocation) -> a
    151:151:net.minecraft.world.item.ItemStack lambda$new$1() -> e
    146:146:void lambda$static$0(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> a
    146:146:void <clinit>() -> <clinit>
	 */
	class Builder(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_Builder)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = CreativeModeTab::class.classDesc
		}

		// todo clean up
		object Temp {
			// todo temporary solution for now...
			@JvmStatic
			fun runGenerator(parameters: ItemDisplayParameters, output: Output) {
				val stack = BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:bread_block")).getDefaultInstance()
				output.accept(stack)
			}
		}

		private val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
		private val cl = object : ClassLoader() {
			fun define(n: String, b: ByteArray) = this.defineClass(n, b, 0, b.size)
		}
		private val name: String = DisplayItemsGenerator::class.qualifiedName!!

		// todo addition to ClassTransform to implement the native class when needed?
		fun runTheNightmareClass(): DisplayItemsGenerator {
			val around = cl.define(
				name,
				cf.build(ClassDesc.of(name)) { classBuilder ->
					classBuilder.withInterfaceSymbols(ClassDesc.of(net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator))
					classBuilder.withMethodBody(
						"accept",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ItemDisplayParameters.classDesc,
							Output.classDesc
						),
						ACC_PUBLIC or ACC_FINAL
					) { codeBuilder ->
						val localVars = listOf(
							LocalVariable.of(
								1,
								"var1",
								ItemDisplayParameters.classDesc,
								codeBuilder.startLabel(),
								codeBuilder.endLabel()
							),
							LocalVariable.of(
								2,
								"var2",
								Output.classDesc,
								codeBuilder.startLabel(),
								codeBuilder.endLabel()
							)
						)
						codeBuilder
							.aload(0)
							.invokeStaticMethodWithLocalVars(::runGenerator.javaMethod, localVars)
							.return_()
					}
					classBuilder.withMethodBody(
						"<init>",
						MethodTypeDesc.of(ConstantDescs.CD_void),
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.aload(0)
							.invokespecial(
								ConstantDescs.CD_Object,
								"<init>",
								MethodTypeDesc.of(ConstantDescs.CD_void)
							)
							.return_()
					}
				}

			).getConstructor().newInstance()

			return DisplayItemsGenerator(around)
		}

		fun title(component: Component): Builder = Builder(
			clazz.getMethod("a", Component.clazz)
				.invoke(around, component.around)
		)

		fun displayItems(): Builder {
			clazz.getMethod("a", loadClass($$"cta$b"))
				.invoke(around, runTheNightmareClass().around)
			return Builder(around)
		}

//		fun displayItems(generator: (ItemDisplayParameters, Output) -> Unit): Builder = Builder(
//			clazz.getMethod("a", DisplayItemsGenerator.clazz)
//				.invoke(around, )
//		)

		fun build(): CreativeModeTab = CreativeModeTab(clazz.getMethod("d").invoke(around))
	}

	/*
	net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator -> cta$b:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    void accept(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> accept
	 */
	open class DisplayItemsGenerator(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = DisplayItemsGenerator::class.classDesc
		}

		open fun accept(displayParameters: ItemDisplayParameters, output: Output) {}
	}

	/*
	net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters -> cta$d:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.flag.FeatureFlagSet enabledFeatures -> a
    boolean hasPermissions -> b
    net.minecraft.core.HolderLookup$Provider holders -> c
    122:122:void <init>(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> <init>
    124:124:boolean needsUpdate(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> a
    122:122:java.lang.String toString() -> toString
    122:122:int hashCode() -> hashCode
    122:122:boolean equals(java.lang.Object) -> equals
    122:122:net.minecraft.world.flag.FeatureFlagSet enabledFeatures() -> a
    122:122:boolean hasPermissions() -> b
    122:122:net.minecraft.core.HolderLookup$Provider holders() -> c
	 */
	class ItemDisplayParameters(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_ItemDisplayParameters)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = ItemDisplayParameters::class.classDesc
		}
	}

	/*
	net.minecraft.world.item.CreativeModeTab$Output -> cta$e:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    void accept(net.minecraft.world.item.ItemStack,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    268:269:void accept(net.minecraft.world.item.ItemStack) -> a
    272:273:void accept(net.minecraft.world.level.ItemLike,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    276:277:void accept(net.minecraft.world.level.ItemLike) -> a
    280:281:void acceptAll(java.util.Collection,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    284:285:void acceptAll(java.util.Collection) -> a
    280:280:void lambda$acceptAll$0(net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> a
	 */
	class Output(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_Output)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Output::class.classDesc
		}

		fun accept(stack: ItemStack) {
			clazz.getMethod("a", ItemStack.clazz)
				.invoke(around, stack.around)
		}
	}

	/*
	net.minecraft.world.item.CreativeModeTab$Row -> cta$f:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.item.CreativeModeTab$Row TOP -> a
    net.minecraft.world.item.CreativeModeTab$Row BOTTOM -> b
    net.minecraft.world.item.CreativeModeTab$Row[] $VALUES -> c
    140:140:net.minecraft.world.item.CreativeModeTab$Row[] values() -> values
    140:140:net.minecraft.world.item.CreativeModeTab$Row valueOf(java.lang.String) -> valueOf
    140:140:void <init>(java.lang.String,int) -> <init>
    140:140:net.minecraft.world.item.CreativeModeTab$Row[] $values() -> a
    140:142:void <clinit>() -> <clinit>
	 */
	class Row(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_Row)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Row::class.classDesc

			val TOP: Row = Row(clazz.enumConstants[0])
			val BOTTOM: Row = Row(clazz.enumConstants[1])
		}
	}

	/*
	net.minecraft.world.item.CreativeModeTab$Type -> cta$h:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
    net.minecraft.world.item.CreativeModeTab$Type CATEGORY -> a
    net.minecraft.world.item.CreativeModeTab$Type INVENTORY -> b
    net.minecraft.world.item.CreativeModeTab$Type HOTBAR -> c
    net.minecraft.world.item.CreativeModeTab$Type SEARCH -> d
    net.minecraft.world.item.CreativeModeTab$Type[] $VALUES -> e
    133:133:net.minecraft.world.item.CreativeModeTab$Type[] values() -> values
    133:133:net.minecraft.world.item.CreativeModeTab$Type valueOf(java.lang.String) -> valueOf
    133:133:void <init>(java.lang.String,int) -> <init>
    133:133:net.minecraft.world.item.CreativeModeTab$Type[] $values() -> a
    133:137:void <clinit>() -> <clinit>
	 */
	class Type(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_Type)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Type::class.classDesc

			val CATEGORY: Type = Type(clazz.enumConstants[0])
			val INVENTORY: Type = Type(clazz.enumConstants[1])
			val HOTBAR: Type = Type(clazz.enumConstants[2])
			val SEARCH: Type = Type(clazz.enumConstants[3])
		}
	}
}