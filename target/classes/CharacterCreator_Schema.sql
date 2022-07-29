DROP TABLE IF EXISTS `characterCreator` CASCADE;
create table `characterCreator` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
    `specialAbility` VARCHAR(255),
    `power` INTEGER NOT NULL,
    `health` INTEGER NOT NULL,
    `attack` INTEGER NOT NULL,
    `defence` INTEGER NOT NULL,
    `agility` INTEGER NOT NULL,
    `intelligence` INTEGER NOT NULL
);
