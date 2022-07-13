DROP TABLE IF EXISTS loans;


CREATE TABLE `loans` (
                            `customer_id` int NOT NULL,
                            `loan_no` int NOT NULL AUTO_INCREMENT,
                            `start_date` date NOT NULL,
                            `loan_type` VARCHAR(100) NOT NULL,
                            `total_loan` int NOT NULL,
                            `paid_amount` int NOT NULL,
                            `outstanding_amount` int NOT NULL,
                            `create_date` DATE DEFAULT NULL,
                            PRIMARY KEY (`loan_no`)
);

INSERT INTO `loans` (`customer_id`, `start_date`, `loan_type`, `total_loan`, `paid_amount`, `outstanding_amount`, `create_date`)
VALUES (1, '2020-10-13', 'Home', '2000000000', '1500000000', '500000000', '2020-10-13' );

INSERT INTO `loans` (`customer_id`, `start_date`, `loan_type`, `total_loan`, `paid_amount`, `outstanding_amount`, `create_date`)
VALUES (1, '2021-06-13', 'Vehicle', '200000000', '120000000', '80000000', '2021-06-13' );

INSERT INTO `loans` (`customer_id`, `start_date`, `loan_type`, `total_loan`, `paid_amount`, `outstanding_amount`, `create_date`)
VALUES (1, '2021-10-14', 'Home', '1000000000', '500000000', '500000000', '2021-10-14' );

INSERT INTO `loans` (`customer_id`, `start_date`, `loan_type`, `total_loan`, `paid_amount`, `outstanding_amount`, `create_date`)
VALUES (1, '2022-04-03', 'Personal', '20000000', '10000000', '10000000', '2022-04-03' );