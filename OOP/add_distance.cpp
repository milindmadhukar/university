// Add two distances in inch-feet by creating a class named 'AddDistance'.

#include <iostream>
using namespace std;

class AddDistance {
public:
  int feet;
  int inches;
  // Constructor
  AddDistance() {
    feet = 0;
    inches = 0;
  }

  // Setter method to set feet and inches
  void setDistance(int ft, int in) {
    feet = ft;
    inches = in;
  }

  // Getter method to get feet and inches
  void getDistance() {
    cout << "Distance: " << feet << " feet " << inches << " inches" << endl;
  }

  // Operator overloading to add two distances
};

AddDistance add (AddDistance d1, AddDistance d2) {
  AddDistance result;
  result.feet = d1.feet + d2.feet;
  result.inches = d1.inches + d2.inches;
  if (result.inches >= 12) {
    result.feet += result.inches / 12;
    result.inches = result.inches % 12;
  }
  return result;
}

int main() {
  AddDistance d1, d2, sum;
  d1.setDistance(5, 6);
  d2.setDistance(3, 10);
  sum = add(d1, d2);
  sum.getDistance();
  return 0;
}
