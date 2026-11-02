## Example Datapack - 1.21.1

Simple datapack that shows how to override the default 'Improvable' modifier recipe. Full
description of modifier recipes and salvage recipes can be found
[here](https://slimeknights.github.io/docs/json/recipes/modifiers/).

In this example we changed the default ingredients needed to apply the 'Improvable' modifier from
**_4x Bottle o' Enchanting_** and **_1x Nether Star_**:

```json
"inputs": [
    {
      "item": "minecraft:experience_bottle"
    },
    {
      "item": "minecraft:nether_star"
    },
    {
      "item": "minecraft:experience_bottle"
    },
    {
      "item": "minecraft:experience_bottle"
    },
    {
      "item": "minecraft:experience_bottle"
    }
]
```

to just **_1x Cobblestone_**:

```json
"inputs": [
    {
      "item": "minecraft:cobblestone"
    }
]
```

We also made the modifier **'slotless'**, meaning no modifier slots are required. We did that just
by removing the _slots_ key from the recipe:

```json
"slots": {
    "abilities": 1
}
```

**Don't forget to also adjust the salvaging recipe accordingly!**

The 1.21.1 recipe directory is `data/<namespace>/recipe/` (singular); the older 1.20.1 example in
the sibling folder uses `recipes/` and does not load on 1.21.1.
