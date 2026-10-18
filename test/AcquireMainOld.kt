import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc

data class Mapping(
    val unobfuscated: String,
    val obfuscated: String,
    val members: MutableList<NamedEntry>,
    var parents: MutableList<Mapping?>,
    var isInterface: Boolean = false
) {
    sealed interface NamedEntry {
        val unobfuscated: String
        val obfuscated: String
    }

    data class Method(
        override val unobfuscated: String,
        override val obfuscated: String,
        val type: MethodTypeDesc
    ) : NamedEntry

    data class Field(
        override val unobfuscated: String,
        override val obfuscated: String,
        val type: ClassDesc
    ) : NamedEntry
}

fun main() {
//    versionInfo.libraries.forEach {
//        if (!it.rules.isNullOrEmpty()) {
//            println(it.rules)
//            return@forEach
//        }
//        client.send(
//            HttpRequest.newBuilder(it.downloads.artifact.url).build(),
//            HttpResponse.BodyHandlers.ofFile(
//                minecraftPath.resolve("libraries").resolve(it.downloads.artifact.path).also { path ->
//                    path.parent.createDirectories()
//                }
//            )
//        )
//    }
//    val mappingsUri = versionInfo.downloads.clientMappings.url
//    val mappings = client.send(
//        HttpRequest.newBuilder(mappingsUri).build(),
//        HttpResponse.BodyHandlers.ofString()
////        HttpResponse.BodyHandlers.ofFile(Path(mappingsUri.path.substringAfterLast('/')))
//    )
//    var lastMapping: Mapping? = null
//    val classes = mutableMapOf<String, Mapping>()
//    val classesObf = mutableMapOf<String, Mapping>()
//    mappings.body().lines().forEachIndexed { index, line ->
//        if (line.startsWith('#') || line.isBlank()) return@forEachIndexed
//        if (line.startsWith("    ")) {
//            val (sideA, obfuscated) = line.removePrefix("    ").split(" -> ")
//            fun handleType(string: String): ClassDesc {
//                val arrayStart = string.indexOf("[]")
//                val type = when (
//                    val clazz = if (arrayStart != -1) string.take(arrayStart)
//                    else string
//                ) {
//                    "boolean" -> ConstantDescs.CD_boolean
//                    "byte" -> ConstantDescs.CD_byte
//                    "short" -> ConstantDescs.CD_short
//                    "char" -> ConstantDescs.CD_char
//                    "int" -> ConstantDescs.CD_int
//                    "long" -> ConstantDescs.CD_long
//                    "float" -> ConstantDescs.CD_float
//                    "double" -> ConstantDescs.CD_double
//                    "void" -> ConstantDescs.CD_void
//                    else -> ClassDesc.of(clazz)
//                }
//                return if (arrayStart != -1 && string.length - arrayStart > 0)
//                    type.arrayType((string.length - arrayStart) / 2)
//                else type
//            }
//
//            if (sideA.contains('(')) {
//                val separator = sideA.indexOf(' ')
//                val returnType = handleType(sideA.take(separator).substringAfterLast(':'))
//                val descriptor = sideA.substring(separator + 1)
//                val bracket = descriptor.indexOf('(')
//                lastMapping!!.members.add(
//                    Mapping.Method(
//                        descriptor.take(bracket),
//                        obfuscated,
//                        descriptor.substring(bracket + 1..<descriptor.length - 1).let {
//                            if (it.isEmpty()) return@let MethodTypeDesc.of(returnType)
//                            MethodTypeDesc.of(
//                                returnType,
//                                it.split(',').map { parameter ->
//                                    handleType(parameter)
//                                }
//                            )
//                        }
//                    )
//                )
//            } else {
//                val separator = sideA.indexOf(' ')
//                val fieldType = sideA.take(separator)
//                val name = sideA.substring(separator + 1)
//                lastMapping!!.members.add(
//                    Mapping.Field(name, obfuscated, handleType(fieldType))
//                )
//            }
//            return@forEachIndexed
//        }
//        val (unobfuscated, obfuscatedWithColon) = line.split(" -> ", limit = 2)
//        val obfuscated = obfuscatedWithColon.take(obfuscatedWithColon.length - 1)
//
//        val mapping = Mapping(unobfuscated, obfuscated, mutableListOf(), mutableListOf())
//        classes[obfuscated] = mapping
//        classesObf[unobfuscated] = mapping
//        lastMapping = mapping
//    }
//    val jarUri = versionInfo.downloads.client.url
//    val jar = client.send(
//        HttpRequest.newBuilder(jarUri).build(),
////        HttpResponse.BodyHandlers.ofInputStream()
//        HttpResponse.BodyHandlers.ofFile(Path(jarUri.path.substringAfterLast('/')))
//    )
//
//    fun lookup(e: ClassDesc): Mapping? = classes[
//        e.let { symbol ->
//            symbol.packageName().let { packageName -> if (packageName.isNotEmpty()) "$packageName." else "" } + symbol.displayName()
//        }
//    ]
//
//    fun lookup2(e: ClassDesc): Mapping? = classesObf[
//        e.let { symbol ->
//            symbol.packageName().let { packageName -> if (packageName.isNotEmpty()) "$packageName." else "" } + symbol.displayName()
//        }
//    ]
//
//    fun lookup(e: ClassEntry): Mapping? = lookup(e.asSymbol())
//
//    println(
//        Files.walk(minecraftPath.resolve("libraries"))
//            .filter { it.name.endsWith(".jar") } .toList().toSet().joinToString(";") {
//            it.toString().replace('\\', '/').substringAfter("./")
//        }
//    )
//
//    val rme = mutableMapOf<ClassDesc, ClassHierarchyResolver.ClassHierarchyInfo>()
//    val cf = ClassFile.of(
//        ClassFile.StackMapsOption.GENERATE_STACK_MAPS,
//        ClassFile.ClassHierarchyResolverOption.of(
//            ClassHierarchyResolver { b ->
//                val mapping = lookup2(b) ?: lookup(b)
//                if (mapping != null) {
//                    if (mapping.isInterface) return@ClassHierarchyResolver ClassHierarchyResolver.ClassHierarchyInfo.ofInterface()
//                    else return@ClassHierarchyResolver ClassHierarchyResolver.ClassHierarchyInfo.ofClass(
//                        mapping.superMapping?.unobfuscated?.let { ClassDesc.of(it) }
//                    )
//                }
//                return@ClassHierarchyResolver rme[b] ?: ClassHierarchyResolver.defaultResolver().getClassInfo(b)
//            }.orElse(
//                ClassHierarchyResolver.ofResourceParsing(
//                    java.net.URLClassLoader(
//                        Files.walk(minecraftPath.resolve("libraries")).toList().map { it.toUri().toURL() }.toTypedArray(),
//                        null
//                    )
//                )
//            )
//        )
//    )
//    val zip1 = ZipInputStream(jar.body().inputStream())
//    while (true) {
//        val entry = zip1.nextEntry ?: break
//        if (entry.name.endsWith(".class")) {
//            val initial = cf.parse(zip1.readAllBytes())
//            val clazz = entry.name.replace('/', '.').take(entry.name.length - 6)
//            val mapping = classes[clazz]
//            if (mapping != null) {
//                if (initial.flags().has(AccessFlag.INTERFACE)) mapping.isInterface = true
//                else {
//                    initial.superclass().ifPresent {
//                        mapping.superMapping = lookup(it)
//                    }
//                }
//            } else {
//                if (initial.flags().has(AccessFlag.INTERFACE)) rme[ClassDesc.of(clazz)] = ClassHierarchyResolver.ClassHierarchyInfo.ofInterface()
//                else {
//                    initial.superclass().ifPresent {
//                        rme[ClassDesc.of(clazz)] = ClassHierarchyResolver.ClassHierarchyInfo.ofClass(
//                            it.asSymbol()
//                        )
//                    }
//                }
//            }
//        }
//    }
//    val zip = ZipInputStream(jar.body().inputStream())
//    val zip2 = ZipOutputStream(Files.newOutputStream(Path("./newjar.jar")))
//    while (true) {
//        val entry = zip.nextEntry ?: break
//        if (entry.name.endsWith("MANIFEST.MF")) continue
//        if (entry.name.endsWith(".class")) {
//            val mapping = classes[entry.name.replace('/', '.').take(entry.name.length - 6)]
//            zip2.putNextEntry(
//                if (mapping != null) ZipEntry(mapping.unobfuscated.replace('.', '/') + ".class")
//                else entry
//            )
//
//            fun read(c: ClassDesc): ClassDesc {
//                if (c.isArray) {
//                    val arrayRank = c.descriptorString().lastIndexOf('[').let {
//                        if (it == -1) 0 else it + 1
//                    }
//
//                    var a = c
//                    while (a.isArray) a = a.componentType()
//
//                    return read(a).arrayType(arrayRank)
//                }
//                val mapping = classes[c.packageName().let { (if (it.isNotEmpty()) "${it}." else "") + c.displayName() }] ?: return c
//                return ClassDesc.of(mapping.unobfuscated)
//            }
//
//            fun deobf(input: MethodTypeDesc): MethodTypeDesc = MethodTypeDesc.of(
//                read(input.returnType()),
//                input.parameterList().map {
//                    read(it)
//                }
//            )
//
//            val initial = cf.parse(zip.readAllBytes())
//            zip2.write(
//                cf.transformClass(
//                    initial,
//                    if (mapping != null) ClassDesc.of(mapping.unobfuscated) else initial.thisClass().asSymbol()
//                ) { classBuilder, classElement ->
//                    when (classElement) {
//                        is FieldModel if mapping != null -> {
//                            val field = mapping.members.first { (it is Mapping.Field) && classElement.fieldName().equalsString(it.obfuscated) } as Mapping.Field
//                            classBuilder.withField(
//                                field.unobfuscated,
//                                field.type,
//                                classElement.flags().flagsMask()
//                            )
//                        }
//
//                        is MethodModel -> {
//                            val method = mapping?.members?.first { (it is Mapping.Method) && classElement.methodName().equalsString(it.obfuscated) && deobf(classElement.methodTypeSymbol()) == it.type } as? Mapping.Method
//                            classBuilder.withMethod(
//                                method?.unobfuscated ?: classElement.methodName().stringValue(),
//                                method?.type ?: classElement.methodTypeSymbol(),
//                                classElement.flags().flagsMask()
//                            ) { methodBuilder ->
//                                classElement.forEach { methodElement ->
//                                    when (methodElement) {
//                                        is CodeModel -> methodBuilder.withCode { codeBuilder ->
//                                            val boundLabels = mutableMapOf<Label, Label>()
//                                            val futureLabels = mutableMapOf<Label, Label>()
//                                            fun getLabel(sourceLabel: Label): Label {
//                                                boundLabels[sourceLabel]?.let { return it }
//                                                return futureLabels.getOrPut(sourceLabel) {
//                                                    codeBuilder.newLabel()
//                                                }
//                                            }
//
//                                            methodElement.forEach { codeElement ->
//                                                when (codeElement) {
//                                                    is LocalVariable, is LineNumber, is LocalVariableType -> {}
//
//                                                    is Label -> {
//                                                        val presentLabel = futureLabels.remove(codeElement)
//                                                        if (presentLabel != null) {
//                                                            codeBuilder.labelBinding(presentLabel)
//                                                            boundLabels[codeElement] = presentLabel
//                                                        } else boundLabels[codeElement] = codeBuilder.newBoundLabel()
//                                                    }
//
//                                                    is BranchInstruction -> {
//                                                        codeBuilder.branch(
//                                                            codeElement.opcode(),
//                                                            getLabel(codeElement.target())
//                                                        )
//                                                    }
//
//                                                    is TableSwitchInstruction -> {
//                                                        codeBuilder.tableswitch(
//                                                            codeElement.lowValue(),
//                                                            codeElement.highValue(),
//                                                            getLabel(codeElement.defaultTarget()),
//                                                            codeElement.cases().map {
//                                                                SwitchCase.of(
//                                                                    it.caseValue(),
//                                                                    getLabel(it.target())
//                                                                )
//                                                            }
//                                                        )
//                                                    }
//
//                                                    is LookupSwitchInstruction -> {
//                                                        codeBuilder.lookupswitch(
//                                                            getLabel(codeElement.defaultTarget()),
//                                                            codeElement.cases().map {
//                                                                SwitchCase.of(
//                                                                    it.caseValue(),
//                                                                    getLabel(it.target())
//                                                                )
//                                                            }
//                                                        )
//                                                    }
//
//                                                    is ExceptionCatch -> {
//                                                        val type = codeElement.catchType().getOrNull()
//                                                        if (type != null) {
//                                                            val mapping = lookup(type)
//                                                            codeBuilder.exceptionCatch(
//                                                                getLabel(codeElement.tryStart()),
//                                                                getLabel(codeElement.tryEnd()),
//                                                                getLabel(codeElement.handler()),
//                                                                if (mapping != null) ClassDesc.of(mapping.unobfuscated)
//                                                                else type.asSymbol()
//                                                            )
//                                                        } else {
//                                                            codeBuilder.exceptionCatchAll(
//                                                                getLabel(codeElement.tryStart()),
//                                                                getLabel(codeElement.tryEnd()),
//                                                                getLabel(codeElement.handler())
//                                                            )
//                                                        }
//                                                    }
//
//                                                    is TypeCheckInstruction -> {
//                                                        val mapping = lookup(codeElement.type())
//                                                        if (mapping == null) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        when (codeElement.opcode()) {
//                                                            Opcode.CHECKCAST -> codeBuilder.checkcast(
//                                                                ClassDesc.of(mapping.unobfuscated)
//                                                            )
//                                                            Opcode.INSTANCEOF -> codeBuilder.instanceOf(
//                                                                ClassDesc.of(mapping.unobfuscated)
//                                                            )
//                                                            else -> TODO("*")
//                                                        }
//                                                    }
//
//                                                    is NewObjectInstruction -> {
//                                                        val mapping = lookup(codeElement.className())
//                                                        if (mapping == null) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        codeBuilder.new_(
//                                                            ClassDesc.of(mapping.unobfuscated)
//                                                        )
//                                                    }
//
//                                                    is NewReferenceArrayInstruction -> {
//                                                        val mapping = lookup(codeElement.componentType())
//                                                        if (mapping == null) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        codeBuilder.anewarray(
//                                                            ClassDesc.of(mapping.unobfuscated)
//                                                        )
//                                                    }
//
//                                                    is NewMultiArrayInstruction -> {
//                                                        codeBuilder.with(codeElement)
//                                                        return@forEach // TODO
//                                                    }
//
//                                                    is InvokeDynamicInstruction -> {
//                                                        codeBuilder.invokedynamic(
//                                                            DynamicCallSiteDesc.of(
//                                                                codeElement.bootstrapMethod(),
//                                                                codeElement.name().stringValue(),
//                                                                MethodTypeDesc.of(
//                                                                    codeElement.typeSymbol().returnType().let {
//                                                                        val mapping = lookup(it) ?: return@let it
//                                                                        ClassDesc.of(mapping.unobfuscated)
//                                                                    },
//                                                                    codeElement.typeSymbol().parameterList().map {
//                                                                        val mapping = lookup(it) ?: return@map it
//                                                                        ClassDesc.of(mapping.unobfuscated)
//                                                                    }
//                                                                ),
//                                                                *codeElement.bootstrapArgs().map {
//                                                                    when (it) {
//                                                                        is ClassDesc -> {
//                                                                            val mapping = lookup(it) ?: return@map it
//                                                                            ClassDesc.of(mapping.unobfuscated)
//                                                                        }
//                                                                        is DirectMethodHandleDesc -> {
//                                                                            val owner = it.owner().let {
//                                                                                val mapping = lookup(it) ?: return@let it
//                                                                                ClassDesc.of(mapping.unobfuscated)
//                                                                            }
//                                                                            val mapping = lookup(owner) ?: lookup2(owner)
//                                                                            if (mapping == null) return@map it
//                                                                            val remoteMethod = mapping.members.firstOrNull { a -> (a is Mapping.Method) && it.methodName() == a.obfuscated && deobf(it.invocationType()) == a.type } as? Mapping.Method
//                                                                            if (remoteMethod == null) {
//                                                                                println("SKIP Dyn ... $it")
//                                                                                return@map  it
//                                                                            }
//                                                                            MethodHandleDesc.of(
//                                                                                it.kind(),
//                                                                                owner,
//                                                                                remoteMethod.unobfuscated,
//                                                                                remoteMethod.type.descriptorString()
//                                                                            )
//                                                                        }
//                                                                        else -> it
//                                                                    }
//                                                                }.toTypedArray()
//                                                            )
//                                                        )
//                                                    }
//
//                                                    is InvokeInstruction -> {
//                                                        val mapping = lookup(codeElement.owner())
//                                                        if (mapping == null) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        var remoteMethod = mapping.members.firstOrNull { (it is Mapping.Method) && codeElement.name().equalsString(it.obfuscated) && deobf(codeElement.typeSymbol()) == it.type } as? Mapping.Method
////                                                            if (remoteMethod == null) {
////                                                                val superQueue2 = ArrayDeque<Mapping>()
////                                                                initial.superclass().ifPresent {
////                                                                    val mapping = lookup(it)
////                                                                    if (mapping != null) superQueue2.add(mapping)
////                                                                }
////                                                                val superQueue = ArrayDeque<Mapping>()
////                                                                initial.interfaces().forEach {
////                                                                    val mapping = lookup(it)
////                                                                    if (mapping != null) superQueue2.add(mapping)
////                                                                }
////                                                                while (superQueue2.isNotEmpty()) {
////
////                                                                }
////
////                                                                while (superQueue.isNotEmpty() && remoteMethod == null) {
////
////                                                                }
////                                                            }
//                                                        if (remoteMethod == null /* TODO(!!!!) */) {
//                                                            println("Skip...${codeElement.name()}, ${codeElement.type()} in ${mapping.unobfuscated}")
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        codeBuilder.invoke(
//                                                            codeElement.opcode(),
//                                                            ClassDesc.of(mapping.unobfuscated),
//                                                            remoteMethod.unobfuscated,
//                                                            remoteMethod.type,
//                                                            codeElement.isInterface
//                                                        )
//                                                    }
//
//                                                    is FieldInstruction -> {
//                                                        val mapping = lookup(codeElement.owner())
//                                                        if (mapping == null) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        val remoteField = mapping.members.firstOrNull { (it is Mapping.Field) && codeElement.name().equalsString(it.obfuscated) } as? Mapping.Field
//                                                        if (remoteField == null /* TODO(!!!!) */) {
//                                                            codeBuilder.with(codeElement)
//                                                            return@forEach
//                                                        }
//                                                        codeBuilder.fieldAccess(
//                                                            codeElement.opcode(),
//                                                            ClassDesc.of(mapping.unobfuscated),
//                                                            remoteField.unobfuscated,
//                                                            remoteField.type
//                                                        )
//                                                    }
//
//                                                    is LoadInstruction, is StoreInstruction,
//                                                    is ReturnInstruction,
//                                                    is StackInstruction,
//                                                    is ConstantInstruction, is ThrowInstruction,
//                                                    is OperatorInstruction, is IncrementInstruction,
//                                                    is ConvertInstruction, is NewPrimitiveArrayInstruction,
//                                                    is ArrayLoadInstruction, is ArrayStoreInstruction,
//                                                    is MonitorInstruction -> codeBuilder.with(codeElement)
//                                                    else -> TODO("$codeElement")
//                                                }
//                                            }
//                                        }
//
//                                        else -> methodBuilder.with(methodElement)
//                                    }
//                                }
//                            }
//                        }
//
//                        is Superclass -> classBuilder.withSuperclass(
//                            classElement.superclassEntry().let {
//                                val mapping = lookup(it)
//                                if (mapping == null) it.asSymbol() else ClassDesc.of(mapping.unobfuscated)
//                            }
//                        )
//
//                        is Interfaces -> classBuilder.withInterfaceSymbols(
//                            classElement.interfaces().map {
//                                val mapping = lookup(it)
//                                if (mapping == null) it.asSymbol() else ClassDesc.of(mapping.unobfuscated)
//                            }
//                        )
//
//                        else -> classBuilder.with(classElement)
//                    }
//                }
//            )
//            zip2.closeEntry()
//            continue
//        }
//        zip2.putNextEntry(entry)
//        zip2.write(zip.readAllBytes())
//        zip2.closeEntry()
//    }
//    zip2.finish()
//    zip2.flush()
}