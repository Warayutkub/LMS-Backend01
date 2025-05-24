package database

import (
	"fmt"
	"github.com/joho/godotenv"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
	"log"
	"os"
	"sk_backend/models"
)

var DB *gorm.DB

func Connect() {
	err := godotenv.Load()
	if err != nil {
		log.Println("Warning: .env file not found or error loading")
	}

	dsn := os.Getenv("db_link")

	db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})
	if err != nil {
		log.Fatalf("❌ failed to connect database: %v", err)
	}

	//AutoMigrate 
	err = db.AutoMigrate(
		&models.Student{},
		&models.Course{})
	if err != nil {
		log.Fatalf("❌ failed to migrate: %v", err)
	}

	DB = db
	fmt.Println("✅ Database connected and migrated")
}
