package models

import "time"

type Student struct {
	Id           uint64 `gorm:"primaryKey;usnique"`
	First_Name   string
	Last_Name    string 
	Nick_Name    string
	Graduation   string
	School       string
	Address      string
	Parent_Name  string
	Parent_Phone string
	Date_Create  time.Time `gorm:"autoCreateTime"` // สร้างอัตโนมัติเมื่อมีการเพิ่มข้อมูล
	Recent_Update time.Time `gorm:"autoUpdateTime"` // อัพเดตอัตโนมัติเมื่อมีการแก้ไขข้อมูล
}
