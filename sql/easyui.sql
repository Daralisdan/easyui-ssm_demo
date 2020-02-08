/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.55 : Database - easyui
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easyui` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easyui`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pro_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreignId` (`pro_id`),
  CONSTRAINT `foreignId` FOREIGN KEY (`pro_id`) REFERENCES `privince` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`name`,`pro_id`) values (1,'长春',1),(2,'吉林',1),(3,'成都',2),(4,'攀枝花',2),(5,'南充',2),(6,'长沙',3),(7,'岳阳',3),(8,'湘潭',3),(9,'沈阳',4),(10,'大连',4);

/*Table structure for table `org` */

DROP TABLE IF EXISTS `org`;

CREATE TABLE `org` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `iconCls` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `count` int(10) DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `org` */

insert  into `org`(`id`,`name`,`iconCls`,`principal`,`count`,`descript`,`state`,`parent_id`) values (1,'总公司',NULL,'张三',100,'我是总公司',NULL,0),(2,'北京分公司',NULL,'小北',100,'我是北京分公司',NULL,1),(3,'天津分公司',NULL,'小天',200,'我是天津分公司',NULL,1),(6,'成都分公司',NULL,'小成',150,'我是成都分公司',NULL,1),(7,'北京产品部',NULL,'北1',52,NULL,NULL,2),(8,'北京研发部',NULL,'北2',82,NULL,NULL,2),(9,'天津财政部',NULL,'天1',90,NULL,NULL,3),(10,'成都行政部',NULL,'成1',150,NULL,NULL,6),(11,'成都人力资源部',NULL,'成2',300,NULL,NULL,6),(12,'深圳分公司',NULL,'小小',300,'深圳分公司',NULL,1),(13,'咨询部',NULL,'小深',20,'咨询部',NULL,12);

/*Table structure for table `privince` */

DROP TABLE IF EXISTS `privince`;

CREATE TABLE `privince` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `privince` */

insert  into `privince`(`id`,`name`) values (1,'吉林省'),(2,'四川省'),(3,'湖南省'),(4,'辽宁省');

/*Table structure for table `treeresoure` */

DROP TABLE IF EXISTS `treeresoure`;

CREATE TABLE `treeresoure` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `chechked` int(50) DEFAULT '0',
  `icon` varchar(255) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

/*Data for the table `treeresoure` */

insert  into `treeresoure`(`id`,`name`,`url`,`chechked`,`icon`,`parent_id`) values (1,'权限菜单',NULL,0,NULL,0),(2,'用户管理',NULL,0,NULL,1),(3,'岗位管理',NULL,0,NULL,1),(5,'用户功能1',NULL,0,NULL,2),(7,'岗位管理1',NULL,0,NULL,3),(66,'资源管理','12323',0,NULL,1),(67,'资源管理1','12222222222222',0,NULL,66);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `brithday` varchar(255) DEFAULT NULL,
  `city` int(50) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`age`,`brithday`,`city`,`salary`,`starttime`,`endtime`,`descript`) values (27,'admin','1234','2',12,'2020-02-03',2,'1000.00','2020-02-02 14:04:10','2020-02-04 14:04:15','不ihiuu免费短信软件'),(28,'小12','1212','2',34,'2019-02-04',2,'3422.00','2020-02-03 19:42:52','2020-02-04 19:42:56','wefsd'),(29,'小2','1212','1',23,'2020-02-04',1,'3422.00','2020-02-04 19:42:04','2020-02-04 19:42:05','小2222'),(30,'sadd','1234','1',22,'2016-02-01',3,'20000','2018-02-01 19:41:12','2019-02-05 19:41:17','一厢情愿，愿赌服输'),(50,'小怪兽','1234','2',20,'2020-02-05',4,'20000.00','2020-02-03 14:03:10','2020-02-04 14:03:14','地形图发隐擿伏'),(51,'小酒','2132','2',21,NULL,3,'2312.00',NULL,NULL,NULL),(54,'装修风格','1212','2',30,'2020-02-02',4,'1000.00','2020-02-02 14:02:31','2020-02-05 14:02:35','虚惊一场乘用车'),(57,'ascds','1234','1',23,'2020-02-02',4,'1212','2020-02-02 22:35:21','2020-02-04 22:35:24','ssjjjjjj');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
