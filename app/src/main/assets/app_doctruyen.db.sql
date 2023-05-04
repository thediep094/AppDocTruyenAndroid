BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Truyen" (
	"id"	INTEGER,
	"ten"	TEXT,
	"tagGia"	TEXT,
	"theLoai"	TEXT,
	"soChuong"	INTEGER,
	"noiDung"	TEXT,
	"image"	TEXT,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Chuong" (
	"id"	INTEGER,
	"idTruyen"	INTEGER,
	"soThuTu"	INTEGER,
	"ten"	TEXT,
	"noiDung"	TEXT,
	PRIMARY KEY("id"),
	FOREIGN KEY("id") REFERENCES "Truyen"("id")
);
CREATE TABLE IF NOT EXISTS "BinhLuan" (
	"id"	INTEGER,
	"truyen_id"	INTEGER,
	"tenND"	TEXT,
	"noiDung"	TEXT,
	PRIMARY KEY("id"),
	FOREIGN KEY("id") REFERENCES "Truyen"("id")
);
INSERT INTO "Truyen" VALUES (0,' Mộc Diệp: So sánh video, ngươi tái rồi toàn bộ giới Ninja?','Au Duong Phong','Đồng Nhân',20,' Mộc Diệp: So sánh video, ngươi tái rồi toàn bộ giới Ninja?','image1.jpg');
COMMIT;
