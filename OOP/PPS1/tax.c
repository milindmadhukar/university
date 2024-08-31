// Calculate tax given the following conditions: If income is less than or equal to 1,50,000 then no tax If taxable income is 1,50,001 – 3,00,000 then charge 10% tax for the remaining slab If taxable income is 3,00,001 – 5,00,000 then charge 20% tax for the remaining slab If taxable income is above 5,00,001 then charge 30% tax for the remaining slab


#include <stdio.h>

int main() {
    int income, tax;
    scanf("%d", &income);

    if (income <= 150000) {
        tax = 0;
    } else if (income <= 300000) {
        tax = (income - 150000) * 0.1;
    } else if (income <= 500000) {
        tax = 15000 + (income - 300000) * 0.2;
    } else {
        tax = 45000 + (income - 500000) * 0.3;
    }

    tax ? printf("%d", tax): ;

    return 0;
}
