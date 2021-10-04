-- carpark.employee definition

CREATE TABLE `employee` (
                            `employeeId` bigint NOT NULL AUTO_INCREMENT,
                            `account` varchar(50) NOT NULL,
                            `department` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `employeeAddress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                            `employeeBirthdate` date NOT NULL,
                            `employeeEmail` varchar(50) DEFAULT NULL,
                            `employeeName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `employeePhone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
                            PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.parkinglot definition

CREATE TABLE `parkinglot` (
                              `parkId` bigint NOT NULL AUTO_INCREMENT,
                              `parkArea` bigint NOT NULL,
                              `parkName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `parkPlace` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `parkPrice` bigint NOT NULL,
                              `parkStatus` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              PRIMARY KEY (`parkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.trip definition

CREATE TABLE `trip` (
                        `tripId` bigint NOT NULL AUTO_INCREMENT,
                        `bookedTicketNumber` int DEFAULT NULL,
                        `carType` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `departureDate` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `departureTime` bigint NOT NULL,
                        `destination` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `driver` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                        `maximumOnlineTicketNumber` int NOT NULL,
                        PRIMARY KEY (`tripId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.bookingoffice definition

CREATE TABLE `bookingoffice` (
                                 `officeId` bigint NOT NULL AUTO_INCREMENT,
                                 `endContractDeadline` date NOT NULL,
                                 `officeName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `officePhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `officePlace` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `officePrice` bigint NOT NULL,
                                 `startContractDeadline` date NOT NULL,
                                 `tripId` bigint DEFAULT NULL,
                                 PRIMARY KEY (`officeId`),
                                 KEY `tripId` (`tripId`),
                                 CONSTRAINT `bookingoffice_ibfk_1` FOREIGN KEY (`tripId`) REFERENCES `trip` (`tripId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.car definition

CREATE TABLE `car` (
                       `licensePlate` varchar(50) NOT NULL,
                       `carColor` varchar(11) DEFAULT NULL,
                       `carType` varchar(50) DEFAULT NULL,
                       `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                       `parkId` bigint DEFAULT NULL,
                       PRIMARY KEY (`licensePlate`),
                       KEY `parkId` (`parkId`),
                       CONSTRAINT `car_ibfk_1` FOREIGN KEY (`parkId`) REFERENCES `parkinglot` (`parkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- carpark.ticket definition

CREATE TABLE `ticket` (
                          `ticketId` bigint NOT NULL AUTO_INCREMENT,
                          `bookingTime` time NOT NULL,
                          `customerName` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `licensePlate` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `tripId` bigint DEFAULT NULL,
                          PRIMARY KEY (`ticketId`),
                          KEY `tripId` (`tripId`),
                          KEY `licensePlate` (`licensePlate`),
                          CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`tripId`) REFERENCES `trip` (`tripId`),
                          CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`licensePlate`) REFERENCES `car` (`licensePlate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;