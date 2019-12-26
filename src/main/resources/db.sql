CREATE TABLE repo
(
repo_id INT AUTO_INCREMENT PRIMARY KEY,
repo_name VARCHAR(100),
repo_type INT NOT NULL,
UNIQUE(repo_name)
);

CREATE TABLE item
(
item_id INT AUTO_INCREMENT PRIMARY KEY,
item_name VARCHAR(100),
unit VARCHAR(5),
price INT DEFAULT 0,
pic_url VARCHAR(100),
UNIQUE(item_name)
);

CREATE TABLE employee
(
emp_id INT AUTO_INCREMENT PRIMARY KEY,
emp_name VARCHAR(100),
avater_url VARCHAR(100),
role INT NOT NULL,
pwd VARCHAR (100) NOT NULL,
UNIQUE (emp_name)
);

CREATE TABLE contract
(
contract_id INT AUTO_INCREMENT PRIMARY KEY,
provider_id INT,
item_id INT,
contract_num INT DEFAULT 0,
price INT DEFAULT 0,
contract_date DATE,
processer INT,
act_num INT DEFAULT 0,
FOREIGN KEY (item_id) REFERENCES item(item_id),
FOREIGN KEY (processer) REFERENCES employee(emp_id)
);

CREATE TABLE item_log
(
log_id INT AUTO_INCREMENT PRIMARY KEY,
in_date DATE,
repo_id INT,
item_id INT,
num INT,
contract_id INT,
processer INT,
FOREIGN KEY(repo_id) REFERENCES repo(repo_id),
FOREIGN KEY(item_id) REFERENCES item(item_id),
FOREIGN KEY(contract_id) REFERENCES contract(contract_id),
FOREIGN KEY(processer) REFERENCES employee(emp_id)
);

CREATE TABLE item_rec
(
item_rec_id INT AUTO_INCREMENT PRIMARY KEY,
item_id INT,
num INT,
repo_id INT,
FOREIGN KEY (item_id) REFERENCES item(item_id),
FOREIGN KEY (repo_id) REFERENCES repo(repo_id),
UNIQUE (item_id,repo_id)
);

CREATE VIEW contract_view AS
SELECT contract_id,provider_id,item_id,contract_num,price,contract_date,processer,act_num
FROM (item i NATURAL right JOIN contract c),employee
WHERE processer=emp_id;

CREATE VIEW todo_contract AS
SELECT * FROM contract_view
WHERE act_num<contract_num;

CREATE VIEW finished_contract AS
SELECT * FROM contract_view
WHERE act_num>=contract_num;

CREATE VIEW item_view AS
SELECT item_id,item_name,unit,price,pic_url,num,repo_id FROM (SELECT * FROM item i NATURAL LEFT JOIN item_rec rec) AS t;

DELIMITER $$

CREATE PROCEDURE Add_item(
  IN pItem_id INT,
  IN pRepo_id INT,
  IN pCon_id INT,
  IN pNum INT,
  IN pProcesser INT
)
BEGIN
  INSERT INTO item_log VALUES (null,SYSDATE(),pRepo_id,pItem_id,pNum,pCon_id,pProcesser);
  IF (SELECT COUNT(*) FROM item_rec WHERE item_id=pItem_id AND repo_id=pRepo_id )>0 THEN
    UPDATE item_rec SET num=num+pNum WHERE item_id=pItem_id AND repo_id=pRepo_id;
  ELSE
    INSERT INTO item_rec VALUES (null,pItem_id,pNum,pRepo_id);
  END IF;
  UPDATE contract SET act_num=act_num+pNum WHERE contract_id=pCon_id;
END
$$
DELIMITER ;