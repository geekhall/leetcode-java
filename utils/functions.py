
def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        pass

    try:
        import unicodedata
        unicodedata.numeric(s)
        return True
    except (TypeError, ValueError):
        pass

    return False


def is_prime(self, n: int) -> bool:
    for i in range(2, n):
        if n % i == 0:
            return False
    return True


def prime_factor(self, num: int) -> list[int]:
    res = []
    tmp = num
    i = 2
    while i <= tmp:
        if tmp % i == 0 and is_prime(i):
            res.append(i)
            tmp = tmp / i
            i = 2
        else:
            i += 1
    return res


def test_prime():
    while True:
        try:
            num = int(input("输入你想分解的数字："))
            if num > 100000000:
                print("你输入的数值太大了，请重新输入！")
                continue
            res = prime_factor(num)
            print("分解结果是：" + str(res))
        except:
            print("二货，想啥呢！只能输入数字！")
            continue
    pass
