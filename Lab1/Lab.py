
def left(e):   #Fuction to return left; for the tuple ('a', '+', 'b'), returns a
    return e[0]
def op(e): 	   #Fuction to return operator(middle); for the tuple ('a', '+', 'b'), returns +
    return e[1]
def right(e):  #Fuction to return right; for the tuple ('a', '+', 'b'), returns b
    return e[2]


def isInside(v, e):            #Function to check if a variable, V, is inside the equation E
    if not isinstance(e,tuple):  #If not a tuple, returns e == v (if not tuple, it is just a single character)
        return e == v
    elif isInside(v, left(e) ): #If V is inside left of equation, return true (recursive)
        return True
    elif isInside(v, right(e) ): #If V is inside right of equation, return true (recursive)
        return True
    else:						#If V isn't inside left or right, returns false
        return False

def solve(v, q):               #Returns Equation setup in format that solving function can handle
    if(isInside(v,left(q) ) ): #If Variable, V, is inside left of equation then equation is setup and returns solving with the equation 
        return solving(v, q)
    elif(isInside(v,right(q) ) ): # If V is on right of equation, flips equation to have V on left so solving can solve equation
        return solving(v, ( right(q), op(q), left(q) ) )
    else:
        return None

def solving(v, q): #Function to solve equation
    if(v == left(q)): #If left of equation is variable(only), equation solved, return equation
        return q
    else:

        op_Test = op(left(q)) # Defines a variable to be the operator on the left side of the equation, where V should be, to solve for V
        
        if (op_Test == '/'): #Runs function solvingDivide if operator is /
            return solvingDivide(v,q)
        elif (op_Test == '*'):	#Runs function solvingMultiply if operator is *
            return solvingMultiply(v,q)
        elif (op_Test == '-'):	#Runs function solvingSubtractif operator is -
            return solvingSubtract(v,q)
        elif (op_Test == '+'):	#Runs function solvingAdd if operator is +
            return solvingAdd(v,q)
        else:
          return None

def solvingAdd(v, q): #Defining Function solvingAdd that simplifies function that includes adding
    expression = left(q) 

    if(isInside(v,left(expression))): # If V is very far left, transforms right of V to right of equation
        return solving(v, ( left(expression), '=', ( right(q), '-', right(expression) ) ) )
    elif(isInside(v,right(expression))): #If V is on right of expression, transforms right of V to right of equation
        return solving(v, ( right(expression), '=', ( right(q), '-', left(expression)  ) ) )

def solvingSubtract(v, q):#Defining Function solvingSubtract that simplifies function that includes subtraction
	
    expression = left(q)
	
	#A − B = C → A = C + B if x is inside A
	#			 B = A − C if x is inside B
	
    if(isInside(v,left(expression))): # If V is A, return A = C+B
        return solving(v, ( left(expression), '=', (right(q), '+', right(expression) ) ) )
		
    elif(isInside(v,right(expression))): # If V is B, return B = A-C
        return solving(v, ( right(expression), '=', (left(expression), '-', right(q)) ) )

def solvingMultiply(v, q):

    expression = left(q)
	
	#A * B = C → A = C / B if x is inside A
	#			 B = C / A if x is inside B
	
    if(isInside(v,left(expression))): # If V is A, return A = C/B
        return solving(v, ( left(expression), '=', (right(q), '/', right(expression) ) ) )
    elif(isInside(v,right(expression))):# If V is B, return B = C/A
        return solving(v, ( right(expression), '=', (right(q), '/', left(expression) ) ) )

def solvingDivide(v, q):

    expression = left(q)

	#A / B = C → A = C * B if x is inside A
	#			 B = A / C if x is inside B

    if(isInside(v,left(expression))):# If V is A, return A = C*B
      return solving(v, ( left(expression), '=', (right(q), '*', right(expression) ) ) )
    elif(isInside(v,right(expression))): # If V is B, return B = A/C
      return solving(v, ( right(expression), '=', (left(expression), '/', right(q) ) ) )
