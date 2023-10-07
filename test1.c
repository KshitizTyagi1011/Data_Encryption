#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool matchSymbol(char *str, int *index, char symbol) {
    if (str[*index] == symbol) {
        (*index)++;
        return true;
    }
    return false;
}

bool matchRule(char *str, int *index) {
    int savedIndex = *index; 
    if (matchSymbol(str, index, 'a') && matchRule(str, index) && matchSymbol(str, index, 'b')) {
        return true;
    }

    *index = savedIndex;
    if (matchSymbol(str, index, 'a')) {
        return true;
    }
    return false;
}

bool isValidString(char *str) {
    int index = 0;
    return str[0] != '\0' && matchRule(str, &index) && str[index] == '\0';
}

int main() {
    char str[100];
    printf("Input: ");
    scanf("%[^\n]s", str); 
    
    if (isValidString(str)) {
        printf("Output: Valid\n");
    } else {
        printf("Output: Invalid\n");
    }
    
    return 0;
}
