Create table Account(
	Id int identity(1,1), 
	username nvarchar(50) Primary Key,
	password nvarchar(50),
	displayName nvarchar(150),
	email varchar(150),
	phone varchar(50)
)

Create Table MonHoc
 (
   MaMH char(5) primary key,
   TenMH nvarchar(30) not null,
   SoTrinh int not null check ( (SoTrinh>0)and (SoTrinh<7) ),
   Id int
 )

Create Table HeDT
 (
   MaHeDT char(5) primary key,
   TenHeDT nvarchar(40) not null
 )


Create Table KhoaHoc
 (
   MaKhoaHoc char(5) primary key,
   TenKhoaHoc nvarchar(20) not null
 )

Create Table Khoa
 (
   MaKhoa char(5) primary key,
   TenKhoa nvarchar(30) not null,
   DiaChi nvarchar(100) not null,
   DienThoai varchar(20) not null
 )

Create Table Lop
 (
   MaLop char(5) primary key,
   TenLop nvarchar(30) not null,
   MaKhoa char(5) foreign key references Khoa (MaKhoa),
   MaHeDT char(5) foreign key references HeDT (MaHeDT),
   MaKhoaHoc char(5) foreign key references KhoaHoc (MaKhoaHoc),
 )

Create Table SinhVien
 (
   MaSV char(15) primary key,
   TenSV nvarchar(20) ,
   GioiTinh bit ,
   NgaySinh datetime ,
   QueQuan nvarchar(50) ,
   MaLop char(5) foreign key references Lop(MaLop),
   Phone varchar(50),
   Email varchar(50),
   accountId int
 )

Create Table Diem
 (
   MaSV char(15) foreign key references SinhVien(MaSV),
   MaMH char(5) foreign key references MonHoc (MaMH),
   HocKy int check(HocKy>0) not null,
   DiemLan1 int ,
   DiemLan2 int
)

insert into Account values ('viet01','123456',N'Bùi Việt','viet01@gmail.com','0987654321','ADMIN')
insert into Account values ('viet02','123456',N'Bùi Việt 1','viet02@gmail.com','0987654322','ADMIN')
insert into Account values ('viet03','123456',N'Bùi Việt 2','viet03@gmail.com','0987654323','ADMIN')
insert into Account values ('viet04','123456',N'Bùi Việt 3','viet04@gmail.com','0987654324','ADMIN')
insert into Account values ('viet05','123456',N'Bùi Việt 4','viet05@gmail.com','0987654325','ADMIN')
insert into Account values ('viet06','123456',N'Bùi Việt 5','viet06@gmail.com','0987654321','ADMIN')
insert into Account values ('viet07','123456',N'Bùi Việt 6','viet07@gmail.com','0987654326','ADMIN')
insert into Account values ('viet08','123456',N'Bùi Việt 7','viet08@gmail.com','0987654327','ADMIN')
insert into Account values ('viet09','123456',N'Bùi Việt 8','viet09@gmail.com','0987654328','USER')
insert into Account values ('viet10','123456',N'Bùi Việt 9','viet10@gmail.com','0987654329','USER')
insert into Account values ('viet11','123456',N'Bùi Việt 10','viet11@gmail.com','0987654320','USER')
insert into Account values ('viet12','123456',N'Bùi Việt 11','viet12@gmail.com','0987654342','USER')
insert into Account values ('viet13','123456',N'Bùi Việt 12','viet13@gmail.com','0987654331','USER')
insert into Account values ('viet14','123456',N'Bùi Việt 13','viet14@gmail.com','0987654333','USER')
insert into Account values ('viet015','123456',N'Bùi Việt 14','viet15@gmail.com','0987654334','USER')

insert into HeDT values('A01',N'Ðại Học')
insert into HeDT values('B01',N'Cao Ðẳng')
insert into HeDT values('C01',N'Trung Cấp')
insert into HeDT values('D01',N'Công nhân')

insert into KhoaHoc values('K1',N'Ðại học khóa 1')
insert into KhoaHoc values('K2',N'Ðại học khóa 2')
insert into KhoaHoc values('K3',N'Ðại học khóa 3')
insert into KhoaHoc values('K9',N'Ðại học khóa 4')
insert into KhoaHoc values('K10',N'Ðại học khóa 5')
insert into KhoaHoc values('K11',N'Ðại học khóa 6')

insert into Khoa values('CNTT',N'Công nghệ thông tin',N'Tầng 4 nhà B','043768888')
insert into Khoa values('CK',N'Cõ Khí',N'Tầng 5 nhà B','043768888')
insert into Khoa values('DT',N'Ðiện tử',N'Tằng 6 nhà B','043768888')
insert into Khoa values('KT',N'Kinh Tế',N'Tầng 2 nhà C','043768888')

