package controllers

import (
	"sk_backend/database"
	"sk_backend/models"

	"github.com/gofiber/fiber/v2"
)

func Create_student(c *fiber.Ctx) error {
	student := new(models.Student)
	if err := c.BodyParser(student); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
			"error": "Invalid request body",
		})
	}

	// create student in DB
	if err := database.DB.Create(student).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to create student",
		})
	}

	return c.Status(fiber.StatusCreated).JSON(student)
}

func Get_students(c *fiber.Ctx) error {
	var students []models.Student
	if err := database.DB.Find(&students).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to fetch students",
		})
	}
	return c.JSON(students)
}

func Get_student(c *fiber.Ctx) error {
	id := c.Params("id")
	var student models.Student

	if err := database.DB.First(&student, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "student not found",
		})
	}

	return c.JSON(student)
}

func Update_student(c *fiber.Ctx) error {
	id := c.Params("id")

	var student models.Student

	if err := database.DB.First(&student, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "Student not found",
		})
	}

	var updatedData models.Student
	if err := c.BodyParser(&updatedData); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
			"error": "Cannot parse JSON",
		})
	}

	student.First_Name = updatedData.First_Name
	student.Last_Name = updatedData.Last_Name
	student.Nick_Name = updatedData.Nick_Name
	student.Graduation = updatedData.Graduation
	student.School = updatedData.School
	student.Address = updatedData.Address
	student.Parent_Name = updatedData.Parent_Name
	student.Parent_Phone = updatedData.Parent_Phone

	// Save ลง DB
	if err := database.DB.Save(&student).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to update student",
		})
	}

	return c.JSON(student)
}

func Delete_student(c *fiber.Ctx) error {
	id := c.Params("id")

	var student models.Student

	// ค้นหา record ก่อนลบ
	if err := database.DB.First(&student, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "Student not found",
		})
	}

	// ลบข้อมูล
	if err := database.DB.Delete(&student).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to delete student",
		})
	}

	return c.JSON(fiber.Map{
		"message": "Student deleted successfully",
	})
}