DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE `customer` (
                            `customer_id` int AUTO_INCREMENT PRIMARY KEY,
                            `name` VARCHAR(100) NOT NULL,
                            `email` VARCHAR(100) NOT NULL,
                            `mobile_no` VARCHAR(20) NOT NULL,
                            `create_date` DATE DEFAULT NULL
);

CREATE TABLE `accounts` (
                            `customer_id` int NOT NULL,
                            `account_no` int AUTO_INCREMENT PRIMARY KEY,
                            `account_type` VARCHAR(100) NOT NULL,
                            `branch_addr` VARCHAR(200) NOT NULL,
                            `create_date` DATE DEFAULT NULL
);

INSERT INTO `customer` (`name`, `email`, `mobile_no`, `create_date`)
VALUES ('Akira Nadhira', 'akiranadhira@outlook.com', '628xxxxxx1812', CURDATE());

INSERT INTO `accounts` (`customer_id`, `account_no`, `account_type`, `branch_addr`, `create_date`)
VALUES (1, 1234567890, 'Savings', 'Indonesia', CURDATE() );