insert into Lop values('MT1',N'MÁy Tính 1','CNTT','A01','K2')
insert into Lop values('MT2',N'MÁy Tính 2','CNTT','A01','K2')
insert into Lop values('MT3',N'MÁy Tính 3','CNTT','A01','K2')
insert into Lop values('MT4',N'MÁy Tính 4','CNTT','A01','K2')
insert into Lop values('KT1',N'Kinh tế 1','KT','A01','K2')

insert into SinhVien values('0241060218',N'Nguyễn Minh Một',1,'08/27/1989','Hải Dýõng','MT3','0914162614','lethuythdkt1@gmail.com',1)
insert into SinhVien values('0241060318',N'Nguyễn Minh Hai',1,'2/08/1989','Nam Dinh','MT1','0914162611','lethuythdkt2@gmail.com',2)
insert into SinhVien values('0241060418',N'Nguyễn Minh Ba',1,'7/04/1989','Ninh Binh','MT2','0914162612','lethuythdkt3@gmail.com',3)
insert into SinhVien values('0241060518',N'Nguyễn Minh Bốn',1,'7/08/1989','Ninh Binh','MT1','0914162613','lethuythdkt4@gmail.com',4)
insert into SinhVien values('0241060618',N'Nguyễn Minh Nãm',0,'7/08/1989','Nam Dinh','MT3','0914162644','lethuythdkt5@gmail.com',5)
insert into SinhVien values('0241060718',N'Nguyễn Minh Sáu',1,'7/08/1989','Ha Noi','MT3','0914162615','lethuythdkt6@gmail.com',6)
insert into SinhVien values('0241060818',N'Nguyễn Minh Bảy',1,'7/08/1989','Ha Noi','MT3','0914162616','lethuythdkt7@gmail.com',7)
insert into SinhVien values('0241060918',N'Nguyễn Minh Tám',1,'7/08/1989','Hai Duong','MT2','0914162617','lethuythdkt8@gmail.com',8)
insert into SinhVien values('0241060128',N'Nguyễn Minh Chín',1,'7/08/1989','Hai Duong','MT2','0914162618','lethuythdkt9@gmail.com',9)
insert into SinhVien values('0241060138',N'Nguyễn Minh Mýời',1,'7/08/1989','Ha Nam','MT2','0914162619','lethuythdkt29@gmail.com',10)
insert into SinhVien values('0241060148',N'Nguyễn Minh Mýời Một',0,'7/08/1989','Bac Giang','MT4','0914162620','lethuythdkt10@gmail.com',11)
insert into SinhVien values('0241060158',N'Nguyễn Minh Mýời Hai',0,'7/08/1989','Ha Noi','MT4','0914162621','lethuythdkt11@gmail.com',12)
insert into SinhVien values('0241060168',N'Nguyễn Minh Mýời Ba',1,'7/08/1989','Hai Duong','MT4','0914162622','lethuythdkt12@gmail.com',13)
insert into SinhVien values('0241060178',N'Nguyễn Minh Mýời Bốn',1,'7/08/1989','Nam Dinh','MT1','0914162623','lethuythdkt13@gmail.com',14)
insert into SinhVien values('0241060978',N'Nguyễn Minh Mýời Nãm',1,'7/08/1989','Nam Dinh','KT1','0914162623','lethuythdkt14@gmail.com',15)

insert into MonHoc values('SQL','SQL',5,1)
insert into MonHoc values('JV','Java',6,2)
insert into MonHoc values('CNPM',N'Công Nghệ phần mềm',4,3)
insert into MonHoc values('PTHT',N'Phân tích hệ thống',4,4)
insert into MonHoc values('Mang',N'Mạng máy tính',5,5)


insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060218','SQL',5,7)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060418','SQL',5,6)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060218','CNPM',5,8)
insert into Diem values('0241060518','SQL',5,4,6)
insert into Diem values('0241060218','Mang',5,4,5)
insert into Diem values('0241060218','JV',5,4,4)
insert into Diem values('0241060518','JV',5,4,6)
insert into Diem values('0241060218','PTHT',4,2,5)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060318','SQL',4,9)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060618','SQL',4,8)
insert into Diem values('0241060318','Mang',5,3,4)
insert into Diem values('0241060418','Mang',5,4,4)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060518','Mang',5,8)



Select * from Diem
Select * from HeDT
Select * from Khoa
Select * from KhoaHoc
Select * from Lop
Select * from MonHoc
Select * from SinhVien

