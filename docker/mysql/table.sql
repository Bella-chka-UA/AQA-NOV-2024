CREATE TABLE Persons (
                         PersonID int UNIQUE AUTO_INCREMENT NOT NULL,
                         LastName varchar(255) NOT NULL,
                         FirstName varchar(255) NOT NULL,
                         Gender varchar(80) NOT NULL,
                         Title varchar(255) NOT NULL,
                         Nat varchar(255) NOT NULL
);

INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('Jane', 'Doe', 'female', 'Mrs', 'US');

delete from Persons where LastName = 'Doe';

select * from Persons where LastName = 'Doe';

select * from Persons  ORDER BY RAND() limit 1;

CREATE TABLE Phones (
    PhoneId INT AUTO_INCREMENT PRIMARY KEY,
    PhoneName VARCHAR(255) NOT NULL,
    GoodsId VARCHAR(100) NOT NULL UNIQUE
);
DELETE FROM table Phones
;


