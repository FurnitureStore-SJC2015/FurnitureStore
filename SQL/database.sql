/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     29.07.2015 12:11:39                          */
/*==============================================================*/
drop schema if exists Store;

create database  Store;

use Store;

drop table if exists Bonus;

drop table if exists Feedback;

drop table if exists Module;

drop table if exists Orders;

drop table if exists Order_Unit;

drop table if exists Payment;

drop table if exists Payment_Form;

drop table if exists Payment_Scheme;

drop table if exists Product_Catalog_Unit;

drop table if exists Product_Template;

drop table if exists Provider;

drop table if exists Request;

drop table if exists Request_Unit;

drop table if exists Role;

drop table if exists Sale;

drop table if exists Shipment;

drop table if exists Shipment_Unit;

drop table if exists `Status`;

drop table if exists Storage_Module_Unit;

drop table if exists User;

drop table if exists WayBill;

/*==============================================================*/
/* Table: Bonus                                                 */
/*==============================================================*/
create table Bonus
(
   bonus_id             int not null AUTO_INCREMENT,
   sum_bound            double,
   percentage           double,
   primary key (bonus_id)
);

/*==============================================================*/
/* Table: Feedback                                              */
/*==============================================================*/
create table Feedback
(
   feedback_id          int not null AUTO_INCREMENT,
   product_catalog_unit_id int not null,
   user_id              int not null,
   text                 varchar(512),
   feedback_date        datetime,
   `range`              int,
   primary key (feedback_id)
);

/*==============================================================*/
/* Table: Module                                                */
/*==============================================================*/
create table Module
(
   module_id            int not null AUTO_INCREMENT,
   storage_module_unit_id int,
   provider_id          int not null,
   request_unit_id      int,
   module_type          varchar(50),
   primary key (module_id)
);

/*==============================================================*/
/* Table: Orders                                               */
/*==============================================================*/
create table Orders
(
   order_id             int not null AUTO_INCREMENT,
   user_id              int not null,
   payment_scheme_id    int not null,
   order_date           datetime,
   execution_date       datetime,
   primary key (order_id)
);

/*==============================================================*/
/* Table: OrderUnit                                             */
/*==============================================================*/
create table Order_Unit
(
   order_unit_id        int not null AUTO_INCREMENT,
   status_id            int not null,
   order_id             int not null,
   product_catalog_unit_id int not null,
   order_unit_cost      double,
   primary key (order_unit_id)
);

/*==============================================================*/
/* Table: Payment                                               */
/*==============================================================*/
create table Payment
(
   payment_id           int not null AUTO_INCREMENT,
   order_id             int not null,
   payment_date         datetime,
   payment_sum          double,
   primary key (payment_id)
);

/*==============================================================*/
/* Table: PaymentForm                                           */
/*==============================================================*/
create table Payment_Form
(
   payment_type_id      int not null AUTO_INCREMENT,
   payment_type         varchar(50),
   primary key (payment_type_id)
);

/*==============================================================*/
/* Table: PaymentScheme                                         */
/*==============================================================*/
create table Payment_Scheme
(
   payment_scheme_id    int not null AUTO_INCREMENT,
   payment_type_id      int not null,
   term                 datetime,
   penalty              double,
   cycle                date,
   interest_rate        double,
   primary key (payment_scheme_id)
);

/*==============================================================*/
/* Table: ProductCatalogUnit                                    */
/*==============================================================*/
create table Product_Catalog_Unit
(
   product_catalog_unit_id int not null AUTO_INCREMENT,
   sale_id              int,
   product_name         varchar(50),
   product_cost         double,
   margin_coefficient   double,
   primary key (product_catalog_unit_id)
);

/*==============================================================*/
/* Table: ProductTemplate                                       */
/*==============================================================*/
create table Product_Template
(
   product_template_id  int not null AUTO_INCREMENT,
   product_catalog_unit_id int,
   module_id            int not null,
   modules_number       int,
   primary key (product_template_id)
);

