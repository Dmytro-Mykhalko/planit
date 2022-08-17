-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema plan_it
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `plan_it` ;

-- -----------------------------------------------------
-- Schema plan_it
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `plan_it` DEFAULT CHARACTER SET utf8 ;
USE `plan_it` ;

-- -----------------------------------------------------
-- Table `plan_it`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`user` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`user` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(320) NOT NULL,
  `password` VARCHAR(68) NOT NULL,
  `avatar_link` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `email_UNIQUE` ON `plan_it`.`user` (`email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `plan_it`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`board` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`board` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `plan_it`.`board_access`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`board_access` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`board_access` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `plan_it`.`priority`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`priority` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`priority` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `plan_it`.`column`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`column` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`column` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `board_id` INT UNIQUE NOT NULL,
  `order` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_column_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `plan_it`.`board` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE INDEX `fk_column_board1_idx` ON `plan_it`.`column` (`board_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `order_UNIQUE` ON `plan_it`.`column` (`order` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `plan_it`.`task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`task` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`task` (
  `id` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(16384) NULL,
  `priority_id` INT UNIQUE NOT NULL,
  `column_id` INT UNIQUE NOT NULL,
  `order` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_task_priority`
    FOREIGN KEY (`priority_id`)
    REFERENCES `plan_it`.`priority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_column1`
    FOREIGN KEY (`column_id`)
    REFERENCES `plan_it`.`column` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE INDEX `fk_task_priority_idx` ON `plan_it`.`task` (`priority_id` ASC) VISIBLE;

CREATE INDEX `fk_task_column1_idx` ON `plan_it`.`task` (`column_id` ASC) VISIBLE;

CREATE UNIQUE INDEX `order_UNIQUE` ON `plan_it`.`task` (`order` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `plan_it`.`user_has_board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan_it`.`user_has_board` ;

CREATE TABLE IF NOT EXISTS `plan_it`.`user_has_board` (
  `user_id` INT UNIQUE NOT NULL,
  `board_id` INT UNIQUE NOT NULL,
  `board_access_id` INT UNIQUE NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `board_id`),
  CONSTRAINT `fk_user_has_board_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plan_it`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_board_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `plan_it`.`board` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_board_board_access1`
    FOREIGN KEY (`board_access_id`)
    REFERENCES `plan_it`.`board_access` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `fk_user_has_board_board1_idx` ON `plan_it`.`user_has_board` (`board_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_board_user1_idx` ON `plan_it`.`user_has_board` (`user_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_board_board_access1_idx` ON `plan_it`.`user_has_board` (`board_access_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
