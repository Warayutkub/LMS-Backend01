package models

import "time"

type Course struct {
	Id            uint64 `gorm:"primaryKey;unique:"`
	Name          string
	Price         float64
	Date_Create   time.Time `gorm:"autoCreateTime"` // สร้างอัตโนมัติเมื่อมีการเพิ่มข้อมูล
	Recent_Update time.Time `gorm:"autoUpdateTime"` // อัพเดตอัตโนมัติเมื่อมีการแก้ไขข้อมูล
}