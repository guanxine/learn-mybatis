CREATE TABLE  STUDENT(
   ID int(10) NOT NULL AUTO_INCREMENT,
   NAME varchar(100) NOT NULL,
   BRANCH varchar(255) NOT NULL,
   PERCENTAGE int(3) NOT NULL,
   PHONE int(10) NOT NULL,
   EMAIL varchar(255),
   PRIMARY KEY ( ID )
);

DELIMITER //
   DROP PROCEDURE IF EXISTS details.read_recordById //
   CREATE PROCEDURE details.read_recordById (IN emp_id INT)

   BEGIN
      SELECT * FROM STUDENT WHERE ID = emp_id;
   END//

DELIMITER ;