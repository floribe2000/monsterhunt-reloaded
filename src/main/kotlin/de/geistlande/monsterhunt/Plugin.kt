package de.geistlande.monsterhunt

import org.bukkit.permissions.PermissionDefault
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.annotation.dependency.SoftDependency
import org.bukkit.plugin.java.annotation.permission.Permission
import org.bukkit.plugin.java.annotation.plugin.Description
import org.bukkit.plugin.java.annotation.plugin.LogPrefix
import org.bukkit.plugin.java.annotation.plugin.Plugin
import org.bukkit.plugin.java.annotation.plugin.author.Author

@Plugin(name = "MonsterHunt Reloaded", version = "1.0")
@Description("A plugin to reward players for hunting monsters")
@Author("doctor_albertio")
@Author("floribe2000")
@SoftDependency("Vault")
@LogPrefix("MonsterHunt")
@Permission(name = "monsterhunt.*", desc = "Wildcard monsterhunt permission", defaultValue = PermissionDefault.OP)
class Plugin : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
    }
}
