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
