package main

import (
	"fmt"
	"log"
	"os"
	"sk_backend/database"
	"sk_backend/routes"

	"github.com/gofiber/fiber/v2"
	"github.com/joho/godotenv"
)

// db_link = "postgresql://postgres:student_sk_2568@db.okajavimvarrgxpcztqc.supabase.co:5432/postgres"
// port = ":2568"
func main() {

	err := godotenv.Load()
	if err != nil {
		log.Println("Warning: .env file not found or error loading")
	}

	database.Connect()
	
	app := fiber.New()

	routes.Setup(app)

	port := os.Getenv("port")
	log.Fatal(app.Listen(port))
	fmt.Print("Hello")
}