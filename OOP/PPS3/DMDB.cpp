// 3. Create two classes DM and DB. DM stores the distance in meters and centimetres and
// DB Stores the distance in feet and inches. Write a program to read the values for the class
// objects and Add one object DM with another object DB. Note: use a friend function to
// carry out addition operation. The resultant object is stored in DM and display it.
// 1 feet = 30 centimetres
// 1 inch =2.54 centimetres
// 1 meter = 100 centimetres 

#include<iostream>

class DB;

class DM {
    private:
        int meter;
        float centimeter;
    
    public:
        void setdata() {
            std::cout << "Enter the value in meter and centimeter:" << std::endl;
            std::cout << "Enter meter value : ";
            std::cin >> meter;
            std::cout << "Enter centimeter value: ";
            std::cin >> centimeter;
        }
        friend DM add(DM, DB);
        friend void display(DM);
};

class DB {
    private:
        int feet;
        float inches;
    
    public:
        void setdata() {
            std::cout << "Enter the value in feet and inches:" << std::endl;
            std::cout << "Enter feet value : ";
            std::cin >> feet;
            std::cout << "Enter inches value : ";
            std::cin >> inches;
        }
        friend DM add(DM, DB);
};

DM add(DM obj1, DB obj2) {
    DM result;
    float centimeter1 = obj1.meter * 100 + obj1.centimeter;
    float centimeter2 = obj2.feet * 30 + obj2.inches * 2.54;
    float totalCentimeter = centimeter1 + centimeter2;
    result.meter = (int)totalCentimeter / 100;
    result.centimeter = (int)totalCentimeter % 100;
    return result;
}

void display(DM obj) {
    std::cout << "The summed value in meter is: " << obj.meter + (float)obj.centimeter/100.0 << std::endl;
}

int main() {
    DM obj1;
    DB obj2;
    obj1.setdata();
    obj2.setdata();
    DM result = add(obj1, obj2);
    display(result);
    return 0;
}
