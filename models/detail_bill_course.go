package models

type DetailBillCourse struct {
	Id             uint64 `gorm:"primaryKey;unique"`
	Transaction_Id uint64 `gorm:"not null"`
	Course_Id      uint64 `gorm:"not null"`
	Amount         int    `gorm:"not null"`
	Detail         string `gorm:"not null"`
}
