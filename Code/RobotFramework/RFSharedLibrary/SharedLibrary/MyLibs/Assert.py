# coding:UTF-8
class Assert(object):
    def assertEquals(self, expected, actual):
        '''比较两个值是否相同，相同返回True，不同返回False。

        :param expected:预期结果。
        :param actual:实际结果。
        :return:返回值。
        '''
        if expected == actual:
            return True
        else:
            return False

a = Assert()
print(a.assertEquals(1, 2))
