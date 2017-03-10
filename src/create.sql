CREATE TABLE IF NOT EXISTS hibernate_dev (
  id SERIAL NOT NULL PRIMARY KEY,
  developer_name VARCHAR(50) NOT NULL,
  salary REAL,
  project_id INT,
  FOREIGN KEY (project_id) REFERENCES hibernate_project(id)
);


CREATE TABLE IF NOT EXISTS hibernate_project (
  id SERIAL NOT NULL PRIMARY KEY ,
  project_name VARCHAR(50) NOT NULL,
  cost REAL
);



INSERT INTO hibernate_dev (developer_name, salary, project_id) VALUES ('vadim', 5000, 1);
INSERT INTO hibernate_dev (developer_name, salary, project_id) VALUES ('ivan', 9000, 1);
INSERT INTO hibernate_dev (developer_name, salary, project_id) VALUES ('igor', 8000, 2);

INSERT INTO hibernate_project (project_name) VALUES ('project 1');
INSERT INTO hibernate_project (project_name) VALUES ('project 2');
INSERT INTO hibernate_project (project_name) VALUES ('project 3');