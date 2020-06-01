# SmartInvs
[![License](https://img.shields.io/github/license/sytm/smart-invs.svg?style=flat-square)](https://github.com/Sytm/smart-invs/blob/master/LICENSE)

Advanced Inventory API for your Spigot plugins.


*Tested Minecraft versions: 1.7, 1.8, 1.9, 1.10, 1.11, 1.12, 1.13, 1.14, 1.15*

Primary support target is 1.13+

## Features
* Inventories of any type (workbench, chest, furnace, ...)
* Customizable size when possible (chest, ...)
* Custom titles
* Allows to prevent the player from closing its inventory
* Custom listeners for the event related to the inventory
* Iterator for inventory slots
* Page system
* Util methods to fill an inventory's row/column/borders/...
* Actions when player clicks on an item
* Update methods to edit the content of the inventory every tick

## Docs
JavaDocs are available here on [GitHub Pages](https://sytm.github.io/smart-invs/apidocs/)

## Usage
To use the SmartInvs API, either:
- Put it in the `plugins` folder of your server, add it to your dependencies in your plugin.yml (e.g. `depend: [SmartInvs]`) and add it to the dependencies in your IDE.
- Put it inside your plugin jar, and then call `SmartInvsPlugin.setPlugin(yourMain)` to set everything up, and you are good to go

You can download the latest version on the [Releases page](https://github.com/Sytm/smart-invs/releases) on Github.

You can also use a build system:
### Gradle
```gradle
repositories {
    maven {
        url 'https://repo.sytm.de/repository/maven-hosted/'
    }
}

dependencies {
    implementation 'de.md5lukas:smart-invs:2.0.0-SNAPSHOT'
}
```

### Maven
```xml
<repository>
    <id>sytm-nexus</id>
    <url>https://repo.sytm.de/repository/maven-hosted/</url>
</repository>
```
```xml
<dependency>
    <groupId>de.md5lukas</groupId>
    <artifactId>smart-invs</artifactId>
    <version>2.0.0-SNAPSHOT</version>
</dependency>
```

## TODO
* Add more JavaDocs

## Issues
If you have a problem with the API, or you want to request a feature, make an issue [here](https://github.com/Sytm/smart-invs/issues).
