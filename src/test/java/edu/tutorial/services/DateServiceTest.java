package edu.tutorial.services;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class DateServiceTest {

    private DateService dateService;

    @BeforeEach
    void setUp() {
        System.out.println("Running DateService Test");
        dateService = new DateService();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Ending DateService Test");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running before all DateService Tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Running after all DateService Tests");
    }

    @Test
    void getDateCorrectly() {
        Date currentDate = dateService.getCurrentDate();

        assertNotNull(currentDate);
//        assertEquals(new Date(), currentDate);
    }

    @Test
    void getDateParsedCorrectly() {
        LocalDate dateParsed = dateService.getDateParsed("2021-01-01", "yyyy-MM-dd");

        assertNotNull(dateParsed);

        assertEquals(1, dateParsed.getDayOfMonth());

    }

    @Test
    void getDateNotThrows() {
        assertDoesNotThrow(() -> dateService.getDateParsed("2021-01-01", "yyyy-MM-dd"));
        assertThrows(DateTimeParseException.class, () -> dateService.getDateParsed("2021-01-01", "yyy-MM-dd-"));
    }
}