/*==============================================================*/
/* Table: Provider                                              */
/*==============================================================*/
create table Provider
(
   provider_id          int not null AUTO_INCREMENT,
   provider_name        varchar(50),
   phone                varchar(50),
   provider_email       varchar(50),
   zip_code             varchar(50),
   provider_login       varchar(50),
   primary key (provider_id)
);

/*==============================================================*/
/* Table: Request                                               */
/*==============================================================*/
create table Request
(
   request_id           int not null AUTO_INCREMENT,
   provider_id          int not null,
   request_date         datetime,
   primary key (request_id)
);

/*==============================================================*/
/* Table: RequestUnit                                           */
/*==============================================================*/
create table Request_Unit
(
   request_unit_id      int not null AUTO_INCREMENT,
   request_id           int not null,
   module_id            int not null,
   request_module_count int,
   primary key (request_unit_id)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   role_id              int not null AUTO_INCREMENT,
   role_type            varchar(50),
   primary key (role_id)
);

/*==============================================================*/
/* Table: Sale                                                  */
/*==============================================================*/
create table Sale
(
   sale_id              int not null AUTO_INCREMENT,
   start_time           datetime,
   end_time             datetime,
   percentage_sale      double,
   primary key (sale_id)
);

/*==============================================================*/
/* Table: Shipment                                              */
/*==============================================================*/
create table Shipment
(
   shipment_id          int not null AUTO_INCREMENT,
   provider_id          int not null,
   way_bill_id          int,
   cargo_margin_coefficient double,
   primary key (shipment_id)
);

/*==============================================================*/
/* Table: ShipmentUnit                                          */
/*==============================================================*/
create table Shipment_Unit
(
   shipment_unit_id     int not null AUTO_INCREMENT,
   shipment_id          int not null,
   module_id            int not null,
   count                int,
   cost                 double,
   primary key (shipment_unit_id)
);

/*==============================================================*/
/* Table: Status                                                */
/*==============================================================*/
create table Status
(
   status_id            int not null AUTO_INCREMENT,
   status_name          varchar(50),
   primary key (status_id)
);

