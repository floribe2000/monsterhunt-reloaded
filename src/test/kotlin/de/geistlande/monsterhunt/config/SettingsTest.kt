package de.geistlande.monsterhunt.config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import kotlin.io.path.absolutePathString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SettingsTest {

    @Test
    fun loadEmptySettings(@TempDir tempDir: Path) {
        loadSettings(tempDir.absolutePathString())
        assertTrue { config.worldSettings.size == 1 }
    }

    @Test
    fun loadSettings() {
        @Language("yaml") val settingsString = """
worldSettings:
  "test-world":
    enabled: true
    startTime: 13000
    endTime: 23600
    tellTime: true
    deathPenalty: 30
    enableSignup: true
    announceSignup: true
    announceLead: true
    minimumPlayers: 2
    startChance: 100
    skipDays: 0
    skipToIfFailsToStart: -1
    signupPeriodTime: 5
    allowSignupAfterStart: false
    huntZoneMode: false
    mobSettings:
      onlyCountMobsSpawnedOutside: false
      outsideHeightCheck: 0
      mobPoints: {}
    rewardSettings:
      enabled: true
      enableRewardEveryonePermission: false
      rewardEveryone: false
      numberOfWinners: 3
      rewardParametersEveryone: "3 1-1"
      minimumPointsEveryone: 1
      minimumPointsPlace:
      - 1
      - 1
      - 1
      rewardParametersPlace: ""
      availableRewards: []
announceLead: true
selectionTool: "WOODEN_SWORD"
defaultRewards: null
dbSettings:
  useMySql: true
  sqlHostName: "db.example.local"
  sqlPort: 3306
  databaseName: "minecraft"
  fileName: "plugins/MonsterHunt/MonsterHunt.sqlite"
  dbUser: ""
  dbPassword: ""
locale: "en"
debug: false
""".trimIndent()

        val settings = Yaml.default.decodeFromString<PluginSettings>(settingsString)
        assertTrue { settings.worldSettings.size == 1 }
        assertEquals("test-world", settings.worldSettings.keys.first())
    }
}
