USE [Vivero]
GO
/****** Object:  User [JorgeLiy512]    Script Date: 24/07/2020 07:41:14 p. m. ******/
CREATE USER [JorgeLiy512] FOR LOGIN [JorgeLiy512] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_datareader] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [JorgeLiy512]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [JorgeLiy512]
GO
/****** Object:  Table [dbo].[Calendario]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Calendario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_producto] [int] NOT NULL,
	[fecha_riedo] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Dia]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dia] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Historial]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Historial](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_producto] [int] NOT NULL,
	[fecha] [nvarchar](20) NOT NULL,
	[fotografia] [nvarchar](50) NULL,
 CONSTRAINT [PK__Historia__3213E83FC96C1134] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Producto]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[id_tipo] [int] NULL,
	[condicion] [nvarchar](50) NULL,
	[fecha_ingreso] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Riego]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Riego](
	[id_producto] [int] NOT NULL,
	[id_dia] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tipo]    Script Date: 24/07/2020 07:41:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Calendario] ON 

INSERT [dbo].[Calendario] ([id], [id_producto], [fecha_riedo]) VALUES (2, 5, N'Jorge')
INSERT [dbo].[Calendario] ([id], [id_producto], [fecha_riedo]) VALUES (3, 2, N'2019-07-20')
INSERT [dbo].[Calendario] ([id], [id_producto], [fecha_riedo]) VALUES (5, 1, N'2019-07-27')
SET IDENTITY_INSERT [dbo].[Calendario] OFF
SET IDENTITY_INSERT [dbo].[Dia] ON 

INSERT [dbo].[Dia] ([id], [dia]) VALUES (1, N'Lunes')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (2, N'Martes')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (3, N'Miercoles')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (4, N'Jueves')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (5, N'Viernes')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (6, N'Sabado')
INSERT [dbo].[Dia] ([id], [dia]) VALUES (7, N'Domingo')
SET IDENTITY_INSERT [dbo].[Dia] OFF
SET IDENTITY_INSERT [dbo].[Historial] ON 

INSERT [dbo].[Historial] ([id], [id_producto], [fecha], [fotografia]) VALUES (1, 1, N'2019-07-26', N'Imagenes/1.png')
INSERT [dbo].[Historial] ([id], [id_producto], [fecha], [fotografia]) VALUES (3, 1, N'2019-07-26', N'Imagenes/3.png')
INSERT [dbo].[Historial] ([id], [id_producto], [fecha], [fotografia]) VALUES (5, 1, N'2019-07-28', N'Imagenes/5.png')
SET IDENTITY_INSERT [dbo].[Historial] OFF
SET IDENTITY_INSERT [dbo].[Producto] ON 

INSERT [dbo].[Producto] ([id], [nombre], [id_tipo], [condicion], [fecha_ingreso]) VALUES (1, N'Rosa', 1, N'Buen estado', N'2019-07-24')
INSERT [dbo].[Producto] ([id], [nombre], [id_tipo], [condicion], [fecha_ingreso]) VALUES (2, N'Sakura', 2, N'Mal estado', N'2019-07-27')
SET IDENTITY_INSERT [dbo].[Producto] OFF
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (1, 2)
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (1, 5)
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (1, 6)
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (2, 1)
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (2, 7)
INSERT [dbo].[Riego] ([id_producto], [id_dia]) VALUES (1, 7)
SET IDENTITY_INSERT [dbo].[Tipo] ON 

INSERT [dbo].[Tipo] ([id], [tipo]) VALUES (1, N'Flor')
INSERT [dbo].[Tipo] ([id], [tipo]) VALUES (2, N'Arbol')
INSERT [dbo].[Tipo] ([id], [tipo]) VALUES (3, N'Desertica')
SET IDENTITY_INSERT [dbo].[Tipo] OFF
