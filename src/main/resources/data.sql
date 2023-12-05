INSERT INTO `projects` (`name`, `description`, `start_date`, `end_date`, `status`) VALUES
('Project One', 'Description of Project One', '2023-01-01', '2023-02-01', 'In Progress'),
('Project Two', 'Description of Project Two', '2023-02-15', '2023-03-15', 'Planning'),
('Project Three', 'Description of Project Three', '2023-03-20', '2023-04-20', 'Completed');

INSERT INTO `tasks` (`id_project`, `due_date`, `status`) VALUES
(1, '2023-01-15', 'In Progress'),
(1, '2023-01-30', 'To do'),
(2, '2023-02-20', 'To do'),
(2, '2023-03-01', 'Completed'),
(3, '2023-03-25', 'In Progress'),
(3, '2023-04-10', 'To do');