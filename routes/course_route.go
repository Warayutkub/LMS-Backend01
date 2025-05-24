package routes

import (
	"sk_backend/controllers"

	"github.com/gofiber/fiber/v2"
)

func Course_route(app *fiber.App) {
	app.Post("/course", controllers.Create_course)
	app.Get("course", controllers.Get_courses)
	app.Get("course/:id", controllers.Get_course)
	app.Put("course/:id", controllers.Update_course)
	app.Delete("course/:id", controllers.Delete_course)
}