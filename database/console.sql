CREATE SCHEMA IF NOT EXISTS `cpt202`;

USE `cpt202`;

CREATE TABLE IF NOT EXISTS `t_user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR (255) UNIQUE NOT NULL,
    `password` VARCHAR (255) NOT NULL,
    `secret_question` INT NOT NULL,
    `secret_answer` VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `t_secret_question` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `question` VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `t_friend` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `friend_a` INT NOT NULL,
    `friend_b` INT NOT NULL
);

ALTER TABLE
    `t_user` AUTO_INCREMENT = 10001;

-- ALTER TABLE `t_user`
--     ADD FOREIGN KEY (`secret_question`) REFERENCES `t_secret_question` (`id`);
-- ALTER TABLE `t_friend`
--     ADD FOREIGN KEY (`friend_a`) REFERENCES `t_user` (`id`);
-- ALTER TABLE `t_friend`
--     ADD FOREIGN KEY (`friend_b`) REFERENCES `t_user` (`id`);
CREATE TABLE IF NOT EXISTS `t_post` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR (255) NOT NULL,
    `content` VARCHAR (255) NOT NULL,
    `writer_id` INT NOT NULL,
    `written_time` DATETIME NOT NULL,
    `update_time` DATETIME DEFAULT NULL,
    `anonymous` INT NOT NULL,
    `kudos` INT DEFAULT 0,
    `criticism` INT DEFAULT 0,
    `views` INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `t_type` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `type_name` VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `t_type_to_post` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `post_id` INT NOT NULL,
    `type_id` INT NOT NULL
);

-- ALTER TABLE `t_post`
--     ADD FOREIGN KEY (`writer_id`) REFERENCES `t_user` (`id`);
-- ALTER TABLE `t_type_to_post`
--     ADD FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`);
-- ALTER TABLE `t_type_to_post`
--     ADD FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`);
CREATE TABLE IF NOT EXISTS `t_comment` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `writer_id` INT NOT NULL,
    `post_id` INT NOT NULL,
    `written_time` DATETIME NOT NULL,
    `update_time` DATETIME DEFAULT NULL,
    `content` VARCHAR (255) NOT NULL,
    `kudos` INT DEFAULT 0,
    `criticism` INT DEFAULT 0
);

-- ALTER TABLE `t_comment`
--     ADD FOREIGN KEY (`writer_id`) REFERENCES `t_user` (`id`);
-- ALTER TABLE `t_comment`
--     ADD FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`);
-- For Personal Information page
ALTER TABLE
    t_user
ADD
    gender VARCHAR(10),
ADD
    grade VARCHAR(10),
ADD
    major VARCHAR(50),
ADD
    personal_info VARCHAR(100),
ADD
    avator VARCHAR(255);

ALTER TABLE
    t_post
ADD
    is_deleted BOOLEAN DEFAULT FALSE;

ALTER TABLE
    t_comment
ADD
    is_deleted BOOLEAN DEFAULT FALSE;

-- Update Post.java
ALTER TABLE
    t_post CHANGE COLUMN kudos total_likes INT DEFAULT 0;

ALTER TABLE
    t_post
ADD
    new_likes INT DEFAULT 0;

-- Tables for like and collect
CREATE TABLE `t_post_likes` (
    id INT AUTO_INCREMENT,
    post_id INT,
    liked_by INT,
    liked_time DATETIME,
    like_check INT DEFAULT 0
);

CREATE TABLE `t_post_collect` (
    id INT AUTO_INCREMENT,
    post_id INT,
    collected_by INT,
    collected_time DATETIME,
    collect_check INT DEFAULT 0
);