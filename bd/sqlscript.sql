CREATE TABLE t_user(
	id INT AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(100) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	birth_date DATE,
	user_type VARCHAR(100),
	creation_date DATETIME,
	update_date datetime,
	version INT
);

CREATE TABLE t_plan(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_user INT,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(255),
	muscle_group VARCHAR(64) NOT NULL,
	creation_date DATETIME,
	update_date DATETIME,
	version INT,
	FOREIGN KEY (id_user) REFERENCES t_user(id)
);

CREATE TABLE t_exercise(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	sets INT,
	reps INT,
	version INT,
	update_date DATETIME,
	creation_date DATETIME
);

CREATE TABLE t_plan_exercise(
	id_plan int,
	id_exercise int,
	PRIMARY KEY (id_plan, id_exercise),
	FOREIGN KEY (id_plan) REFERENCES t_plan(id),
	FOREIGN KEY (id_exercise) REFERENCES t_exercise(id)
);

SELECT * FROM t_exercise, t_plan, t_plan_exercise, t_user 

