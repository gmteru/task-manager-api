CREATE TABLE IF NOT EXISTS `projects` (
    `id` bigint auto_increment,
    `name` varchar(50) NOT NULL DEFAULT '',
    `description` varchar(50) DEFAULT NULL,
    `start_date` date DEFAULT NULL,
    `end_date` date DEFAULT NULL,
    `status` varchar(15) NOT NULL DEFAULT 'Planning', 

    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tasks` (
    `id` bigint auto_increment,
    `id_project` bigint,
    `due_date` date DEFAULT NULL,
    `status` varchar(15) NOT NULL DEFAULT 'To do',

    PRIMARY KEY (`id`),
    FOREIGN KEY (`id_project`) REFERENCES `projects` (`id`) ON DELETE CASCADE
);
