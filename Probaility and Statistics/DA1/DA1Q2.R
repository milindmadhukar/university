# Problem 2: Collect data of at least 600 students/employees/others with four
# different columns and
# (a) analyze the data by using descriptive statistics
# (b) Plot the said columns combinations with bar diagrams, pie and curved
# graph’s (Ref. Table and Graphical Representations material)

data <- read.delim("./fake_student_data.csv", header = TRUE, sep = ",")

roll_number <- data$roll_number
math_marks <- data$math_marks
science_marks <- data$science_marks
english_marks <- data$english_marks
height_in_cm <- data$height_in_cm

mean_math_marks <- mean(math_marks)

median_math_marks <- median(math_marks)

math_marks_table <- table(math_marks)
mode_math_marks_idx <- which(math_marks_table == max(math_marks_table))
mode_math_marks <- names(math_marks_table)[mode_math_marks_idx]

var_math_marks <- var(math_marks)
sd_math_marks <- sd(math_marks)

cov_math_marks <- (sd_math_marks / mean_math_marks) * 100

print(paste("Mean Math Marks: ", mean_math_marks))
print(paste("Median Math Marks: ", median_math_marks))
print(paste("Mode Math Marks: ", mode_math_marks))
print(paste("Variance Math Marks: ", var_math_marks))
print(paste("Standard Deviation Math Marks: ", sd_math_marks))
print(paste("Coefficient of Variation Math Marks: ", cov_math_marks))


mean_science_marks <- mean(science_marks)

median_science_marks <- median(science_marks)

science_marks_table <- table(science_marks)
mode_science_marks_idx <- which(science_marks_table == max(science_marks_table))
mode_science_marks <- names(science_marks_table)[mode_science_marks_idx]

var_science_marks <- var(science_marks)
sd_science_marks <- sd(science_marks)

cov_science_marks <- (sd_science_marks / mean_science_marks) * 100

print(paste("Mean Science Marks: ", mean_science_marks))
print(paste("Median Science Marks: ", median_science_marks))
print(paste("Mode Science Marks: ", mode_science_marks))
print(paste("Variance Science Marks: ", var_science_marks))
print(paste("Standard Deviation Science Marks: ", sd_science_marks))
print(paste("Coefficient of Variation Science Marks: ", cov_science_marks))




mean_english_marks <- mean(english_marks)

median_english_marks <- median(english_marks)

english_marks_table <- table(english_marks)
mode_english_marks_idx <- which(english_marks_table == max(english_marks_table))
mode_english_marks <- names(english_marks_table)[mode_english_marks_idx]

var_english_marks <- var(english_marks)
sd_english_marks <- sd(english_marks)

cov_english_marks <- (sd_english_marks / mean_english_marks) * 100

print(paste("Mean English Marks: ", mean_english_marks))
print(paste("Median English Marks: ", median_english_marks))
print(paste("Mode English Marks: ", mode_english_marks))
print(paste("Variance English Marks: ", var_english_marks))
print(paste("Standard Deviation English Marks: ", sd_english_marks))
print(paste("Coefficient of Variation English Marks: ", cov_english_marks))


mean_height_in_cm <- mean(height_in_cm)

median_height_in_cm <- median(height_in_cm)

height_in_cm_table <- table(height_in_cm)
mode_height_in_cm_idx <- which(height_in_cm_table == max(height_in_cm_table))
mode_height_in_cm <- names(height_in_cm_table)[mode_height_in_cm_idx]

var_height_in_cm <- var(height_in_cm)
sd_height_in_cm <- sd(height_in_cm)

cov_height_in_cm <- (sd_height_in_cm / mean_height_in_cm) * 100

print(paste("Mean Height in cm: ", mean_height_in_cm))
print(paste("Median Height in cm: ", median_height_in_cm))
print(paste("Mode Height in cm: ", mode_height_in_cm))
print(paste("Variance Height in cm: ", var_height_in_cm))
print(paste("Standard Deviation Height in cm: ", sd_height_in_cm))
print(paste("Coefficient of Variation Height in cm: ", cov_height_in_cm))

plot(
  data$math_marks,
  type = "l",
  main = "Math Marks",
  xlab = "roll_number",
  ylab = "math_marks"
)

plot(
  data$science_marks,
  type = "l",
  main = "Science Marks",
  xlab = "roll_number",
  ylab = "science_marks"
)

plot(
  data$english_marks,
  type = "l",
  main = "English Marks",
  xlab = "roll_number",
  ylab = "english_marks"
)

plot(
  data$height_in_cm,
  type = "l",
  main = "Height in cm",
  xlab = "roll_number",
  ylab = "height_in_cm"
)

gender_table <- table(data$gender)
pie(gender_table)

table1 <- table(data$gender, data$course)
barplot(
  table1,
  beside = TRUE,
  xlim = c(1, 15),
  ylim = c(0, 300),
  col = c("blue", "red"),
  legend = rownames(table1)
)

boxplot(
  data$roll_number ~ data$course,
  col = c("red", "blue")
)
