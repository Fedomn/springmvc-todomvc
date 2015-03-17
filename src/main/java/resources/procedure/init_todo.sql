CREATE PROCEDURE init_todo()
  BEGIN
    DROP TABLE IF EXISTS `todo`;
    CREATE TABLE `todo` (
      id int(11) NOT NULL AUTO_INCREMENT,
      title varchar(30) DEFAULT NULL,
      completed BOOLEAN,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

    INSERT INTO todo VALUE (1, 'first', FALSE);
    INSERT INTO todo VALUE (2, 'second', FALSE);
    INSERT INTO todo VALUE (3, 'third', FALSE);
  END

