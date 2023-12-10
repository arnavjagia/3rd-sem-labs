# Numpy

## ndarray
- In NumPy, when you assign a NumPy array to a new variable, it creates a reference to the original array rather than copying the data. Therefore, changes made to the new variable will affect the original array, and vice versa.\
To make a seperate copy use,
```py
# Create a NumPy array
original_array = np.array([1, 2, 3, 4, 5])

# Assign the array to a new variable
new_variable = original_array.copy()  # Use copy to create an independent array
```

### [np.ndarray.shape](https://numpy.org/doc/stable/reference/generated/numpy.ndarray.shape.html)
- tuple of N positive integers that represent the size of each dimension
