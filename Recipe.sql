USE master
GO

/****** Object:  Database Recipe     ******/
IF DB_ID('Recipe') IS NOT NULL
    DROP DATABASE Recipe
GO

CREATE DATABASE Recipe
GO

USE Recipe
GO

/****** Object:  Table Users     ******/
CREATE TABLE Errors(
	[ErrorID] int IDENTITY(1,1) NOT NULL,
	[MESSAGE] nvarchar(2000), 
	[NUMBER] int,
	[LINE] int,
	[PROCEDURE] nvarchar(200),
	[SEVERITY] int,
	[STATE] int
	CONSTRAINT PK_Errors PRIMARY KEY CLUSTERED(ErrorID ASC)
)
GO


/****** Object:  Table Users     ******/
CREATE TABLE Users(
	UserID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	UserName nvarchar(50) NOT NULL,
	UserPassWord nvarchar(max) Not NULL
	
	

	
	
	
)
GO

/****** Object:  Table Ingredients     ******/
CREATE TABLE Ingredients(
	IngredientsID  int IDENTITY(1,1) NOT NULL,
	Title nvarchar(50) NOT NULL,
	UnitWeight decimal (5,2) NOT NULL
	CONSTRAINT PK_Items PRIMARY KEY CLUSTERED(IngredientsID ASC)
)
GO

/****** Object:  Table OrderDetails     ******/
CREATE TABLE OrderDetails(
	OrderID int NOT NULL,
	IngredientsID int NOT NULL,
	Quantity smallint NOT NULL
)
GO

/****** Object:  Table Orders     ******/
CREATE TABLE Orders(
	OrderID int IDENTITY(1,1) NOT NULL,
	UserID int NOT NULL,
	OrderDate datetime NOT NULL,
	UploadDate datetime NULL
	CONSTRAINT PK_Orders PRIMARY KEY CLUSTERED(OrderID ASC)
)
GO


SET IDENTITY_INSERT Users ON 
INSERT Users (UserID, UserName, UserPassWord) VALUES 
(1, 'Blanca', '6145553928'),
(2, 'Randall', '2095552262'),
(3, 'Millerton', '2125554800', NULL),
(4, 'Damion', '2025555561', NULL),
(5, 'Mayte', '5135553043', NULL)

SET IDENTITY_INSERT Users OFF
GO


SET IDENTITY_INSERT Ingredients ON
INSERT Ingredients (IngredientsID, Title, UnitWeight) VALUES 
(1, 'salt' , 0.6),
(2, 'sugar', 0.8),
(3, 'edible oil',  1),
(4, 'salad oil',  1),
(5, 'starch',  3),
(6, 'flour',  3),
(7, 'vinegar',  2),
(8, 'black pepper',  0.5),
(9, 'soy sauce',  1),
(10, 'ketchup',  4)
SET IDENTITY_INSERT Ingredients OFF

GO

INSERT OrderDetails (OrderID, IngredientsID, Quantity) VALUES 
(381, 1, 1),
(601, 9, 1),
(442, 1, 1),
(523, 9, 1),
(630, 5, 1),
(778, 1, 1),
(693, 10, 1),
(118, 1, 1),
(264, 7, 1),
(607, 10, 1),
(624, 7, 1),
(658, 1, 1),
(800, 5, 1),
(158, 3, 1),
(321, 10, 1),
(687, 6, 1),
(827, 6, 1),
(144, 3, 1),
(264, 8, 1),
(479, 1, 2),
(630, 6, 2),
(796, 5, 1),
(97, 4, 1),
(601, 5, 1),
(773, 10, 1),
(800, 1, 1),
(29, 10, 1),
(70, 1, 1),
(97, 8, 1),
(165, 4, 1),
(180, 4, 1),
(231, 10, 1),
(392, 8, 1),
(413, 10, 1),
(491, 6, 1),
(494, 2, 1),
(606, 8, 1),
(607, 3, 1),
(651, 3, 1),
(703, 4, 1),
(796, 2, 1),
(802, 2, 1),
(802, 3, 1),
(824, 7, 2),
(829, 1, 1),
(550, 4, 1),
(796, 7, 1),
(829, 2, 1),
(693, 6, 1),
(29, 3, 1),
(32, 7, 1),
(242, 1, 1),
(298, 1, 1),
(479, 4, 1),
(548, 9, 1),
(627, 9, 1),
(778, 3, 1),
(687, 8, 1),
(19, 5, 1),
(89, 4, 1),
(242, 6, 1),
(264, 4, 1),
(550, 1, 1),
(631, 10, 1),
(693, 7, 3),
(824, 3, 1),
(829, 5, 1),
(829, 9, 1)
GO

