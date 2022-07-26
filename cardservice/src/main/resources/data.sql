DROP TABLE IF EXISTS cards;


CREATE TABLE `cards` (
                            `customer_id` int NOT NULL,
                            `card_id` int NOT NULL AUTO_INCREMENT,
                            `card_no` VARCHAR(100) NOT NULL,
                            `card_type` VARCHAR(100) NOT NULL,
                            `total_limit` int NOT NULL,
                            `used_amount` int NOT NULL,
                            `available_amount` int NOT NULL,
                            `create_date` DATE DEFAULT NULL,
                            PRIMARY KEY (`card_id`)
);

INSERT INTO `cards` (`customer_id`, `card_no`, `card_type`, `total_limit`, `used_amount`, `available_amount`, `create_date`)
VALUES (1, '5307XXXXXXXX0091', 'Credit', '10000', '500', '9500', CURDATE() );

INSERT INTO `cards` (`customer_id`, `card_no`, `card_type`, `total_limit`, `used_amount`, `available_amount`, `create_date`)
VALUES (1, '5307XXXXXXXX9510', 'Credit', '20000', '15000', '5000', CURDATE() );

INSERT INTO `cards` (`customer_id`, `card_no`, `card_type`, `total_limit`, `used_amount`, `available_amount`, `create_date`)
VALUES (1, '5307XXXXXXXX5307', 'Credit', '50000', '5000', '45000', CURDATE() );

