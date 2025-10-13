package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.main

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_main_GameConfig
import java.lang.constant.ClassDesc

/*
net.minecraft.client.main.GameConfig -> fua:
# {"fileName":"GameConfig.java","id":"sourceFile"}
    net.minecraft.client.main.GameConfig$UserData user -> a
    com.mojang.blaze3d.platform.DisplayData display -> b
    net.minecraft.client.main.GameConfig$FolderData location -> c
    net.minecraft.client.main.GameConfig$GameData game -> d
    net.minecraft.client.main.GameConfig$QuickPlayData quickPlay -> e
    21:27:void <init>(net.minecraft.client.main.GameConfig$UserData,com.mojang.blaze3d.platform.DisplayData,net.minecraft.client.main.GameConfig$FolderData,net.minecraft.client.main.GameConfig$GameData,net.minecraft.client.main.GameConfig$QuickPlayData) -> <init>
net.minecraft.client.main.GameConfig$FolderData -> fua$a:
# {"fileName":"GameConfig.java","id":"sourceFile"}
    java.io.File gameDirectory -> a
    java.io.File resourcePackDirectory -> b
    java.io.File assetDirectory -> c
    java.lang.String assetIndex -> d
    66:71:void <init>(java.io.File,java.io.File,java.io.File,java.lang.String) -> <init>
    74:74:java.nio.file.Path getExternalAssetSource() -> a
net.minecraft.client.main.GameConfig$GameData -> fua$b:
# {"fileName":"GameConfig.java","id":"sourceFile"}
    boolean demo -> a
    java.lang.String launchVersion -> b
    java.lang.String versionType -> c
    boolean disableMultiplayer -> d
    boolean disableChat -> e
    36:42:void <init>(boolean,java.lang.String,java.lang.String,boolean,boolean) -> <init>
net.minecraft.client.main.GameConfig$QuickPlayData -> fua$c:
# {"fileName":"GameConfig.java","id":"sourceFile"}
    java.lang.String path -> a
    java.lang.String singleplayer -> b
    java.lang.String multiplayer -> c
    java.lang.String realms -> d
    78:78:void <init>(java.lang.String,java.lang.String,java.lang.String,java.lang.String) -> <init>
    80:80:boolean isEnabled() -> a
    78:78:java.lang.String toString() -> toString
    78:78:int hashCode() -> hashCode
    78:78:boolean equals(java.lang.Object) -> equals
    78:78:java.lang.String path() -> b
    78:78:java.lang.String singleplayer() -> c
    78:78:java.lang.String multiplayer() -> d
    78:78:java.lang.String realms() -> e
net.minecraft.client.main.GameConfig$UserData -> fua$d:
# {"fileName":"GameConfig.java","id":"sourceFile"}
    net.minecraft.client.User user -> a
    com.mojang.authlib.properties.PropertyMap userProperties -> b
    com.mojang.authlib.properties.PropertyMap profileProperties -> c
    java.net.Proxy proxy -> d
    51:56:void <init>(net.minecraft.client.User,com.mojang.authlib.properties.PropertyMap,com.mojang.authlib.properties.PropertyMap,java.net.Proxy) -> <init>
 */
class GameConfig(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_main_GameConfig
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}