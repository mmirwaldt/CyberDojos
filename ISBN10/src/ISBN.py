import re


class ISBN:

    def validate(self, isbn_str):
        onlyDigits = re.sub("\D", "", isbn_str)
        if len(onlyDigits) == 9 and isbn_str[len(isbn_str) - 1] == 'X':
            if self.calc(onlyDigits) == 10:
                return "valid"
        if len(onlyDigits) == 10:
            if self.calc(onlyDigits) == 0:
                return "valid"
        return "invalid"

    def calc(self, onlyDigits):
        digit_list = [int(a) for a in onlyDigits]
        sum_digit = 0
        position = 1
        for digit in digit_list:
            sum_digit += position * digit
            position += 1
        return sum_digit % 11