SET IDENTITY_INSERT Orders ON
INSERT Orders (OrderID, UserID, OrderDate, UploadDate) VALUES 
(19, 1, CAST('2014-06-23 00:00:00.000' AS DateTime), CAST('2014-06-28 00:00:00.000' AS DateTime)),
(29, 8, CAST('2014-07-05 00:00:00.000' AS DateTime), CAST('2014-07-11 00:00:00.000' AS DateTime)),
(32, 11, CAST('2014-07-10 00:00:00.000' AS DateTime), CAST('2014-07-13 00:00:00.000' AS DateTime)),
(45, 2, CAST('2014-07-25 00:00:00.000' AS DateTime), CAST('2014-07-30 00:00:00.000' AS DateTime)),
(70, 10, CAST('2014-08-28 00:00:00.000' AS DateTime), CAST('2014-09-07 00:00:00.000' AS DateTime)),
(89, 22, CAST('2014-09-20 00:00:00.000' AS DateTime), CAST('2014-09-22 00:00:00.000' AS DateTime)),
(97, 20, CAST('2014-09-29 00:00:00.000' AS DateTime), CAST('2014-10-02 00:00:00.000' AS DateTime)),
(118, 3, CAST('2014-10-24 00:00:00.000' AS DateTime), CAST('2014-10-28 00:00:00.000' AS DateTime)),
(144, 17, CAST('2014-11-21 00:00:00.000' AS DateTime), CAST('2014-11-29 00:00:00.000' AS DateTime)),
(158, 9, CAST('2014-12-04 00:00:00.000' AS DateTime), CAST('2014-12-20 00:00:00.000' AS DateTime)),
(165, 14, CAST('2014-12-11 00:00:00.000' AS DateTime), CAST('2014-12-13 00:00:00.000' AS DateTime)),
(180, 24, CAST('2014-12-25 00:00:00.000' AS DateTime), CAST('2015-01-30 00:00:00.000' AS DateTime)),
(231, 15, CAST('2015-02-14 00:00:00.000' AS DateTime), CAST('2015-02-22 00:00:00.000' AS DateTime)),
(242, 23, CAST('2015-02-24 00:00:00.000' AS DateTime), CAST('2015-03-06 00:00:00.000' AS DateTime)),
(264, 9, CAST('2015-03-15 00:00:00.000' AS DateTime), CAST('2015-03-18 00:00:00.000' AS DateTime)),
(298, 18, CAST('2015-04-18 00:00:00.000' AS DateTime), CAST('2015-05-22 00:00:00.000' AS DateTime)),
(321, 2, CAST('2015-05-09 00:00:00.000' AS DateTime), CAST('2015-06-05 00:00:00.000' AS DateTime)),
(381, 7, CAST('2015-07-08 00:00:00.000' AS DateTime), CAST('2015-07-16 00:00:00.000' AS DateTime)),
(392, 19, CAST('2015-07-16 00:00:00.000' AS DateTime), CAST('2015-07-23 00:00:00.000' AS DateTime)),
(413, 17, CAST('2015-08-05 00:00:00.000' AS DateTime), CAST('2015-09-11 00:00:00.000' AS DateTime)),
(442, 5, CAST('2015-08-28 00:00:00.000' AS DateTime), CAST('2015-09-03 00:00:00.000' AS DateTime)),
(479, 1, CAST('2015-09-30 00:00:00.000' AS DateTime), CAST('2015-11-03 00:00:00.000' AS DateTime)),
(491, 16, CAST('2015-10-08 00:00:00.000' AS DateTime), CAST('2015-10-14 00:00:00.000' AS DateTime)),
(494, 4, CAST('2015-10-10 00:00:00.000' AS DateTime), CAST('2015-10-14 00:00:00.000' AS DateTime)),
(523, 3, CAST('2015-11-07 00:00:00.000' AS DateTime), CAST('2015-11-15 00:00:00.000' AS DateTime)),
(548, 2, CAST('2015-11-22 00:00:00.000' AS DateTime), CAST('2015-12-18 00:00:00.000' AS DateTime)),
(550, 17, CAST('2015-11-23 00:00:00.000' AS DateTime), CAST('2015-12-03 00:00:00.000' AS DateTime)),
(601, 16, CAST('2015-12-21 00:00:00.000' AS DateTime), CAST('2015-12-27 00:00:00.000' AS DateTime)),
(606, 6, CAST('2015-12-25 00:00:00.000' AS DateTime), CAST('2016-01-02 00:00:00.000' AS DateTime)),
(607, 20, CAST('2015-12-25 00:00:00.000' AS DateTime), CAST('2016-01-04 00:00:00.000' AS DateTime)),
(624, 2, CAST('2016-01-04 00:00:00.000' AS DateTime), CAST('2016-01-09 00:00:00.000' AS DateTime)),
(627, 17, CAST('2016-01-05 00:00:00.000' AS DateTime), CAST('2016-01-10 00:00:00.000' AS DateTime)),
(630, 20, CAST('2016-01-08 00:00:00.000' AS DateTime), CAST('2016-01-18 00:00:00.000' AS DateTime)),
(631, 21, CAST('2016-01-09 00:00:00.000' AS DateTime), CAST('2016-01-11 00:00:00.000' AS DateTime)),
(651, 12, CAST('2016-01-19 00:00:00.000' AS DateTime), CAST('2016-02-02 00:00:00.000' AS DateTime)),
(658, 12, CAST('2016-01-23 00:00:00.000' AS DateTime), CAST('2016-02-02 00:00:00.000' AS DateTime)),
(687, 17, CAST('2016-02-05 00:00:00.000' AS DateTime), CAST('2016-02-08 00:00:00.000' AS DateTime)),
(693, 9, CAST('2016-02-07 00:00:00.000' AS DateTime), CAST('2016-02-19 00:00:00.000' AS DateTime)),
(703, 19, CAST('2016-02-12 00:00:00.000' AS DateTime), CAST('2016-02-19 00:00:00.000' AS DateTime)),
(773, 25, CAST('2016-03-11 00:00:00.000' AS DateTime), CAST('2016-03-13 00:00:00.000' AS DateTime)),
(778, 13, CAST('2016-03-12 00:00:00.000' AS DateTime), CAST('2016-03-21 00:00:00.000' AS DateTime)),
(796, 17, CAST('2016-03-19 00:00:00.000' AS DateTime), CAST('2016-03-26 00:00:00.000' AS DateTime)),
(800, 19, CAST('2016-03-21 00:00:00.000' AS DateTime), CAST('2016-03-28 00:00:00.000' AS DateTime)),
(802, 2, CAST('2016-03-21 00:00:00.000' AS DateTime), CAST('2016-03-31 00:00:00.000' AS DateTime)),
(824, 1, CAST('2016-04-01 00:00:00.000' AS DateTime), NULL),
(827, 18, CAST('2016-04-02 00:00:00.000' AS DateTime), NULL),
(829, 9, CAST('2016-04-02 00:00:00.000' AS DateTime), NULL)
SET IDENTITY_INSERT Orders OFF
GO


USE master
GO

ALTER DATABASE Recipe SET  READ_WRITE 
GO
