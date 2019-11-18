SELECT * FROM [airbnb_dev].[dbo].[owner]
--INSERT INTO [airbnb_dev].[dbo].[owner] (name, email, contact_no, created_at, updated_at) 
--VALUES ('jia_jun_ong', 'elton_lion@hotmail.com', '0145553311', SYSDATETIME(), SYSDATETIME());

SELECT * FROM [airbnb_dev].[dbo].[property]
--INSERT INTO [airbnb_dev].[dbo].[property] (address, created_at, updated_at, owner_id) VALUES ('Taman Desa', SYSDATETIME(), SYSDATETIME(), 1);


SELECT * FROM [airbnb_dev].[dbo].[user]
--INSERT INTO [airbnb_dev].[dbo].[user] (name, contact_no, created_at, updated_at) VALUES ('jia_jun_ong', '0145553311', SYSDATETIME(), SYSDATETIME());


SELECT * FROM [airbnb_dev].[dbo].[booking]

--INSERT INTO [airbnb_dev].[dbo].[booking] (price, booking_date, check_in, check_out, created_at, updated_at, user_id, property_id) 
--VALUES (5000, SYSDATETIME(), GETDATE() + 3, GETDATE() + 7, SYSDATETIME(), SYSDATETIME(), 1, 1);


SELECT * FROM [airbnb_dev].[dbo].[payment]

--INSERT INTO [airbnb_dev].[dbo].[payment] (status, amount, created_at, updated_at, booking_id) 
--VALUES (1, 5000, SYSDATETIME(), SYSDATETIME(), 1);