# Tinkers' Levelling Addon

![MIT](https://img.shields.io/badge/license-MIT-blue.svg?longCache=true&style=flat)

Unofficial NeoForge 1.21.1 port of [Tinkers' Levelling Addon](https://github.com/Pyre540/tinkers-levelling-addon),
originally by Pyre540.

Simple addon mod for [Tinkers' Construct](https://github.com/SlimeKnights/TinkersConstruct) for
modern Minecraft versions. Based on the
[Tinkers' Tool Leveling](https://github.com/SlimeKnights/TinkersToolLeveling) addon for Minecraft 1.12.2.

This addon adds a single new modifier for Tinkers' tools and armors - _Improvable_. Unlike the
original addon, tool levelling is not available from the start and must be applied to each piece of
gear separately. After applying, your tools are able to earn XP and level up. XP is earned by
performing the tool's intended actions like mining, harvesting, dealing damage, etc. On level up an
additional modifier slot and/or stat is rewarded.

**Disclaimer:** Since Tinkers' Construct is based around a limited amount of modifier slots and
stats, this addon completely disrupts its balance!

## Features

- Earn tool XP by performing actions with your tools (mining, harvesting, shearing, attacking, etc.)
- Earn armor XP by taking damage or using the Thorns modifier
- Gain 1 free modifier slot and/or stat per level up
- Customize the order of modifier slot and/or stat types gained after each level up (or set it to random)
- Set maximum level (or make it unlimited)
- Adjust level requirements and experience sources
- Customize level up sound and messages

## Getting started

To get started simply apply the _Improvable_ modifier to your tool/armor piece. As it's designed to
be an endgame modifier, the default recipe is pricey (1x Nether Star, 4x Bottle o' Enchanting) and
requires a Tinker's Anvil and 1 ability slot. The recipe can be changed with a datapack - see the
[1.21.1 example](examples/datapacks/override_improvable_recipe_1.21.1).

<img src="https://raw.githubusercontent.com/Pyre540/tinkers-levelling-addon/1.20/examples/image/default-modifier-recipe.png" alt="Default modifier recipe"/>

After that your tool is ready to earn some XP, so go and mine some stuff, cut some trees and kill
some mobs!

<img src="https://raw.githubusercontent.com/Pyre540/tinkers-levelling-addon/1.20/examples/image/example-tool.png" alt="Example tool"/>

Hold _Alt_ to display a summary of the perks gained so far.

<img src="https://raw.githubusercontent.com/Pyre540/tinkers-levelling-addon/1.20/examples/image/example-level-info.png" alt="Example level info"/>

## Requirements

- Minecraft 1.21.1 with NeoForge 21.1.264 or newer.
- Tinkers' Construct 3.12 or newer; Mantle 1.12 or newer comes with it.

## Building

Requires JDK 21. The project builds against Mantle and Tinkers' Construct, so clone all three
repositories into the same folder:

- [Mantle-NeoForge](https://github.com/Maf1sher/Mantle-NeoForge)
- [TinkersConstruct-NeoForge](https://github.com/Maf1sher/TinkersConstruct-NeoForge)
- this repository

Then build them in order, starting from that folder.

Linux / macOS:

```bash
cd Mantle-NeoForge && ./gradlew build
cd ../TinkersConstruct-NeoForge && ./gradlew build
cd ../tinkers-levelling-addon-NeoForge && ./gradlew build
```

Windows (Command Prompt or PowerShell):

```bat
cd Mantle-NeoForge && gradlew.bat build
cd ..\TinkersConstruct-NeoForge && gradlew.bat build
cd ..\tinkers-levelling-addon-NeoForge && gradlew.bat build
```

The jar is written to `build/libs/TinkersLevellingAddon-1.21.1-*.jar`.

## License

Code, textures, and binaries of this addon are licensed under the
[MIT License](https://tldrlegal.com/license/mit-license). Any alternate licenses are noted where
appropriate.

You are allowed to use the mod in your modpack.

## Credits

- Original addon: [Tinkers' Levelling Addon](https://github.com/Pyre540/tinkers-levelling-addon) by Pyre540.
- 'Chime' level up sound and most level up messages are from the original addon -
  [Tinkers' Tool Leveling (MIT license)](https://github.com/SlimeKnights/TinkersToolLeveling)
- 'Snare Drum' level up sound -
  [Army Rank Up 2 by PearceWilsonKing](https://pixabay.com/sound-effects/army-rank-up-2-84543/)
  [(Pixabay License)](https://pixabay.com/service/terms/#license)
- 'Yay' level up sound -
  [CHILDREN YAY! - SOUND EFFECT](https://www.soundboard.com/sb/sound/1041462)
