/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     02.08.2015 8:45:10                           */
/*==============================================================*/
drop schema if exists Store;

create database  Store;

use Store;

drop table if exists Bonus;

drop table if exists Feedback;

drop table if exists Module;

drop table if exists Order_Unit;

drop table if exists Orders;

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

drop table if exists State;

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
   product_catalog_unit_id int,
   user_id              int,
   text                 varchar(512),
   feedback_date        datetime,
   rating               int,
   primary key (feedback_id)
);

/*==============================================================*/
/* Table: Module                                                */
/*==============================================================*/
create table Module
(
   module_id            int not null AUTO_INCREMENT,
   storage_module_unit_id int,
   provider_id          int,
   module_type          varchar(50),
   primary key (module_id)
);

/*==============================================================*/
/* Table: Order_Unit                                            */
/*==============================================================*/
create table Order_Unit
(
   order_unit_id        int not null AUTO_INCREMENT,
   state_id             int,
   order_id             int,
   product_catalog_unit_id int,
   order_unit_cost      double,
   primary key (order_unit_id)
);

/*==============================================================*/
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   order_id             int not null AUTO_INCREMENT,
   user_id              int,
   payment_scheme_id    int,
   order_date           datetime,
   execution_date       datetime,
   primary key (order_id)
);

/*==============================================================*/
/* Table: Payment                                               */
/*==============================================================*/
create table Payment
(
   payment_id           int not null AUTO_INCREMENT,
   order_id             int,
   payment_date         datetime,
   payment_sum          double,
   payment_status       bool,
   primary key (payment_id)
);

/*==============================================================*/
/* Table: Payment_Form                                          */
/*==============================================================*/
create table Payment_Form
(
   payment_type_id      int not null AUTO_INCREMENT,
   payment_type         varchar(50),
   primary key (payment_type_id)
);

/*==============================================================*/
/* Table: Payment_Scheme                                        */
/*==============================================================*/
create table Payment_Scheme
(
   payment_scheme_id    int not null AUTO_INCREMENT,
   payment_type_id      int,
   term                 int,
   penalty              double,
   number_of_payments   int,
   interest_rate        double,
   primary key (payment_scheme_id)
);

/*==============================================================*/
/* Table: Product_Catalog_Unit                                  */
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
/* Table: Product_Template                                      */
/*==============================================================*/
create table Product_Template
(
   product_template_id  int not null AUTO_INCREMENT,
   product_catalog_unit_id int,
   module_id            int,
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
   provider_id          int,
   request_date         datetime,
   primary key (request_id)
);

/*==============================================================*/
/* Table: Request_Unit                                          */
/*==============================================================*/
create table Request_Unit
(
   request_unit_id      int not null AUTO_INCREMENT,
   request_id           int,
   module_id            int,
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
   provider_id          int,
   way_bill_id          int,
   cargo_margin_coefficient double,
   is_processed         BOOLEAN,
   primary key (shipment_id)
);

/*==============================================================*/
/* Table: Shipment_Unit                                         */
/*==============================================================*/
create table Shipment_Unit
(
   shipment_unit_id     int not null AUTO_INCREMENT,
   shipment_id          int,
   module_id            int,
   count                int,
   cost                 double,
   primary key (shipment_unit_id)
);

/*==============================================================*/
/* Table: State                                                 */
/*==============================================================*/
create table State
(
   state_id             int not null AUTO_INCREMENT,
   state_name           varchar(50),
   primary key (state_id)
);

/*==============================================================*/
/* Table: Storage_Module_Unit                                   */
/*==============================================================*/
create table Storage_Module_Unit
(
   storage_module_unit_id int not null AUTO_INCREMENT,
   module_id            int,
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
   role_id              int,
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
   shipment_id          int,
   departure_date       datetime,
   delivery_date        datetime,
   delivery_cost        double,
   primary key (way_bill_id)
);

