#Tanner Jack
#CSCI 1913 with James Moen
#9/23/19

class Zillion:
  def __init__(self, digits): #Initialization, digits a string of digits containing nothing but digits
    self.digits = []

    for digit in digits:
      if (digit >= "0") and (digit <= "9"):
        self.digits += [int(digit)]
      elif (digit == "") or (digit == ",") or (digit == " "):#ignores blanks, commas and spaces
        pass
      else:
        raise RuntimeError #raise an error if not a digit

    if self.digits == []: #raises an error if digits is empty
      raise RuntimeError

  def isZero(self): #checks if digits is 0
    for element in self.digits:
      if(element != 0): #if a digit in digits isn't 0, return false
        return False
      elif (element == 0):#if a digit is 0, pass and go to next digit
        pass
    return True #after checking all digits, will return true if no digit isn't 0 

  def toString(self):#digit to string
    set = "" #empty string
    for element in self.digits:
      set += str(element) #adds each number in digits to string
    return set#returns string

    
  def increment(self): #adds one to digits
    index = len(self.digits) - 1 #set length of digits
    
    while (self.digits[index] == 9) and (index >= 0) : #For last digit in index, if equal to 9, set to 0
      self.digits[index] = 0
      index = index - 1 #go to next digit in index

    if (index >= 0):#for digits in index
      self.digits[index] = self.digits[index] + 1 #add one
      #print("Index: +1" + str(index) + "  Self.digits: " + str(self.digits))
    
    else:
      self.digits = [1] + self.digits # if outside index(possible if all digits 9), add a one to front
