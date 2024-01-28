import csv
from faker import Faker
import random

fake = Faker()


def generate_fake_data(num_students):
    data = []
    for idx in range(num_students):
        roll_number = idx + 1
        name = fake.name()
        gender = random.choice(["Male", "Male", "Male", "Female", "Female"])
        course = random.choice(
            ["B.Tech", "B.Tech", "B.Tech", "M.Tech", "M.Tech", "PhD"],
        )
        math_mark = random.randint(30, 100)
        science_mark = random.randint(40, 100)
        english_mark = random.randint(50, 100)
        height = round(random.uniform(150, 190), 2)  # Height in centimeters

        data.append(
            [
                roll_number,
                name,
                gender,
                course,
                math_mark,
                science_mark,
                english_mark,
                height,
            ]
        )

    return data


def write_to_csv(data, filename):
    with open(filename, "w", newline="") as csvfile:
        csv_writer = csv.writer(csvfile)
        csv_writer.writerow(
            [
                "roll_number",
                "name",
                "gender",
                "course",
                "math_marks",
                "science_marks",
                "english_marks",
                "height_in_cm",
            ]
        )
        csv_writer.writerows(data)


if __name__ == "__main__":
    num_students = 600  # Change this value to generate more or fewer student records
    fake_data = generate_fake_data(num_students)
    csv_filename = "fake_student_data.csv"
    write_to_csv(fake_data, csv_filename)
    print(f"Fake student data has been generated and saved to {csv_filename}.")
