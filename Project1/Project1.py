class Random:
  def __init__(self,seed):
    self.seed = seed
    #generates sequence of pseudo random integers
  def next(self):
    self.seed = (16807 * self.seed) % (2147483648-1) #generates next random int in sequence and returns

    return self.seed
  def choose(self, limit):
    return self.next()%(limit)#returns a random number between 0 and the given limit

class Rule:
  def __init__(self, left, right):
    self.left = left#Sets left in method to left, a string
    self.right = right#Sets right in method to right, tuple
    self.count = 1
  def __repr__(self):
    stringRule = "'" + str(self.count) + " " + str(self.left) + " -> " #Creates a string with given elements
    for x in range(len(self.right)-1):#Adds each element of the tuple except for the last and a space after
      stringRule += self.right[x] + " "
    stringRule += self.right[len(self.right)-1] + "'"#Adds last element of tuple with an apostrophe
    return stringRule#Returns a formatted string

class Grammar:
  def __init__(self, seed):
    self.Random = Random(seed)#Creates a random number from seed
    self.dictionary = {} #Initializes an empty dictionary
  def rule(self, left, right):
    if (left in self.dictionary): #If Left is a key in dictionary
      self.dictionary[left] = self.dictionary[left] + (Rule(left,right),) #Add value to key
    else:
        self.dictionary[left] = (Rule(left,right),) #Create new Key Value pair in dictionary
  def generate(self):
    if ('Start' in self.dictionary):
      return (self.generating(('Start',)) )#If start is a key, then calls generating
    else:
      raise ValueError("Error, no Startstring key in Dictionary.") #If no start key raises an error
  def generating(self, strings):
    result = '' #Initializes result
    for string in strings:
      if string in self.dictionary:
        result = result + self.generating(self.select(string))#If string is in dictionary, runs generating then adds result
      else:
        result += string + ' ' # If string isn't a key in dictionary it is terminal and just adds to the result
    return result # returns the result
  def select(self, left):
    total = 0
    rules = self.dictionary[left]

    for count in rules:
      total += count.count

    index = self.Random.choose(total)#Sets index to a random between 0 and total
    chosen = ()

    for count2 in rules:
      index -= count2.count#Subtracts from index until 0
      if (index <=0):
        chosen = count2 #Once index is zero, sets to chosen
        break
    for count3 in rules:
      if(count3 == chosen):
        pass #If chosen add nothing
      else:
        count3.count += 1 #Otherwise add 1

    return chosen.right


G = Grammar(101)
G.rule('Noun',   ('cat',))                                #  01
G.rule('Noun',   ('boy',))                                #  02
G.rule('Noun',   ('dog',))                                #  03
G.rule('Noun',   ('girl',))                               #  04
G.rule('Verb',   ('bit',))                                #  05
G.rule('Verb',   ('chased',))                             #  06
G.rule('Verb',   ('kissed',))                             #  07
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08
G.rule('Story',  ('Phrase',))                             #  09
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10
G.rule('Story',  ('Phrase', 'but', 'Story'))              #  11
G.rule('Start',  ('Story', '.'))                          #  12
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
