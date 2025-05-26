package models

import "time"

type Transaction struct {
	Id            uint64             `gorm:"primaryKey;unique"`
	Seller        string             `gorm:"not null"`
	Student_id    uint64             `gorm:"not null"`
	Courses       []Course           `gorm:"many2many:transaction_courses;"`
	Detail_Bills  []DetailBillCourse `gorm:"foreignKey:Transaction_Id"`
	Type_paid     string             `gorm:"not null"`
	Discount      float64            `gorm:"default:0"`
	Total_price   float64            `gorm:"not null"`
	Date_Create   time.Time          `gorm:"autoCreateTime"` // สร้างอัตโนมัติเมื่อมีการเพิ่มข้อมูล
	Recent_Update time.Time          `gorm:"autoUpdateTime"` // อัพเดตอัตโนมัติเมื่อมีการแก้ไขข้อมูล
}
