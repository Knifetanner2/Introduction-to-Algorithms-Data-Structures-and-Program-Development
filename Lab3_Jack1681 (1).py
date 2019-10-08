def Sort(T): # Return Tuple T with elements sorted
  if len(T) == 0:
    return ()
  else:
    x = Maximum(T)
    return Sort(Remove(T, x)) + (x,) #recursively sorts and appends maximum to end(sorts min to max, starting at max)
def Maximum(T): # Assuming T has one element, return the largest element as an integer
  if len(T) == 1: #If T is one element, return element
    return T[0]
  maxT = Maximum(T[1:])
  if T[0] > maxT : # If second element is less than first, return Maximum of elements without second element
    return T[0] # Needs to be a tuple
  else: #Returns Maximum without first element (Element 1 less than Element 2)
    return maxT
def Remove(T, E): # return tuple with first appearance of element @ removed
  if len(T) == 0: # If no elements in T, return T
    return T
  elif T[0] == E: # If first element of T is element to remove, return all other elements
    return T[1:]
  else:#Otherwise separate First element and run Remove for other elements
    return (T[0],) + Remove(T[1:],E)

#
#  TESTS. Tests for CSci 1913 Lab 3.
#
#    James Moen
#    11 Feb 19
#
#  Each test is worth 2 points, for 40 points total. Comments show what must be
#  printed to receive credit. Note that your http://wiki.ros.org/ROS/Tutorials/http://wiki.ros.org/ROS/Tutorials/funhttp://wiki.ros.org/ROS/Tutorials/ction SORT must work for tuples
#  with negative elements.
#

print(Maximum((1,)))                      #  1                            2 pt.
print(Maximum((-2, -1)))                  # -1                            2 pt.
print(Maximum((1, 1)))                    #  1                            2 pt.
print(Maximum((1, 2, 3)))                 #  3                            2 pt.

print(Remove((), 1))                      #  ()                           2 pt.
print(Remove((1,), 1))                    #  ()                           2 pt.
print(Remove((0, 1), 0))                  #  (1,)                         2 pt.
print(Remove((0, 1, 2, 1, 3), 1))         #  (0, 2, 1, 3)                 2 pt.
print(Remove((0, 1, 2, 1, 3), 2))         #  (0, 1, 1, 3)                 2 pt.
print(Remove((1, 2, 3), 3))               #  (1, 2)                       2 pt.

print(Sort(()))                           #  ()                           2 pt.
print(Sort((0,)))                         #  (0,)                         2 pt.
print(Sort((0, -1)))                      #  (-1, 0)                      2 pt.
print(Sort((1, 0)))                       #  (0, 1)                       2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.
print(Sort((0, -1, 0)))                   #  (-1, 0, 0)                   2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.

print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 3, 4, 5, 6, 7, 8, 9)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))  #  (1, 1, 2, 2, 3, 4, 4, 5, 5)  2 pt.
