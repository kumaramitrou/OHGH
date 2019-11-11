-- create Tables

/****** Object:  Table [dbo].[Student]    Script Date: 11-11-2019 17:41:44 ******/

CREATE TABLE [dbo].[Student](
	[Name] [nvarchar](50) NOT NULL,
	[RollNo] [nvarchar](20) NOT NULL,
	[Batch] [int] NOT NULL,
	[Stream] [nvarchar](50) NOT NULL,
	[Id] [bigint] IDENTITY(10000,1) NOT NULL
);

/****** Object:  Table [dbo].[FacilityHead]    Script Date: 11-11-2019 17:42:51 ******/

CREATE TABLE [dbo].[FacilityHead](
	[Name] [nvarchar](50) NOT NULL,
	[EmpNo] [nvarchar](20) NOT NULL,
	[Department] [nvarchar](50) NOT NULL,
	[Specialization] [nvarchar](50) NOT NULL,
	[Facility] [nvarchar](50) NOT NULL,
	[Id] [bigint] IDENTITY(10000,1) NOT NULL
)

/****** Object:  Table [dbo].[User]    Script Date: 11-11-2019 17:43:31 ******/

CREATE TABLE [dbo].[User](
	[Name] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
	[Password] [nvarchar](24) NOT NULL,
	[Question] [nvarchar](100) NOT NULL,
	[Answer] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
	[HomePage] [nvarchar](50) NOT NULL,
	[Id] [bigint] IDENTITY(10000,1) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[UID] [nvarchar](20) NOT NULL
)

/****** Object:  Table [dbo].[Update]    Script Date: 11-11-2019 17:44:25 ******/

CREATE TABLE [dbo].[Update](
	[Subject] [nvarchar](100) NOT NULL,
	[Content] [nvarchar](500) NOT NULL,
	[Id] [bigint] IDENTITY(100000,1) NOT NULL
)

/****** Object:  Table [dbo].[Notification]    Script Date: 11-11-2019 17:45:24 ******/

CREATE TABLE [dbo].[Notification](
	[UserName] [nvarchar](50) NOT NULL,
	[Message] [nvarchar](100) NOT NULL,
	[RequestId] [bigint] NOT NULL,
	[Subject] [nvarchar](50) NOT NULL,
	[IsViewed] [bit] NOT NULL,
	[Id] [bigint] IDENTITY(100000,1) NOT NULL
)

/****** Object:  Table [dbo].[Events]    Script Date: 11-11-2019 17:46:11 ******/

CREATE TABLE [dbo].[Events](
	[Subject] [nvarchar](100) NULL,
	[Message] [nvarchar](200) NOT NULL,
	[DocumentUrl] [nvarchar](500) NULL,
	[EventType] [nvarchar](20) NOT NULL,
	[TrackingId] [nvarchar](50) NOT NULL,
	[SerialNo] [int] NOT NULL,
	[Id] [bigint] IDENTITY(100000,1) NOT NULL,
	[To] [nvarchar](50) NULL,
	[From] [nvarchar](50) NOT NULL,
	[Facility] [nvarchar](50) NULL
)

/****** Insert base data into user table ******/

INSERT INTO [dbo].[User]
           ([Name]
           ,[Email]
           ,[Password]
           ,[Question]
           ,[Answer]
           ,[Status]
           ,[HomePage]
           ,[UserName]
           ,[UID])
     VALUES
           ('Admin'
           ,'admin@college.com'
           ,'Admin@123'
           ,'Who is Admin?'
           ,'Admin'
           ,1
           ,'WelcomeAdmin.jsp'
           ,'admin'
           ,'12345')