/*==============================================================*/
/* Table: StorageModuleUnit                                     */
/*==============================================================*/
create table Storage_Module_Unit
(
   storage_module_unit_id int not null  AUTO_INCREMENT,
   module_id            int not null,
   module_count         int,
   unit_cost            double,
   date_of_delivery     datetime,
   primary key (storage_module_unit_id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   user_id              int not null AUTO_INCREMENT,
   role_id              int not null,
   bonus_id             int,
   name                 varchar(50),
   surname              varchar(50),
   login                varchar(50),
   password             varchar(50),
   email                varchar(50),
   primary key (user_id)
);

/*==============================================================*/
/* Table: WayBill                                               */
/*==============================================================*/
create table WayBill
(
   way_bill_id          int not null AUTO_INCREMENT,
   shipment_id          int not null,
   departure_date       datetime,
   delivery_date        datetime,
   delivery_cost        double,
   primary key (way_bill_id)
);

INSERT INTO `store`.`provider` (`provider_id`, `provider_name`, `phone`, `provider_email`, `zip_code`, `provider_login`) VALUES ('1', 'AS Furniture', '+375339851565', 'asfurniture@gmail.com', '230005', 'asfurniture');
INSERT INTO `store`.`provider` (`provider_id`, `provider_name`, `phone`, `provider_email`, `zip_code`, `provider_login`) VALUES ('2', 'Davanty Style', '+375296751952', 'dstyle@mail.ru', '230015', 'D_Style');
INSERT INTO `store`.`provider` (`provider_id`, `provider_name`, `phone`, `provider_email`, `zip_code`, `provider_login`) VALUES ('3', 'Irwin', '+288556851970', 'irwin_co@gmail.com', '450085', 'Irwin');
INSERT INTO `store`.`provider` (`provider_id`, `provider_name`, `phone`, `provider_email`, `zip_code`, `provider_login`) VALUES ('4', 'OTK Group', '+755338512650', 'otkgruop@gmail.com', '341575', 'OTKGroup');
INSERT INTO `store`.`request` (`request_id`, `provider_id`, `request_date`) VALUES ('1', '1', '2012-06-12 12:03:14');
INSERT INTO `store`.`request` (`request_id`, `provider_id`, `request_date`) VALUES ('2', '2', '2013-12-12 13:11:05');
INSERT INTO `store`.`waybill` (`way_bill_id`, `shipment_id`, `departure_date`, `delivery_date`, `delivery_cost`) VALUES ('1', '1', '2012-05-12', '2012-05-15', '12.5');
INSERT INTO `store`.`waybill` (`way_bill_id`, `shipment_id`, `departure_date`, `delivery_date`, `delivery_cost`) VALUES ('2', '2', '2015-06-11', '2015-06-17', '14.5');
INSERT INTO `store`.`request_unit` (`request_unit_id`, `request_id`, `module_id`, `request_module_count`) VALUES ('1', '1', '1', '6');
INSERT INTO `store`.`request_unit` (`request_unit_id`, `request_id`, `module_id`, `request_module_count`) VALUES ('2', '2', '1', '7');
INSERT INTO `store`.`shipment` (`shipment_id`, `provider_id`, `way_bill_id`, `cargo_margin_coefficient`) VALUES ('1', '1', '1', '15.5');
INSERT INTO `store`.`shipment` (`shipment_id`, `provider_id`, `way_bill_id`, `cargo_margin_coefficient`) VALUES ('2', '2', '2', '17.5');
INSERT INTO `store`.`shipment_unit` (`shipment_unit_id`, `shipment_id`, `module_id`, `count`, `cost`) VALUES ('1', '1', '1', '6', '7');
INSERT INTO `store`.`shipment_unit` (`shipment_unit_id`, `shipment_id`, `module_id`, `count`, `cost`) VALUES ('2', '2', '1', '8', '9');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('1', '1', '25', '4.5', '2015-09-12');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('2', '2', '45', '1.2', '2015-08-14');

INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('1', 'admin');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('2', 'company');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('3', 'provider');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('4', 'user');
INSERT INTO `store`.`bonus` (`bonus_id`, `sum_bound`, `percentage`) VALUES ('1', '150', '7.5');
INSERT INTO `store`.`bonus` (`bonus_id`, `sum_bound`, `percentage`) VALUES ('2', '200', '10');
INSERT INTO `store`.`bonus` (`bonus_id`, `sum_bound`, `percentage`) VALUES ('3', '275', '12.5');
INSERT INTO `store`.`bonus` (`bonus_id`, `sum_bound`, `percentage`) VALUES ('4', '0', '0');
INSERT INTO `store`.`user` (`user_id`, `role_id`, `bonus_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('1', '1', '4', 'admin', 'admin', 'root', 'root', 'admin@exposit-ds.com');
INSERT INTO `store`.`user` (`user_id`, `role_id`, `bonus_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('2', '4', '1', 'user', 'user', 'user', 'user', 'user@gmail.com');
INSERT INTO `store`.`payment_form` (`payment_type_id`, `payment_type`) VALUES ('1', 'credit');
INSERT INTO `store`.`payment_scheme` (`payment_scheme_id`, `payment_type_id`, `term`, `penalty`, `cycle`, `interest_rate`) VALUES ('1', '1', '2017-05-17', '0.3', '0000-00-10', '5');
INSERT INTO `store`.`orders` (`order_id`, `user_id`, `payment_scheme_id`, `order_date`, `execution_date`) VALUES ('1', '2', '1', '2015-08-01', '2015-08-25');

INSERT INTO `store`.`status` (`status_id`, `status_name`) VALUES ('1', 'READY');
INSERT INTO `store`.`status` (`status_id`, `status_name`) VALUES ('2', 'INPROGRESS');
INSERT INTO `store`.`status` (`status_id`, `status_name`) VALUES ('3', 'NOTREADY');

INSERT INTO `store`.`sale` (`sale_id`, `start_time`, `end_time`, `percentage_sale`) VALUES ('1', '2015-07-12 12:0:0', '2015-09-12 12:0:0', '12.5');
INSERT INTO `store`.`sale` (`sale_id`, `start_time`, `end_time`, `percentage_sale`) VALUES ('2', '2015-07-12 12:0:0', '2015-10-12 12:0:0', '10.5');
INSERT INTO `store`.`product_catalog_unit` (`product_catalog_unit_id`, `sale_id`, `product_name`, `product_cost`, `margin_coefficient`) VALUES ('1', '1', 'Chair', '120', '24.5');
INSERT INTO `store`.`product_catalog_unit` (`product_catalog_unit_id`, `sale_id`, `product_name`, `product_cost`, `margin_coefficient`) VALUES ('2', '2', 'Cupboard', '1450', '10');
INSERT INTO `store`.`product_catalog_unit` (`product_catalog_unit_id`, `product_name`, `product_cost`, `margin_coefficient`) VALUES ('3', 'Table', '1000', '12.5');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `request_unit_id`, `module_type`) VALUES ('1', '1', '1', '1', 'TABLE_LEG');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `request_unit_id`, `module_type`) VALUES ('2', '2', '1', '2', 'TABLETOP');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('1', '1', '1', '4');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('2', '1', '2', '2');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('3', '2', '1', '2');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('4', '2', '2', '3');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('5', '3', '1', '10');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('6', '3', '2', '100');
INSERT INTO `store`.`feedback` (`feedback_id`, `product_catalog_unit_id`, `user_id`, `text`, `feedback_date`, `range`) VALUES ('1', '1', '2', 'Good', '2015-12-12 12:12:12', '4');
INSERT INTO `store`.`feedback` (`feedback_id`, `product_catalog_unit_id`, `user_id`, `text`, `feedback_date`, `range`) VALUES ('2', '2', '2', 'Bad', '2015-12-14 12:12:12', '1');
INSERT INTO `store`.`feedback` (`feedback_id`, `product_catalog_unit_id`, `user_id`, `text`, `feedback_date`, `range`) VALUES ('3', '3', '2', 'Cool', '2015-12-16 12:12:12', '5');
INSERT INTO `store`.`order_unit` (`order_unit_id`, `status_id`, `order_id`, `product_catalog_unit_id`, `order_unit_cost`) VALUES ('1', '1', '1', '1', '2000');
INSERT INTO `store`.`order_unit` (`order_unit_id`, `status_id`, `order_id`, `product_catalog_unit_id`, `order_unit_cost`) VALUES ('2', '1', '1', '2', '2000');
INSERT INTO `store`.`order_unit` (`order_unit_id`, `status_id`, `order_id`, `product_catalog_unit_id`, `order_unit_cost`) VALUES ('3', '1', '1', '3', '2000');

