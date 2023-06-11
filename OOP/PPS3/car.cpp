// 6. Create a class called "Car" with attributes "make", "model", and "year". Create an object of
// the class and print out its attributes.


#include <iostream>
using namespace std;

class Car {
    private:
        string make;
        string model;
        int year;

    public:
        Car(string make, string model, int year) {
            if(year < 0) {
                cout << "Invalid." << endl;
                exit(0);
            }
            this->make = make;
            this->model = model;
            this->year = year;
        }

        string getMake() {
            return make;
        }

        string getModel() {
            return model;
        }

        int getYear() {
            return year;
        }
};

int main() {
    Car car1("Toyota", "Camry", 2022);
    cout << "Make: " << car1.getMake() << ", Model: " << car1.getModel() << ", Year: " << car1.getYear() << endl;

    Car car2("Honda", "Verna", 2021);
    cout << "Make: " << car2.getMake() << ", Model: " << car2.getModel() << ", Year: " << car2.getYear() << endl;

    Car car3("Suzuki", "swift", 2020);
    cout << "Make: " << car3.getMake() << ", Model: " << car3.getModel() << ", Year: " << car3.getYear() << endl;

    Car car4("Suzuki", "Swift", -2020);  // Output: Invalid.
    return 0;
}
