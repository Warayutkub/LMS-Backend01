package routes

import (
	"github.com/gofiber/fiber/v2"
	"sk_backend/controllers"
)

func Student_route(app *fiber.App) {
	app.Post("/student",controllers.Create_student)
	app.Get("student",controllers.Get_students)
	app.Get("student/:id",controllers.Get_student)
	app.Put("student/:id",controllers.Update_student)
	app.Delete("student/:id",controllers.Delete_student)
}