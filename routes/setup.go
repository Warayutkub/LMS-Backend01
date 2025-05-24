package routes

import "github.com/gofiber/fiber/v2"

func Setup(app *fiber.App) {
	Student_route(app)
	Course_route(app)
}