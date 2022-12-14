create database QLDaoTao
go
USE [QLDaoTao]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 10/26/2020 10:53:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MaSV] [nchar](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Gioitinh] [bit] NULL,
	[Email] [nvarchar](50) NULL,
	[DienThoai] [nvarchar](15) NULL,
	[DiaChi] [nvarchar](100) NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 10/26/2020 10:53:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[TenDangNhap] [nvarchar](20) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[VaiTro] [nvarchar](50) NULL,
 CONSTRAINT [PK_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'admin1', N'admin123', N'CanBoDaoTao')
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'admin2', N'admin123', N'GiangVien')
INSERT [dbo].[NguoiDung] ([TenDangNhap], [MatKhau], [VaiTro]) VALUES (N'admin3', N'admin123', N'GiangVien')
/****** Object:  Table [dbo].[BangDiem]    Script Date: 10/26/2020 10:53:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangDiem](
	[MaSo] [int] IDENTITY(1,1) NOT NULL,
	[MaSV] [nchar](10) NULL,
	[TiengAnh] [float] NULL,
	[TinHoc] [float] NULL,
	[GDTC] [float] NULL,
 CONSTRAINT [PK_BangDiem] PRIMARY KEY CLUSTERED 
(
	[MaSo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_BangDiem_SinhVien]    Script Date: 10/26/2020 10:53:36 ******/
ALTER TABLE [dbo].[BangDiem]  WITH CHECK ADD  CONSTRAINT [FK_BangDiem_SinhVien] FOREIGN KEY([MaSV])
REFERENCES [dbo].[SinhVien] ([MaSV])
GO
ALTER TABLE [dbo].[BangDiem] CHECK CONSTRAINT [FK_BangDiem_SinhVien]
GO
