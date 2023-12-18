### WorldOfECN-Game
This Java-based game is developed from scratch and features a 5x5 game world with various elements such as objects and creatures.

## Creatures:

# Characters (Personnage):
- Archers
- Warriors (Guerrier)
- Mages (Magician)
- Peasants (Paysan)
Characters move randomly in the game world. Each character, except the Peasant, possesses unique powers and can engage in combat, either from a distance (e.g., Archer with felches) or in close combat (e.g., Warrior).

# Monsters:
- Wolves (Loup)
- Rabbits (Lapin)
- Monsters, like characters, move randomly in the world. Wolves can engage in combat with characters.

# Objects:
- Food (Nourriture):
Provides bonus or malus points that temporarily modify a randomly chosen character's characteristics for a specified number of game turns.

- Toxic Cloud (Nuage Toxique):
. Characterized by its center and radius.
. Reduces the life points of creatures beneath it.
. Moves randomly in the world each turn.

# Potions:
- Healing (Soin): Increases a character's life points.
- Mana: Increases magic points.

## Gameplay:
- A human player can choose to be one of the characters, select a name, and decide whether to fight or flee in each game round.
- For movement, the player can use the "WDSA" keys on the keyboard.
- Creatures and the player cannot occupy the same world space.
- Collection and consumption of potions and food, as well as combat between entities, are part of the gameplay.

# Game Initialization:
At the beginning, the user can choose to play a random game or load an existing game from a text file (5x5).
In a random game, the user selects a player type and a name, and characters, monsters, potions, and toxic clouds are generated randomly.
At each turn, the user can choose to save the game, optionally providing a name to avoid overwriting existing games.

# End of Game:
A display shows the characteristics of all game elements and the player.
A graphical interface visualizes the distribution of game elements and the player in the world.
