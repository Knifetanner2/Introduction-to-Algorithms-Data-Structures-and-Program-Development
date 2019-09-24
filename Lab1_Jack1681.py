
def left(e):
    return e[0]
def op(e):
    return e[1]
def right(e):
    return e[2]


def isInside(v, e):
    if not isinstance(e,tuple):
        return e == v
    elif isInside(v, left(e) ):
        return True
    elif isInside(v, right(e) ):
        return True
    else:
        return False

def solve(v, q):
    if(isInside(v,left(q) ) ):
        return solving(v, q)
    elif(isInside(v,right(q) ) ):
        return solving(v, ( right(q), op(q), left(q) ) )
    else:
        return None

def solving(v, q):
    if(v == left(q)):
        return q
    else:

        op_Test = op(left(q))
        
        if (op_Test == '/'):
            return solvingDivide(v,q)
        elif (op_Test == '*'):
            return solvingMultiply(v,q)
        elif (op_Test == '-'):
            return solvingSubtract(v,q)
        elif (op_Test == '+'):
            return solvingAdd(v,q)
        else:
          return None

def solvingAdd(v, q):
    expression = left(q)

    if(isInside(v,left(expression))):
        return solving(v, ( left(expression), '=', ( right(q), '-', right(expression) ) ) )
    elif(isInside(v,right(expression))):
        return solving(v, ( right(expression), '=', ( right(q), '-', left(expression)  ) ) )

def solvingSubtract(v, q):
    expression = left(q)
    if(isInside(v,left(expression))):
        return solving(v, ( left(expression), '=', (right(q), '+', right(expression) ) ) )
    elif(isInside(v,right(expression))):
        return solving(v, ( right(expression), '=', (left(expression), '-', right(q)) ) )

def solvingMultiply(v, q):
    expression = left(q)
    if(isInside(v,left(expression))):
        return solving(v, ( left(expression), '=', (right(q), '/', right(expression) ) ) )
    elif(isInside(v,right(expression))):
        return solving(v, ( right(expression), '=', (right(q), '/', left(expression) ) ) )

def solvingDivide(v, q):
    expression = left(q)
    if(isInside(v,left(expression))):
      return solving(v, ( left(expression), '=', (right(q), '*', right(expression) ) ) )
    elif(isInside(v,right(expression))):
      return solving(v, ( right(expression), '=', (left(expression), '/', right(q) ) ) )

#Tests
print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points

print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points

print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points

print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points

print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points

print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points

print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points

print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points

print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points

print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points

print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points
