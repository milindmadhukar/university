
#include <iostream>
#include <string>

template <typename T>
class Character {
private:
    std::string name;
    T health;
    T attack;
    T defense;

public:
    Character(const std::string& name, const T& health, const T& attack, const T& defense)
        : name(name), health(health), attack(attack), defense(defense) {}

    void showValues() const {
        std::cout << "Name: " << name << std::endl;
        std::cout << "Health: " << health << std::endl;
        std::cout << "Attack: " << attack << std::endl;
        std::cout << "Defense: " << defense << std::endl;
    }

    void changeHealth(const T& value) {
        health += value;
    }

    void modifyAttack(const T& value) {
        attack += value;
    }

    void modifyDefense(const T& value) {
        defense += value;
    }
};

int main() {
    Character<int> hero("Hero", 100, 10, 5);
    hero.showValues();

    std::cout << "Health: ";
    hero.changeHealth(-50);
    hero.showValues();

    std::cout << "Attack: ";
    hero.modifyAttack(5);
    hero.showValues();

    return 0;
}