INSERT INTO `store`.`user` (`user_id`, `role_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('1', '1', 'Ivan', 'Adamin', 'Admin', 'root', 'adamin@gmail.com');
INSERT INTO `store`.`user` (`user_id`, `role_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('2', '2', 'Max', 'Sorokin', 'Max', 'provider', 'sorokin@gmail.com');
INSERT INTO `store`.`user` (`user_id`, `role_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('3', '3', 'Kate', 'Dobrilko', 'Kate', 'company', 'dobrilko@gmail.com');
INSERT INTO `store`.`user` (`user_id`, `role_id`, `bonus_id`, `name`, `surname`, `login`, `password`, `email`) VALUES ('4', '4', '1', 'Vasili', 'Yavorchuk', 'Vasili', 'user', 'yavorchuk@gmail.com');

INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('1', 'ADMIN');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('2', 'PROVIDER');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('3', 'COMPANY');
INSERT INTO `store`.`role` (`role_id`, `role_type`) VALUES ('4', 'USER');

INSERT INTO `store`.`bonus` (`bonus_id`, `sum_bound`, `percentage`) VALUES ('1', '2250', '12.5');

INSERT INTO `store`.`state` (`state_id`, `state_name`) VALUES ('1', 'READY');
INSERT INTO `store`.`state` (`state_id`, `state_name`) VALUES ('2', 'INPROGRESS');
INSERT INTO `store`.`state` (`state_id`, `state_name`) VALUES ('3', 'NOTREADY');

INSERT INTO `store`.`payment_form` (`payment_type_id`, `payment_type`) VALUES ('1', 'CREDIT');

INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `module_type`) VALUES ('1', '1', '1', 'TABLE_LEG');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `module_type`) VALUES ('2', '2', '1', 'TABLETOP');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `module_type`) VALUES ('3', '3', '1', 'CHAIR_BACK');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `module_type`) VALUES ('4', '4', '1', 'CHAIR_LEG');
INSERT INTO `store`.`module` (`module_id`, `storage_module_unit_id`, `provider_id`, `module_type`) VALUES ('5', '5', '1', 'CHAIR_SEAT');

INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('1', '1', '100', '500', '2015-07-28 12:00:00');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('2', '2', '200', '400', '2015-07-28 12:00:00');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('3', '3', '300', '300', '2015-07-28 12:00:00');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('4', '4', '400', '200', '2015-07-28 12:00:00');
INSERT INTO `store`.`storage_module_unit` (`storage_module_unit_id`, `module_id`, `module_count`, `unit_cost`, `date_of_delivery`) VALUES ('5', '5', '500', '100', '2015-07-28 12:00:00');

INSERT INTO `store`.`provider` (`provider_id`, `provider_name`, `phone`, `provider_email`, `zip_code`, `provider_login`) VALUES ('1', 'Pinskdrev', '+375 (29) 605-57-57', 'question@pinskdrev.by', '224831', 'Max');

INSERT INTO `store`.`product_catalog_unit` (`product_catalog_unit_id`, `sale_id`, `product_name`, `product_cost`, `margin_coefficient`) VALUES ('1', '1', 'Table', '10000', '22.5');

INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('1', '1', '1', '4');
INSERT INTO `store`.`product_template` (`product_template_id`, `product_catalog_unit_id`, `module_id`, `modules_number`) VALUES ('2', '1', '2', '1');

INSERT INTO `store`.`request` (`request_id`, `provider_id`, `request_date`) VALUES ('1', '1', '2015-07-28 12:00:00');

INSERT INTO `store`.`request_unit` (`request_unit_id`, `request_id`, `module_id`, `request_module_count`) VALUES ('1', '1', '1', '1000');
INSERT INTO `store`.`request_unit` (`request_unit_id`, `request_id`, `module_id`, `request_module_count`) VALUES ('2', '1', '2', '1000');
INSERT INTO `store`.`request_unit` (`request_unit_id`, `request_id`, `module_id`, `request_module_count`) VALUES ('3', '1', '3', '1000');

INSERT INTO `store`.`shipment` (`shipment_id`, `provider_id`, `way_bill_id`, `cargo_margin_coefficient`, `is_processed`) VALUES ('1', '1', '1', '25', '0');

INSERT INTO `store`.`shipment_unit` (`shipment_unit_id`, `shipment_id`, `module_id`, `count`, `cost`) VALUES ('1', '1', '3', '1000', '1000');
INSERT INTO `store`.`shipment_unit` (`shipment_unit_id`, `shipment_id`, `module_id`, `count`, `cost`) VALUES ('2', '1', '4', '1000', '2000');
INSERT INTO `store`.`shipment_unit` (`shipment_unit_id`, `shipment_id`, `module_id`, `count`, `cost`) VALUES ('3', '1', '5', '1000', '3000');

INSERT INTO `store`.`waybill` (`way_bill_id`, `shipment_id`, `departure_date`, `delivery_date`, `delivery_cost`) VALUES ('1', '1', '2015-07-12', '2015-07-24', '1230');

INSERT INTO `store`.`sale` (`sale_id`, `start_time`, `end_time`, `percentage_sale`) VALUES ('1', '2015-07-12', '2015-08-12', '11.5');
INSERT INTO `store`.`sale` (`sale_id`, `start_time`, `end_time`, `percentage_sale`) VALUES ('2', '2015-07-12', '2015-09-12', '1.5');

INSERT INTO `store`.`feedback` (`feedback_id`, `product_catalog_unit_id`, `user_id`, `text`, `feedback_date`, `rating`) VALUES ('1', '1', '4', 'Good product', '2015-08-01 12:00:00', '4');

INSERT INTO `store`.`orders` (`order_id`, `user_id`, `payment_scheme_id`, `order_date`, `execution_date`) VALUES ('1', '4', '1', '2015-07-29 12:00:00', '2015-07-31 12:00:00');

INSERT INTO `store`.`order_unit` (`order_unit_id`, `state_id`, `order_id`, `product_catalog_unit_id`, `order_unit_cost`) VALUES ('1', '1', '1', '1', '2000');
INSERT INTO `store`.`order_unit` (`order_unit_id`, `state_id`, `order_id`, `product_catalog_unit_id`, `order_unit_cost`) VALUES ('2', '1', '1', '1', '2000');

INSERT INTO `store`.`payment_scheme` (`payment_scheme_id`, `payment_type_id`, `term`, `penalty`, `number_of_payments`, `interest_rate`) VALUES ('1', '1', '15', '1.5', '10', '12.5');

INSERT INTO `store`.`payment` (`payment_id`, `order_id`, `payment_date`, `payment_sum`, `payment_status`) VALUES ('1', '1', '2015-07-29 12:00:00', '200', '1');
INSERT INTO `store`.`payment` (`payment_id`, `order_id`, `payment_date`, `payment_sum`, `payment_status`) VALUES ('2', '1', '2015-07-30 12:00:00', '300', '1');