ALTER TABLE `store`.`payment` 

ADD COLUMN `payment_status` BIT(1) NULL DEFAULT FALSE AFTER `payment_sum`;
DELETE FROM `store`.`payment_scheme` WHERE `payment_scheme_id`='1';


ALTER TABLE `store`.`payment_scheme` 

CHANGE COLUMN `term` `term` INT(11) NULL ,

CHANGE COLUMN `cycle` `number_of_payments` INT(11) NULL ;


INSERT INTO `store`.`payment_scheme` (`payment_scheme_id`, `payment_type_id`, `term`, `penalty`, `number_of_payments`, `interest_rate`) VALUES ('1', '1', '30', '0.3', '2', '5');


INSERT INTO `store`.`payment` (`payment_id`, `order_id`, `payment_date`, `payment_sum`, `payment_status`) VALUES ('1', '1', '2015-08-15', '50', 0);

INSERT INTO `store`.`payment` (`payment_id`, `order_id`, `payment_date`, `payment_sum`, `payment_status`) VALUES ('2', '1', '2015-08-29', '75', 0);

UPDATE `store`.`orders` SET `execution_date`='2015-08-30 00:00:00' WHERE `order_id`='1';

UPDATE `store`.`role` SET `role_type`='ADMIN' WHERE `role_id`='1';
UPDATE `store`.`role` SET `role_type`='PROVIDER' WHERE `role_id`='3';
UPDATE `store`.`role` SET `role_type`='COMPANY' WHERE `role_id`='2';
UPDATE `store`.`role` SET `role_type`='USER' WHERE `role_id`='4';
