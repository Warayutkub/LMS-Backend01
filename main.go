package main

import (
	"log"
	"os"
	"sk_backend/database"
	"sk_backend/routes"

	"github.com/gofiber/fiber/v2"
	"github.com/joho/godotenv"
)

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
}