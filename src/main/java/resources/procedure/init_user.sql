CREATE PROCEDURE init_user()
  BEGIN
    DROP TABLE IF EXISTS `user`;
    CREATE TABLE `user` (
      id int(11) NOT NULL AUTO_INCREMENT,
      name varchar(30) DEFAULT NULL,
      age int(11),
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
  END

