INSERT ALL
    INTO ADDRESSES  VALUES (1,'4891 Pacific Hwy','San Diego','CA','92110','San Diego')
    INTO ADDRESSES  VALUES (2,'2400 N Jefferson St','Perry','FL','32347','Taylor')
    INTO ADDRESSES  VALUES (3,'710 N Cable Rd','Lima','OH','45825','Allen')
    INTO ADDRESSES  VALUES (4,'5108 W Gore Blvd','Lawton','OK','32365','Comanche')
    SELECT 1 FROM DUAL;

INSERT ALL
    INTO STUDENTS VALUES (1,'Timothy','timothy@gmail.com','123-123-1234','1988-04-25',NULL,NULL,3)
    INTO STUDENTS VALUES (2,'Douglas','douglas@gmail.com','789-456-1234','1990-08-15',NULL,NULL,4)
    SELECT 1 FROM DUAL;

INSERT ALL
    INTO TUTORS VALUES  (1,'John','john@gmail.com','111-222-3333','1980-05-20',NULL,NULL,1)
    INTO TUTORS VALUES  (2,'Ken','ken@gmail.com','111-222-3333','1980-05-20',NULL,NULL,1)
    INTO TUTORS VALUES  (3,'Paul','paul@gmail.com','123-321-4444','1981-03-15',NULL,NULL,2)
    INTO TUTORS  VALUES  (4,'Mike','mike@gmail.com','123-321-4444','1981-03-15',NULL,NULL,2)
    SELECT 1 FROM DUAL;

INSERT ALL
    INTO COURSES VALUES (1,'Quickstart Core Java','Core Java Programming','2013-03-01','2013-04-15',1) 
    INTO COURSES VALUES (2,'Quickstart JavaEE6','Enterprise App Development using JavaEE6','2013-04-01','2013-08-30',1) 
    INTO COURSES VALUES (3,'MyBatis3 Premier','MyBatis 3 framework','2013-06-01','2013-07-15',2) 
    SELECT 1 FROM DUAL;

INSERT ALL
    INTO COURSE_ENROLLMENT VALUES (1,1)
    INTO COURSE_ENROLLMENT VALUES (1,2)
    INTO COURSE_ENROLLMENT VALUES (2,2)
    SELECT 1 FROM DUAL;
    

SELECT * FROM students;
SELECT STUD_ID AS studId, name, email, dob, phone
FROM STUDENTS
WHERE stud_id = 1;

SELECT stud_id, name, email, dob, phone,
	substr(phone, 1, 3) AS f,
	substr(phone, 5, 3) AS m,
	substr(phone, 9, 3) AS l
FROM STUDENTS WHERE stud_id = 1;

INSERT INTO STUDENTS(STUD_ID, NAME, EMAIL, PHONE, DOB) VALUES(4, 'Banana', 'Banana@gmail.com', '010-1234-5678', sysdate);

SELECT STUD_ID, NAME, EMAIL, PHONE, DOB,  s.ADDR_ID, STREET, CITY, STATE, ZIP, COUNTRY
FROM STUDENTS s LEFT OUTER JOIN ADDRESSES a ON s.ADDR_ID = a.ADDR_ID
WHERE STUD_ID = 1;

SELECT t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
FROM TUTORS t LEFT OUTER JOIN COURSES c ON t.TUTOR_ID = c.TUTOR_ID
WHERE t.TUTOR_ID = 1;


SELECT * FROM STUDENTS s ;
DELETE students WHERE stud_id = 4;
