-- carpark.employee definition

CREATE TABLE `employee` (
                            `employee_id` varchar(36) NOT NULL,
                            `account` varchar(50) NOT NULL,
                            `department` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `employee_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                            `employee_birthdate` date NOT NULL,
                            `employee_email` varchar(50) DEFAULT NULL,
                            `employee_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `employee_phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
                            PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.parkinglot definition

CREATE TABLE `parkinglot` (
                              `park_id` varchar(36) NOT NULL ,
                              `park_area` bigint NOT NULL,
                              `park_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `park_place` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `park_price` bigint NOT NULL,
                              `park_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              PRIMARY KEY (`park_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.trip definition

CREATE TABLE `trip` (
                        `trip_id` varchar(36) NOT NULL ,
                        `booked_ticket_number` int DEFAULT NULL,
                        `car_type` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `departure_date` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `departure_time` bigint NOT NULL,
                        `destination` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `driver` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `maximum_online_ticket_number` int NOT NULL,
                        PRIMARY KEY (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.bookingoffice definition

CREATE TABLE `bookingoffice` (
                                 `office_id` varchar(36) NOT NULL ,
                                 `end_contract_deadline` date NOT NULL,
                                 `office_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `office_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `office_place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `office_price` bigint NOT NULL,
                                 `start_contract_deadline` date NOT NULL,
                                 `trip_id` varchar(36) DEFAULT NULL,
                                 PRIMARY KEY (`office_id`),
                                 FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.car definition

CREATE TABLE `car` (
                       `license_plate` varchar(50) NOT NULL,
                       `car_color` varchar(11) DEFAULT NULL,
                       `car_type` varchar(50) DEFAULT NULL,
                       `company` varchar(50) NOT NULL,
                       `park_id` varchar(36) DEFAULT NULL,
                       PRIMARY KEY (`license_plate`),
                       FOREIGN KEY (`park_id`) REFERENCES `parkinglot` (`park_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.ticket definition

CREATE TABLE `ticket` (
                          `ticket_id` varchar(36) NOT NULL ,
                          `booking_time` time NOT NULL,
                          `customer_name` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `license_plate` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `trip_id` varchar(36) DEFAULT NULL,
                          PRIMARY KEY (`ticket_id`),
                          FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`),
                          FOREIGN KEY (`license_plate`) REFERENCES `car` (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;