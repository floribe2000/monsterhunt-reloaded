package de.geistlande.monsterhunt.config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.bukkit.Material
import java.io.File
import java.util.*

const val configFileName = "config.yml"

lateinit var config: PluginSettings
    private set

fun loadSettings(dataFolderPath: String) {
    val path = "$dataFolderPath/$configFileName"
    val file = File(path)
    if (!file.exists()) {
        config = PluginSettings()
        saveSettings(dataFolderPath, config)
        return
    }

    config = Yaml.default.decodeFromString(file.readText())
}

fun saveSettings(dataFolderPath: String, settings: PluginSettings) {
    val path = "$dataFolderPath/$configFileName"
    val file = File(path)
    file.absoluteFile.parentFile.mkdirs()
    file.writeText(Yaml.default.encodeToString(settings))
}

@Serializable
data class PluginSettings(
    val worldSettings: Map<String, WorldSettings> = mapOf("default" to WorldSettings()),
    val announceLead: Boolean = true,
    val selectionTool: Material = Material.WOODEN_SWORD,
    val defaultRewards: RewardSettings? = null,
    val dbSettings: DatabaseSettings = DatabaseSettings(),
    val locale: String = Locale.ENGLISH.language,
    val debug: Boolean = false,
)

@Serializable
data class DatabaseSettings(
    val useMySql: Boolean = true,
    val sqlHostName: String = "db.example.local",
    val sqlPort: Int = 3306,
    val databaseName: String = "minecraft",
    val fileName: String = "plugins/MonsterHunt/MonsterHunt.sqlite",
    val dbUser: String = "",
    val dbPassword: String = "",
)
