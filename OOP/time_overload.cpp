#include <iostream>

class Time {
private:
  int hours;
  int minutes;
  int seconds;

public:
  bool operator==(const Time &other) const {
    return (hours == other.hours && minutes == other.minutes &&
            seconds == other.seconds);
  }

  friend std::istream &operator>>(std::istream &input, Time &t) const {
    input >> t.hours >> t.minutes >> t.seconds;
    return input;
  }

  friend std::ostream &operator<<(std::ostream &output, const Time &t) {
    output << t.hours << ":" << t.minutes << ":" << t.seconds;
    return output;
  }
};

int main() {
  Time t1, t2;

  std::cout << "Enter time t1 (hours minutes seconds): ";
  std::cin >> t1;

  std::cout << "Enter time t2 (hours minutes seconds): ";
  std::cin >> t2;

  std::cout << "Time t1: " << t1 << std::endl;
  std::cout << "Time t2: " << t2 << std::endl;

  if (t1 == t2) {
    std::cout << "Time t1 and t2 are the same." << std::endl;
  } else {
    std::cout << "Time t1 and t2 are different." << std::endl;
  }

  return 0;
}
