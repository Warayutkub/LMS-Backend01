package controllers

import (
	"sk_backend/database"
	"sk_backend/models"

	"github.com/gofiber/fiber/v2"
)

func Create_course(c *fiber.Ctx) error {
	course := new(models.Course)
	if err := c.BodyParser(course); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
			"error": "Invalid request body",
		})
	}

	// create course in db
	if err := database.DB.Create(course).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to create course",
		})
	}

	return c.Status(fiber.StatusCreated).JSON(course)
}

func Get_courses(c *fiber.Ctx) error {
	var courses []models.Course
	if err := database.DB.Find(&courses).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to fetch courses",
		})
	}
	return c.JSON(courses)
}

func Get_course(c *fiber.Ctx) error {
	id := c.Params("id")
	var course models.Course

	if err := database.DB.First(&course, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "course not found",
		})
	}

	return c.JSON(course)
}

func Update_course(c *fiber.Ctx) error {
	id := c.Params("id")

	var course models.Course

	if err := database.DB.First(&course, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "course not found",
		})
	}

	var updatedData models.Course
	if err := c.BodyParser(&updatedData); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
			"error": "Cannot parse JSON",
		})
	}

	course.Name = updatedData.Name
	course.Price = updatedData.Price

	// Save ลง DB
	if err := database.DB.Save(&course).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to update course",
		})
	}

	return c.JSON(course)
}

func Delete_course(c *fiber.Ctx) error {
	id := c.Params("id")

	var course models.Course

	// ค้นหา record ก่อนลบ
	if err := database.DB.First(&course, id).Error; err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": "course not found",
		})
	}

	// ลบข้อมูล
	if err := database.DB.Delete(&course).Error; err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": "Failed to delete course",
		})
	}

	return c.JSON(fiber.Map{
		"message": "course deleted successfully",
	})
}