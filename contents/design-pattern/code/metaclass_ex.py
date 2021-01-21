__author__ = 'Chetan'

class MyInt(type):
    
    def __call__(cls, *args, **kwds):
        print("***** Here's My int *****", args)
        print("Now do whatever you want with these objects...")
        return type.__call__(cls, *args, **kwds)

class int(metaclass=MyInt):
    
    def __init__(self, x, y):
        self.x = x
        self.y = y
        pass

i = int(4,5)
i = int(7,8)