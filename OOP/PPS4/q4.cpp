#include <algorithm>
#include <iostream>

class Lecture {
private:
  int start;
  int end;

public:
  Lecture(int s, int e) : start(s), end(e) {}

  int getStart() const { return start; }

  int getEnd() const { return end; }

  bool operator<(const Lecture &other) const { return start < other.start; }
};

int findMinimumClassrooms(Lecture *lectures, int size) {
  std::sort(lectures, lectures + size); // Sort lectures based on start time

  int minClassrooms = 0;
  int *endTimes = new int[size]; // Store the end times of ongoing lectures

  for (int i = 0; i < size; i++) {
    const Lecture &lecture = lectures[i];

    // Check if any ongoing lecture ends before the current lecture starts
    auto it =
        std::find_if(endTimes, endTimes + minClassrooms, [&](int endTime) {
          return endTime <= lecture.getStart();
        });

    if (it != endTimes + minClassrooms) {
      // Found an ongoing lecture that ends before the current lecture starts,
      // reuse the classroom for the current lecture
      *it = lecture.getEnd();
    } else {
      // No available classroom, need to allocate a new one
      endTimes[minClassrooms] = lecture.getEnd();
      minClassrooms++;
    }
  }

  delete[] endTimes;

  return minClassrooms;
}

int main() {
  const int size1 = 3;
  Lecture lectures1[size1] = {Lecture(0, 5), Lecture(1, 2), Lecture(1, 10)};
  std::cout << "Minimum number of classrooms required: "
            << findMinimumClassrooms(lectures1, size1) << std::endl;

  const int size2 = 3;
  Lecture lectures2[size2] = {Lecture(0, 5), Lecture(1, 2), Lecture(6, 10)};
  std::cout << "Minimum number of classrooms required: "
            << findMinimumClassrooms(lectures2, size2) << std::endl;

  return 0;
}
