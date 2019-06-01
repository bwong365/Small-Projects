def main():
    number = None
    while not isinstance(number, int):
        try:
            number = int(input('Enter an integer: '))
        except ValueError:
            print('You must enter an integer!')

    while number != 1:
        number = collatz(number)


def collatz(number: int):
    if number % 2 == 0:
        result = number // 2
        print(result)
        return result

    result = 3 * number + 1
    print(result)
    return result


if __name__ == '__main__':
    main()
